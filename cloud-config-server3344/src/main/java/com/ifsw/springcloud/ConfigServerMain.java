package com.ifsw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhengLiang
 * @description
 * @date 2021/1/20 10:37
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain.class, args);
    }
}
