package it.akademija.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import it.akademija.dao.DBUserDao;
import it.akademija.model.User;

@Service
public class UserService {

	@Autowired
	private DBUserDao dbUserDao;

	public DBUserDao getDBuserDao() {
		return dbUserDao;
	}

	public void setDBuserDao(DBUserDao dbUserDao) {
		this.dbUserDao = dbUserDao;
	}

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return dbUserDao.findAll();

	}

	@Transactional
	public void createUser(User user) {
		dbUserDao.save(user);
	}

	@Transactional
	public void deleteUser(@PathVariable final Long id) {
		dbUserDao.deleteById(id);

	}

}
