package com.example;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.interceptor.SimpleKeyGenerator;

@Configuration
@EnableCaching
public class EhCacheConfig extends CachingConfigurerSupport {
    private static final String DESTROY_METHOD = "shutdown";

    @Value("${cache.config.request.data.cache.name}")
    private String requestDataCacheName;

    @Value("${cache.config.request.data.cache.eviction.policy}")
    private String requestDataCacheEvictionPolicy;

    @Value("${cache.config.request.data.cache.max.entries}")
    private int requestDataCacheMaxEntries;

    @Value("${cache.config.request.data.cache.idle.time}")
    private int requestDataCacheIdleTime;

    @Bean(destroyMethod = DESTROY_METHOD)
    public CacheManager ehCacheManager() {
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName(requestDataCacheName);
        cacheConfiguration.setMemoryStoreEvictionPolicy(requestDataCacheEvictionPolicy);
        cacheConfiguration.setMaxEntriesLocalHeap(requestDataCacheMaxEntries);
        cacheConfiguration.setTimeToIdleSeconds(requestDataCacheIdleTime);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(cacheConfiguration);

        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    public org.springframework.cache.CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }
}
