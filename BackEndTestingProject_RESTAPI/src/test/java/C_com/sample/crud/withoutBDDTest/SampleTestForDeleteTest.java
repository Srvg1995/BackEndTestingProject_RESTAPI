package com.sample.crud.withoutBDDTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForDeleteTest {
	@Test
	public void deleteDataFromServer()
	{
		Response resp = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_246"); //Since, we don't have pre-condition for Delete(&Get),we are directly using RestAssured Delete()(instead of using Delete() available in 'RequestSpecification' Interface)

		resp.then().assertThat().statusCode(204);

		resp.then().log().all(); 
	}
}
