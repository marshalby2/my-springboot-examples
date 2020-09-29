package com.my;

import com.my.producer.HelloProducer;
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
    private HelloProducer helloProducer;

    @Test
    public void hello() throws Exception{
        int i = 0;
        while (i < 10) {
            helloProducer.produce(i);
            Thread.sleep(3000);
            i++;
        }
    }
}
