package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation 
{
	@Test
	public void dynamicResponseValidationTest()
	{
		baseURI="http://localhost:8084";

		String expData="TY_PROJ_2202";

		//step 1:send the request
		Response res = when().get("/projects");

		//step 2: captured the response by writting json path
		boolean flag=false;
		List<String> list = res.jsonPath().get("projectId");
		for(String data:list)
		{
			if(data.equalsIgnoreCase(expData))
			{
				System.out.println(data);
				flag=true; //flag rising
				break;
			}
		}
		
		//step 3:validate
		Assert.assertTrue(flag);
	
	}
}
