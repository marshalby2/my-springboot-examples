package com.my;

import com.my.bean.MpUser;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Description ActiveRecord 模式 测试类
 * @Author marshal
 * @Date 7/9/20 10:57 AM
 */
public class ARTest {

    @Test
    public void testSelect() {
        MpUser user = new MpUser();
        List<MpUser> users = user.selectAll();
        users.stream().forEach(System.out::println);
    }

}
