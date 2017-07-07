package com.wefine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    @CacheEvict(allEntries = true, value = {"books"})
    @Scheduled(fixedRate = 5 * 1000L, initialDelay = 1000L)
    public void reportCurrentTime() {
        log.info("Scheduled Task");
    }
}
