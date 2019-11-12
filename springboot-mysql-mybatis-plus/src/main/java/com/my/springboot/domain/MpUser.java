package com.my.springboot.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 8:38 AM
 */
@Data
public class MpUser{

    private Long id;
    private String name;
    private Integer age;

    @TableLogic
    private Integer deleted;


}
