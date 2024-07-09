package com.sample.crud.withoutBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPartialUpdateTest {
	@Test
	public void patchDataToServer()
	{
		JSONObject jsonObj=new JSONObject();   
		    
		jsonObj.put("projectName", "Laptop"); //projectName changed from Orange1 to Laptop.
		

		RequestSpecification req = RestAssured.given();	  
		req.contentType(ContentType.JSON);               
		req.body(jsonObj.toJSONString());               

		Response resp = req.patch("http://49.249.28.218:8091/project/NH_PROJ_251"); 
		resp.then().log().all();
		//resp.then().assertThat().statusCode(201);  
	}
}
