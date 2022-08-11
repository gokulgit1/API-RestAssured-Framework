package SerializationDeserializtion;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforserializationanddeserialization.EmployeeDetailswithArrayofObject;
import POJOforserializationanddeserialization.SpouseDetails;

public class DeserializationEmployeeDeatilsObject 
{
@Test
public void DeserializationEmployeeDeatilsObjectTest() throws Throwable
{
	ObjectMapper obj=new ObjectMapper();
	EmployeeDetailswithArrayofObject emp=obj.readValue(new File(".\\EmpDeatilsObject.json"),EmployeeDetailswithArrayofObject.class);
	System.out.println(emp.getAddres());
	System.out.println(emp.geteName());
	System.out.println(emp.getPhoneno()[1]);
	System.out.println(emp.getEmail()[0]);
	System.out.println(emp.getSpouseDetails());       /// spouse details
}
}
