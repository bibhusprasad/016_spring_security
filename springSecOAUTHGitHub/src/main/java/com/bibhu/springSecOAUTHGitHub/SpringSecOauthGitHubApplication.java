package com.bibhu.springSecOAUTHGitHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bibhu.springSecOAUTHGitHub")
public class SpringSecOauthGitHubApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SpringSecOauthGitHubApplication.class, args);
	}

}
