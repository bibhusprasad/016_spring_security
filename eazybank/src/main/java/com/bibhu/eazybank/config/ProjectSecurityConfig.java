package com.bibhu.eazybank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    //Note: Configuring users using inMemoryAuthentication
    /**
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("12345").authorities("admin")
                .and()
                .withUser("user").password("12345").authorities("read")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }
    */

    //Note: Configuring users using InMemoryUserDetailsManager
    /**
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        final InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        final UserDetails user1 = User.withUsername("admin").password("12345").authorities("admin").build();
        final UserDetails user2 = User.withUsername("user").password("12345").authorities("read").build();
        userDetailsService.createUser(user1);
        userDetailsService.createUser(user2);
        auth.userDetailsService(userDetailsService);
    }
    */

    //Using JdbcUserDetailsManager to perform authentication
    /**
    @Bean
    public UserDetailsService userDetailsService(final DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    */

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
