package com.cl.controller;

import com.cl.entities.CommonResult;
import com.cl.entities.Payment;
import com.cl.service.PaymentSrtvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenglei
 * @create 2021-07-30 16:56
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentSrtvice paymentSrtvice;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentSrtvice.create(payment);
        log.info("result: "+result);
        if(result > 0){
            return new CommonResult(200,"成功",result);
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
            return new CommonResult(200,"成功",payment);
        }else{
            return new CommonResult(444,"失败",null);
        }
    }
}
