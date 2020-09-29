package com.my.consumer;

import com.my.bean.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODOimageQueueA
 * @Author marshal
 * @Date 29/9/20 4:15 PM
 */
@Component
@Slf4j
public class ImageReceiverA {

    @RabbitListener(queues = "imageQueueA")
    public void receive(byte[] image) {
        log.info("ImageReceiverA receive : " + new String(image));
    }

}
