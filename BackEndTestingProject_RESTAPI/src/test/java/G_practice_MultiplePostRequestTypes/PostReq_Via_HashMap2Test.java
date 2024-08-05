package G_practice_MultiplePostRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Via_HashMap2Test {

	@Test
	public void postDataToServer()
	{
		HashMap<String,Object> map=new HashMap();  //Here,Key is always a 'String',but Value may be String/integer/object/array of object,so will put 'Object' here,bcz 'Object' is a Super Class for entire Java,so it can store any type of Data.
		map.put("createdBy", "GAGAN"); 
		map.put("projectName", "Orange12345");
		map.put("status", "Created");
		map.put("teamSize", 10);

		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();

	}
}
