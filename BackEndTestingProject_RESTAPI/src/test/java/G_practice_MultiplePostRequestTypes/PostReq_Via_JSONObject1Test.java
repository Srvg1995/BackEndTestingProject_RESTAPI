package G_practice_MultiplePostRequestTypes;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Via_JSONObject1Test {

	@Test
	public void postDataToServer()
	{
		JSONObject jsonObj=new JSONObject();   
		jsonObj.put("createdBy", "GAGAN"); 
		jsonObj.put("projectName", "Orange220");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 10);

		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();

	}
}
