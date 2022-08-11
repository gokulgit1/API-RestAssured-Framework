package BasicCRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectTestBDD 
{
	@Test
	public void deleteProjectTestBDD()
	{
		baseURI="http://localhost";
		port=8084;

		when()
		    .delete("/projects/TY_PROJ_824")
		.then()
		   .assertThat().statusCode(204).log().all();
	}
}
