package com.my.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.bean.MpUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 9:00 AM
 */
@Mapper
public interface MpUserMapper extends BaseMapper<MpUser> {

    List<MpUser> selectAdult();
}
