package com.ifsw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/22 9:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulMain8003.class, args);
    }
}
