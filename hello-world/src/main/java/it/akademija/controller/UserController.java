package it.akademija.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.akademija.PagingData;
import it.akademija.model.CreateUserCommand;
import it.akademija.model.User;
import it.akademija.service.UserService;

//@RestController
//@Api(value = "user")
//@RequestMapping(value = "/api/users")
//public class UserController {
//
//	private final UserDAO userDao;
//	private UserService userService;
//
//	@Autowired
//	public UserController(UserDAO userDao) {
//		this.userDao = userDao;
//	}
//
//	@RequestMapping(method = RequestMethod.GET)
//	@ApiOperation(value = "Get users", notes = "Returns registered users")
//	public List<User> getUsers() {
//		return userDao.getUsers();
//	}
//
//	@RequestMapping(method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	@ApiOperation(value = "Create user", notes = "Creates user with data")
//	public void createUser(@ApiParam(value = "User Data", required = true) @RequestBody CreateUserCommand cmd) {
//		Long id = cmd.getId();
//		String username = cmd.getUsername();
//		String firstName = cmd.getFirstName();
//		String lastName = cmd.getLastName();
//		String email = cmd.getEmail();
//		userDao.createUser(new User(id, username, firstName, lastName, email));
//	}
//
//	@RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	@ApiOperation(value = "Delete user", notes = "Deletes user by username")
//	public void deleteUser(@PathVariable String username) {
//		userDao.deleteUser(username);
//	}
//
//}
@RestController
@Api(value = "user")
@RequestMapping(value = "/api/users")
public class UserController {

	private UserService userService;
	private PagingData pagingData;

	@Autowired
	public UserController(UserService userService, PagingData pagingData) {
		super();
		this.userService = userService;
		this.pagingData = pagingData;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PagingData getPagingData() {
		return pagingData;
	}

	public void setPagingData(PagingData pagingData) {
		this.pagingData = pagingData;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get users", notes = "Returns registered users")
	public List<User> getUsers() {
		pagingData.setLimit(10);
		return userService.getUsers();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create user", notes = "Creates users with data")
	public void createUser(
			@ApiParam(value = "User Data", required = true) @Valid @RequestBody final CreateUserCommand cmd) {
		User user = new User(cmd.getUsername(), cmd.getFirstName(), cmd.getLastName(), cmd.getEmail(), cmd.getAge());
		userService.createUser(user);
		System.out.println("Created user with username: " + user.getUsername());
	}

	/* Apdoros užklausas: DELETE /api/users/<vartotojas> */
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete user", notes = "Deletes user by username")
	public void deleteUser(@PathVariable final String username) {
		userService.deleteUser(username);
		System.out.println("Deleting user: " + username);
	}

}
