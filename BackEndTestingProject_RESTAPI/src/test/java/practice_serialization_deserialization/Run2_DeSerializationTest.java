package practice_serialization_deserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class Run2_DeSerializationTest {
	public static void main(String[] args) throws Throwable {

		FileInputStream fileIn=new FileInputStream("./file.txt"); //Create an object to FileInputStream
		//To Getting the Binary Data available in this Text file back to Java Object,we are writing below line of codes.
		ObjectInputStream objIn=new ObjectInputStream(fileIn); 
		NFSGame user1Object=(NFSGame)objIn.readObject(); //Downcasting-ie,Converting back to NFSGame(ObjectInputStream is a 'Superclass' here)
		System.out.println(user1Object.name);   //To display the current java status
		System.out.println(user1Object.level);
		System.out.println(user1Object.score);
		System.out.println(user1Object.life);

	}
}
 