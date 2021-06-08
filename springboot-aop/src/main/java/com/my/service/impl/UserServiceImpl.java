package com.my.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.bean.User;
import com.my.mapper.UserMapper;
import com.my.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author YangYunbo
 * @version 2021-06-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
