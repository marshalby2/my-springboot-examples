package com.my;

import com.my.producer.ColorProducer;
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
    private ColorProducer colorProducer;

    @Test
    public void test1() {
        String criteria = "yellow.blue.red";
        colorProducer.produce(criteria);
        // ColorReceiverA receive: This is yellow.blue.red
    }

    @Test
    public void test2() {
        String criteria = "green.blue.red";
        colorProducer.produce(criteria);
        // ColorReceiverA receive: This is green.blue.red
        // ColorReceiverB receive: This is green.blue.red
    }

}
