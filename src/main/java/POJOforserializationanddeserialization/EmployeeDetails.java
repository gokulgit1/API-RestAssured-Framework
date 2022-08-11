package POJOforserializationanddeserialization;

public class EmployeeDetails 
{
	//rule :1 declare the variable as global
	String eName;
	String eId;
	int phoneno;
	String address;

	// rule:2 create the constructor for to initialize the variables
	public EmployeeDetails(String eName, String eId, int phoneno, String address)
	{
		this.eName = eName;
		this.eId = eId;
		this.phoneno = phoneno;
		this.address = address;
	}
	
	//empty constructor only for deserialization
	public void EmployeeDetails()
	{
		
	}
//rule:3 create a getter and setter method for access

	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	


}
