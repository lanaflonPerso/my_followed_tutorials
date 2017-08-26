package com.wefine.mybatis.mapper;

import com.wefine.mybatis.entity.Tutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorMapperTests {

    @Resource
    private TutorMapper mapper;

    @Test
    public void test01FindWithRefById() {
        Tutor address = mapper.findWithRefById(1L);

        System.out.println(address);
    }
}
