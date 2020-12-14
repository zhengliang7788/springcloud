package com.ifsw.springcloud.service.impl;


import com.ifsw.springcloud.entity.Payment;
import com.ifsw.springcloud.mapper.PaymentMapper;
import com.ifsw.springcloud.service.PaymentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/9 23:34
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    /**
     * 保存
     *
     * @param payment
     * @return
     */
    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Payment getById(Long id) {
        return paymentMapper.getById(id);
    }
}
