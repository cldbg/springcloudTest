package com.cl.service.impl;

import com.cl.entities.CommonResult;
import com.cl.entities.Payment;
import com.cl.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author chenglei
 * @create 2021-08-10 16:17
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
    }
}
