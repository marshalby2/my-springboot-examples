package com.my.contoller;

import com.my.bean.Goods;
import com.my.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author marshal
 * @Date 27/9/20 3:41 PM
 */
@RestController
@RequestMapping("/goods")
@Api(value = "商品接口", tags = "goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public void save(@RequestBody Goods goods) {
        goodsService.save(goods);
    }

    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据ID查询")
    public Goods getById(@PathVariable Long id) {
        return goodsService.findById(id);
    }
}
