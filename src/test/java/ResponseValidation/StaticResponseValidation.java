package ResponseValidation;

import static io.restassured.RestAssured.baseURI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation
{
@Test
public void staticResponseValidationTest()
{
	baseURI="http://localhost:8084";

	String expData="TY_PROJ_1202";

	//step 1:send the request and validate the response
	Response resp=when()
			           .get("/projects");
	
	String actData=resp.jsonPath().get("[2].projectId");
	System.out.println(actData);
	
	Assert.assertEquals(expData,actData);
	resp.then().log().all();
}
}
