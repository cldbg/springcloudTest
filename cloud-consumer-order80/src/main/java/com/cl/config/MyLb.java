package com.cl.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenglei
 * @create 2021-08-03 16:12
 */
@Component
public class MyLb implements LoadBalancer{

    private AtomicInteger atomicInteger =  new AtomicInteger(0);

    public final int getAndCrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current++;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.err.println("next: "+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> ServiceInstances) {
        int index = getAndCrement() % ServiceInstances.size();
        return ServiceInstances.get(index);
    }
}
