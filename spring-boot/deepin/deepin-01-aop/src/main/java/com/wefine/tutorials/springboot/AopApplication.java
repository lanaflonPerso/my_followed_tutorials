package com.wefine.tutorials.springboot;

import com.wefine.tutorials.springboot.service.DemoAnnotationService;
import com.wefine.tutorials.springboot.service.DemoMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Resource
    private DemoAnnotationService demoAnnotationService;
    @Resource
    private DemoMethodService demoMethodService;

    @Override
    public void run(String... strings) throws Exception {
        demoAnnotationService.add();
        demoMethodService.add();
    }
}
