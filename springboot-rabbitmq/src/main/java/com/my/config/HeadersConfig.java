package com.my.config;

import com.google.common.collect.Maps;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;


/**
 * @Description TODO
 * @Author marshal
 * @Date 29/9/20 8:53 AM
 */
@Configuration
public class HeadersConfig {

    @Bean
    public Queue imageQueueA() {
        return new Queue("imageQueueA");
    }

    @Bean
    public Queue imageQueueB() {
        return new Queue("imageQueueB");
    }


    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange("headers.image");
    }

    /**
     * 匹配type=jpg且size=12的消息，分发给队列imageQueueA
     *
     * @return
     */
    @Bean
    public Binding bindingHeadersExchangeA() {
        Map<String, Object> keys = Maps.newHashMap();
        keys.put("type", "jpg");
        keys.put("size", 12);
        return BindingBuilder.bind(imageQueueA()).to(headersExchange()).whereAll(keys).match();
    }

    /**
     *  匹配type=png或者size=6的消息，分发给队列imageQueueB
     *
     * @return
     */
    @Bean
    public Binding bindingHeadersExchangeB() {
        Map<String, Object> keys = Maps.newHashMap();
        keys.put("type", "png");
        keys.put("size", 6);
        return BindingBuilder.bind(imageQueueB()).to(headersExchange()).whereAny(keys).match();
    }
}
