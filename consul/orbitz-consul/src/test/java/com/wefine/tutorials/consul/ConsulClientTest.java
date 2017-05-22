package com.wefine.tutorials.consul;

import com.google.common.base.Optional;
import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.KeyValueClient;
import com.orbitz.consul.async.ConsulResponseCallback;
import com.orbitz.consul.cache.ServiceHealthCache;
import com.orbitz.consul.model.ConsulResponse;
import com.orbitz.consul.model.kv.Value;
import com.orbitz.consul.option.QueryOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
class ConsulClientTest {
    private Consul consul;

    @BeforeEach
    void before() {
        consul = Consul.builder()
                .withHostAndPort(HostAndPort.fromParts("consulhost", 8500))
                .withReadTimeoutMillis(20000L)
                .build();
    }

    @Test
    void test() throws InterruptedException {
        final KeyValueClient kvClient = consul.keyValueClient();

        kvClient.putValue("foo", "bar");

        ConsulResponseCallback<Optional<Value>> callback = new ConsulResponseCallback<Optional<Value>>() {

            AtomicReference<BigInteger> index = new AtomicReference<>(null);

            @Override
            public void onComplete(ConsulResponse<Optional<Value>> consulResponse) {

                if (consulResponse.getResponse().isPresent()) {
                    Value v = consulResponse.getResponse().get();
                    log.info("Value is: {}", v.getValue());
                }

                index.set(consulResponse.getIndex());
                watch();
            }

            void watch() {
                kvClient.getValue("foo", QueryOptions.blockMinutes(5, index.get()).build(), this);
            }

            @Override
            public void onFailure(Throwable throwable) {
                log.error("Error encountered", throwable);
                watch();
            }
        };

        kvClient.getValue("foo", QueryOptions.blockMinutes(5, new BigInteger("0")).build(), callback);

        Thread.sleep(30000L);
    }

    @Test
    void test_set_get_value() {
        final KeyValueClient kvClient = consul.keyValueClient();

        kvClient.putValue("foo", "bar2");
        Optional<Value> optional = kvClient.getValue("foo");

        if (optional.isPresent()) {
            Value v = optional.get();

            log.info(v.getValueAsString().orNull());
        }
    }

    @Test
    void test_health_cache() throws Exception {
        String serviceName = "myapp_01";

        HealthClient healthClient = consul.healthClient();
        ServiceHealthCache svHealth = ServiceHealthCache.newCache(healthClient, serviceName);

        svHealth.addListener(newValues -> log.info("Changed!! newValues=" + newValues));

        svHealth.start();

        Thread.sleep(30 * 60 * 1000L);
    }
}
