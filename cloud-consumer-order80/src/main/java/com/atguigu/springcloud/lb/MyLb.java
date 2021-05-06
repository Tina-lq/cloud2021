package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 48038
 */
@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        //自旋锁
        do{
            //拿到数据的原子值
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("********第几次访问，次数next"+next);
        return next;
    }

    //负债均衡算法，rest接口第几次请求数%服务器集群总数量 = 实际调用服务器位置下标，每次服务重新启动后rest接口计数从1开始
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstance) {

        int index = getAndIncrement() % serviceInstance.size();

        return serviceInstance.get(index);
    }
}
