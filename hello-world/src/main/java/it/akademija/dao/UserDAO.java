package it.akademija.dao;

import java.util.List;

import it.akademija.entities.User;

public interface UserDAO {

	List<User> getUsers();

	void createUser(User user);

	void deleteUser(String username);

}
