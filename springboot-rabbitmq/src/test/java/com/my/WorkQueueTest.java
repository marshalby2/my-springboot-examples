package com.my;

import com.my.producer.WorkSender;
import com.my.producer.WorkSenderB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 3:49 PM、
 *
 *
 *  在没有指定交换机的一对多和多对多的模式中，（所有）生产者生产的消息会被平分到（所有）消费者，每个消费者拿到的一部分
 *
 */
@SpringBootTest
public class WorkQueueTest {

    @Autowired
    private WorkSender workSender;
    @Autowired
    private WorkSenderB workSenderB;

    /**
     *  一对多
     *
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


    /**
     *  多对多
     *
     */
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
