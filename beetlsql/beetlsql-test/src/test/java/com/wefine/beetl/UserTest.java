package com.wefine.beetl;


import com.wefine.app.conf.BeetlMgt;
import com.wefine.app.domain.User;
import org.beetl.sql.core.SQLManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserTest {
    private SQLManager sqlManager = BeetlMgt.getManager();

    @Test
    void test() throws Exception {
        Assert.assertNotNull(sqlManager);

        //使用内置的生成的sql 新增用户，如果需要获取主键，可以传入KeyHolder
        User user1 = new User();
        user1.setAge(36);
        user1.setName("wefine");
        sqlManager.insert(user1);

        User user2 = new User();
        user2.setAge(18);
        user2.setName("wefine");
        sqlManager.insert(user2);

        //使用内置sql查询用户
        int id = 1;
        User user = sqlManager.unique(User.class, id);

        //模板更新,仅仅根据id更新值不为null的列
        User newUser = new User();
        newUser.setId(1);
        newUser.setAge(20);
        sqlManager.updateTemplateById(newUser);

        //模板查询
        User query1 = new User();
        query1.setName("wefine");
        List<User> list1 = sqlManager.template(query1);

        //使用user.md 文件里的select语句
        User query2 = new User();
        query2.setName("wefine");
        List<User> list2 = sqlManager.select("user.select", User.class, query2);
    }
}
