package com.wefine.tutorials.spring.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTestWithRestTemplate {

    @Resource
    private TestRestTemplate template;

    @Test
    public void getHello() throws Exception {

        String body = template.getForObject("/hello", String.class);
        assertThat(body).isEqualTo("Hello World");
    }
}
