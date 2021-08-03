package com.cl.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author chenglei
 * @create 2021-08-03 15:59
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> ServiceInstances);
}
