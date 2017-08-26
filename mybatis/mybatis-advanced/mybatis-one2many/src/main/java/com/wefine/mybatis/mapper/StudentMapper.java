package com.wefine.mybatis.mapper;

import com.wefine.mybatis.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> findAll();

    List<Student> findAllWithRef();

    Student findById(Long id);

    Student findByIdWithRef(Long id);

    void insertStudent(Student student);

    void insertStudentWithMap(Map<String, Object> map);

    void updateStudent(Student student);

    int deleteStudent(Long id);
}
