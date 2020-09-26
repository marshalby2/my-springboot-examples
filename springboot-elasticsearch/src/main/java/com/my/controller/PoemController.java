package com.my.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author marshal
 * @Date 26/9/20 7:38 PM
 */
@RestController
@RequestMapping("/poem")
@Api(value = "古诗", tags = "poem")
public class PoemController {


}
