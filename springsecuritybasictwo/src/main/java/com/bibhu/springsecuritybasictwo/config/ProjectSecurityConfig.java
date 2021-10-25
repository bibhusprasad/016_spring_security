package com.bibhu.springsecuritybasictwo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private MyAuthenticationProvider authenticationProvider;

	//Default AuthenticationProvider
    /**
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        final InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        final UserDetails user = User.withUsername("bibhu").password(this.passwordEncoder.encode("12345")).authorities("read").build();
        userDetailsService.createUser(user);
        auth.userDetailsService(userDetailsService).passwordEncoder(this.passwordEncoder);
    }
	 */

	//Custom AuthenticationProvider
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(this.authenticationProvider);
	}



    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests.anyRequest().authenticated());
        http.formLogin();
        http.httpBasic();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
