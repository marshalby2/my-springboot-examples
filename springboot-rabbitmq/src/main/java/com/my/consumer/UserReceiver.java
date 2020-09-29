package com.my.consumer;

import com.my.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:50 PM
 */
@Component
@Slf4j
public class UserReceiver {

    /**
     *  RabbitListener注解可以直接作用于方法
     *
     * @param user
     */
    @RabbitListener(queues = "user.info")
    public void receive(User user) {
        log.info("receive user : " + user);
    }

}
