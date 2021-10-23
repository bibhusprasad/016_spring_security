package com.bibhu.eazybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.bibhu.eazybank")
@SpringBootApplication
public class EazybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazybankApplication.class, args);
	}

}
