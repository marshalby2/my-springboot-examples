package com.my.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 8:22 PM
 */
@Component
@Slf4j
public class BroadcastProducer {

    @Autowired
    private RabbitTemplate template;

    public void send() {
        String context = "This is a broadcast message";
        template.convertAndSend("fanout.broadcast","", context);
    }
}
