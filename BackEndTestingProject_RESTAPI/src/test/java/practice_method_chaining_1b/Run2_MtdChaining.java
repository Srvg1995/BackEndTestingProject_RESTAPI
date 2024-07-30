package practice_method_chaining_1b;

import static practice_method_chaining_1a.A2_MtdChaining.*;

import org.testng.annotations.Test;

public class Run2_MtdChaining {
	@Test
	public void sampleTest() 
	{
		//A2 a1=new A2();
		a().b().c().d();  //Here,eventhough 'd()' is non-static, we can able to access without creating an Object,bcz c() returning the object of B2,that is the reason we can access d() available in B2 class.

	}
}
