package BasicCRUDoperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest 
{
@Test
public void updateProjectTest()
{
	//step 1:create the necessary data
	JSONObject jobj=new JSONObject();
    jobj.put("createdBy","Gokul");
    jobj.put("projectName", "TYSS");
    jobj.put("status","On Going");
    jobj.put("teamSize",10);
    
	//step 2:send the request
    RequestSpecification req=RestAssured.given();
    req.body(jobj);
    req.contentType(ContentType.JSON);
    Response resp=req.put("http://localhost:8084/projects/TY_PROJ_1602");
    
	//step 3:validate the response
    resp.then().log().all();
}
}
