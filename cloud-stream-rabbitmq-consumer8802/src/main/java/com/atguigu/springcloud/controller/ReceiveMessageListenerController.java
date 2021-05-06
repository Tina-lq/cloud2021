package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @ClassName ReceiveMessageListenerController
 * @Author Liucz
 * @Description
 * @Date 2021/4/23 9:14
 **/

@Component
@EnableBinding(Sink.class) //消费端注解
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 接收消息（消费者）
     * Message<String> 发送消息是String类型，接收端也要用String类型接收
     * @param message
     */
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号：——————————————>接收到的消息：" + message.getPayload() + "\t port:" + serverPort);
    }

}
