package ResponseValidation;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;



public class ResponseTimeValidation 
{
@Test
public void resPonseTimeValidationTest()
{
	baseURI="http://localhost:8084";
	long expTime = 600;
	
	//step 1:send the request
	Response resp = when().get("/projects");
	
	//step 2:capture the response
	long time = resp.getTime();
	if(time<=expTime)
	{
		System.out.println("time validated"+ " "+time);
	}
	else
	{
		System.out.println("time not validated"+" "+time);
	}
}

}
