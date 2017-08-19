package com.wefine.reactive.service.impl;

import com.wefine.reactive.dao.UserDao;
import com.wefine.reactive.model.User;
import com.wefine.reactive.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User save(User user) {
        return userDao.save(user);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
