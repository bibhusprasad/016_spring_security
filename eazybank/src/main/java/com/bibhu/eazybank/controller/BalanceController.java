package com.bibhu.eazybank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bibhu.eazybank.model.AccountTransactions;
import com.bibhu.eazybank.model.Customer;
import com.bibhu.eazybank.repository.AccountTransactionsRepository;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @PostMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestBody final Customer customer) {
        final List<AccountTransactions> accountTransactions = this.accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(customer.getId());
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }

}
