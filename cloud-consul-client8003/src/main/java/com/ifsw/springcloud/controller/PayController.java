package com.ifsw.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/22 9:41
 */
@RequestMapping("/consul/provider")
@RestController
public class PayController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/string")
    public String get() {
        return "springcloud with consul: " + port + "\t" + UUID.randomUUID().toString();
    }

}
