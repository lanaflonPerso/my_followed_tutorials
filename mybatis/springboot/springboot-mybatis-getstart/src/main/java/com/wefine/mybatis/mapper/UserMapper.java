package com.wefine.mybatis.mapper;

import com.wefine.mybatis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void insertBatch(List<User> users);

    void update(User user);

    void delete(Long id);
}
