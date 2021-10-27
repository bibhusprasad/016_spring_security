package com.bibhu.couponservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibhu.couponservice.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

    Coupon findByCode(String code);
}
