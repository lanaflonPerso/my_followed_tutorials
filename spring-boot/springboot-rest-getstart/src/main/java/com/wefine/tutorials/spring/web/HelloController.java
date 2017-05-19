package com.wefine.tutorials.spring.web;

import com.wefine.tutorials.spring.conf.FooProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class HelloController {

    @Autowired
    private FooProperties fooProperties;

    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @PostConstruct
    public void post() {
        System.out.println("==============");
        System.out.println(fooProperties);
        System.out.println("==============");
    }
}