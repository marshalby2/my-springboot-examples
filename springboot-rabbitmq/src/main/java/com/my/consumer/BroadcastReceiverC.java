package com.my.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 8:38 PM
 */
@Component
@Slf4j
@RabbitListener(queues = "broadcastQueueC")
public class BroadcastReceiverC {

    @RabbitHandler
    public void process(String message) {
        log.info("BroadcastReceiverC receive : " + message);
    }

}
