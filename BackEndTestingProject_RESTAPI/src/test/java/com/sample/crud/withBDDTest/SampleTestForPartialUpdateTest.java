 package com.sample.crud.withBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class SampleTestForPartialUpdateTest {
	@Test
	public void putDataToServer()
	{
		JSONObject jsonObj=new JSONObject();   
		jsonObj.put("projectName", "SRVG");
		
		given()  
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString()) //Hashmap raw format converting to String here.
		.when()  
		.patch("http://49.249.28.218:8091/project/NH_PROJ_293")
		.then()  
		.log().all();

	}
}
