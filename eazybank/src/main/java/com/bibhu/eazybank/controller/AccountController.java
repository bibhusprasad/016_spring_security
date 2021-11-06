package com.bibhu.eazybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bibhu.eazybank.model.Accounts;
import com.bibhu.eazybank.model.Customer;
import com.bibhu.eazybank.repository.AccountsRepository;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody final Customer customer) {
        final Accounts accounts = this.accountsRepository.findByCustomerId(customer.getId());
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }

}
