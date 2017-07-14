package com.wefine.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/greeting")
public class GreetingController {

    @GetMapping("{name}")
    public String greeting(@PathVariable String name) {
        return "Hello, " + name + " !";
    }
}
