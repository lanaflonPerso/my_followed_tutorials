package com.wefine.mybatis.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long addrId;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address(Long addrId) {
        this.addrId = addrId;
    }

    public Address(Long addrId, String street, String city, String state,
                   String zip, String country) {
        this.addrId = addrId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

}
