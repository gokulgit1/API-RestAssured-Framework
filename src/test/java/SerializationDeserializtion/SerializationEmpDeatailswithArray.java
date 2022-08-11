package SerializationDeserializtion;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforserializationanddeserialization.EmployeeDetailswithArray;

public class SerializationEmpDeatailswithArray 
{
@Test
public void SerializationEmpDeatailswithArrayTest() throws JsonGenerationException, JsonMappingException, IOException
{
	//step:1 create object of pojo and provide values
	int[] id= {123,456};
	String[] email= {"abc","xyz"};
	EmployeeDetailswithArray emp1=new EmployeeDetailswithArray("Gokul", "Ty123", "Sivakasi", id, email);
	ObjectMapper obj=new ObjectMapper();
	obj.writeValue(new File("./EmpDeatilswithArray.json"), emp1);
}
}
