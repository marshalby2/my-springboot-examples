package com.my.producer;

import com.my.bean.Image;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 29/9/20 4:11 PM
 */
@Component
public class ImagesProducer {

    @Autowired
    private RabbitTemplate template;

    public void produce(Image image) {
        MessageProperties properties = new MessageProperties();
        properties.setHeader("type", image.getType());
        properties.setHeader("size", image.getSize());
        template.convertAndSend("headers.image", "", new Message(image.toString().getBytes(), properties));
    }
}
