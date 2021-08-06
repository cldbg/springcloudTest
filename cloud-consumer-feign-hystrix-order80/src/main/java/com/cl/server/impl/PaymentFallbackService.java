package com.cl.server.impl;

import com.cl.server.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author chenglei
 * @create 2021-08-06 17:11
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80--paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80--paymentInfo_TimeOut";
    }
}
