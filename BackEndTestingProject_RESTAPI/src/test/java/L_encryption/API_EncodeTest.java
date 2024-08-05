package encryption;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class API_EncodeTest {
	@Test
	public void sampleTest(){
	//Passing Credentials before sending 'get' request.
	given()
	.auth().preemptive().basic("rmgyantra", "rmgy@9999")//Display sensitive password in header which can be Decrypted and easily used by Hackers,so we are not going to use Pre-emptive Auth,instead we go for Digestive Auth.
	.log().all()
	.when()
	.get("http://49.249.28.218:8091/projects")
	.then().log().all();
	}

}
