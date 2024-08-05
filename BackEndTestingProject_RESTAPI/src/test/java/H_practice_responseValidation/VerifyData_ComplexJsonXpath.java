package H_practice_responseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.codehaus.groovy.ast.builder.AstStringCompiler;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyData_ComplexJsonXpath {
	//BELOW PROGRAM IS AFTER ADDING JAYWAY JSONPATH DEPENDENCY
	@Test
	public void sampleTest() {
		Response resp = given()
		.get("http://49.249.28.218:8091/projects"); //if u have used EndPoint as==>'/projects-paginated' then Script gets FAILED after few minutes of getting PASSED,bcz it will show only first 20 projects.So,if u pass '/projects'as an EndPoint,then u will get all the Projects available.
		resp.then()
		.log().all();
		

		List<String> list = JsonPath.read(resp.asString(), ".[*].projectName");   //This 'JsonPath' Class coming from the 'jayway' library which is added(dependency) inside pom.xml file.//This is not the one which is coming from 'RestAssured'.//This 'JsonPath' class coming from 'JayWay' will be used only when the Response is Complicated & we supposed to write Complicated JsonXpath. //Here(resp.asString()),the complete Response will be converted to String if we use .asString() after 'resp' keyward).//The meaning of this complete line is==>This read() available in JsonPath required 2 arguments,1 is complete response(resp.asString()) & go this Response Payload and go to this(".content[*].projectName") complex JsonXpath & capture all the information and store it in a variable called 'list'. //This read() always return the ArrayList. 
		for(String data:list) {
			System.out.println(data);
		}
		
		
		
		List<String> list1 = JsonPath.read(resp.asString(), ".[*].[?(@.projectName=='Joanne_91')].projectId");   //JSONXPATH==>".[*].[?(@.projectName=='Joanne_91')].projectId"
		String actProjectId = list1.get(0);
		
		
		 
		Assert.assertEquals(actProjectId, "NH_PROJ_960"); //This is TestNG Assert statement. //We can't go for RestAssured Assertion here,bcz we are extracting the data from the response & after extracting the data if we want to put an assertion,u have to go for TestNG Assertion.
       /*Why we are Extracting this above data? means,1)Extract first ProjectId==>After extracting the data,I can use it for Assertion.
		                                        2)DB Validation
                                                3)Request Chaining */
	}

}
