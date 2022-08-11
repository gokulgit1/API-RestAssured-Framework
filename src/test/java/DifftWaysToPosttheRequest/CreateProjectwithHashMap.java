package DifftWaysToPosttheRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectwithHashMap 
{
	@Test
	public void createProject()
	{
		baseURI="http://localhost:8084";

		//step 1: create the data
		HashMap map=new HashMap();
		map.put("createdBy", "Gokul");
		map.put("projectName", "TYSS-ESPINACA");
		map.put("status", "on going");
		map.put("teamSize", 15);

		//send request and validate the response
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201).log().all();


	}
}
