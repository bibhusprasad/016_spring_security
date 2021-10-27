package com.bibhu.couponservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibhu.couponservice.model.Coupon;
import com.bibhu.couponservice.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

    @Autowired
    private CouponRepo couponRepo;

    @PostMapping("/coupons")
    public Coupon create(@RequestBody final Coupon coupon){
        return this.couponRepo.save(coupon);
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable final String code){
        return this.couponRepo.findByCode(code);
    }

}
