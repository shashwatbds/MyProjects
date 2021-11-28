package youtube.streams;

public class UserWithPhone {

	private String name;
	private int age=30;
	
	public UserWithPhone(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Name : "+this.getName()+", Age : "+this.getAge();
	}
}
