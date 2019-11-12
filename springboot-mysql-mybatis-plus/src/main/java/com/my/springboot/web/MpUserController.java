package com.my.springboot.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.springboot.domain.MpUser;
import com.my.springboot.service.MpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 9:09 AM
 */
@RestController
public class MpUserController {

    @Autowired
    private MpUserService service;

    @GetMapping("/page")
    public R page(Page<MpUser> page) {
        IPage<MpUser> iPage = this.service.page(page, Wrappers.emptyWrapper());
        return R.ok(iPage);
    }

    @GetMapping("/queryById")
    public R queryById(Long id) {
        return R.ok(this.service.getById(id));
    }

    @GetMapping("/queryAdult")
    public R queryAdult() {
        return R.ok(this.service.queryAdult());
    }

    @PostMapping("/saveOrUpdate")
    public R saveOrUpdate(MpUser user){
        return R.ok(this.service.saveOrUpdate(user));
    }

    @DeleteMapping("/delete/{id}")
    public R logicDelete(@PathVariable("id") Long id) {
       return R.ok( this.service.removeById(id));
    }




}
