package com.cl.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenglei
 * @create 2021-08-11 16:32
 */
@Configuration
@MapperScan({"com.cl.dao"})
public class MyBatisConfig {
}
