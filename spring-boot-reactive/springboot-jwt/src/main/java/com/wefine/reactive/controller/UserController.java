package com.wefine.reactive.controller;

import com.wefine.reactive.model.User;
import com.wefine.reactive.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import java.util.Date;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User login) throws ServletException {

        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = login.getEmail();
        String password = login.getPassword();

        User user = userService.findByEmail(email);

        if (user == null) {
            throw new ServletException("User email not found.");
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }

        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return jwtToken;
    }
}
