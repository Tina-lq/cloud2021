package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentDao
 * @author: liucz
 * @Description TODO
 * @Date 2021/3/22 16:26
 * @Version 1.0版本
 */
@Mapper
public interface PaymentDao {

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
