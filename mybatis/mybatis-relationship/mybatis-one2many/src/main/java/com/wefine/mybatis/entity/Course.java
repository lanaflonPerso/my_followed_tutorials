package com.wefine.mybatis.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long courseId;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Tutor tutor;
    private List<Student> students;

    public List<Student> getStudents() {
        if (students == null) {
            students = new ArrayList<>(0);
        }
        return students;
    }
}
