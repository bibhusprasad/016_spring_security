package com.bibhu.eazybank.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bibhu.eazybank.model.Authority;
import com.bibhu.eazybank.model.Customer;
import com.bibhu.eazybank.repository.CustomerRepository;

@Component
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final String username = authentication.getName();
        final String pwd = authentication.getCredentials().toString();
        final List<Customer> customerList = this.customerRepository.findByEmail(username);

        if(customerList.size() > 0){
            if(this.passwordEncoder.matches(pwd, customerList.get(0).getPwd())){
                return new UsernamePasswordAuthenticationToken(username, pwd, this.getGrantedAuthorities(customerList.get(0).getAuthorities()));
            }else{
                throw new BadCredentialsException("Invalid Password!.");
            }
        }else{
            throw new BadCredentialsException("No user registered with the details.");
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private List<GrantedAuthority> getGrantedAuthorities(final Set<Authority> authorities){
        final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(final Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }
}
