package Authentication;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerTokenTest 
{
@Test
public void bearerTokenTest()
{
	//step 1:create the requisties
	HashMap map=new HashMap();
	map.put("name", "SDET36-RESTAssured");
	map.put("description", "api-frameworker");
	
	given()
	 .auth()
	 .oauth2("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")
	 .body(map)
	 .contentType(ContentType.JSON)
	
	//step 2:send the request and validate the response
	.when()
	  .post("https://api.github.com/user/repos")
	  .then().log().all();
}
}
