package com.bibhu.eazybank.config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.bibhu.eazybank.filter.AuthoritiesLoggingAfterFilter;
import com.bibhu.eazybank.filter.AuthoritiesLoggingAtFilter;
import com.bibhu.eazybank.filter.RequestValidationBeforeFilter;

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
        http.cors().configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(final HttpServletRequest request) {
                final CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                configuration.setAllowedMethods(Collections.singletonList("*"));
                configuration.setAllowCredentials(true);
                configuration.setAllowedHeaders(Collections.singletonList("*"));
                configuration.setMaxAge(3600L);
                return configuration;
            }
        }).and().csrf().ignoringAntMatchers("/contact").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
                .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
        .authorizeRequests(requests ->
                requests.antMatchers("/myAccount").hasRole("USER")
                        .antMatchers("/myBalance").hasAnyRole("USER", "ADMIN")
                        .antMatchers("/myLoans").hasRole("ROOT")
                        .antMatchers("/myCards").authenticated()
                        .antMatchers("/user").authenticated()
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

    // BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
