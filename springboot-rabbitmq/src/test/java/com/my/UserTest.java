package com.my;

import com.my.producer.UserProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Author marshal
 * @Date 28/9/20 10:57 PM
 */
@SpringBootTest
public class UserTest {

    @Autowired
    private UserProducer userProducer;


    @Test
    public void test() {
        userProducer.produce();
        // receive user : User(name=Tom, age=20)
    }
}
