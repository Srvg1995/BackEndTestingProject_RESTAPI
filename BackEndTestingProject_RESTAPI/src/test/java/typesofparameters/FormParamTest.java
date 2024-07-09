package typesofparameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormParamTest {
	@Test
	public void SampleTest(){

		given()
		.formParam("teamSize", 10) //If u want to pass the data in the Request Body,we are going to use 'FormParam'. 
		.log().all() //This line is to Display the Request Header & Body 
		.when()
		.post("http://49.249.28.218:8091/project")
		.then()
		.log().all();

	}

}
