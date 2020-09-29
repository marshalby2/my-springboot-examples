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
@RabbitListener(queues = "logQueueB")
public class LogReceiverB {

    @RabbitHandler
    public void receive(String message) {
        log.info("mix receiver receive : " + message);
    }

}
