package com.wefine.tutorials.consul;

import com.google.common.base.Optional;
import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.KeyValueClient;
import com.orbitz.consul.NotRegisteredException;
import com.orbitz.consul.async.ConsulResponseCallback;
import com.orbitz.consul.cache.ServiceHealthCache;
import com.orbitz.consul.model.ConsulResponse;
import com.orbitz.consul.model.agent.Check;
import com.orbitz.consul.model.agent.ImmutableCheck;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.agent.Registration;
import com.orbitz.consul.model.catalog.CatalogRegistration;
import com.orbitz.consul.model.catalog.ImmutableCatalogRegistration;
import com.orbitz.consul.model.health.HealthCheck;
import com.orbitz.consul.model.health.ImmutableService;
import com.orbitz.consul.model.health.Service;
import com.orbitz.consul.model.kv.Value;
import com.orbitz.consul.option.QueryOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
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

    @Test
    void test_agent_service_register() throws NotRegisteredException {
        String serviceName = "w2";

//        Registration.RegCheck check = Registration.RegCheck.ttl(30);
//        Registration registration = ImmutableRegistration
//            .builder()
//            .check(check)
//            .port(8080)
//            .name(serviceName)
//            .id(serviceName)
//            .build();
//        consul.agentClient().register(registration);

        consul.agentClient().register(8080, 20L, serviceName, serviceName);
        consul.agentClient().pass(serviceName);
    }

    @Test
    void test_check_register() throws NotRegisteredException {
        String serviceName = "w1";
        String serviceId = "w1";
        System.out.println("serviceName=" + serviceName);
        System.out.println("serviceId=" + serviceId);

//        Registration.RegCheck check = Registration.RegCheck.ttl(30);


        Check check = ImmutableCheck.builder()
            .ttl("5s")
            .id("service:w1")
            .serviceId("w1")
            .name("w1check").build();

        consul.agentClient().registerCheck(check);
    }

    @Test
    void test_get_all_checks() {
        ConsulResponse<List<HealthCheck>> w1 = consul.healthClient().getServiceChecks("w2");
        List<HealthCheck> response = w1.getResponse();

        System.out.println(response);
    }

    @Test
    void test_user_check() throws NotRegisteredException {
//        consul.agentClient().pass("w2");
        consul.agentClient().passCheck("service:w2");
    }

    @Test
    void getAllService() {
        Map<String, Service> agentServices = consul.agentClient().getServices();

        System.out.println(agentServices.size());

        ConsulResponse<Map<String, List<String>>> consulResponse = consul.catalogClient().getServices();

        Map<String, List<String>> response = consulResponse.getResponse();
        System.out.println(response.size());
        System.out.println(response);
    }


    @Test
    void test_catalog_service_register() throws NotRegisteredException {
        String serviceName = "catalog_w2";

        Service service = ImmutableService.builder()
            .id(serviceName)
            .service(serviceName)
            .address("localhost")
            .port(8080)
            .build();

        Check check = ImmutableCheck.builder()
            .ttl("5s")
            .id("service:" + serviceName)
            .serviceId(serviceName)
            .name(serviceName)

            .build();

        CatalogRegistration registration = ImmutableCatalogRegistration.builder()
            .service(service)
            .node("n1")
            .address("consulhost")
            .check(check)
            .build();

        consul.catalogClient().register(registration);
    }

}
