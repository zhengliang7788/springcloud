package com.ifsw.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/29 9:36
 */
@Service
public class ProviderService {
    /**
     * 正常服务
     *
     * @param id
     * @return
     */
    public String normalFun(String id) {
        return "线程池:" + Thread.currentThread().getName() + "服务正常,id=" + id;
    }

    /**
     * 服务降级
     *
     * @param
     * @return
     */
    @HystrixCommand(fallbackMethod = "handelTimeout", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String timeout() {
        int time = 4;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "服务耗时(s)" + time;
    }

    public String handelTimeout() {
        return "系统繁忙请稍后再试";
    }

    /**
     * 服务熔断
     *
     * @param id
     * @return
     */
    @HystrixCommand(
            fallbackMethod = "breakFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    }
    )
    public String breakFun(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为复数");
        } else {
            String no = IdUtil.simpleUUID();
            return "线程池:" + Thread.currentThread().getName() + "调用成功流水号:" + no;
        }
    }

    public String breakFallback(Integer id) {
        return "服务异常,id不能为负数：id=" + id;
    }
}
