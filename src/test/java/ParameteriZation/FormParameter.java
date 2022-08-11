package ParameteriZation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class FormParameter 
{
	@Test
	public void createtheProjectTest()
	{
		baseURI="https://reqres.in/";
		Random r=new Random();
		int ran=r.nextInt(400);

		JSONObject jobj=new JSONObject();
		jobj.put("name", "Rajendran"+ran);
		jobj.put("job", "BusinessMan");


		//step 1: create the pre requiesties
		given()
//		.formParam("name", "Rajendran"+ran)         //reqres is not suppoort formparameter it will support JSON Object
//		.formParam("job", "BusinessMan")
		.body(jobj)
		.contentType(ContentType.JSON)

		//send the request validate the response
		.when()
		.post("/api/users")
		.then()
		 .assertThat().statusCode(201).log().all();
	}
}
