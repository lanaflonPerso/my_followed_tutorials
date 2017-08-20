package com.wefine.reactive.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wefine.reactive.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	User save(User user);

	User findByEmail(String email);
}
