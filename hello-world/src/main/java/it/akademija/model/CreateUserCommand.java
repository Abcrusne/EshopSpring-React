package it.akademija.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreateUserCommand {

	@NotNull
	@Length(min = 1, max = 30)
	private String username;

//	@NotNull
//	@Length(min = 1, max = 100)
	private String firstname;

//	@NotNull
//	@Length(min = 1, max = 100)
	private String lastname;

//	@NotNull
//	@Length(min = 1, max = 100)
//	@Email
	private String email;

	// @NotNull
	private int age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

}
