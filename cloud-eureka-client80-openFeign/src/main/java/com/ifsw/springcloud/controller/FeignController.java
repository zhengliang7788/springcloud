package com.ifsw.springcloud.controller;

import com.ifsw.springcloud.base.Result;
import com.ifsw.springcloud.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/28 9:20
 */
@RequestMapping("/consumer/payment")
@RestController
@Slf4j
public class FeignController {
    @Resource
    private ProviderService providerService;

    @RequestMapping("/get/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        return providerService.getPaymentById(id);
    }

    @RequestMapping("/timeout")
    public String timeout() {
        return providerService.timeout();
    }
}
