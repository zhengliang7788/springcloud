package com.ifsw.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/28 9:55
 */
@Configuration
public class OpenFeignConfig {
    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }
}
