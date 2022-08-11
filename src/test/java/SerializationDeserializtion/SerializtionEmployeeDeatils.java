package SerializationDeserializtion;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOforserializationanddeserialization.EmployeeDetails;

public class SerializtionEmployeeDeatils 
{
@Test
public void serializtionEmpDetailsTest() throws JsonGenerationException, JsonMappingException, IOException
{
	//step:1 create object of pojo and provide values
	EmployeeDetails emp=new EmployeeDetails("Gokul","rgokul@gmail.com",12345,"Tamilnadu");
	
	//step:2 create object of object mapper from jackson mapper
	ObjectMapper obj=new ObjectMapper();
	
	//step:3 write data into json file
	obj.writeValue(new File("./EmpDetails.json"), emp);
}
}
