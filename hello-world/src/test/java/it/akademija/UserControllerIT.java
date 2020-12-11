package it.akademija;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { App.class })
public class UserControllerIT {

	private static final String URI = "/api/users";

	@Autowired
	private TestRestTemplate rest;

	@Test
	public void createsUserThenRetrievesUserListAndDeletesUser() {
//		final Long id = 123L;
//		final String username = "testUsername";
//		final String firstName = "testFirstname";
//		final String lastName = "testLastname";
//		final String email = "test@mail.lt";
//		final CreateUserCommand createUser = new CreateUserCommand();
//		createUser.setId(id);
//		createUser.setUsername(username);
//		createUser.setFirstName(firstName);
//		createUser.setLastName(lastName);
//		createUser.setEmail(email);
//		rest.postForLocation(URI, createUser);
//		List<User> users = rest.getForEntity(URI, List.class).getBody();
//		Assert.assertThat(users.size(), CoreMatchers.is(1));
//		rest.delete(URI + "/" + username);
//		users = rest.getForEntity(URI, List.class).getBody();
//		Assert.assertThat(users.size(), CoreMatchers.is(0));
	}
}