package com.my;

import com.my.producer.WorkSender;
import com.my.producer.WorkSenderB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 3:49 PM
 */
@SpringBootTest
public class WorkQueueTest {

    @Autowired
    private WorkSender workSender;
    @Autowired
    private WorkSenderB workSenderB;

    /**
     * 参考：<a>https://www.rabbitmq.com/tutorials/tutorial-two-python.html</a>
     * <p>
     * By default, RabbitMQ will send each message to the next consumer, in sequence.
     * On average every consumer will get the same number of messages
     */
    @Test
    public void oneToMany() {
        int i = 0;
        while (i < 20) {
            workSender.send(i);
            i++;
        }
    }



    @Test
    public void manyToMany() {
        int i = 0;
        while (i < 40) {
            workSender.send(i);
            workSenderB.send(i);
            i++;
        }
    }

}
