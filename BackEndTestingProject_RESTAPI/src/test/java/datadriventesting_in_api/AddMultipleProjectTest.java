package datadriventesting_in_api;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Iterator;

public class AddMultipleProjectTest {

	@Test(dataProvider = "getData")
	public void sampleTest(String projName,String status){
		
		/*
		 * Instead of using POJO class&other 3 methods,we are using String variable
		 * below(i.e,String reqBody)which is a easiest way to create a Request Body.
		 * String projName = "Googly"; 
		 * String status = "Created";
		 */
		
		String reqBody = "{\r\n"
				+ "  \"createdBy\": \"Deepak\",\r\n"
				+ "  \"projectName\": \""+projName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 10\r\n"
				+ "}";
		
		given()
		.contentType(ContentType.JSON)
		.body(reqBody)
		
		.when()
		.post("http://49.249.28.218:8091/addProject")
		
		.then()
		.log().all();
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		int count = eLib.getRowcount("project");
		Object[][] objArr=new Object[count][2];
		for(int i=0;i<count;i++) {
			objArr[i][0]=eLib.getDataFromExcel("project", i+1, 0); //Here we are using 'i+1',bcz in my Excel sheet first row is a Heading,so we need to avoid that.
			objArr[i][1]=eLib.getDataFromExcel("project", i+1, 1);
		}
		return objArr;
	}
	
}
