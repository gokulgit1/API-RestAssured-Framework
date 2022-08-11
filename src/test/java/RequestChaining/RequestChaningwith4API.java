package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class RequestChaningwith4API 
{
	@Test
	public void requestChaining()
	{
		baseURI = "http://localhost";
		port = 8084;

		Random r=new Random();
		int ran = r.nextInt(300);

		//step 1:create the project using pojo
		ProjectLibrary pLib=new ProjectLibrary("Gokulakannan","Tyss-Espinaca"+ran, "created", 25);
		Response resp = given()
				.body(pLib)
				.contentType(ContentType.JSON)
				.when()
				.post("/addProject");
				resp.then().assertThat().log().all();
		


		//step 2: capture the project id in response body
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();

		//step :3 :get the project
		given()
		.pathParam("pid", proId)
		.when()
		.get("/projects/{pid}")
		.then()
		.assertThat().statusCode(200).log().all();

		//step 4:update the project

		ProjectLibrary pLib1=new ProjectLibrary("Gokulakannan","Tyss-Espinaca", "completed", 50);
		given()
		.pathParam("pid",proId)
		.body(pLib1)
		.contentType(ContentType.JSON)
		.when()
		.put("/projects/{pid}")
		.then().assertThat().statusCode(200).log().all();

		//step 5:delete the project
		given()
		.pathParam("pid", proId)
		.when()
		.delete("/projects/{pid}")
		.then()
		.assertThat().statusCode(204).log().all();


	}
}
