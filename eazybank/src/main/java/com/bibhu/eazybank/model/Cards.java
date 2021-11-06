package com.bibhu.eazybank.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int cardId;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "total_limit")
    private int totalLimit;
    @Column(name = "amount_used")
    private int amountUsed;
    @Column(name = "available_amount")
    private int availableAmount;
    @Column(name = "create_dt")
    private Date createDt;

    public Cards() {
    }

    public Cards(final int customerId, final String cardNumber, final String cardType, final int totalLimit, final int amountUsed, final int availableAmount, final Date createDt) {
        this.customerId = customerId;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.totalLimit = totalLimit;
        this.amountUsed = amountUsed;
        this.availableAmount = availableAmount;
        this.createDt = createDt;
    }

    public int getCardId() {
        return this.cardId;
    }

    public void setCardId(final int cardId) {
        this.cardId = cardId;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final int customerId) {
        this.customerId = customerId;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(final String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(final String cardType) {
        this.cardType = cardType;
    }

    public int getTotalLimit() {
        return this.totalLimit;
    }

    public void setTotalLimit(final int totalLimit) {
        this.totalLimit = totalLimit;
    }

    public int getAmountUsed() {
        return this.amountUsed;
    }

    public void setAmountUsed(final int amountUsed) {
        this.amountUsed = amountUsed;
    }

    public int getAvailableAmount() {
        return this.availableAmount;
    }

    public void setAvailableAmount(final int availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Date getCreateDt() {
        return this.createDt;
    }

    public void setCreateDt(final Date createDt) {
        this.createDt = createDt;
    }
}
