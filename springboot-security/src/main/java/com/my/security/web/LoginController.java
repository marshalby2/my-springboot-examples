package com.my.security.web;

import com.baomidou.mybatisplus.extension.api.R;
import com.my.security.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author marshal
 * @Date 7/9/20 11:23 AM
 */
@RestController
@Api(tags = "login", value = "登录")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;


    /**
     *
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public R login(String username, String password) {
        return R.ok(sysUserService.login(username, password));
    }
}
