package com.wefine.mybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wefine.mybatis.entity.Address;
import com.wefine.mybatis.mapper.AddressMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {

    private AddressMapper mapper;

    public AddressService(AddressMapper mapper) {
        this.mapper = mapper;
    }

    public List<Address> paging(int pageNum, int pageSize) {
        Page<Address> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> mapper.findAll());

        return page.getResult();
    }

    @Transactional
    public Address insert(Address address) {
        mapper.insert(address);

        return address;
    }
}
