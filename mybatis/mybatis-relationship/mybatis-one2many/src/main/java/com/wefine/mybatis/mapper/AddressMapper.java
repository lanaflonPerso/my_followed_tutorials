package com.wefine.mybatis.mapper;

import com.wefine.mybatis.entity.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
    Address findAddressById(Long id);
}
