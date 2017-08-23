package org.xman.mybatis;

import com.wefine.mybatis.entity.Pet;
import com.wefine.mybatis.mapper.PetMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({@ContextConfiguration(
        locations = {"classpath*:applicationContext.xml"}
)})
public class PetMapperTest {

    @Autowired
    private PetMapper mapper;

    @Test
    public void test01CreatePet() throws Exception {
        List<Pet> pets = mapper.findAll();

        System.out.println(pets.size());
    }

}
