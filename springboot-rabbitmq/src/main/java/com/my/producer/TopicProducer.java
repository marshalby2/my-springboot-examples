package com.my.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:40 PM
 */
@Component
@Slf4j
public class TopicProducer {

    @Autowired
    private RabbitTemplate template;

    public void produce(String criteria) {
//        var strings = criteria.split(".");
//        StringBuilder sb = new StringBuilder();
        template.convertAndSend("topic.color", criteria, "This is " + criteria);
    }

}
