package com.wefine.mybatis.dao;


import com.wefine.mybatis.dvo.PetDVO;

import java.util.List;

public interface PetDAO {
    List<PetDVO> getAllPetsData();
    List<String> getAllSpecies();
    List<PetDVO> selectPets(String sex);
    PetDVO getPetObject(String petName);
    int createPet(PetDVO petDVO);
}
