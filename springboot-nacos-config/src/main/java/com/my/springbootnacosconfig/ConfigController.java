package com.my.springbootnacosconfig;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author marshal
 * @Date 2021-03-31 8:25 PM
 */
@RestController
@RequestMapping("config")
public class ConfigController {

    // 通过 Nacos 的 @NacosValue 注解设置属性值
    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping("/get")
    public boolean get() {
        return useLocalCache;
    }

}
