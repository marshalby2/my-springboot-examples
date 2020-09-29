package com.my;

import com.my.producer.TopicProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:44 PM
 */
@SpringBootTest
public class TopicTest {

    @Autowired
    private TopicProducer topicProducer;

    /**
     * 只有topicQueueA 能收到消息
     *
     */
    @Test
    public void test1() {
        String criteria = "yellow.blue.red";
        topicProducer.produce(criteria);
        // ColorReceiverA receive: This is yellow.blue.red
    }

    /**
     *  topicQueueA 和 topicQueueB 都能收到消息
     *
     */
    @Test
    public void test2() {
        String criteria = "green.blue.red";
        topicProducer.produce(criteria);
        // ColorReceiverA receive: This is green.blue.red
        // ColorReceiverB receive: This is green.blue.red
    }

}
