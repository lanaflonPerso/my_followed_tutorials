package com.wefine.mybatis;

import com.wefine.mybatis.dao.PetDao;
import com.wefine.mybatis.dvo.PetDVO;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class PetDaoTest {
    PetDao petDao = new PetDao();

    @Test
    public void test01CreatePet() throws Exception {
        PetDVO pet = new PetDVO();
        pet.setName("Slimmmy");
        pet.setOwner("Suk");
        pet.setSpecies("snake");
        pet.setBirth(new Date());
        pet.setSex("m");

        petDao.createPet(pet);
    }

    @Test
    public void test02UpdatePetData() throws Exception {
        // Setting the data into a domain object
        PetDVO pet = new PetDVO();
        pet.setName("Slimmmy");
        pet.setSex("f");
        pet.setBirth(new Date());

        petDao.updatePetData(pet);
    }

    @Test
    public void test03GetAllPetsData() throws Exception {
        List<PetDVO> allPets = petDao.getAllPetsData();
        System.out.println("--- allPets ----" + allPets.size());
    }

    @Test
    public void test04DeletePet() throws Exception {
        PetDVO petDataObj = new PetDVO();
        petDataObj.setName("Slimmy1");
        petDataObj.setSpecies("snake");

        petDao.deletePet(petDataObj);
    }
}
