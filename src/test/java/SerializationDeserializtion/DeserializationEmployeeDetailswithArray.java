package SerializationDeserializtion;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforserializationanddeserialization.EmployeeDetailswithArray;

public class DeserializationEmployeeDetailswithArray 
{
@Test
public void DeserializationEmployeeDetailswithArrayTest() throws JsonParseException, JsonMappingException, IOException
{
	// create object of object mapper from jackson mapper
		ObjectMapper obj=new ObjectMapper();
		
		//read the value from object mapper
		EmployeeDetailswithArray emp=obj.readValue(new File(".\\EmpDeatilswithArray.json"), EmployeeDetailswithArray.class);
		
		//fetch the required value from class
		System.out.println(emp.getAddres());
		System.out.println(emp.geteName());
		System.out.println(emp.getPhoneno()[1]);
		System.out.println(emp.getEmail()[0]);
}
}
