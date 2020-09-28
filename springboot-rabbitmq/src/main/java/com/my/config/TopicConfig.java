package com.my.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 8:48 PM
 */
@Configuration
public class TopicConfig {

    public Queue topicQueue() {
        return new Queue("topicQueue");
    }

}
