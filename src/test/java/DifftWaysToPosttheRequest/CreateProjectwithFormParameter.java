package DifftWaysToPosttheRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectwithFormParameter 
{
@Test
public void createProject()
{
	baseURI="http://localhost:8084";
	
	//step 1:create the data
	given()
	 .formParam("createdBy","Gokul")
	 .formParam("projectName","TYSS-ESPINACA")
	 .formParam("status","created")
	 .formParam("teamSize",15)
	 .contentType(ContentType.JSON)
	.when()
	 .post("/addProject")
	.then()                                     //send request and validate the response
	 .assertThat().statusCode(201).log().all();
}
}
