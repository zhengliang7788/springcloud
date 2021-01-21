package com.ifsw.springcloud.controller;

import com.ifsw.springcloud.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhengLiang
 * @description
 * @date 2021/1/21 11:03
 */
@RestController
public class MessageController {
    @Resource
    private MessageService messageService;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageService.sendMsg();
    }
}
