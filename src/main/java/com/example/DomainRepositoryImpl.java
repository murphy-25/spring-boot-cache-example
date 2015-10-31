package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class DomainRepositoryImpl implements DomainRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Value("${cache.config.request.data.cache.name}")
    private static final String requestDataCacheName = "entries";

    @Override
    @Cacheable(value=requestDataCacheName)
    public String getEntriesFromBp(String id) {

        LOGGER.info("Getting Entries for " + id + "....");
        simulateSlowService();
        return id+"=userContent";
    }

    @Override
    @CacheEvict(value = "entries", allEntries = true)
    public void resetCache() {

        LOGGER.info("Removing all elements from cache ......");
        //intentionally blank
    }

    private void simulateSlowService() {

        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
