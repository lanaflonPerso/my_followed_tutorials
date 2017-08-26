package com.wefine.mybatis.mapper;

import com.wefine.mybatis.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseMapperTests {

    @Resource
    private CourseMapper mapper;

    @Test
    public void test01FindById() {
        Course course = mapper.findById(1L);

        System.out.println(course);
    }

    @Test
    public void test02FindByTutorId() {
        List<Course> courses = mapper.findByTutorId(1L);

        System.out.println(courses);
    }

    @Test
    public void test03SearchCoursesByTutors() {
        Map<String, Object> tutorIds = new HashMap<>();
        tutorIds.put("tutorIds", Arrays.asList(1L, 2L));

        List<Course> courses = mapper.searchCoursesByTutors(tutorIds);

        System.out.println(courses);
    }
}
