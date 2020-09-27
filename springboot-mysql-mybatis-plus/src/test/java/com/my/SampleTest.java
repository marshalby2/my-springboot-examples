package com.my;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.my.bean.MpUser;
import com.my.mapper.MpUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 2/9/20 9:45 AM
 */
@SpringBootTest
public class SampleTest {


    @Autowired
    private MpUserMapper mapper;


    @Test
    public void selectAll() {
        List<MpUser> list = mapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void selectByWrapper() {
        // SELECT id,deleted,name,age FROM mp_user WHERE deleted=0 AND (name LIKE ? AND age >= ?)
        QueryWrapper<MpUser> wrapper = Wrappers.<MpUser>query().like("name", "c").ge("age", 10);
        List<MpUser> mpUsers = mapper.selectList(wrapper);
        mpUsers.forEach(System.out::println);
    }

    @Test
    public void selectListByLambda() {
        //SELECT id,deleted,name,age FROM mp_user WHERE deleted=0 AND (name LIKE ? AND age >= ?)
        LambdaQueryChainWrapper<MpUser> chainWrapper = new LambdaQueryChainWrapper<>(mapper);
        List<MpUser> mpUsers = chainWrapper.like(MpUser::getName, "m").ge(MpUser::getAge, 10).list();
        mpUsers.forEach(System.out::println);
    }

    @Test
    public void selectOneByLambda() {
        LambdaQueryChainWrapper<MpUser> chainWrapper = new LambdaQueryChainWrapper<>(mapper);
        MpUser tom = chainWrapper.eq(MpUser::getName, "Tom").one();
        System.out.println(tom);

    }

}
