package com.my.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 8:48 PM
 *
 * <a>https://www.rabbitmq.com/tutorials/tutorial-five-python.html</a>
 * Messages sent to a topic exchange can't have an arbitrary routing_key - it must be a list of words, delimited by dots.
 * The words can be anything, but usually they specify some features connected to the message.
 * A few valid routing key examples: "stock.usd.nyse", "nyse.vmw", "quick.orange.rabbit".
 * There can be as many words in the routing key as you like, up to the limit of 255 bytes.
 */
@Configuration
public class TopicConfig {

    @Bean
    public Queue topicQueueA() {
        return new Queue("topicQueueA");
    }

    @Bean
    public Queue topicQueueB() {
        return new Queue("topicQueueB");
    }

    @Bean
    public TopicExchange colorTopicExchange() {
        return new TopicExchange("topic.color");
    }

    @Bean
    public Binding bindingExchangeTopicQueueA() {
        return BindingBuilder.bind(topicQueueA()).to(colorTopicExchange()).with("*.blue.*");
    }

    @Bean
    public Binding bindingExchangeTopicQueueB() {
        return BindingBuilder.bind(topicQueueB()).to(colorTopicExchange()).with("green.#");
    }
}
