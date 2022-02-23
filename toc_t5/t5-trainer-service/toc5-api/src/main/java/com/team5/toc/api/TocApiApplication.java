package com.team5.toc.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication

public class TocApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TocApiApplication.class, args);
	}

}
