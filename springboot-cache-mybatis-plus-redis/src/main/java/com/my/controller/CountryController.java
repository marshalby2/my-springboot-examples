package com.my.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.my.bean.Country;
import com.my.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/14/19 8:45 AM
 */
@RestController
@RequestMapping("/country")
@Api(value = "CountryController")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/queryById")
    @ApiOperation(value = "根据ID查询")
    public R<Object> queryById(Integer id) {
        return R.ok(this.service.getById(id));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public R page(int current, int size) {
        return R.ok(this.service.page(current, size));
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public R save(Country country) {
        return R.ok(this.service.saveOrUpdate(country));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除")
    public R delete(@PathVariable Integer id) {
        return R.ok(this.service.removeById(id));
    }



}
