package com.wefine.mybatis.controller;

import com.wefine.mybatis.entity.User;
import com.wefine.mybatis.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return userMapper.getOne(id);
    }
}
