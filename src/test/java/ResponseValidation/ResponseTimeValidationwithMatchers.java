package ResponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidationwithMatchers 
{
@Test
public void responseTimeValidationTest()
{
	baseURI="http://localhost:8084";
	
	//step 1:send the request and validate the response
	 when()
	  .get("/projects")
	 .then()
	   .assertThat().time(Matchers.lessThan(600L),TimeUnit.MILLISECONDS);
	
}
}
