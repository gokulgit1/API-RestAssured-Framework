package GenericLibrary;

import io.restassured.response.Response;

/**
 * This class Contains RestAssured specific re-usable methods
 * @author Gokul
 *
 */
public class RestAssuredLibrary 
{
	/**
	 * This method will get the json data through json path from response body 
	 * @param response
	 * @param path
	 * @return
	 */
public String getJsonData(Response response,String path)
{
	
	String jsonData = response.jsonPath().get(path);
	return jsonData;
}
}
