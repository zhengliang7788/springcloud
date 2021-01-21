package com.ifsw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengLiang
 * @description
 * @date 2021/1/21 9:26
 */
@RestController
@RefreshScope
@Slf4j
public class ConfigFileController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String port;
    @GetMapping("/configInfo")
    public String getInfo(){
        log.info("获取配置信息");
        return  "port:"+port+"\t"+configInfo;
    }
}
