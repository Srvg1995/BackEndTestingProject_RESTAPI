package J_typesof_parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParamTest {
	@Test
	public void SampleTest(){

		given()
		.queryParam("teamSize", 10)
		.when()
		.get("http://49.249.28.218:8091/project")
	//.get("http://49.249.28.218:8091/project?teamSize=10")
		.then()
		.log().all();

	}

}
