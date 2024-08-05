 package C_com.sample.crud.withoutBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {
	@Test
	public void putDataToServer()
	{
		JSONObject jsonObj=new JSONObject();   
		jsonObj.put("createdBy", "GAGAN");     
		jsonObj.put("projectName", "Apple1");//projectName changed from Laptop to Apple1.
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 10);


		RequestSpecification req = RestAssured.given();	  
		req.contentType(ContentType.JSON);               
		req.body(jsonObj.toJSONString());               

		Response resp = req.put("http://49.249.28.218:8091/project/NH_PROJ_251"); 
		resp.then().log().all();
		//resp.then().assertThat().statusCode(201);  
	}
}
