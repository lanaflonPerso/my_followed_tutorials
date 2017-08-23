package com.wefine.mybatis.dao;

import com.wefine.mybatis.dvo.PetDVO;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.HashMap;
import java.util.List;

public class PetDAOImpl implements PetDAO {
    private SqlSessionTemplate sqlSessionTemplate;

    public List<PetDVO> getAllPetsData() {
        return sqlSessionTemplate.selectList("getAllPets");
    }

    public List<String> getAllSpecies() {
        return sqlSessionTemplate.selectList("getAllSpecies");
    }

    public List<PetDVO> selectPets(String sex) {
        HashMap<String, String> inputMap = new HashMap<>();
        inputMap.put("sex", sex);
        return sqlSessionTemplate.selectList("selectPets", inputMap);
    }

    public PetDVO getPetObject(String petName) {
        HashMap<String, String> inputMap = new HashMap<>();
        inputMap.put("name", petName);
        return (PetDVO) sqlSessionTemplate.selectOne("getPetObject", inputMap);
    }

    public int createPet(PetDVO petDVO) {
        HashMap<String, Object> inputMap = new HashMap<>();
        inputMap.put("name", petDVO.getName());
        inputMap.put("owner", petDVO.getOwner() );
        inputMap.put("species", petDVO.getSpecies() );
        inputMap.put("sex", petDVO.getSex());
        inputMap.put("birth", petDVO.getBirth());
        inputMap.put("death", petDVO.getDeath());

        sqlSessionTemplate.insert("createPet", inputMap);

        return Integer.parseInt(inputMap.get("id").toString());
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
