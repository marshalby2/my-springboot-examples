package com.my.controller;

import com.my.bean.Poem;
import com.my.service.PoemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author marshal
 * @Date 26/9/20 7:38 PM
 */
@RestController
@RequestMapping("/poem")
@Api(value = "古诗", tags = "poem")
public class PoemController {


    @Autowired
    private PoemService poemService;

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public void save(Poem poem) {
        poemService.save(poem);
    }

    /**
     *  等价于： GET /poem/_doc/2
     *
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据ID查询")
    public Poem getById(@PathVariable Long id) {
        return poemService.findById(id);
    }


    @GetMapping("/getAll")
    @ApiOperation(value = "查询所有")
    public Iterable<Poem> getAll() {
        return poemService.findAll();
    }


    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public Page<Poem> page(Integer current, Integer size) {
        return poemService.page(current, size);
    }


}
