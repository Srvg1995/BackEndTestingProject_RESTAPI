package L_encryption;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UpdatePayrollInfoViaAESEncryption {

	@Test
	public void sampleTest() throws Throwable {
		EncryptionAndDecryptionUtility_NA ed=new EncryptionAndDecryptionUtility_NA();//This Class is present in "EncryptionAndDecryptionUtility class".
//As we know there are 4 ways to send the 'POST request'==>Hashmap,json file,json object,pojo class.Apart from these 4,below is the another easiest way of doing it.
		String jsonBody = "{ \"employee\": { \"empId\":\"NH_0002\", \"designation\": \"string\", \"dob\": \"dd/MM/yyyy\", \"email\": \"string\", \"empName\": \"string\", \"experience\": 0, \"mobileNo\": \"string\", \"project\": \"string\", \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0, \"hra\": 0, \"insurance\": 0, \"lta\": 0, \"lwf\": 0, \"netPay\": 0, \"payroll_id\": 1, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Active” }"; //This Json body we got in straightline through online json to string converter tool.
//If you want to update the payroll information ,you have to pass Encrypted data only in the Request Body.		
		String jsonReqBody = ed.encrypt(jsonBody, "Ac03tEam@j!tu_#1");
		System.out.println(jsonReqBody);

		Response resp = given()
				.body(jsonReqBody)
				.when()
				.put("http://49.249.28.218:8091/payroll");
		resp.then().log().all();
		
		String respBody = ed.decrypt(resp.getBody().asString(), "Ac03tEam@j!tu_#1");
	      System.out.println(respBody);
	}
	
}
