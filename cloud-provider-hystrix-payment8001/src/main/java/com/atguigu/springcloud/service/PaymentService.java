package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentService
 * @Author Liucz
 * @Description
 * @Date 2021/4/19 14:38
 **/
@Service
public class PaymentService {
    //==》服务降级

    /**
     *
     * 正常访问，肯定OK方法
     * @param id
     * @return
     */
    public String paymentIInfo_OK(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK,id" + id + "\t" + "测试";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000") //此线程3秒钟之内显示正常的结果，超过3秒(包括所有运行时异常，列10/0)则启用服务降级方案的方法paymentInfo_TimeOutHandler
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
            int age = 10/0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id：" + id + "\t" + "测试,耗时："+ timeNumber;

    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "系统繁忙或运行报错，请稍后再试！！！线程池：" + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler,id：" + id + "\t" + "替补测试";

    }

    //==》服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = { //指定服务降级的方法
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            //请求总数阀值：在快照时间窗内，必须满足请求总数阀值才有资格熔断。默认为20，意味着在10秒内，如果该hystrix命令的调用次数不足20次，
                //即使所有的请求都超时或其他原因失败，断路器都不会打开。
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期10秒（尝试再次恢复时间窗口期）
            //快照时间窗：断路器确定是否打开需要统计一些请求和错误数据，而统计的时间范围就是快照时间窗，默认为最近的10秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸（60%）
            //错误百分比阀值：当请求总数在快照时间窗内超过了阀值，比如发生了30次调用，如果在这30次调用中，有15次发生了超时异常，也就是超过了
            // 50%的错误百分比，在默认设定50%阀值情况下，这时候就会将断路器打开。
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id 不能为负数，请稍后再试，o(╥﹏╥)o，id：" + id;
    }
}
