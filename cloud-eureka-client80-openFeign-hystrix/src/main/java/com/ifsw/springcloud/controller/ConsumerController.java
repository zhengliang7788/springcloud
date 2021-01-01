package com.ifsw.springcloud.controller;

import com.ifsw.springcloud.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/29 17:01
 */
@RequestMapping("/consumer/service")
@RestController
@DefaultProperties(defaultFallback = "globalFallback")
public class ConsumerController {
    @Resource
    private ConsumerService consumerService;

    @GetMapping("/normal/{id}")
    @HystrixCommand
    public String normal(@PathVariable("id") String id) {
        return consumerService.normalFun(id);
    }

    @GetMapping("/timeout")
    @HystrixCommand
    public String timeout() {
        return consumerService.timeout();
    }

    public String globalFallback() {
        return "服务异常，请稍后再试";
    }

}
