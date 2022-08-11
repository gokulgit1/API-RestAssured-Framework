package GenericLibrary;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class BaseAPIClass 
{
	public DataBaseLibrary dLib = new DataBaseLibrary();
	public JavaLibrary jLib = new JavaLibrary();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();

	@BeforeSuite
	public void bsConfig() throws SQLException
	{
	    dLib.connectToDB();
		Reporter.log("===connection sucessfull===",true);
		baseURI = IConstants.baseURI;
		port = IConstants.port;
	}

	@AfterSuite
	public void asConfig() throws SQLException
	{
		dLib.closeDB();
		Reporter.log("===connction closed===",true);
	}
}
