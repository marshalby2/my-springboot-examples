package com.my.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:23 AM
 */
@Component
@RabbitListener(queues = "workQueue")
@Slf4j
public class WorkReceiverB {

    @RabbitHandler
    public void process(String message) {
        log.info("workReceiverB :  " + message);
    }
}
