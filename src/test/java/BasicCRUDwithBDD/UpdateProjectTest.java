package BasicCRUDwithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import  io.restassured.http.ContentType;

public class UpdateProjectTest 
{
	@Test
	public void updateProjectTest()
	{
		baseURI="http://localhost";
		port=8084;
		
		//step 1:create the necessary data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","Kannan");
		jobj.put("projectName", "Espinaca");
		jobj.put("status","Completed");
		jobj.put("teamSize",40);
		
		//send req and validate response
		given()
		 .body(jobj)
		 .contentType(ContentType.JSON)
		.when()
		 .put("/projects/TY_PROJ_1802")
		.then()
		 .assertThat().statusCode(200).log().all();


	} 
}
