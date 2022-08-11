package ParameteriZation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter
{
	@Test
	public void getSingleProjectTest() 
	{
		baseURI ="http://localhost";
		port = 8084;
		// create Pre requisites
		given()
		.pathParam("pid", "TY_PROJ_808")

		//Actions send the request
		.when()
		 .get("/projects/{pid}")

		//Validate the response
		.then()
		  .assertThat().statusCode(200).log().all();
	}
}
