package com.bibhu.eazybank.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loans")
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_number")
    private int loanNumber;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name="start_dt")
    private Date startDt;
    @Column(name = "loan_type")
    private String loanType;
    @Column(name = "total_loan")
    private int totalLoan;
    @Column(name = "amount_paid")
    private int amountPaid;
    @Column(name = "outstanding_amount")
    private int outstandingAmount;
    @Column(name = "create_dt")
    private String createDt;

    public Loans() {
    }

    public Loans(final int customerId, final Date startDt, final String loanType, final int totalLoan, final int amountPaid, final int outstandingAmount, final String createDt) {
        this.customerId = customerId;
        this.startDt = startDt;
        this.loanType = loanType;
        this.totalLoan = totalLoan;
        this.amountPaid = amountPaid;
        this.outstandingAmount = outstandingAmount;
        this.createDt = createDt;
    }

    public int getLoanNumber() {
        return this.loanNumber;
    }

    public void setLoanNumber(final int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final int customerId) {
        this.customerId = customerId;
    }

    public Date getStartDt() {
        return this.startDt;
    }

    public void setStartDt(final Date startDt) {
        this.startDt = startDt;
    }

    public String getLoanType() {
        return this.loanType;
    }

    public void setLoanType(final String loanType) {
        this.loanType = loanType;
    }

    public int getTotalLoan() {
        return this.totalLoan;
    }

    public void setTotalLoan(final int totalLoan) {
        this.totalLoan = totalLoan;
    }

    public int getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(final int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getOutstandingAmount() {
        return this.outstandingAmount;
    }

    public void setOutstandingAmount(final int outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public String getCreateDt() {
        return this.createDt;
    }

    public void setCreateDt(final String createDt) {
        this.createDt = createDt;
    }
}
