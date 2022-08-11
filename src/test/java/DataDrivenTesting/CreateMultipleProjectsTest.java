package DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateMultipleProjectsTest 
{
	@Test(dataProvider = "getData")
	public void createProject(String createdBy, String projectName, String status, int teamSize)
	{

		//Prerequisties
		baseURI = "http://localhost";
		port = 8084;

		Random r=new Random();
		int ran = r.nextInt(400);

		ProjectLibrary pLib = new ProjectLibrary(createdBy, projectName+ran, status, teamSize);
		given().body(pLib).contentType(ContentType.JSON).post("/addProject").then().assertThat().statusCode(201).log().all();			
	}
	@DataProvider(name = "getData")
	public Object[][] data()
	{
		Object[][] data = new Object[3][4];

		data[0][0] = "Chaitra";
		data[0][1] = "Dell";
		data[0][2] = "Completed";
		data[0][3] = 12;

		data[1][0] = "Gokul";
		data[1][1] = "HP";
		data[1][2] = "Created";
		data[1][3] = 15;

		data[2][0] = "Prathap";
		data[2][1] = "TYSS";
		data[2][2] = "On Going";
		data[2][3] = 20;


		return data;
	}

}
