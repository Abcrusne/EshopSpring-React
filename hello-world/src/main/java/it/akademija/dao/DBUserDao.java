package it.akademija.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.akademija.model.User;

public interface DBUserDao extends JpaRepository<User, Long>, UserDAO {

	default List<User> getUsers() {
		return this.findAll();
	}

	default void createUser(User user) {
		this.save(user);
	}

	default void deleteUser(String username) {
		this.deleteByUsername(username);
	}

	void deleteByUsername(String username);

//	@Modifying
//	@Query("delete from User where id = :id")
//	void deleteUserById(Long id);

	User findByFirstnameAndLastname(String firstname, String lastname);

	@Query("select u from User u where u.age = (select max(u1.age) from User u1)")
	User findOldestUser();

}
