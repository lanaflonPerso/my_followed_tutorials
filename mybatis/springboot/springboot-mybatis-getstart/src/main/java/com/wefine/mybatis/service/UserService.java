package com.wefine.mybatis.service;

import com.wefine.mybatis.entity.User;
import com.wefine.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper mapper;

    @Transactional
    public void insert(User user) {
        mapper.insert(user);
    }

    @Transactional
    public void insertBatch(List<User> users) {
        mapper.insertBatch(users);
    }
}
