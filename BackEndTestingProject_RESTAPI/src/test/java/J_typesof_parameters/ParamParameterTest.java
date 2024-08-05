package J_typesof_parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParamParameterTest {
	@Test
	public void SampleTest(){

		given()
		.param("teamSize", 10)  
		.log().all() //This line is to Display the Request Header & Body 
		.when()
		.get("http://49.249.28.218:8091/project") //here '.get()'==>Acts like a 'Form Param'. //If u are using '.post()' instead of '.get()'==>Acts like a 'Query Param'. 
		.then()
		.log().all();
	}

}
