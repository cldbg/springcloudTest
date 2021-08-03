package com.cl.controller;

import com.cl.entities.CommonResult;
import com.cl.entities.Payment;
import com.cl.service.PaymentSrtvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentSrtvice.create(payment);
        log.info("result: "+result);
        if(result > 0){
            return new CommonResult(200,"成功，serverPort: " + serverPort,result);
        }else{
            return new CommonResult(444,"失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        Payment payment = paymentSrtvice.getPaymentById(id);
        System.out.println("11");
        log.info("result: "+payment);
        if(payment != null){
            return new CommonResult(200,"成功，serverPort: " + serverPort,payment);
        }else{
            return new CommonResult(444,"失败",null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

}
