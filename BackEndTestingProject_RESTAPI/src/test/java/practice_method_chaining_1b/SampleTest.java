package practice_method_chaining_1b;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
//Here we haven't made static import in the above lines,so only we should use class name(RestAssured)before calling get()in the below.
public class SampleTest {

	@Test
	public void sampleGetReqTest() {
      
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(resp.prettyPrint());
	}
}
