package DifftWaysToPosttheRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectwithJSONFile
{
	@Test
	public void createProject() //this JSONFile first time only executed 2nd time it will through error bcoz of random number we cannot append
	{
		baseURI="http://localhost:8084";
      //step 1: create the data
		File file=new File(".\\src\\test\\resources\\APIReqData.json");
		
		given()
		 .body(file)
		 .contentType(ContentType.JSON)
		.when()                        //Step 2: perform Action
		 .post("/addProject")
		.then()                        //Step 3: Validation
		 .assertThat().statusCode(201)
		 .log().all();
		
		
	}
}
