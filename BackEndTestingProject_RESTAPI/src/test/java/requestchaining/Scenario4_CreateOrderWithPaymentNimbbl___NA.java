package requestchaining;

import static io.restassured.RestAssured.baseURI;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Scenario4_CreateOrderWithPaymentNimbbl___NA {

	public static void main(String[] args) {
		//https://nimbbl.biz/docs/api-reference/introduction/
		
		//Set Base URI
		 baseURI="https://api.nimbbl.tech";
		 
		
	System.out.println("***************************Authorization POST Request*****************************");
		
		//Authorization POST Request to generate token
		
		String accessKey = "access_key_pKx7rWVgVpbXQvq2";
		String accessSecret = "access_secret_DX3w55VKAkXbx7aB";
		
		String authorizationRequestBody = "\"{\\\"access_key\\\":\\\""+accessKey+"\",\\\"access_secret\\\":\\\""+accessSecret+"}\"";
		 Response authorizationResponseBody = given()
				                           .body(authorizationRequestBody)
				                           .contentType(ContentType.JSON)
				                           .post("/api/v3/generate-token");
		                authorizationResponseBody.then().log().all();
		                                   
		                String bearerToken = authorizationResponseBody.jsonPath().get("token");
		         
	 System.out.println("******************Create an Order POST Request******************************");
		                
	 //Create an Order POST Request
	 String invoiceId = "Inv_"+new Random().nextInt();
	 String createOrderRequestBody = "\"{\\\"amount_before_tax\\\":2100,\\\"tax\\\":105,\\\"total_amount\\\":2205,\\\"user\\\":{\\\"email\\\":\\\"wonderwoman@themyscira.gov\\\",\\\"first_name\\\":\\\"Diana\\\",\\\"last_name\\\":\\\"Prince\\\",\\\"country_code\\\":\\\"+91\\\",\\\"mobile_number\\\":\\\"9876543210\\\"},\\\"shipping_address\\\":{\\\"address_1\\\":\\\"1080BeachMansion\\\",\\\"street\\\":\\\"MagicBeachDrive\\\",\\\"landmark\\\":\\\"OppositeMagicMountain\\\",\\\"area\\\":\\\"Elyria\\\",\\\"city\\\":\\\"Atlantis\\\",\\\"state\\\":\\\"Castalia\\\",\\\"pincode\\\":\\\"100389\\\",\\\"address_type\\\":\\\"BeachHouse\\\"},\\\"currency\\\":\\\"INR\\\",\\\"invoice_id\\\":\\\""+invoiceId+"\\\",\\\"referrer_platform\\\":\\\"string\\\",\\\"referrer_platform_version\\\":\\\"string\\\",\\\"order_line_items\\\":[{\\\"sku_id\\\":\\\"item_2783027490\\\",\\\"title\\\":\\\"BestSlicedAlphonsoMango\\\",\\\"description\\\":\\\"TheAlphonsomangoisaseasonalfruitharvestedfrommid-AprilthroughtheendofJune.Thetimefromfloweringtoharvestisabout90days,whilethetimefromharvesttoripeningisabout15days.Thefruitsgenerallyweighbetween150and300grams(5.3and10.6oz),havearich,creamy,tendertextureanddelicate,non-fibrous,juicypulp.Asthefruitmatures,theskinofanAlphonsomangoturnsgolden-yellowwithatingeofredacrossthetopofthefruit\\\",\\\"image_url\\\":\\\"https://en.wikipedia.org/wiki/Alphonso_mango#/media/File:Alphonso_mango.jpg\\\",\\\"rate\\\":1050,\\\"quantity\\\":\\\"2\\\",\\\"amount_before_tax\\\":\\\"2100.00\\\",\\\"tax\\\":\\\"105.00\\\",\\\"total_amount\\\":\\\"2205.00\\\"}],\\\"bank_account\\\":{\\\"account_number\\\":\\\"10038849992883\\\",\\\"name\\\":\\\"DianaPrince\\\",\\\"ifsc\\\":\\\"ICIC0000011\\\"},\\\"custom_attributes\\\":{\\\"name\\\":\\\"Diana\\\",\\\"place\\\":\\\"Themyscira\\\",\\\"animal\\\":\\\"Jumpa\\\",\\\"thing\\\":\\\"Tiara\\\"}}\"";
		      Response createOrderResponseBody = given()
		    		                 .header("Authorization", "Bearer"+bearerToken)	
		    		                 .body(createOrderRequestBody)
		    		                 .contentType(ContentType.JSON)
		    		                 .post("/api/v3/create-order");
		      createOrderResponseBody.then().log().all();
		      
		      String orderId = createOrderResponseBody.jsonPath().get("order_id");
		      String userToken = createOrderResponseBody.jsonPath().get("user.token");
    // given().auth();
		      
	System.out.println("*************************Initiate Payment POST Request******************************");
		      //Initiate Payment POST Request
		       LinkedHashMap<String, String> initiatePaymentHeader=new LinkedHashMap<String, String>();
		       initiatePaymentHeader.put("Authorization", "Bearer"+bearerToken);
		       initiatePaymentHeader.put("x-nimbbl-user-token", userToken);
		       String initiatePaymentRequestBody = "{\r\n"
		       		+ "  \"order_id\": \""+orderId+"\",\r\n"
		       		+ "  \"callback_url\": \"https://mangoseller.awesome/transaction-response\",\r\n"
		       		+ "  \"payment_mode_code\": \"net_banking\",\r\n"
		       		+ "  \"bank_code\": \"hdfc\"\r\n"
		       		+ "}";
		       Response initiatePaymentResponseBody = given()
		    		   .headers(initiatePaymentHeader)
		    		   .body(initiatePaymentRequestBody)
		    		   .contentType(ContentType.JSON)
		    		   .post("/api/v3/initiate-payment");
		       initiatePaymentResponseBody.then().log().all();
		       String redirectUrl = initiatePaymentResponseBody.jsonPath().get("next[0].url");
		       String transactionId = initiatePaymentResponseBody.jsonPath().get("transaction_id");
		                
		        System.out.println("Transaction ID:"+transactionId); 
		        System.out.println("Redirect URL:"+redirectUrl); 
		                
	System.out.println("******************************WEBHOOK payment confirmation**************");	                
		                
		       WebDriverManager.chromedriver().setup();
		    WebDriver driver=new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get(redirectUrl);
		    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		    driver.findElement(By.id("username")).sendKeys("payu");
		    driver.findElement(By.id("password")).sendKeys("payu");
		    driver.findElement(By.xpath("//input[@type='submit']")).click();
		    driver.findElement(By.xpath("//input[@type='submit']")).click();
		    
		    System.out.println("*****************************Transaction Enquiry POST Request*********************");
		    LinkedHashMap<String, String> transactionEnquiryHeader=new LinkedHashMap<String, String>();
		    transactionEnquiryHeader.put("Authorization", "Bearer"+bearerToken);
		    transactionEnquiryHeader.put("x-nimbbl-user-token", userToken);
		       String transactionEnquiryRequestBody ="{\r\n"
		       		+ "  \"transaction_id\": \""+transactionId+"\",\r\n"
		       		+ "  \"order_id\": \""+orderId+"\",\r\n"
		       		+ "  \"invoice_id\": \""+invoiceId+"\"\r\n"
		       		+ "}";
		        Response transactionEnquiryResponseBody = given().headers(transactionEnquiryHeader)
		    		                                 .body(transactionEnquiryRequestBody)
		    		                                 .contentType(ContentType.JSON).log().all()
		    		                                  .when()
		    		                                  .post("/api/v3/transaction-enquiry");
		                      transactionEnquiryResponseBody.then().log().all();
		                      String orderStatus = transactionEnquiryResponseBody.jsonPath().get("order.status");
		                      
		    //Print Order Status
		      System.out.println("Order status:"+orderStatus);
		    		                                  
	}
}
