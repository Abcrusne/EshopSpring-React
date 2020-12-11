package it.akademija.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.model.User;

public interface DBUserDao extends JpaRepository<User, Long> {

}
