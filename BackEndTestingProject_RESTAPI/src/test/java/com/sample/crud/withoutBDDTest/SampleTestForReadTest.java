package com.sample.crud.withoutBDDTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForReadTest {
 @Test
 public void getDataFromServer()
 {
	 Response resp = RestAssured.get("http://49.249.28.218:8091/projects");
	
//	  System.out.println(resp.asString()); //If u use this 'asString()'then u will get the entire response in String format only,so we should use 'PrettyPrint()'to get the response in JSON format. 
//    System.out.println(resp.prettyPrint());//But here,'prettyPrint()'gives only response body,not the header,so will go to 'log().all()'.
      
      resp.then().assertThat().statusCode(200);
      
      resp.then().log().all(); //If I want to see the complete log of the response(log includes both Response Header & Body,but in prettyPrint() we can see only Response Body),then I should use 'log().all()'.
 }
}
