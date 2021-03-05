package com.aircas.hopital.fluid_infusion;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring4all.swagger.EnableSwagger2Doc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@EnableSwagger2Doc
@SpringBootApplication(scanBasePackages="com.aircas.hopital")
@EnableJpaRepositories(basePackages="com.aircas.hopital.dao")
@EntityScan("com.aircas.hopital.dao")
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {
		logger.info("START MY APP");
        SpringApplication.run(App.class,args);
    }
}
