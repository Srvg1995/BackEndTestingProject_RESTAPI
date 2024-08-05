package G_practice_MultiplePostRequestTypes;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import F_pojoclass.utility.ProjectPojo;
import io.restassured.http.ContentType;

public class PostReq_Via_POJOClass4Test {

	@Test
	public void postDataToServer()
	{
		Random random=new Random();
		int ranNum = random.nextInt(5000);
		
		//create an Object to POJO Class //This POJO class is available in 'pojoclass.utility package'.
		ProjectPojo pObj=new ProjectPojo("ABCDE_"+ranNum, "Created", "GAGAN", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(pObj)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();

	}
}
