package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentService
 * @author: liucz
 * @Description TODO
 * @Date 2021/3/22 17:51
 * @Version 1.0版本
 */
public interface PaymentService {

    /**
     * @Description  新增
     * @params   payment
     * @return   int
     * @Author   liucz
     * @since 2021/3/22 16:29
     */
    public int create(Payment payment);

    /**
     * @Description  查询
     * @params   id
     * @return   Payment
     * @Author   liucz
     * @since 2021/3/22 16:29
     */
    public Payment getPaymentById(@Param("id") Long id);
}
