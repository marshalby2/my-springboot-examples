package com.my.security.controller;

import com.my.security.bean.SysUser;
import com.my.security.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author marshal
 * @Date 7/9/20 11:42 AM
 */
@RestController
@RequestMapping("/user")
@Api(tags = "user", value = "用户管理")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/add")
    public void add(@RequestBody SysUser user) {
        sysUserService.add(user);
    }

}
