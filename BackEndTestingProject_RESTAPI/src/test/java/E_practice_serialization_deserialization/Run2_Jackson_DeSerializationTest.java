package E_practice_serialization_deserialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

//DE-SERIALIZATION PROGRAM
public class Run2_Jackson_DeSerializationTest {  
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
	ObjectMapper objM=new ObjectMapper();
	 Project pObj = objM.readValue(new File("./project.json"), Project.class); //Here we need to pass 2 arguments,1st is location of the file & 2nd is the name of the POJO class(The name of the POJO class which we declared in the class 'Run1_Jackson_SerializationTest.java' is 'Project'--> & '.Class' is to specify that ,this is a class) //Here this readValue() goto this file="./project.json" & convert this entire Json file into object of this Project class="Project.class".
	System.out.println(pObj.getProjectName());
	System.out.println(pObj.getTeamSize());
	System.out.println(pObj.getStatus());
	System.out.println(pObj.getCreatedBy());
}
}
