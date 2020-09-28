package com.my.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 3:46 PM
 */
@Component
@Slf4j
public class WorkSenderB {

    @Autowired
    private RabbitTemplate template;

    public void send(int i) {
        template.convertAndSend("workQueue", ("WorkSenderB send message ******* " + i));
    }

}

