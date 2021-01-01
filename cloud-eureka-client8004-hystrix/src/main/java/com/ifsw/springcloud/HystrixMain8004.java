package com.ifsw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/29 9:32
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableCircuitBreaker
public class HystrixMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain8004.class, args);
    }
}
