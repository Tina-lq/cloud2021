package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentFallbackService
 * @Author Liucz
 * @Description
 * @Date 2021/4/20 9:31
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackServiice fall back-paymentInfo_OK,(*^▽^*)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackServiice fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}
