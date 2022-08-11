package SerializationDeserializtion;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforserializationanddeserialization.EmployeeDetailswithArrayofObject;
import POJOforserializationanddeserialization.SpouseDetails;

public class SerializationwithObjectTest 
{
	@Test
	public void SerializationwithObjectTest1() throws JsonGenerationException, JsonMappingException, IOException {
	int[] id= {123,456};
	String[] email= {"abc","xyz"};
	EmployeeDetailswithArrayofObject emp=new EmployeeDetailswithArrayofObject("Gokul","TY123","TN", id, email,new SpouseDetails("XYZ",21,"CTS"));
	ObjectMapper obj=new ObjectMapper();
	obj.writeValue(new File("./EmpDeatilsObject.json"),emp);
	}
}
