package com.lofo.learnMockito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.lofo.learnMockito.config")
@SpringBootApplication
public class LearnMockitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnMockitoApplication.class, args);
		//JDBCExample.main(null);
	}

}
