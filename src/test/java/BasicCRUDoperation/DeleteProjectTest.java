package BasicCRUDoperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest 
{
@Test
public void deleteProjectTest()
{
	Response resp=RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1402");
	resp.then().log().all();
}
}
