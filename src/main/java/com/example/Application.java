package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

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

			LOGGER.info(".... Fetching entries");

			LOGGER.info("patient-1234 selected");
			LOGGER.info("entry-1234 -->" + domainRepository.getEntriesFromBp("1234"));
			LOGGER.info("entry-1234 -->" + domainRepository.getEntriesFromBp("1234"));

			LOGGER.info("patient-2345 selected");
			domainRepository.resetCache();
			LOGGER.info("entry-2345 -->" + domainRepository.getEntriesFromBp("2345"));

			LOGGER.info("patient-2345 selected");
			domainRepository.resetCache();
			LOGGER.info("entry-2345 -->" + domainRepository.getEntriesFromBp("2345"));
			domainRepository.resetCache();
			LOGGER.info("entry-1234 -->" + domainRepository.getEntriesFromBp("1234"));
		}
	}
}
