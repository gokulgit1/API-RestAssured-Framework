package POJOClasses;

public class ProjectLibrary 
{

	//step 1: declare the variable as global
	String createdBy;
	String projectName;
	String status;
	int teamSize;

	//Step 2: create a constructor to initialise the variables
	public ProjectLibrary(String createdBy, String projectName, String status, int teamSize) 
	{
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}

	//Step 3: Provide getters and setters to access the variables
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
}
