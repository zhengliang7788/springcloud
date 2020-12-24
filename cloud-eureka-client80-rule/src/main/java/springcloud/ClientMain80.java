package com.ifsw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import rabbionRules.CustomRules;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/10 22:23
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@RibbonClient(name = "cloud-payment-service",configuration = CustomRules.class)
public class ClientMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ClientMain80.class, args);
    }

}
