package com.bibhu.eazybank.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibhu.eazybank.model.Customer;
import com.bibhu.eazybank.repository.CustomerRepository;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(final Principal user) {
        final List<Customer> customers = this.customerRepository.findByEmail(user.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        }else {
            return null;
        }

    }

}
