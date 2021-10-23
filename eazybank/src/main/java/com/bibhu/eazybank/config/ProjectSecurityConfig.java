package com.bibhu.eazybank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * /contact - not secured
     * /notices - not secured
     * /myAccount - secured
     * /myBalance - secured
     * /myLoans - secured
     * /myCards - secured
     */

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        /**
         * Default configuration which secured all the request
         */

        /**
         *
         * http.authorizeRequests(requests
         * 		-> requests.anyRequest().authenticated()
         * 	);
         * 	http.formLogin();
         * 	http.httpBasic();
         */

        /**
         * Custom configuration as per our requirement
         */

        http.authorizeRequests(requests ->
                requests.antMatchers("/myAccount").authenticated()
                        .antMatchers("/myBalance").authenticated()
                        .antMatchers("/myLoans").authenticated()
                        .antMatchers("/myCards").authenticated()
                        .antMatchers("/contact").permitAll()
                        .antMatchers("/notices").permitAll()
        );
        http.formLogin();
        http.httpBasic();
    }
}
