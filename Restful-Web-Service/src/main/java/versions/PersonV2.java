package versions;

public class PersonV2 {
	private String fName;
	private String lName;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public PersonV2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonV2(String fName, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
	}
}
