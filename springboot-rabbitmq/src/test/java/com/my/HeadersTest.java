package com.my;

import com.google.common.collect.Maps;
import com.my.bean.Image;
import com.my.producer.ImagesProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * @Description TODO
 * @Author marshal
 * @Date 29/9/20 4:34 PM
 */
@SpringBootTest
public class HeadersTest {

    @Autowired
    private ImagesProducer imagesProducer;

    @Test
    public void testAll() {
        imagesProducer.produce(Image.builder().type("jpg").size(12).build());
        // ImageReceiverA receive : Image(type=jpg, size=12)
    }

    @Test
    public void testAny() {
        imagesProducer.produce(Image.builder().type("png").size(12).build());
        // ImageReceiverB receive : Image(type=png, size=12)
    }

    @Test
    public void testAny2() {
        imagesProducer.produce(Image.builder().type("jpg").size(6).build());
        // ImageReceiverB receive : Image(type=jpg, size=6)
    }

}
