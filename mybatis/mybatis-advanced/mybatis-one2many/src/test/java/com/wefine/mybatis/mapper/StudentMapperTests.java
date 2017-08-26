package com.wefine.mybatis.mapper;

import com.wefine.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTests {

    @Resource
    private StudentMapper mapper;

    @Test
    public void test01FindAll() {
        List<Student> students = mapper.findAll();

        System.out.println(students);
    }

    @Test
    public void test02FindAllWithRef() {
        List<Student> students = mapper.findAllWithRef();

        System.out.println(students);
    }

    @Test
    public void test03FindById() {
        Student student = mapper.findById(1L);

        System.out.println(student);
    }

    @Test
    public void test04FindByIdWithRef() {
        Student student = mapper.findByIdWithRef(1L);

        System.out.println(student);
    }
}
