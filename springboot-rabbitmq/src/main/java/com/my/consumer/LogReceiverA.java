package com.my.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 9:06 PM
 */
@Component
@Slf4j
@RabbitListener(queues = "logQueueA")
public class LogReceiverA {

    @RabbitHandler
    public void receive(String message) {
        log.info("error receiver receive : " + message);
    }

}
