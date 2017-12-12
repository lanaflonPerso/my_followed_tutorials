package com.wefine.tutorials.springboot.aop;

import com.wefine.tutorials.springboot.model.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.wefine.tutorials.springboot.model.Action)")
    public void annotationPointCut() {
    }

    @After("annotationPointCut()")
    public void after(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);

        System.out.println("注解拦截：" + action.name());
    }

    @Before("execution(* com.wefine.tutorials.springboot.service.DemoMethodService.*(..))")
    public void before(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        System.out.println("方法拦截：" + method.getName());
    }
}
