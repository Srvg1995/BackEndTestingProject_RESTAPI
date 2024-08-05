package practice_method_chaining_1b;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class SampleTest_UsingMtdChainingTest {

	@Test
	public void getRequestTest() 
	{
		get("https://reqres.in/api/users?page=2")
		.then()
		.log()   //we can write all these 3 methods in the singleline itself after get(),but just to show it us clearly sir written in multiple lines.
		.all();
		
		
//		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
//		System.out.println(resp.prettyPrint());
		
	}
}
 