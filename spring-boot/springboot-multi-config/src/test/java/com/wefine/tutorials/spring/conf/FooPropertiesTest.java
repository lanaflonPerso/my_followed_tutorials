package com.wefine.tutorials.spring.conf;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FooPropertiesTest {

    @Autowired
    private FooProperties properties;

    @Test
    public void testBlogProperties() {
        Assert.assertEquals("中文码", properties.getSecurity().getPassword());

        log.info("随机int : " + properties.getCounter());
    }
}
