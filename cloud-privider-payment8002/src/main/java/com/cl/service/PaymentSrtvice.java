package com.cl.service;

import com.cl.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenglei
 * @create 2021-07-30 16:51
 */
public interface PaymentSrtvice {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);
}
