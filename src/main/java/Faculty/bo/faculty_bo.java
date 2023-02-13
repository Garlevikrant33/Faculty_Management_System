package Faculty.bo;

public class faculty_bo
{
  private int id;
  private String email;
  private String password;
  private String name;
  private String contact;
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
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
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

public faculty_bo(int id,String name, String contact, String email, String password) {
	super();
	this.id = id;
	this.name = name;
	this.contact = contact;
	this.email = email;
	this.password = password;
}
@Override
public String toString() {
	return "faculty_bo [id=" + id + ", name=" + name + ", contact=" + contact + ", email=" + email + ", password=" + password + "]";
}
public faculty_bo() {
	super();
	// TODO Auto-generated constructor stub
}
  
  
}
