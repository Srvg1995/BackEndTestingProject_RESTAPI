package encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodeAndDecodeTest {
 @Test
 public void sampleTest() {
	 
	 //General Example to show EncodeAndDecode concept
	String encodeData=new String(Base64.getEncoder().encode("ABC".getBytes())); //Base64-comes from JAVA.
	System.out.println(encodeData);
	String decodeData=new String(Base64.getDecoder().decode("QUJD".getBytes())); 
	System.out.println(decodeData);
	
	//UN&PW Example to show EncodeAndDecode concept
	String encodeData1=new String(Base64.getEncoder().encode("rmgyantra:rmgy@9999".getBytes())); 
	System.out.println(encodeData1);
	String decodeData1=new String(Base64.getDecoder().decode(encodeData1.getBytes())); 
	System.out.println(decodeData1);
 }
 
}
