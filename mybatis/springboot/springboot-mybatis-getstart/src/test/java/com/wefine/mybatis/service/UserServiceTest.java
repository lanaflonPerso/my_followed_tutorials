package com.wefine.mybatis.service;

import com.wefine.mybatis.entity.SexEnum;
import com.wefine.mybatis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserService service;

    @Test
    public void testInsertBatch(){
        List<User> users = new ArrayList<>();
        users.add(new User("wefine", "a123456", SexEnum.MAN));
        users.add(new User("fenian", "a123456", SexEnum.WOMAN));
        users.add(new User("follow", "a123456", SexEnum.WOMAN));

        service.insertBatch(users);
    }

}
