package com.cl.myhander;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cl.entities.CommonResult;

/**
 * @author chenglei
 * @create 2021-08-10 15:04
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler");
    }
}
