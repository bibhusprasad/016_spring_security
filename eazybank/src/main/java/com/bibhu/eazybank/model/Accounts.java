package com.bibhu.eazybank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts {

    @Column(name = "customer_id")
    private int customerId;
    @Column(name="account_number")
    @Id
    private long accountNumber;
    @Column(name="account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;
    @Column(name = "create_dt")
    private String createDt;

    public Accounts() {
    }

    public Accounts(final int customerId, final long accountNumber, final String accountType, final String branchAddress, final String createDt) {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.branchAddress = branchAddress;
        this.createDt = createDt;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final int customerId) {
        this.customerId = customerId;
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(final long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return this.branchAddress;
    }

    public void setBranchAddress(final String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getCreateDt() {
        return this.createDt;
    }

    public void setCreateDt(final String createDt) {
        this.createDt = createDt;
    }
}
