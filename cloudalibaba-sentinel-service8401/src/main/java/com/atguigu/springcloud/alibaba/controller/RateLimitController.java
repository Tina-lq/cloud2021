package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RateLimitController
 * @Author Liucz
 * @Description
 * @Date 2021/5/10 14:25
 **/
@RestController
public class RateLimitController {

    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试OK", new Payment(2020L,  "serial001"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName() + "\t" + "服务不可用");
    }

    @GetMapping(value = "/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")  //没有指定的兜底方法，使用sentinel默认自带的方法：Blocked by Sentinel (flow limiting)，指定了兜底的的方法也没用，还是会使用默认的sentinel方法
    public CommonResult byUrl(){
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }

    @GetMapping(value = "/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2") //blockHandlerClass：指定兜底的方法是哪个类，blockHandler：类下面的方法名称
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按客户自定义",new Payment(2020L,"serial003"));
    }


}
