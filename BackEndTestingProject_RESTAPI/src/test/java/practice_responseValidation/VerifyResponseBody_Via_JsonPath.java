package practice_responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class VerifyResponseBody_Via_JsonPath {
	//BELOW PROGRAM IS BEFORE ADDING JAYWAY JSONPATH DEPENDENCY
	@Test
	public void sampleTest1() {
		Response resp = given()
				.get("http://49.249.28.218:8091/projects-paginated");
		resp.then()
		.log().all();


		resp.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_789"));
		   //ArrayList<String> lst = resp.jsonPath().get("content[*].projectName");  //Here these Json xpath("content[*].projectId") found by an open source tool(https://www.site24x7.com/tools/json-path-evaluator.html) //while copying the xpath we should not copy this($.) //Here("content[*].projectId")we are using * inside content[] ,bcz if we keep Index value it will capture only that particular index contents,whereas if u keep * it will capture all the "ProjectId" inside the Response Body)
		ArrayList<String> lst = resp.jsonPath().get("content.projectName"); //This jsonPath()coming from 'RestAssured',can be used for Simple/Eazy Responses only,if the Response is complicated then we should go for 'JsonPath' class coming from 'JayWay'.
		System.out.println(lst);

		
		

		//		int data = resp.jsonPath().get("numberOfElements"); //Here no need to Begin with DOT(.) before "numberOfElements"(which we used to do it while writing manually),bcz RestAssured can understand this & it will navigate to Root Object by default. 
		//		System.out.println(data);
		//
		//		boolean data1 = resp.jsonPath().get("pageable.sort.unsorted"); //No need to Begin with DOT(.) before "pageable",but afterwards if we want to traverse to other objects/elements,we should use DOT as we do it manually.
		//		System.out.println(data1);
		//
		//		String data2 = resp.jsonPath().get("content[0].projectId");
		//		System.out.println(data2);

	}

}
