package com.wefine.tutorials.springboot.service;

import com.wefine.tutorials.springboot.model.Action;
import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {

    @Action(name = "注解事件--Add操作")
    public void add() {
    }
}
