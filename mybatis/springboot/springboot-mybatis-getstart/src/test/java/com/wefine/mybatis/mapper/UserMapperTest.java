package com.wefine.mybatis.mapper;

import java.util.ArrayList;
import java.util.List;

import com.wefine.mybatis.entity.SexEnum;
import com.wefine.mybatis.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper mapper;

	@Test
	public void testInsert() throws Exception {
		mapper.insert(new User("aa", "a123456", SexEnum.MAN));
		mapper.insert(new User("bb", "b123456", SexEnum.WOMAN));
		mapper.insert(new User("cc", "b123456", SexEnum.WOMAN));

		Assert.assertEquals(3, mapper.getAll().size());
	}

	@Test
	public void testInsertBatch() throws Exception {
	    List<User> users = new ArrayList<>();
	    users.add(new User("aa", "a123456", SexEnum.MAN));
	    users.add(new User("bb", "a123456", SexEnum.WOMAN));
	    users.add(new User("cc", "a123456", SexEnum.WOMAN));

        mapper.insertBatch(users);
	}

	@Test
	public void testQuery() throws Exception {
		List<User> users = mapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}

	@Test
	public void testUpdate() throws Exception {
		User user = mapper.getOne(6L);
		System.out.println(user.toString());
		user.setNickName("wefine");
		mapper.update(user);
		Assert.assertTrue(("wefine".equals(mapper.getOne(6L).getNickName())));
	}

}
