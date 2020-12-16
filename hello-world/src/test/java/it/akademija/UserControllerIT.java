package it.akademija;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import it.akademija.entities.User;
import it.akademija.model.CreateUserCommand;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { App.class })
public class UserControllerIT {

	private static final String URI = "/api/users";

	@Autowired
	private TestRestTemplate rest;

	@Test
	public void createsUserThenRetrievesUserListAndDeletesUser() {
		final String username = "testUsername";
		final String firstname = "testName";
		final String lastname = "testLastName";
		final int age = 45;
		final String email = "test@gmail.com";
		final CreateUserCommand createUser = new CreateUserCommand();

		createUser.setUsername(username);
		createUser.setFirstname(firstname);
		createUser.setLastname(lastname);
		createUser.setEmail(email);
		createUser.setAge(age);

		rest.postForLocation(URI, createUser);
		List<User> users = rest.getForEntity(URI, List.class).getBody();

		Assert.assertThat(users.size(), CoreMatchers.is(1));

		rest.delete(URI + "/" + username);
		users = rest.getForEntity(URI, List.class).getBody();
		Assert.assertThat(users.size(), CoreMatchers.is(0));

	}
}
