package com.ifsw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhengLiang
 * @description
 * @date 2021/1/21 11:30
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class MqConsumerMia8803 {
    public static void main(String[] args) {
        SpringApplication.run(MqConsumerMia8803.class, args);
    }
}
