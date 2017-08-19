package com.wefine.reactive.service;

import com.wefine.reactive.model.User;

public interface UserService {
	User save(User user);

	User findByEmail(String email);

}
