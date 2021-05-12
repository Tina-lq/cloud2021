package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName FlowLimiController
 * @Author Liucz
 * @Description Sentinel测试controller
 * @Date 2021/5/7 17:00
 **/
@RestController
@Slf4j
public class FlowLimiController {

    @GetMapping("/testA")
    public String testA(){
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "-----testB";
    }



    @GetMapping("/testD")
    public String testD(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD 测试RT");
        log.info("testD 异常比例");
        int age = 10/0;
        return "-----testD";

    }


    @GetMapping("/testE")
    public String testE(){

        log.info("testE 测试异常数");
        int age = 10/0;
        return "-----testE";

    }

    /**
     * 热点降级
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHostKey")
    //@SentinelResource：此方法违背了在sentinel控制台设置的规则就会报错，报错后将会按照指定的方法（deal_testHostKey）替此方法兜底，不指定兜底的方法错误页面直接返回
    @SentinelResource(value = "testHostKey",blockHandler = "deal_testHostKey") //value值唯一，资源名称，在sentinel界面配置新增热点限流的资源名的值，blockHandler降级后兜底的指定方法
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,@RequestParam(value = "p2",required = false)String p2){
        int age = 10/0;
        return "--------testHostKey";
    }


    /**
     * 兜底的方法
     * @param p1
     * @param p2
     * @param exception
     * @return
     */
    public String deal_testHostKey(String p1, String p2, BlockException exception){
        return "--------deal_testHostKey，o(╥﹏╥)o"; //sentinel默认系统提示：Blocked by sentinel（flow limiting）
    }

}
