package com.my.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 8:58 PM
 */
@Configuration
public class LogsProducer {

    @Autowired
    private RabbitTemplate template;


    /**
     *  根据参数指定routingKey
     *
     * @param type
     */
    public void produce(String type) {
        switch (type) {
            case "error" -> template.convertAndSend("directExchange","error", "This is error logs");
            case "info" -> template.convertAndSend("directExchange","info", "This is info logs");
        }
    }

}
