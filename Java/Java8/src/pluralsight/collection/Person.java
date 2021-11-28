package pluralsight.collection;

public class Person {

	private String fName;
	private String lName;
	private int age;
	private String gender;
	
	public Person(String fName, String lName, int age, String gender) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.gender = gender;
	}

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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return this.getfName()+", "+this.getlName()+" aged "+this.getAge()+ " and gender is "+this.getGender();
	}
}
