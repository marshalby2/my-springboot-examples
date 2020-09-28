package com.my;

import com.my.consumer.HelloReceiver;
import com.my.producer.HelloSender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:25 AM
 */
@SpringBootTest
@Slf4j
public class HelloTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception{
        int i = 10;
        while (i > 0) {
            helloSender.send();
            Thread.sleep(3000);
            i--;
        }
    }
}
