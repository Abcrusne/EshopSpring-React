package it.akademija.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import it.akademija.dao.DBUserDao;
import it.akademija.model.User;

@Service
@ApiOperation(value = "UserService")
public class UserService {

	@Autowired
	private DBUserDao dbUserDao;

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return dbUserDao.getUsers();

	}

	@Transactional
	public void createUser(User user) {
		dbUserDao.createUser(user);

	}

	@Transactional
	public void deleteUser(String username) {
		dbUserDao.deleteUser(username);

	}

//	@Transactional
//	public void deleteUserById(@PathVariable final Long id) {
//		dbUserDao.deleteById(id);
//	}

	@Transactional
	@RequestMapping("/findOldestUser")
	public User findOldestUser() {
		return dbUserDao.findOldestUser();
	}

	@Transactional
	public User findByFirstnameAndLastname(String firstname, String lastname) {
		return dbUserDao.findByFirstnameAndLastname(firstname, lastname);
	}

	public DBUserDao getDbUserDao() {
		return dbUserDao;
	}

	public void setDbUserDao(DBUserDao dbUserDao) {
		this.dbUserDao = dbUserDao;
	}

//	@Autowired
//	private List<User> users;
//	@RequestMapping("/findUsersByName")
//	public User findByFirstnameAndLastname(String firstname, String lastname)
//
//	{
//		for (User user : users)
//			if (user.getFirstname().equals(firstname) && user.getLastname().equals(lastname)) {
//				return user;
//			}
//		return null;
	// }
//
//	@RequestMapping("/findOldestUser")
//	public User findOldestUser() {
//		return Collections.max(users, Comparator.comparingInt(u -> u.getAge()));
//	}
//	@RequestMapping(path = "/findUsersByName", method = RequestMethod.GET)
//	public User findUser(@RequestParam String firstname, @RequestParam String lastname) {
//		return userService.findByFirstnameAndLastname(firstname, lastname);
//	}
//
//	@RequestMapping(path = "/findOldestUser", method = RequestMethod.GET)
//	public User findOldestUser() {
//		return userService.findOldestUser();
//	}

}
