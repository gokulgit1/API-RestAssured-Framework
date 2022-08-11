package DifftWaysToPosttheRequest;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectwithJSONObject 
{
	@Test
	public void createProject()
	{
	
		//Step 1: create pre requisites
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Prakash");
		jObj.put("projectName", "Allstates");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 100);

		baseURI = "http://localhost";
		port = 8084;

		given()
		.body(jObj)
		.contentType(ContentType.JSON)

		.when()
		.post("/addProject")

		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}
}
