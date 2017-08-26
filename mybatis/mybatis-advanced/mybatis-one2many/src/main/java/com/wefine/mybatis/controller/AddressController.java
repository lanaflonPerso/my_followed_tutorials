package com.wefine.mybatis.controller;

import com.wefine.mybatis.entity.Address;
import com.wefine.mybatis.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AddressController {

    @Resource
    private AddressService service;

    @GetMapping("/address")
    public List<Address> paging(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "0") int pageSize) {
        return service.paging(pageNum, pageSize);
    }

}
