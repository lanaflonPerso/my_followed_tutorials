package com.wefine.tutorials.consul;

import com.orbitz.consul.NotRegisteredException;
import com.orbitz.consul.cache.ConsulCache;
import com.orbitz.consul.cache.ServiceHealthCache;
import com.orbitz.consul.cache.ServiceHealthKey;
import com.orbitz.consul.model.health.ServiceHealth;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ServiceHealthCacheTests extends BaseIntegrationTest {

    @Test
    public void shouldNotifyListener() throws Exception {
        String serviceName = UUID.randomUUID().toString();
        String serviceId = UUID.randomUUID().toString();

        client.agentClient().register(8080, 20L, serviceName, serviceId);
        client.agentClient().pass(serviceId);

        ServiceHealthCache svHealth = ServiceHealthCache.newCache(client.healthClient(), serviceName);

        final List<Map<ServiceHealthKey, ServiceHealth>> events = new ArrayList<>();
        svHealth.addListener(new ConsulCache.Listener<ServiceHealthKey, ServiceHealth>() {
            @Override
            public void notify(Map<ServiceHealthKey, ServiceHealth> newValues) {
                events.add(newValues);
            }
        });

        svHealth.start();
        svHealth.awaitInitialized(1000, TimeUnit.MILLISECONDS);

        Thread.sleep(200);
        client.agentClient().deregister(serviceId);
        Thread.sleep(200);

        assertEquals(2, events.size());
        Map<ServiceHealthKey, ServiceHealth> event0 = events.get(0);

        assertEquals(1, event0.size());
        for (Map.Entry<ServiceHealthKey, ServiceHealth> kv : event0.entrySet()) {
            assertEquals(kv.getKey().getServiceId(), serviceId);
        }

        Map<ServiceHealthKey, ServiceHealth> event1 = events.get(1);
        assertEquals(0, event1.size());
        svHealth.stop();
    }

    private int count = 0;

    @Test
    public void shouldNotifyListener2() throws Exception {
        String serviceName = UUID.randomUUID().toString();
        String serviceId = UUID.randomUUID().toString();

        client.agentClient().register(8080, 20L, serviceName, serviceId);
        client.agentClient().pass(serviceId);

        ServiceHealthCache svHealth = ServiceHealthCache.newCache(client.healthClient(), serviceName);

        final List<Map<ServiceHealthKey, ServiceHealth>> events = new ArrayList<>();

        svHealth.addListener(newValues -> {
            System.out.println("======================" + ++count);
            events.add(newValues);
        });

        svHealth.start();
        svHealth.awaitInitialized(1000, TimeUnit.MILLISECONDS);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000L);
                    client.agentClient().deregister(serviceId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2500L);
                    client.agentClient().register(8080, 20L, serviceName, serviceId);
                    client.agentClient().pass(serviceId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                } catch (NotRegisteredException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000 * 60 * 5);
        System.out.println(events);
    }

    @Test
    public void shouldNotifyLateListenersIfNoService() throws Exception {
        String serviceName = UUID.randomUUID().toString();

        ServiceHealthCache svHealth = ServiceHealthCache.newCache(client.healthClient(), serviceName);

        final List<Map<ServiceHealthKey, ServiceHealth>> events = new ArrayList<>();
        svHealth.addListener(newValues -> {
            System.out.println("======================");
            events.add(newValues);
        });

        svHealth.start();
        svHealth.awaitInitialized(1000, TimeUnit.MILLISECONDS);

        assertEquals(1, events.size());
        Map<ServiceHealthKey, ServiceHealth> event0 = events.get(0);
        assertEquals(0, event0.size());
        svHealth.stop();
    }
}
