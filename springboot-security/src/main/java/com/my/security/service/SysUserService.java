package com.my.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my.security.bean.SysUser;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Description TODO
 * @Author marshal
 * @Date 7/9/20 10:48 AM
 */
public interface SysUserService extends IService<SysUser> {

    /**
     *  根据ID查询用户
     *
     * @param id
     * @return
     */
    SysUser getUserById(int id);
    /**
     *  根据用户名查询用户
     *
     * @param username
     * @return
     */
    SysUser getUserByUsername(String username);


    UserDetails login(String username, String password);


    void add(SysUser user);

}
