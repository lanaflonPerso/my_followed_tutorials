package com.wefine.mybatis.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@Getter
@Setter
public class Tutor implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long tutorId;
    private String name;
    private String email;
    private Address address;
    private List<Course> courses;
}
