package com.ifsw.springcloud.controller;

import com.ifsw.springcloud.base.Result;
import com.ifsw.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/10 22:26
 */
@RequestMapping("/consumer/payment")
@RestController
@Slf4j
public class OrderController {
    public static final String PAY_PATH = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public Result create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAY_PATH + "/provider/payment/create", payment, Result.class);
    }

    @GetMapping("/get/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAY_PATH + "/provider/payment/get/" + id, Result.class);
    }
}
