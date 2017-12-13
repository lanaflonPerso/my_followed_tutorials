package com.wefine.spring;

import com.wefine.spring.config.TimerConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        TimerConfig config = context.getBean(TimerConfig.class);

        System.out.println(config.getDateFormat().format(new Date()));
    }
}
