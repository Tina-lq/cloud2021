package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentHystrixService
 * @Author Liucz
 * @Description
 * @Date 2021/4/19 15:21
 **/
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-SERVICE",fallback = PaymentFallbackService.class)  // 调用的微服务名称,服务降级的指定类
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);


    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
