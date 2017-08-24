package com.wefine.mybatis.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class PhoneNumber implements Serializable {
    private static final long serialVersionUID = 1L;

    private String countryCode;
    private String stateCode;
    private String number;

    public PhoneNumber(String countryCode, String stateCode, String number) {
        super();
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.number = number;
    }

    public PhoneNumber(String string) {
        if (string != null) {
            String[] parts = string.split("-");
            if (parts.length > 0) this.countryCode = parts[0];
            if (parts.length > 1) this.stateCode = parts[1];
            if (parts.length > 2) this.number = parts[2];

        }
    }

    @Override
    public String toString() {
        return countryCode + "-" + stateCode + "-" + number;
    }

}
