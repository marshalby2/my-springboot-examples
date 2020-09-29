package com.my.producer;

import com.my.bean.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:50 PM
 */
@Component
public class UserProducer {

    @Autowired
    private RabbitTemplate template;

    public void produce() {
        template.convertAndSend("topic.user", "user.info", User.builder().name("Tom").age(20).build());
    }

}
