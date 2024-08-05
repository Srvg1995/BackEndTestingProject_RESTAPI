package practice_serialization_deserialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable{   //'Serializable' is a Marker Interface & this is an Indication saying that,this class is SERIALIZABLE(Marker Interface is an Interface which doesn't contain Abstract Method / or Empty Interface we call it as Marker Interface.
	String name;
	int level;
	long score;
	int life;
	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
	
}

public class Run1_SerializationTest {
	
	public static void main(String[] args) throws Throwable {
		NFSGame user1Obj= new NFSGame("GAGAN", 15,90000L , 1);        //Create object to serializable class
		FileOutputStream fileOut=new FileOutputStream("./file.txt");  //(Java representation of the physical file)(write back to Text file)
		ObjectOutputStream objOut=new ObjectOutputStream(fileOut); //Converting Java Object into Binary Data
		objOut.writeObject(user1Obj);                              // Write Java Object back to Binary File
	    System.out.println("==========END===========");	
	}

}
 