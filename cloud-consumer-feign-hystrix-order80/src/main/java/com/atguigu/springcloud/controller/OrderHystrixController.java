package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentHistrixController
 * @Author Liucz
 * @Description
 * @Date 2021/4/19 15:25
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //设置默认的服务降级方法
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }


    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = { //指定服务降级方法
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500") //此线程3秒钟之内显示正常的结果，超过3秒(包括所有运行时异常，列10/0)则启用服务降级方案的方法paymentInfo_TimeOutHandler
//    })
    @HystrixCommand   //使用默认的服务降级方法paymentTimeOutFallbackMethod
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
//        int age  =  10/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);

    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙或自己运行报错，请稍后再试！！！";

    }

    //默认服务降级fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o";
    }

}
