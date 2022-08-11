package BasicCRUDwithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest 
{
	@Test
	public void createProjectTest()
	{
		//create the Random Number
		Random r=new Random();
		int random=r.nextInt(500);
		
		baseURI="http://localhost";
		port=8084;
		
		//step 1:create the necessary data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","Gokul");
		jobj.put("projectName", "TYSS"+random);
		jobj.put("status","Created");
		jobj.put("teamSize",20);
		
		//step 2:send request and validate the respone
		given()
		 .body(jobj)
		 .contentType(ContentType.JSON)
		.when()
		 .post("/addProject")
		.then()
		 .assertThat().statusCode(201).log().all();		
	}
}
