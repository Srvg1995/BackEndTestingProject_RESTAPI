package practice_serialization_deserialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(                 //Annotation-1
		value= {  "createdBy",
				  "projectName",
				  "teamSize",
				  "status"
		        }
		          )
@JsonIgnoreProperties(               //Annotation-2
		value= { "teamSize" },
		        allowSetters = true
               		)

class Project1{   //POJO Class[Plain Old Java Object]=The Business Class whatever we create during SERIALIZATION,that class we called as POJO Class(In C#,it is POCO).
	private String projectName;
	@JsonProperty(value="created By") //Annotation-3
	private String createdBy;
	private int teamSize;
	private String status;
	
	private Project1() {}  //This Empty Constructor is required for DESERIALIZATION
	
	public Project1(String projectName, String createdBy, int teamSize, String status) {
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
public class Run_Jackson_Serialization_ANNOTATION_Test {  
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		Project1 pObj=new Project1("Orangeee", "MSG", 10, "Created");  //This is a Java Object which needs to be converted to JSON file
		
		ObjectMapper objM=new ObjectMapper();
		objM.writeValue(new File("./project.json"), pObj);  //The above(line#30) Java Object is converted to JSON file here.//This is called Jackson Serialization/Marshalling//This writeValue()always ask 2 arguments,1st argument is Path of the Json file & 2nd argument is POJO Object,sothat by taking the help of Setters(),all the properties available in Java will converting back to Json file & that conversion is takencare by ObjectMapper.
		System.out.println("===========END=========");
	}

}
