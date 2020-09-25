package com.my.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 8:38 AM
 */
@Data
public class MpUser extends Model<MpUser> {

    private Long id;
    private String name;
    private Integer age;

    @TableLogic
    private Integer deleted;


}
