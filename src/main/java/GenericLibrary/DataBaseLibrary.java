package GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class database specific re-usable methods
 * @author Gokul
 *
 */
public class DataBaseLibrary 
{
	Driver driverRef;
	Connection conn=null;
	/**
	 * This method will Establish the connection with mysql DB
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection(IConstants.dbURL,IConstants.dbUserName,IConstants.dbPassword);
	}
	/**
	 * This method will close the database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		conn.close();
	}
    /**
     * This method is used to read and validate the data from Response body
     * @param query
     * @param columnIndex
     * @param expData
     * @return
     * @throws SQLException
     */
	public String readDataFromDBAndValidate(String query,int columnIndex,String expData) throws SQLException
	{
		boolean flag = false;
		ResultSet result = conn.createStatement().executeQuery(query);
		System.out.println("Query executed");
		while(result.next())
		{
			
			if(result.getString(columnIndex).equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("data verified");
			return expData;	
		}
		else
		{
			System.out.println("data not verified");
			return "";
		}
	}
}
