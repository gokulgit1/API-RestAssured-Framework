package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0 
{
@Test
public void oauth2_0Test()
{
	baseURI="http://coop.apps.symfonycasts.com";
	
	//step 1: generate the access token
	 Response resp = given()
	 .formParam("client_id", "SEDT36-REST-Espinaca")
	 .formParam("client_secret", "c3e6de6f3cc4c3d727490da48b9dd892")
	 .formParam("grant_type", "client_credentials")
	 .formParam("redirect_uri", "http://espinaca.com")
	 .formParam("code", "authorization_code")
	 
	 .when()
	  .post("/token");
	  //.then().log().all();
	
	//step 2:capture the access token using json path
	String token = resp.jsonPath().get("access_token");
	System.out.println(token);
	
	//step 3:utilise the access token
	given()
	 .auth()
	 .oauth2(token)
	 .pathParam("USER_ID",3679)
	 
	 .when()
	  .post("/api/{USER_ID}/chickens-feed")
	  .then().log().all();
	
}
}
