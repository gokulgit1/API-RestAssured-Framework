package ParameteriZation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter 
{
@Test
public void getThepParticularPageTest()
{
	baseURI="https://reqres.in/";
	
	//create the pre-requisties
	given()
    .queryParam("page", 2)
    .queryParam("page", 3)    //but it will given only 2 page
    
    //send the request & validate the response
   .when()
    .get("/api/users")
    .then()
    .assertThat().statusCode(200).log().all();
}
}
