package com.team5.toc.api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.team5.toc.api.repo.TOCRepository;
@Configuration
@EnableMongoRepositories(basePackageClasses = TOCRepository.class)
public class MongoConfig {

	public CommandLineRunner commandLineRunner(TOCRepository tocRepo){
		
		return null;
	}
}
