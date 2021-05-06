package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName GateWayConfig
 * @Author Liucz
 * @Description
 * @Date 2021/4/21 10:57
 **/
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //设置路由 参数一：路由id（不能重复） 参数2:函数（lambda表达式）
        routes.route("path_route_atguigu",
                r -> r.path("/guonei") //当访问这个地址的时候
                        .uri("http://news.baidu.com/guonei")).build(); //转发到这个地址
        routes.route("path_route_atguigu_mil",
                r -> r.path("/mil")
                        .uri("http://news.baidu.com/mil")).build();
        return routes.build();
    }
}
