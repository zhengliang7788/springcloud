package com.ifsw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/22 9:35
 */
@RequestMapping("/consul/consumer")
@RestController
@Slf4j
public class OrderController {
    public static final String PAY_PATH = "http://cloud-consul-provider";
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/string")
    public String getString() {

        return restTemplate.getForObject(PAY_PATH + "/consul/provider", String.class);

    }
}
