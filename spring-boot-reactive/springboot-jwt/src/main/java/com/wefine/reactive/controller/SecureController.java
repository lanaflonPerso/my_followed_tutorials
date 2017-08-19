package com.wefine.reactive.controller;

import com.wefine.reactive.model.User;
import com.wefine.reactive.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/secure")
public class SecureController {

    @Resource
    private UserService userService;

    @RequestMapping("/user/users")
    public String loginSuccess() {
        return "Login Successful!";
    }

    @RequestMapping(value = "/user/email", method = RequestMethod.POST)
    public User findByEmail(@RequestBody String email) {
        return userService.findByEmail(email);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }
}
