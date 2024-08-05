package K_authtest;

import org.testng.annotations.Test;
//import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class BearerTokenAuthTest {
	@Test
	public void sampleTest() {
		//given()==>PRE-CONDITION
		given()                   
		.auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJsZUN3YUNPai00RXVlbzJkTFFrTmZuLXh2M0F3Nm5ZdWZtS0pINXBFWkNNIn0.eyJleHAiOjE3MTk0NjQ2ODEsImlhdCI6MTcxOTQ2Mjk3OCwianRpIjoiNDVmMzg1ZTUtNmNkMi00MzY1LThlYWEtZGQ2Y2M0NjAzYzMxIiwiaXNzIjoiaHR0cDovLzQ5LjI0OS4yOC4yMTg6ODE4MC9hdXRoL3JlYWxtcy9uaW56YSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI0ODVlYTJhYi1kY2MzLTQwOGItOTUxZi04NGMwM2JmZDAwMmYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJuaW56YS1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiYmJkOTk3MmItYWEyYi00ZTcxLWE4NjItZTZlZmZiMDg4NGM2IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vNDkuMjQ5LjI4LjIxODo4MDkxIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLW5pbnphIiwib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiYmJkOTk3MmItYWEyYi00ZTcxLWE4NjItZTZlZmZiMDg4NGM2IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJybWd5YW50cmEifQ.F-CYoa0Ufuf61pw514m34ATeG8xxzsIbgJYIW99jHxq8xYgBB13A49J1BCjFwBqHnrrWrUCvKQvP0ip0TT14jzn5xeJCOvYESJeWPdDxWD0gTGoxstfRYUumA4Q3nfuhLM1Bp_kLMibLd2pvy2aMiY-IUZBlK65kHJNECKdTGroTU3wF-Oino27llSmYZ56JErqPz5NSFdP0n8RqbjCxWR4N25qmrULwQkzQPdXK9v5Zk9QmYsUp3_EfpFuUcXoOaOoQ0k91FBCRegApv5lzHcYKxNCcwjpRkRaTvFFASWNFsSXfRjTuBnuHXToknuxk4zGNe2n2E1XwBJKJgDXScA")
		.log().all()
		//when()==>EXECUTION(of API)
		.when()                    
		.get("http://49.249.28.218:8091/projects")
		//then()==>VALIDATION
		.then()     
		.log().all();
	}
}
