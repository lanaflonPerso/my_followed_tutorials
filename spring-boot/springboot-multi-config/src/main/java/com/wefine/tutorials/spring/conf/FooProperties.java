package com.wefine.tutorials.spring.conf;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "foo")
@Getter
@Setter
@ToString
public class FooProperties {
    private boolean enabled;
    private int counter;
    private InetAddress remoteAddress;
    private final Security security = new Security();

    @Getter
    @Setter
    @ToString
    public static class Security {
        private String name;
        private String password;
        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
    }
}
