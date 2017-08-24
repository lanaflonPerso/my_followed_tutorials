package com.wefine.mybatis.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Pet {
    private Long id;
    private String name;
    private String owner;
    private String species;
    private String sex;
    private Date birth;
    private Date death;
}
