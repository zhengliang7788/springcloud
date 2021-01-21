package com.ifsw.springcloud.service.impl;

import com.ifsw.springcloud.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author zhengLiang
 * @description
 * @date 2021/1/21 10:50
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageChannel output;
    /**
     * 发送消息
     *
     * @return
     */
    @Override
    public String sendMsg() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info(serial);
        return serial;
    }
}
