package com.bibhu.couponservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bibhu.couponservice.model.Coupon;
import com.bibhu.couponservice.repos.CouponRepo;

@Controller
public class CouponController {

    @Autowired
    private CouponRepo couponRepo;

    @GetMapping("/showCreateCoupon")
    public String showCreateCoupon(){
        return "createCoupon";
    }

    @PostMapping("/saveCoupon")
    public String saveCoupon(final Coupon coupon){
        this.couponRepo.save(coupon);
        return "createResponse";
    }

    @GetMapping("/showGetCoupon")
    public String showGetCoupon(){
        return "getCoupon";
    }

    @PostMapping("/getCoupon")
    public ModelAndView getCoupon(final String code){
        final ModelAndView mav =  new ModelAndView("couponDetails");
        final Coupon coupon = this.couponRepo.findByCode(code);
        mav.addObject(coupon);
        return mav;
    }

}
