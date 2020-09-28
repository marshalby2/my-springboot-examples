package com.my.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:17 AM
 */
@Component
@Slf4j
public class HelloSender {

    @Autowired
    private RabbitTemplate template;

    public void send() {
        String context = "hello : " + Date.from(Instant.now());
        log.info("produce: ===============> " + context);
        template.convertAndSend("hello", context);
    }
}
