package com.my;

import com.my.producer.BroadcastProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 8:18 PM
 */
@SpringBootTest
public class FanoutTest {

    @Autowired
    private BroadcastProducer fanoutSender;

    /**
     *  发布订阅模式
     *
     */
    @Test
    public void testFanout() {
        fanoutSender.send();
        /**
         *  FanoutReceiverA receive : This is a fanout message
         *  FanoutReceiverB receive : This is a fanout message
         *  FanoutReceiverC receive : This is a fanout message
         */
    }

}
