package com.bibhu.springSecOAUTHGitHub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecOAUTHGitHubConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().oauth2Login();
    }

    //new Configuration
    //Auto configured in yml file
    /**
    private ClientRegistration clientRegistration() {
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("a8357ad1bb14f6841529")
                .clientSecret("0bee8ace7c45ed0b0953c873459915ddd8b50a17")
                .build();
    }
     */

    //Auto configured in yml file
    /**
     *
    @Bean
    public ClientRegistrationRepository clientRepository() {
        final ClientRegistration clientReg = this.clientRegistration();
        return new InMemoryClientRegistrationRepository(clientReg);
    }
    */


    //Manual Configuration old way
    /**
     private ClientRegistration clientRegistration() {
         final ClientRegistration cr = ClientRegistration.withRegistrationId("github")
             .clientId("a8357ad1bb14f6841529")
             .clientSecret("0bee8ace7c45ed0b0953c873459915ddd8b50a17")
             .scope(new String[]{ "read:user" })
             .authorizationUri("https://github.com/login/oauth/authorize")
             .tokenUri("https://github.com/login/oauth/access_token")
             .userInfoUri("https://api.github.com/user")
             .userNameAttributeName("id")
             .clientName("GitHub")
             .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
             .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}")
             .build();
          return cr;
     }
     */
}
