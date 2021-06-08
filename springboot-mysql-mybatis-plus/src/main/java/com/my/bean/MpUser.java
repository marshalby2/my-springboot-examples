package com.my.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 8:38 AM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MpUser extends Model<MpUser> {

    private Long id;
    private String name;
    private Integer age;

    @TableLogic
    private Integer deleted;


}
