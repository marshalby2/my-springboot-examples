package com.my.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 8:22 PM
 */
@Component
@Slf4j
public class FanoutSender {

    @Autowired
    private RabbitTemplate template;

    public void send() {
        String context = "This is a fanout message";
        // 因为我们在配置文件FanoutConfig中已经将队列都绑定在fanoutExchange交换机上了，所以这里的routingKey参数可以为空
        template.convertAndSend("fanoutExchange","", context);
    }

}
