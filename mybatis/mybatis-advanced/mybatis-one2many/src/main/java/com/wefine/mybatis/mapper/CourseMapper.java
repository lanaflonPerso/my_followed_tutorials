package com.wefine.mybatis.mapper;

import com.wefine.mybatis.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper {

    List<Course> selectCoursesByTutor(int tutorId);

    List<Course> searchCourses(Map<String, Object> map);

    List<Course> searchCoursesByTutors(Map<String, Object> map);
}
