package BasicCRUDoperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginRMGwithAuthTest 
{
@Test
public void loginRMGwithAuthTest()
{
	RequestSpecification req = RestAssured.given();
	//req.auth().basic("rmgyantra","rmgy@9999");
	//Response resp = req.get("http://localhost:8084/login");   //code optimization
	//resp.then().log().all();
	req.auth().basic("rmgyantra","rmgy@9999").get("http://localhost:8084/login").then().log().all();
}
}
