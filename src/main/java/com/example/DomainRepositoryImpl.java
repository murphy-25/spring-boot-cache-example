package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DomainRepositoryImpl implements DomainRepository {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    @Cacheable("entries")
    public HashMap<String, String> getEntriesFromBp(String id) {
        log.info("Getting Entries for "+id+"....");
        simulateSlowService();
        HashMap<String, String> entries = new HashMap<String, String>();
        entries.put("5454", "test content");
        entries.put("3213", "test content");
        return entries;
    }

    @Override
    @CacheEvict(value = "entries", allEntries = true)
    public void resetCache() {
        log.info("Removing elements from the cache ......");
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
