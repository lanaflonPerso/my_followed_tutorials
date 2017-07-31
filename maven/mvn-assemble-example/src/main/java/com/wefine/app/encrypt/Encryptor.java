package com.wefine.app.encrypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Encryptor {
    private static final String PASS_WORD = "p@ssword";
    private StandardPBEStringEncryptor encryptor;

    public Encryptor(){
        encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(PASS_WORD);
    }

    public String encrypt(String message) {
        return encryptor.encrypt(message);
    }

    public String decrypt(String message) {
        return encryptor.decrypt(message);
    }
}
