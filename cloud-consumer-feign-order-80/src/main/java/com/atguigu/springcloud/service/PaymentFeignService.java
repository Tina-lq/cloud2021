package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 48038
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE") //参数：调用微服务的名称
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);


    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
