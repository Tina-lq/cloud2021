package com.atguigu.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FlowLimiController
 * @Author Liucz
 * @Description Sentinel测试controller
 * @Date 2021/5/7 17:00
 **/
@RestController
public class FlowLimiController {

    @GetMapping("/testA")
    public String testA(){
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "-----testB";
    }


}
