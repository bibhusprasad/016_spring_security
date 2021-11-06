package com.bibhu.eazybank.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_transactions")
public class AccountTransactions {

    @Id
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name="account_number")
    private long accountNumber;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name="transaction_dt")
    private Date transactionDt;
    @Column(name = "transaction_summary")
    private String transactionSummary;
    @Column(name="transaction_type")
    private String transactionType;
    @Column(name = "transaction_amt")
    private int transactionAmt;
    @Column(name = "closing_balance")
    private int closingBalance;
    @Column(name = "create_dt")
    private String createDt;

    public AccountTransactions() {
    }

    public AccountTransactions(final String transactionId, final long accountNumber, final int customerId, final Date transactionDt, final String transactionSummary, final String transactionType, final int transactionAmt, final int closingBalance, final String createDt) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.transactionDt = transactionDt;
        this.transactionSummary = transactionSummary;
        this.transactionType = transactionType;
        this.transactionAmt = transactionAmt;
        this.closingBalance = closingBalance;
        this.createDt = createDt;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(final long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final int customerId) {
        this.customerId = customerId;
    }

    public Date getTransactionDt() {
        return this.transactionDt;
    }

    public void setTransactionDt(final Date transactionDt) {
        this.transactionDt = transactionDt;
    }

    public String getTransactionSummary() {
        return this.transactionSummary;
    }

    public void setTransactionSummary(final String transactionSummary) {
        this.transactionSummary = transactionSummary;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(final String transactionType) {
        this.transactionType = transactionType;
    }

    public int getTransactionAmt() {
        return this.transactionAmt;
    }

    public void setTransactionAmt(final int transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public int getClosingBalance() {
        return this.closingBalance;
    }

    public void setClosingBalance(final int closingBalance) {
        this.closingBalance = closingBalance;
    }

    public String getCreateDt() {
        return this.createDt;
    }

    public void setCreateDt(final String createDt) {
        this.createDt = createDt;
    }
}
