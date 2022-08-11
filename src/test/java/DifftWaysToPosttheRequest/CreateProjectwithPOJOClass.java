package DifftWaysToPosttheRequest;

import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectwithPOJOClass
{
	@Test
	public void createProject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: create pre requisites
		ProjectLibrary obj = new ProjectLibrary("GokulakannanRaj","Kuppi","created", 20);
		
       given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()                          //Step 2: perform action
		.post("/addProject")
		.then()                          //Step 3: validation
		.assertThat().statusCode(201)
		.log().all();
	}
}
