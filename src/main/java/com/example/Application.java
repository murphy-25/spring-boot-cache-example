package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
//@EnableCaching
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Component
	static class Runner implements CommandLineRunner {
		@Autowired
		private DomainRepository domainRepository;

		@Override
		public void run(String... args) throws Exception {

//			log.info(".... Fetching entires");s
//
//			log.info("patient-1234 selected");
//			log.info("entry-1234 -->" + domainRepository.getEntriesFromBp("1234"));
//			log.info("entry-1234 -->" + domainRepository.getEntriesFromBp("1234"));
//
//			log.info("patient-2345 selected");
//			domainRepository.resetCache();
//			log.info("entry-2345 -->" + domainRepository.getEntriesFromBp("2345"));
//
//			log.info("patient-2345 selected");
//			domainRepository.resetCache();
//			log.info("entry-2345 -->" + domainRepository.getEntriesFromBp("2345"));
//			domainRepository.resetCache();
//			log.info("entry-1234 -->" + domainRepository.getEntriesFromBp("1234"));
		}
	}

//	@Bean
//	public CacheManager cacheManager() {
//		return new ConcurrentMapCacheManager("entries");
//	}
}
