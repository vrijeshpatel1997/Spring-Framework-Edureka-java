package bean;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class User {

	
	// variables
	String firstName;
	String lastName;
	String userName;
	String password;

	String email;

	
	// constructor 
	public User() {
		firstName = "";
		lastName = "";
		userName = "";
		password = "";
		email = "";

	}
// getters and setters 
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
