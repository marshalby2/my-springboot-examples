package com.my.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.bean.MpUser;
import com.my.service.MpUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 9:09 AM
 */
@Api(tags = "user", value = "用户管理接口")
@RequestMapping("/user")
@RestController
public class MpUserController {

    @Autowired
    private MpUserService service;

    @GetMapping("/page")
    @ApiOperation(value = "用户分页查询")
    public R page(Page<MpUser> page) {
        IPage<MpUser> iPage = this.service.page(page, Wrappers.emptyWrapper());
        return R.ok(iPage);
    }

    @GetMapping("/queryById/{id}")
    @ApiOperation(value = "根据ID查询用户")
    public R queryById(@PathVariable Long id) {
        return R.ok(this.service.getById(id));
    }

    @GetMapping("/queryAdult")
    public R queryAdult() {
        return R.ok(this.service.queryAdult());
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "更新或保存")
    public R saveOrUpdate(@RequestBody MpUser user){
        return R.ok(this.service.saveOrUpdate(user));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除")
    public R logicDelete(@PathVariable("id") Long id) {
       return R.ok( this.service.removeById(id));
    }




}
