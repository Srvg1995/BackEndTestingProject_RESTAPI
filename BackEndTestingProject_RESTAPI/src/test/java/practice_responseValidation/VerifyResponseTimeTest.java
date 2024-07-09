package practice_responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;


public class VerifyResponseTimeTest {
	
	@Test
	public void verifyHeader() {
		Response resp = given()
		                  .get("http://49.249.28.218:8091/projects");
		resp.then().log().all();
		long timeTaken = resp.time();  //To get the time in MilliSeconds
		long timeTakenInSec = resp.timeIn(TimeUnit.SECONDS);  //To get the time in Seconds

		System.out.println(timeTaken);  
		System.out.println(timeTakenInSec);
		
		resp.then().assertThat().time(Matchers.lessThan(900L));  //Here we should mention 'L' at the end of 900(900 milliseconds),bcz the 'MilliSecond' always will be in the form of 'long'.
		resp.then().assertThat().time(Matchers.greaterThan(400L));
		resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));
	}

}
