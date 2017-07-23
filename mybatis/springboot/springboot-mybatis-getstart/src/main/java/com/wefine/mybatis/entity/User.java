package com.wefine.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Long id;
    private String name;
    private String password;
    private SexEnum sex;
    private String nickName;

    public User(String name, String password, SexEnum sex){
        this.name = name;
        this.password = password;
        this.sex = sex;
    }
}
