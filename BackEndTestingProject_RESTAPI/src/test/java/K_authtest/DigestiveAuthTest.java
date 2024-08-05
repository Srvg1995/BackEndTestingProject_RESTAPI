package authtest;

import org.testng.annotations.Test;
//import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class DigestiveAuthTest {
	@Test
	public void sampleTest() {
		//given()==>PRE-CONDITION
		given()                   
		.auth().digest("rmgyantra", "rmgy@9999")
		.log().all()
		//when()==>EXECUTION(of API)
		.when()                    
		.get("http://49.249.29.5:8091/login")
		//then()==>VALIDATION
		.then()     
		.log().all();
	}
}
