package N_mockingsolution;

import org.mockito.Mockito;
import org.testng.Assert;

class PANCard{
	public /* static */ String isValid(String panCard) //Here we are changing it to Non-Static bcz,during the MOCK(ie,getMockObject())we are getting the object(ie,mockObj)of the class.
	{
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true) //This is the format for PANCARD,where actually [A-Z]{1},but even if u haven't mentioned this also it works.
		{
			return "is valid pan";
		}
		else {
			return "is  invalid pan";
		}
	}
	//This below program(getMockObject())is a STUB actually
	public static PANCard getMockObject() {
		PANCard mockObj = Mockito.mock(PANCard.class); //doubt
		Mockito.when(mockObj.isValid("ABCDE1234A")).thenReturn("valid PAN Card");
		Mockito.when(mockObj.isValid("ABCDE1234B")).thenReturn("valid PAN Card");
		Mockito.when(mockObj.isValid("ABCDE1234C")).thenReturn("invalid PAN Card");
		return mockObj;
	}

}



public class PANCardMockingTest {

	public static void main(String[] args) {
		//System.out.println(PANCard.isValid("ABCDE1234A")); //This line is to check before creating a STUB above(ie,Before creating getMockObject()).

		PANCard mkObj = PANCard.getMockObject();
		System.out.println(mkObj.isValid("ABCDE1234C5")); //If we want to verify using Assert statement,then we can use this line====>Assert.assertEquals(mkObj.isValid("ABCDE1234C5"), "valid PAN Card");
	}
}
