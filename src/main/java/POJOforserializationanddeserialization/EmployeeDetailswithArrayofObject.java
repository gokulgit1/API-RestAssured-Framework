package POJOforserializationanddeserialization;

public class EmployeeDetailswithArrayofObject 
{
	String eName;
	String eId;
	String addres;
	int[] phoneno;//=new int[2];
	String[] email;//=new String[2];
	Object SpouseDetails;
	
	public EmployeeDetailswithArrayofObject(String eName, String eId, String addres, int[] phoneno, String[] email,
			Object spouseDetails) 
	{
		this.eName = eName;
		this.eId = eId;
		this.addres = addres;
		this.phoneno = phoneno;
		this.email = email;
		SpouseDetails = spouseDetails;
	}
	public EmployeeDetailswithArrayofObject()
	{
		
	}
	
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
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public int[] getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int[] phoneno) {
		this.phoneno = phoneno;
	}
	public String[] getEmail() {
		return email;
	}
	public void setEmail(String[] email) {
		this.email = email;
	}
	public Object getSpouseDetails() {
		return SpouseDetails;
	}
	public void setSpouseDetails(Object spouseDetails) {
		SpouseDetails = spouseDetails;
	}
	
	
}
