package com.wefine.mybatis.mapper;

import com.wefine.mybatis.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Select("select * from address")
    List<Address> findAll();

    Address findById(Long id);

    void insert(Address address);
}
