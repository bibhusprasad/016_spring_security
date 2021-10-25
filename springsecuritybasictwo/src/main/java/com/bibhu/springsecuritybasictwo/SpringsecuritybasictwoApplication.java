package com.bibhu.springsecuritybasictwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bibhu.springsecuritybasictwo")
public class SpringsecuritybasictwoApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringsecuritybasictwoApplication.class, args);
    }

}
