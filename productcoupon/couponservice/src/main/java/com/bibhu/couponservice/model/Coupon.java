package com.bibhu.couponservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal discount;
    @Column(name = "exp_date")
    private String expDate;

    public Coupon() {
    }

    public Coupon(final String code, final BigDecimal discount, final String expDate) {
        this.code = code;
        this.discount = discount;
        this.expDate = expDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setDiscount(final BigDecimal discount) {
        this.discount = discount;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public void setExpDate(final String expDate) {
        this.expDate = expDate;
    }
}
