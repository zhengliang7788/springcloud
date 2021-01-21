package com.ifsw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhengLiang
 * @description
 * @date 2021/1/21 10:48
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class MqProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(MqProvider8801.class, args);
    }
}
