package com.my.web;

import com.baomidou.mybatisplus.extension.api.R;
import com.my.annotation.OperationLogAnnotation;
import com.my.bean.User;
import com.my.constant.OperationType;
import com.my.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YangYunbo
 * @version 2021-06-08
 */
@RestController
@Api(tags = "user", value = "用户管理接口")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    @ApiOperation(value = "新增")
    @OperationLogAnnotation(module = "用户模块", type = OperationType.ADD, description = "新增")
    public R save(@RequestBody User user) {
        return R.ok(this.userService.save(user));
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新")
    @OperationLogAnnotation(module = "用户模块", type = OperationType.UPDATE, description = "保存")
    public R update(@RequestBody User user) {
        return R.ok(this.userService.updateById(user));
    }

    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据ID查询")
    @OperationLogAnnotation(module = "用户模块", type = OperationType.QUERY, description = "根据ID查询")
    public R query(@PathVariable Long id) {
        return R.ok(this.userService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除")
    @OperationLogAnnotation(module = "用户模块", type = OperationType.DELETE, description = "根据ID删除")
    public R delete(@PathVariable Long id) {
        return R.ok(this.userService.getById(id));
    }
}
