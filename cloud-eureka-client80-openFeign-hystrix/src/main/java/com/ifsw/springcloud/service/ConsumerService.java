package com.ifsw.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/29 17:00
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE",fallback = ConsumerServiceFallback.class)
public interface ConsumerService {
    /**
     * 正常服务
     *
     * @param id
     * @return
     */
    @GetMapping("/provider/service/normal/{id}")
    String normalFun(@PathVariable("id") String id);

    /**
     * 服务降级
     * @return
     */
    @GetMapping("/provider/service/timeout")
    String timeout();


}
