package requestchaining;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.ProjectPojo;

public class Scenario1_DeleteProject {

	@Test
	public void postDataToServer()
	{
		Random random=new Random();
		int ranNum = random.nextInt(5000);
		
		
		//API-1==>add a project inside the Server
		//create an Object to POJO Class(POJO Class is present in pojoclass.utility package)
		ProjectPojo pObj=new ProjectPojo("Jio_"+ranNum, "Created", "GAGAN", 10);
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(pObj)
		.when()
		.post("http://49.249.28.218:8091/addProject");
		resp.then()
		.assertThat().statusCode(201)
		.log().all();
		//Capture projectId from the Response
		String projectID = resp.jsonPath().get("projectId");
         System.out.println(projectID);
         
         
         
         
       //API-2==>delete the Project
         given()
         .delete("http://49.249.28.218:8091/project/"+projectID)
         .then()
         .log().all();
         
         
         
         
         
         
	}
}
