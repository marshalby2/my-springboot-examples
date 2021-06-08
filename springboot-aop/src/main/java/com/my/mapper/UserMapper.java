package com.my.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author YangYunbo
 * @version 2021-06-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
