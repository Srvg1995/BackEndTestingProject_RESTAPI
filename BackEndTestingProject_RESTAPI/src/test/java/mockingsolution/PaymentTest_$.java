package mockingsolution;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PaymentTest_$ {

/*YOU CAN'T RUN THIS BELOW CLASS WITHOUT RUNNING THIS(CreditCardMock_$)MOCKING SOLUTION CLASS BEFORE, if u run this(PaymentTest_$)class alone then u will get an ERROR.*/
	@Test
	public void sampleTest()
	{
		
	/*We can't(CAN if u have Jackson dependency) send the body with STRING data like below,bcz in the "CreditCardMock_$" class we have mentioned the "CONTENT TYPE" as "application/json",so we have to send this Request Payload in the form of JSON only(ie,showed in Line#23-26).
		 * String body = "{\r\n" + "\"creditcard\":\"1234567891237\",\r\n" +
		 * "\"cvv\":\"123\",\r\n" + "\"cardName\":\"deepak\"\r\n" + "}";
		 */
		 

		JSONObject obj=new JSONObject();
		obj.put("creditcard", "1234567891234");
		obj.put("cvv", "123");
		obj.put("cardName", "deepak");


		given()
		.contentType(ContentType.JSON)
	    .body( /* body */  obj )
		.when()
		.post("http://localhost:8889/credit-card") //Here, we are getting this PORT NO. & END POINT from "CreditCardMock"class only.
		.then()
		.log().all();
	}

}
