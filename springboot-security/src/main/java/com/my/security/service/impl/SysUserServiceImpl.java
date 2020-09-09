package com.my.security.service.impl;

import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.security.bean.SysUser;
import com.my.security.config.security.SysUserDetailsServiceImpl;
import com.my.security.mapper.SysUserMapper;
import com.my.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author marshal
 * @Date 7/9/20 11:05 AM
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper mapper;
    @Autowired
    private SysUserDetailsServiceImpl userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public SysUser getUserById(int id) {
        return mapper.selectById(id);
    }

    @Override
    public SysUser getUserByUsername(String username) {
        var wrapper = new LambdaQueryChainWrapper<>(mapper);
        return wrapper.eq(SysUser::getUsername, username).one();
    }

    @Override
    public UserDetails login(String username, String password) {
        var userDetails = userDetailsService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return userDetails;
    }

    @Override
    public void add(SysUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        mapper.insert(user);
    }
}
