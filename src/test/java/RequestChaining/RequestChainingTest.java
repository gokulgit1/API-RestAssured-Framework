package RequestChaining;

import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class RequestChainingTest
{
	@Test
	public void requestChainingTest()
	{
		baseURI = "http://localhost";
		port = 8084;

		Random r=new Random();
		int ran = r.nextInt(300);

		//step 1:create the project using pojo
		ProjectLibrary pLib=new ProjectLibrary("Sheela","Tyss"+ran, "created", 25);
		Response resp = given()
				.body(pLib)
				.contentType(ContentType.JSON)
				.when()
				.post("/addProject");

		//step 2: capture the project id in response body
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();

		//step 3://Create a get request and pass proID as path parameter
		given()
		.pathParam("pid", proId)
		.when()
		.get("/projects/{pid}")
		.then()
		.assertThat().statusCode(200).log().all();

		//step 4: create the request for delete the project
		given()
		.pathParam("pid", proId)
		.when()
		.delete("/projects/{pid}")
		.then()
		.assertThat().statusCode(204).log().all();
	}
}
