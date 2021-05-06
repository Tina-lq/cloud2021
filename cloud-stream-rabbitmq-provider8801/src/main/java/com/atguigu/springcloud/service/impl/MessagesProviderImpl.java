package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessaggeProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ClassName MessagesProviderImpl
 * @Author Liucz
 * @Description
 * @Date 2021/4/22 16:51
 **/
@EnableBinding(Source.class)  //定义消息的推送管道（发布者端注解）
public class MessagesProviderImpl implements IMessaggeProvider {

    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());//发送消息
        System.out.println("******************serial:" + serial);
        return null;
    }
}
