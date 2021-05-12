package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * @ClassName customerBlockHandler
 * @Author Liucz
 * @Description 全局自定义兜底方法类
 * @Date 2021/5/10 15:39
 **/
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444, "按客户自定义，global handlerException---1");
    }


    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444, "按客户自定义，global handlerException---2");
    }
}
