package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName HystrixDashboardMain9001
 * @Author Liucz
 * @Description
 * @Date 2021/4/20 16:08
 **/
@SpringBootApplication
@EnableHystrixDashboard  //开启服务监控
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}
