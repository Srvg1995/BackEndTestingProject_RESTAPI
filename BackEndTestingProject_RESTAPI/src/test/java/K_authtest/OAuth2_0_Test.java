package K_authtest;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

//import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class OAuth2_0_Test {
	@Test
	public void sampleTest() {
		
		/*
		 * All these below details will be given by Developers actually,but here it's
		 * given by Deepak sir in the video. client_id ninza-client client_secret
		 * gPQBf1Yxew5OMccMhzos1GefIyiSnXzM grant_type client_credentials
		 * http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token
		 */		
		
		//given()==>PRE-CONDITION
	 Response resp = given() 
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		//when()==>EXECUTION(of API)
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		//then()==>VALIDATION
		 resp.then()     
		  .log().all();
		 
//Capture token from the response(KEYCLOAK-OAUTH2.0)
		 String token = resp.jsonPath().get("access_token");
		
		
		
		
		//given()==>PRE-CONDITION
		given()      
		.auth().oauth2(token)
		.log().all()
		//when()==>EXECUTION(of API)
		.when()                    
		.get("http://49.249.28.218:8091/projects")
		//then()==>VALIDATION
		.then()     
		.log().all();
	}
}
