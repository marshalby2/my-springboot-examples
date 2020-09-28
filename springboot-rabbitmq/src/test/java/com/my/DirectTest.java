package com.my;

import com.my.producer.LogsProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 9:44 PM
 */
@SpringBootTest
public class DirectTest {

    @Autowired
    private LogsProducer logsProducer;

    @Test
    public void testErrorLog() {
        logsProducer.produce("error");
        // mix receiver receive : This is error logs
        // error receiver receive : This is error logs
    }

    /**
     *  只有
     *
     */
    @Test
    public void testInfoLog() {
        logsProducer.produce("info");
        // mix receiver receive : This is info logs
    }



}
