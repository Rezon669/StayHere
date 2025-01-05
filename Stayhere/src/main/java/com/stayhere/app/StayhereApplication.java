package com.stayhere.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StayhereApplication {

	public static void main(String[] args) {
		SpringApplication.run(StayhereApplication.class, args);
	}

}
