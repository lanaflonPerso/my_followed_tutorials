package com.wefine.tutorials.spring.web;

import com.wefine.tutorials.spring.conf.FooProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
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