package org.xman.mybatis;

import com.wefine.mybatis.dao.PetDAO;
import com.wefine.mybatis.dvo.PetDVO;
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
public class PetDaoTest {
    @Autowired
    private PetDAO petDAO;

    @Test
    public void test01CreatePet() throws Exception {
        PetDVO pet = new PetDVO();
        pet.setName("Xman");
        pet.setOwner("Wang");
        pet.setSpecies("monkey");
        pet.setBirth(new Date());
        pet.setSex("m");

        int id = petDAO.createPet(pet);

        System.out.println(id);
    }

    @Test
    public void test02SelectPets() throws Exception {
        List<PetDVO> pet = petDAO.selectPets("m");

        System.out.println(pet);
    }

    @Test
    public void test03GetPetObject() throws Exception {
        PetDVO pet = petDAO.getPetObject("Sunny");

        System.out.println(pet);
    }

    @Test
    public void testGetAllPetsData() throws Exception {
        List<PetDVO> list = petDAO.getAllPetsData();
        System.out.println(list.size());
    }

    @Test
    public void testGetAllSpecies() throws Exception {

        List<String> list = petDAO.getAllSpecies();
        System.out.println(list.size());
    }

}
