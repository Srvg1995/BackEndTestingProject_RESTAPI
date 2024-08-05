package C_com.sample.crud.withoutBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCreateTest {
	@Test
	public void postDataToServer()
	{
		JSONObject jsonObj=new JSONObject();   //Here(In line#15 to 19)we are creating the payload(BODY)of the Request(After adding 'JSON simple' dependencies from MVNREPOSITORY).
		jsonObj.put("createdBy", "GAGAN");     //This JSONObject is exactly similar to HashMap(ie, we already knows, in HashMap will always store the data in KEY-VALUE pairs only).
		jsonObj.put("projectName", "Orange1");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 10);

		RequestSpecification req = RestAssured.given();	  //Eventhough all the CRUD operations(HTTP Methods) are available in 'RestAssured' class,but we can't use Post()(except get(),we can't use any other methods like,post(),patch(),delete()),bcz before sending post request I need to write Request body or I have to set some pre-conditions & Those precondition methods like, body(),contenttype() are available in 'RequestSpecification' Interface. 
		req.contentType(ContentType.JSON);               //Here,line# 23 to 24 are the preconditions.
		req.body(jsonObj.toJSONString());               //Here we are converting the 'jsonObj' into 'toJSONString' & this conversion should be mandatory bcz,which will convert this Map(ie,jsonObj)into complete 'Json format of string' before passing inside the body(this has to be done bcz,we don't have/installed Json Parser tool to convert).

		
		
		
		
		Response resp = req.post("http://49.249.28.218:8091/addProject"); //Here,in line#18 we are sending the POST request.
		resp.then().log().all();
		resp.then().assertThat().statusCode(201);  //Here we are putting an Assertion.
	}
}
