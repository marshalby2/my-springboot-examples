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
 * @Date 28/9/20 3:46 PM
 */
@Component
@Slf4j
public class WorkSender {

    @Autowired
    private RabbitTemplate template;

    public void send(int i) {
//        log.info("WorkSender produce message ******* " + i);
        template.convertAndSend("workQueue", ("WorkSender send message ******* " + i));
    }

}

