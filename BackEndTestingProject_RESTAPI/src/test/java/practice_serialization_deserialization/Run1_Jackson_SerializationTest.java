package practice_serialization_deserialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project{   //POJO Class[Plain Old Java Object]=The Business Class whatever we create during SERIALIZATION,that class we called as POJO Class(In C#,it is POCO).
	private String projectName;
	private String createdBy;
	private int teamSize;
	private String status;
	
	private Project() {}   //This Empty Constructor is required for DESERIALIZATION
	
	public Project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

//SERIALIZATION PROGRAM
public class Run1_Jackson_SerializationTest {  
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		Project pObj=new Project("Orangeee", "MSG", 10, "Created");  //This is a Java Object which needs to be converted to JSON file
		
		ObjectMapper objM=new ObjectMapper();
		objM.writeValue(new File("./project.json"), pObj);  //The above(line#30) Java Object is converted to JSON file here.//This is called Jackson Serialization/Marshalling//This writeValue()always ask 2 arguments,1st argument is Path of the Json file & 2nd argument is POJO Object,sothat by taking the help of Setters(),all the properties available in Java will converting back to Json file & that conversion is takencare by ObjectMapper.
		System.out.println("===========END=========");
	}

}
