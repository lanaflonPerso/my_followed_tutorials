package com.wefine.tutorials.consul;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;
import org.junit.BeforeClass;

public abstract class BaseIntegrationTest {
    protected static Consul client;

    @BeforeClass
    public static void beforeClass() {
        client = Consul.builder()
            .withHostAndPort(HostAndPort.fromParts("consulhost", 8500))
            .withReadTimeoutMillis(20000L)
            .build();
    }
}
