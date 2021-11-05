package com.bibhu.eazybank.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bibhu.eazybank.model.Customer;
import com.bibhu.eazybank.model.SecurityCustomer;
import com.bibhu.eazybank.repository.CustomerRepository;

@Service
public class EazyBankUserDetails implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final List<Customer> customers = this.customerRepository.findByEmail(username);
        if(customers.size() == 0) {
            throw new UsernameNotFoundException("Customer not found : " + username);
        }
        return new SecurityCustomer(customers.get(0));
    }
}
