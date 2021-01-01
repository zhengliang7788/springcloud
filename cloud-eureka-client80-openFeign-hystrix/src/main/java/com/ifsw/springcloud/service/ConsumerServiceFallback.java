package com.ifsw.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/29 17:18
 */
@Component
public class ConsumerServiceFallback implements ConsumerService {

    /**
     * 正常服务
     *
     * @param id
     * @return
     */
    @Override
    public String normalFun(String id) {
        return "服务异常,请重试";
    }

    /**
     * 服务降级
     *
     * @return
     */
    @Override
    public String timeout() {
        return "服务超时请重试";
    }


}
