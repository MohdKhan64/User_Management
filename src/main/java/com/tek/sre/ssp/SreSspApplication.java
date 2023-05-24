package com.tek.sre.ssp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SreSspApplication {
	public static void main(String[] args) {
		SpringApplication.run(SreSspApplication.class, args);
	}

}
