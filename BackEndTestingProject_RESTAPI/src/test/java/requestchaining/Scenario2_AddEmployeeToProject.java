package requestchaining;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.EmployeePOJO;
import pojoclass.utility.ProjectPojo;

public class Scenario2_AddEmployeeToProject {

	@Test
	public void addEmployee()
	{
		Random random=new Random();
		int ranNum = random.nextInt(5000);
		
		
		//API-1==>add a project inside the Server
		//create an Object to POJO Class
		ProjectPojo pObj=new ProjectPojo("Jio_"+ranNum, "Created", "GAGAN", 10);
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(pObj)
		.when()
		.post("http://49.249.28.218:8091/addProject");
		resp.then()
		.assertThat().statusCode(201)
		.and()     //If u want to put multiple Assertions ,we can use 'and()' also here, which is not Required but looks good actually.
		.assertThat().body("msg", Matchers.equalTo("Successfully Added"))
		.log().all();
		//Capture project Name from the Response
		 String projName = resp.jsonPath().get("projectName");
         System.out.println(projName);
        
         
         
         
         
       //API-2==>add Employee to the same project
         EmployeePOJO empObj=new EmployeePOJO("Arhitect", "24/06/1947", "gogo@gmail.com", "emp_"+ranNum, 18, "9888000876", projName, "ROLE_EMPLOYEE", "user_"+ranNum); //This class is there in 'pojoclass.utility' package.
         given()
 		.contentType(ContentType.JSON)
 		.body(empObj)
 		.when()
 		.post("http://49.249.28.218:8091/employees")
 		.then()
         .assertThat().statusCode(201)
         .log().all();
	}
}
