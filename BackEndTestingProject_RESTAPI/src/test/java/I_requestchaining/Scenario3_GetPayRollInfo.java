package requestchaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Scenario3_GetPayRollInfo {

	@Test
	public void payRollInfo() {
		
		//API-1==>get Auth API-1
		Response resp = given()
    //These below 3 'PROTOCOL INFORMATION'(ie,Line#17,18,19) will be given by the Developers,whenever they use 'Oauth2 PROTOCOL'(Here it is given by Deepak sir in the Video).
		.formParam("client_id", "ninza-client")      
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");  //This is an "Authentication Protocol URL"(Copied from the my NOTEPAD which was showed in the VIDEO) which will generate a Bearer Token(Exactly similar to OTP) for us.
		resp.then()
		.log().all();
		//Capture the token from the Response
		String token = resp.jsonPath().get("access_token");
		         
		
		

		
		
		//API-2==>get Payroll info
		given()
		.auth().oauth2(token) //Before execution of below get payroll information(ie==>.get("http://49.249.28.218:8091/admin/payrolls")),we should pass this 'token' And without this token SERVER will not going to Response.Inorder to get this token,we need to write these piece of program above(ie,//API-1==>get Auth API-1 or Line#14to24).
		.get("http://49.249.28.218:8091/admin/payrolls")
		.then()
		.log().all();
	}
}
