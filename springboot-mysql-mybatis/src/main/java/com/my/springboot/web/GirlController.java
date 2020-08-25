package com.my.springboot.web;

import com.my.springboot.bean.Girl;
import com.my.springboot.service.GirlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 25/8/20 8:35 PM
 */
@Api(tags = "girl", value = "Girl管理接口")
@RequestMapping("/girl")
@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

    @GetMapping("/query/{id}")
    @ApiOperation(value = "根据ID查询")
    public Girl query(@PathVariable int id) {
        return girlService.query(id);
    }


    @GetMapping("/queryList")
    @ApiOperation(value = "查询列表")
    public List<Girl> queryList() {
        return girlService.queryList();
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public void save(Girl girl) {
        girlService.save(girl);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除")
    public void delete(@PathVariable int id) {
        girlService.delete(id);
    }

}
