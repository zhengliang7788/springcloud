package com.ifsw.springcloud.service;

import com.ifsw.springcloud.base.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/28 9:21
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
public interface ProviderService {
    /**
     * 查询信息
     *
     * @param id
     * @return
     */
    @GetMapping("/provider/payment/get/{id}")
    Result getPaymentById(@PathVariable("id") Long id);

    /**
     * feign 超时测试
     * @return
     */
    @GetMapping("/provider/payment/timeout")
    String timeout();
}
