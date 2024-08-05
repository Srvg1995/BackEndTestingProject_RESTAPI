package encryption;

import org.testng.annotations.Test;

public class AES_EncryptTest {
	@Test
	public void sampleTest() throws Exception {
		String privateKey = "Ac03tEam@j!tu_#1";
		String data="deepak";
//For AES Encryption(Symmetric Encryption)-Here for both Encryption & Decryption we will use the same PrivateKey.
		EncryptionAndDecryptionUtility_NA ed=new EncryptionAndDecryptionUtility_NA();
		//Symetric Encryption
		System.out.println(ed.encrypt(data, privateKey));
		
		
		//Symetric Encryption
		//System.out.println(ed.decrypt("75mZ2BXSq4ztBd+mA0xuyg==", privateKey));
	}

}
