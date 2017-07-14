package com.wefine.distributed.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnowFlakeController {

    @GetMapping("/snowflake")
    public String snowflake() {
        return "Hello World";
    }

}
