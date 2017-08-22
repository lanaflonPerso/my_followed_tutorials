package com.wefine.mybatis.dao;

import com.wefine.mybatis.dvo.PetDVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class PetDao {

    private static SqlSession getSqlSession() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream =
                Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }

    public List<PetDVO> getAllPetsData() throws Exception {
        return getSqlSession().selectList("getAllPets");
    }

    public PetDVO getPetObject(String petName) throws Exception {
        HashMap<String, String> inputMap = new HashMap<>();
        inputMap.put("name", petName);
        return (PetDVO) getSqlSession().selectOne("getPetObject", inputMap);
    }

    public List<String> getAllSpecies() throws Exception {
        return getSqlSession().selectList("getAllSpecies");
    }

    public List<PetDVO> selectPets(String sex) throws Exception {
        HashMap<String, String> inputMap = new HashMap<>();
        inputMap.put("sex", sex);
        return getSqlSession().selectList("selectPets", inputMap);
    }

    public void createPet(PetDVO petDVO) throws Exception {
        HashMap<String, Object> inputMap = new HashMap<>();

        inputMap.put("name", petDVO.getName());
        inputMap.put("owner", petDVO.getOwner());
        inputMap.put("species", petDVO.getSpecies());
        inputMap.put("sex", petDVO.getSex());
        inputMap.put("birth", petDVO.getBirth());

        // Get the sql session and commit the data
        SqlSession sqlSession = getSqlSession();
        sqlSession.insert("createPet", inputMap);
        sqlSession.commit();

        // Printing the generated sequence number
        System.out.println("--- Id value ---" + inputMap.get("id"));
    }

    public void updatePetData(PetDVO petDVO) throws Exception {
        HashMap<String, Object> inputMap = new HashMap<>();
        inputMap.put("birth", petDVO.getBirth());
        inputMap.put("sex", petDVO.getSex());
        inputMap.put("name", petDVO.getName());
        SqlSession sqlSession = getSqlSession();
        sqlSession.update("updatePetData", inputMap);
        sqlSession.commit();
    }

    public void deletePet(PetDVO petDVO) throws Exception {
        HashMap<String, String> inputMap = new HashMap<>();
        inputMap.put("species", petDVO.getSpecies());
        inputMap.put("name", petDVO.getName());

        System.out.println("--- try to delete Pet ---" + inputMap);
        SqlSession sqlSession = getSqlSession();
        sqlSession.update("deletePet", inputMap);
        sqlSession.commit();
    }
}
