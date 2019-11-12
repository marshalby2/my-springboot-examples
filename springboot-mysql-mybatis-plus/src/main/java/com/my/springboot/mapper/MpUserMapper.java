package com.my.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.springboot.domain.MpUser;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 9:00 AM
 */
public interface MpUserMapper extends BaseMapper<MpUser> {

    List<MpUser> selectAdult();
}
