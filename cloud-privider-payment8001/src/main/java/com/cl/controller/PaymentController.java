package com.cl.controller;

import com.cl.entities.CommonResult;
import com.cl.entities.Payment;
import com.cl.service.PaymentSrtvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chenglei
 * @create 2021-07-30 16:56
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentSrtvice paymentSrtvice;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentSrtvice.create(payment);
        log.info("result: "+result);
        if(result > 0){
            return new CommonResult(200,"成功 ,serverPort: " + serverPort, result);
        }else{
            return new CommonResult(444,"失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        Payment payment = paymentSrtvice.getPaymentById(id);
        log.info("result: "+payment);
        if(payment != null){
            return new CommonResult(200,"成功 ,serverPort: " + serverPort,payment);
        }else{
            return new CommonResult(444,"失败",null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String s : services){
            System.err.println("services: "+services);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instances){
            System.err.println("serviceInstance: "+serviceInstance);
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut()
    {
        System.out.println("*****paymentFeignTimeOut from port: "+serverPort);
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
