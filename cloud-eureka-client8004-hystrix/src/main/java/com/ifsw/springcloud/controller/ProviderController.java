package com.ifsw.springcloud.controller;

import com.ifsw.springcloud.service.ProviderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhengLiang
 * @description
 * @date 2020/12/29 9:33
 */
@RequestMapping("/provider/service")
@CrossOrigin
@RestController
public class ProviderController {

    @Resource
    private ProviderService providerService;

    @GetMapping("/normal/{id}")
    public String normalFun(@PathVariable("id") String id) {
        return providerService.normalFun(id);
    }

    @GetMapping("/timeout")
    public String timeout() {
        return providerService.timeout();
    }

    @GetMapping("/break/{id}")
    public String breakFun(@PathVariable("id")Integer id){
        return providerService.breakFun(id);
    }
}
