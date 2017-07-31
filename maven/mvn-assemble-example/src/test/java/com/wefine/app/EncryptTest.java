package com.wefine.app;


import com.wefine.app.encrypt.Encryptor;
import org.junit.Before;
import org.junit.Test;

public class EncryptTest {
    private Encryptor encryptor;

    @Before
    public void before() {
        encryptor = new Encryptor();
    }

    @Test
    public void testEncrypt() {
        String host = encryptor.encrypt("192.168.1.110");
        String name = encryptor.encrypt("wefine");
        String pswd = encryptor.encrypt("fine");

        System.out.println(host);
        System.out.println(name);
        System.out.println(pswd);
    }

    @Test
    public void testDecrypt() {
        String host = "2H0+UMavR8AnOhKCfs+l43PeK5p9Yh8A";
        String name = "Xn5Nb6bE41pZ1mP3CC9zdg==";

        System.out.println(encryptor.decrypt(host));
        System.out.println(encryptor.decrypt(name));
    }
}
