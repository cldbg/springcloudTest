package com.cl.service;

import com.cl.domain.Order;

/**
 * @author chenglei
 * @create 2021-08-11 16:03
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
