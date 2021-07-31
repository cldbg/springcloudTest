package com.cl.service.impl;

import com.cl.dao.PaymentDao;
import com.cl.entities.Payment;
import com.cl.service.PaymentSrtvice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenglei
 * @create 2021-07-30 16:52
 */
@Service
public class PaymentServiceImpl implements PaymentSrtvice {

    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") Integer id){
        return paymentDao.getPaymentById(id);
    }
}
