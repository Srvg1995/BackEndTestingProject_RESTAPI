package com.sample.crud.withBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class SampleTestForCompleteUpdateTest {
	@Test
	public void putDataToServer()
	{
		JSONObject jsonObj=new JSONObject();   
		jsonObj.put("createdBy", "GAGAN");     
		jsonObj.put("projectName", "BANANA");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 10);

    //Pre-Condition(praveen)
     given()
     .contentType(ContentType.JSON)
     .body(jsonObj.toJSONString())
   //Http Methods(praveen)
     .when()
     .put("http://49.249.28.218:8091/project/NH_PROJ_293")
   //Response validation/Post-Condition(praveen)
     .then()
     .assertThat().statusCode(200)
     .log().all();
		
	}
}
