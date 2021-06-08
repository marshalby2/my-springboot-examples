package com.my;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.my.bean.MpUser;
import com.my.mapper.MpUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YangYunbo
 * @version 2021-04-23
 */
@SpringBootTest
public class NewSampleTest {
    @Autowired
    private MpUserMapper mapper;

    @Test
    public void selectList() {
        System.out.println(mapper.selectList(Wrappers.emptyWrapper()));
    }

    @Test
    public void selectByWrapper() {
        QueryWrapper<MpUser> queryWrapper = Wrappers.query();
        queryWrapper.eq("age", 12);
        System.out.println(mapper.selectList(queryWrapper));;
    }

    @Test
    public void selectByLambda() {
        LambdaQueryWrapper<MpUser> lambdaQuery = Wrappers.lambdaQuery(MpUser.class);
        lambdaQuery.ge(MpUser::getAge, 15).like(MpUser::getName, "L");
        System.out.println(mapper.selectList(lambdaQuery));
    }
}

