package com.ifsw.springcloud.messageListen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;



/**
 * @author zhengLiang
 * @description
 * @date 2021/1/21 11:20
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class MessageListener {
    @Value("${server.port}")
    private String serverPort;
    @StreamListener(Sink.INPUT)
    public void inputMessage(Message<String> message){
        log.info("接收到消息：port:"+serverPort+":"+message.getPayload());
    }
}
