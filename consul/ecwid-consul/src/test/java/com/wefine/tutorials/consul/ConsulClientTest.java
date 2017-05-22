package com.wefine.tutorials.consul;


import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.NewService;
import com.ecwid.consul.v1.agent.model.Service;
import com.ecwid.consul.v1.health.model.HealthService;
import com.ecwid.consul.v1.kv.model.GetValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class ConsulClientTest {
    private ConsulClient client;

    @BeforeEach
    void before() {
        // consul agent -dev -client=0.0.0.0
        client = new ConsulClient("consulhost");
    }

    @Test
    void test_set_kv() {
        byte[] binaryData = new byte[]{1, 2, 3, 4, 5, 6, 7};
        client.setKVBinaryValue("someKey", binaryData);

        client.setKVValue("com.my.app.foo", "foo");
        client.setKVValue("com.my.app.bar", "bar");
        client.setKVValue("com.your.app.foo", "hello");
        client.setKVValue("com.your.app.bar", "world");
    }

    @Test
    void test_get_single_kv() {
        Response<GetValue> response = client.getKVValue("com.my.app.foo");
        System.out.println(response.getValue().getKey() + ": " + response.getValue().getDecodedValue());
        // prints "com.my.app.foo: foo"
    }

    @Test
    void test_get_list_kv() {
        // get list of KVs for key prefix (recursive)
        Response<List<GetValue>> response = client.getKVValues("com.my");
        response.getValue().forEach(value -> System.out.println(value.getKey() + ": " + value.getDecodedValue()));
        // prints "com.my.app.foo: foo" and "com.my.app.bar: bar"
    }

    @Test
    void test_get_data_centers() {
        //list known datacenters
        Response<List<String>> response = client.getCatalogDatacenters();
        System.out.println("Datacenters: " + response.getValue());
    }

    @Test
    void test_register_service() {
        NewService newService1 = new NewService();
        newService1.setId("myapp_01");
        newService1.setName("myapp");
        newService1.setTags(Arrays.asList("EU-West", "EU-East"));
        newService1.setPort(8080);
        client.agentServiceRegister(newService1);
    }

    @Test
    void test_register_service_with_health_check() {
        NewService newService2 = new NewService();
        newService2.setId("myapp_02");
        newService2.setTags(Collections.singletonList("EU-East"));
        newService2.setName("myapp");
        newService2.setPort(8080);

        NewService.Check serviceCheck = new NewService.Check();
        // 这里设置的健康检查脚本实际并不存在，所以本服务是不健康的
        serviceCheck.setScript("/usr/bin/some-check-script");
        serviceCheck.setInterval("10s");

        newService2.setCheck(serviceCheck);
        client.agentServiceRegister(newService2);
    }

    @Test
    void test_get_all_service() {
        final Response<Map<String, Service>> agentServices = client.getAgentServices();

        agentServices.getValue().entrySet().forEach(System.out::println);
    }

    @Test
    void test_health_check() {
        // 根据服务名查询
        Response<List<HealthService>> healthyServices1 = client.getHealthServices("myapp", true, QueryParams.DEFAULT);
        System.out.println("healthyServices1:" + healthyServices1);

        // 根据服务名和标记查询
        Response<List<HealthService>> healthyServices2 = client.getHealthServices("myapp", "EU-West", true, QueryParams.DEFAULT);
        System.out.println("healthyServices2:" + healthyServices2);
    }

    @Test
    void test_deregister_service() {
        String serviceId = "myapp_02";
        client.agentServiceDeregister(serviceId);
    }
}
