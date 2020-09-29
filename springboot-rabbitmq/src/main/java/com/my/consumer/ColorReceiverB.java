package com.my.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 29/9/20 8:32 AM
 */
@Component
@Slf4j
@RabbitListener(queues = "topicQueueB")
public class ColorReceiverB {

    @RabbitHandler
    public void receive(String color) {
        log.info("ColorReceiverB receive: " + color);
    }

}
