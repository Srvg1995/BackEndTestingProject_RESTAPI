package E_practice_serialization_deserialization;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;



class Project12 {

	String projectName;
	String projectStatus;
	int teamSize;
	List<String> teamMember;
	ProjectManager projectManager;
	
	public Project12(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}
	
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectName() {
		return projectName;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getProjectStatus() {
		return projectStatus;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}
	public List<String> getTeamMember() {
		return teamMember;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}
	public ProjectManager getProjectManager() {
		return projectManager;
	}

}

class ProjectManager {

	String name;
	String empID;

	public ProjectManager(String name, String empID) {
		super();
		this.name = name;
		this.empID = empID;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getEmpID() {
		return empID;
	}

}

public class Run_POJO {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		List<String> lst=new ArrayList<String>(); //Since,teammember is an array which requires List<String>,So we are creating object for 'List(ArrayList)'here.
		lst.add("Jhon");
		lst.add("devid");
		lst.add("Stev");
		
		ProjectManager pM=new ProjectManager("sagar", "tp01"); //Creating an Object to ProjectManager here.
		
		Project12 projectObj=new Project12("Deepak", "created", 10, lst, pM);//Creating an Object to Project12 here & 'lst & pM' variables are used inside the object.
	 //System.out.println(projectObj.projectName); 
		
		
		
		ObjectMapper objM=new ObjectMapper(); //Here by taking the help of the POJO Class,converting Object(data) back to Json file.
		objM.writeValue(new File("./Project12.json"), projectObj);
	}
}
