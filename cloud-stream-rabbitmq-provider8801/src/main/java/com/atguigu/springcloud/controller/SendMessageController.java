package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessaggeProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName SendMessageController
 * @Author Liucz
 * @Description
 * @Date 2021/4/22 17:03
 **/
@RestController
public class SendMessageController {

    @Resource
    private IMessaggeProvider  messaggeProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messaggeProvider.send();
    }
}
