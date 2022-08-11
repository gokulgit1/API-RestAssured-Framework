package BasicCRUDoperation;


import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest
{
@Test
public void createProjectTest()
{
	//create the Random Number
	Random r=new Random();
	int random=r.nextInt(500);
	
	//step 1:create the necessary data
     JSONObject jobj=new JSONObject();
     jobj.put("createdBy","Gokul");
     jobj.put("projectName", "TYSS"+random);
     jobj.put("status","Created");
     jobj.put("teamSize",20);
          
	//step 2:send the request
     RequestSpecification req=RestAssured.given();
     req.body(jobj);
     req.contentType(ContentType.JSON);
     Response resp = req.post("http://localhost:8084/addProject");
         
	  //step 3:validate the response
      // System.out.println(resp.asString());
      // System.out.println(resp.prettyPrint());
      // System.out.println(resp.prettyPeek());
     
     ValidatableResponse validate=resp.then();
     validate.log().all();     
}
}
