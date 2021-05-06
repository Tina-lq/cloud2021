package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PaymentController
 * @Author Liucz
 * @Description
 * @Date 2021/4/23 15:38
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String  getPayment(@PathVariable("id")Integer id){

        return "nacos registry,serverPort:" + serverPort + "\t id:" + id;
    }

}
