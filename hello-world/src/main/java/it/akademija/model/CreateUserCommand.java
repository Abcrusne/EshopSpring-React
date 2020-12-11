package it.akademija.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public final class CreateUserCommand {
	@NotNull
	private Long id;

	@NotNull
	@Length(min = 1, max = 30)
	private String username;
	@NotNull
	@Length(min = 1, max = 100)
	private String firstName;
	@NotNull
	@Length(min = 1, max = 100)
	private String lastName;
	@NotNull
	@Length(min = 1, max = 100)
	@Email
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
