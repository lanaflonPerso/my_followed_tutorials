package com.wefine.spring;

import java.util.Arrays;

import com.wefine.spring.web.MyDAO;
import com.wefine.spring.web.MyService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		MyService service = context.getBean("myservice-123", MyService.class);
		MyDAO dao = context.getBean("mydao-123", MyDAO.class);

		Assert.isTrue(dao == service.getDefaultDao(), "it's same");
		Assert.isTrue(dao == service.getDaoRegistry().get("dao1"), "it's same");
		System.out.println(Arrays.toString(dao.getFields().toArray()));

		context.close();
	}
}
