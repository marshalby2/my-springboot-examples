package com.my.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:17 AM
 */
@Component
@Slf4j
public class HelloProducer {

    @Autowired
    private RabbitTemplate template;

    public void produce(int i) {
        String message = "hello : " + i;
        log.info("hello produce: ===============> " + message);
        // 参考：<a>https://www.rabbitmq.com/tutorials/tutorial-one-python.html<a/>
        // The queue name needs to be specified in the routing_key parameter:
        // convertAndSend函数有三个参数，第一个是交换机名称，如果不给就是默认的；第二个是路由key指队列名称；第三个是消息体
        template.convertAndSend("hello", message);
    }
}
