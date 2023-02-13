package Faculty.bo;

public class addfaculty_bo 
{
	private int id;
	private String name;
	private String Age;
	private String gender;
	private String dept;
	private String contact;
	private String salary;
	private String location;
	private String email;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "addfaculty_bo [id=" + id + ", name=" + name + ", Age=" + Age + ", gender=" + gender + ", dept=" + dept
				+ ", contact=" + contact + ", salary=" + salary + ", location=" + location + ",email=" + email + ",password=" + password +  "]";
	}
	public addfaculty_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public addfaculty_bo( String name, String age, String gender, String dept, String contact, String salary,
			String location,String email,String password) {
		super();
		this.id = id;
		this.name = name;
		this.Age = age;
		this.gender = gender;
		this.dept = dept;
		this.contact = contact;
		this.salary = salary;
		this.location = location;
		this.email = email;
		this.password=password;
	}
	
	
	

}
