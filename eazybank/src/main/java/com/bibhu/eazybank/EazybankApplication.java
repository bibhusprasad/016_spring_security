package com.bibhu.eazybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@ComponentScan("com.bibhu.eazybank")
@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.bibhu.eazybank")
@EnableWebSecurity(debug = true)
public class EazybankApplication {

	public static void main(final String[] args) {
		SpringApplication.run(EazybankApplication.class, args);
	}

}
