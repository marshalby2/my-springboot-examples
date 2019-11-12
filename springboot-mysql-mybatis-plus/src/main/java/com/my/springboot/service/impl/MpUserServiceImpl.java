package com.my.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.springboot.domain.MpUser;
import com.my.springboot.mapper.MpUserMapper;
import com.my.springboot.service.MpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 9:01 AM
 */
@Service
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUser> implements MpUserService {
    @Autowired
    private MpUserMapper mapper;

    @Override
    public List<MpUser> queryAdult() {
        return this.mapper.selectAdult();
    }
}
