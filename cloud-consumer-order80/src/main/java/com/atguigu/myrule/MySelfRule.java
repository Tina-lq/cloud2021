package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 48038
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //负载均衡定义为随机
        return new RandomRule();
    }

}
