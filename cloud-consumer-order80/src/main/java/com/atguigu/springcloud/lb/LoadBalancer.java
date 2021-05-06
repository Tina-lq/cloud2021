package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 48038
 */
public interface LoadBalancer {

    /**
     * 从eureka服务指定微服务名称获得能够提供服务的机器，自写轮询算法计算返回某个提供者服务
     * @param serviceInstance(服务实例)
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstance);
}
