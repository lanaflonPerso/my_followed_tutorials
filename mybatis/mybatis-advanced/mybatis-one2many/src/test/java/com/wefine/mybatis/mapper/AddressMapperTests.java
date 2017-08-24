package com.wefine.mybatis.mapper;

import com.wefine.mybatis.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {

    @Resource
    private AddressMapper mapper;

    @Test
    public void test() {
        Address address = mapper.findById(1L);

        System.out.println(address);
    }
}
