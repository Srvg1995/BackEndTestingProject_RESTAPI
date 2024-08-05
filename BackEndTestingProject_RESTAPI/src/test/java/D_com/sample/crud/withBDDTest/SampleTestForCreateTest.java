 package D_com.sample.crud.withBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class SampleTestForCreateTest {
	@Test
	public void postDataToServer()
	{
		JSONObject jsonObj=new JSONObject(); //'JSONObject' works similar to 'Hashmap'only.
		jsonObj.put("createdBy", "GAGAN"); 
		jsonObj.put("projectName", "Orange220");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 10);

		/*Pre-Condition*/
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		/*Actual Execution of HTTP Methods*/
		.when()
		.post("http://49.249.28.218:8091/addProject")
		/*Response validation/Post-Condition*/
		.then()
		.assertThat().statusCode(201)
		.log().all();

	}
}
