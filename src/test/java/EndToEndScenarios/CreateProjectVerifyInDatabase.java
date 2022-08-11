package EndToEndScenarios;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;
import GenericLibrary.BaseAPIClass;
import GenericLibrary.DataBaseLibrary;
import GenericLibrary.EndpointsLibrary;
import GenericLibrary.IConstants;
import GenericLibrary.JavaLibrary;
import GenericLibrary.RestAssuredLibrary;
import POJOClasses.ProjectLibrary;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectVerifyInDatabase extends BaseAPIClass
{
	
	// here no need to create object of any library bcoz already we declared in BaseAPIClass in public 
	@Test
	public void createTheProject() throws SQLException
	{
		//step 1:create the necessary data
		ProjectLibrary pLib = new ProjectLibrary("GokulRaj","TestYatra"+jLib.getRandomNumber(),"created",40);	

		//step 2:send request 
		Response response = given().body(pLib).contentType(ContentType.JSON) 
				           .when()
				              .post(EndpointsLibrary.createProject);
		//			       .then()
			//		          .assertThat().statusCode(201).log().all();	

		//step 3: capture the project id in response body
		String expData = rLib.getJsonData(response,"projectId");
		System.out.println(expData);
		response.then().log().all();

		//step 4: validate the data
		String actData = dLib.readDataFromDBAndValidate(IConstants.query,1,expData);
		
		Assert.assertEquals(actData, expData);

	}
}
