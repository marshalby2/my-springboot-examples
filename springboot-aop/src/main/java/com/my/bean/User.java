package com.my.bean;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsKey;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;

/**
 * @author YangYunbo
 * @version 2021-06-08
 */
@Data
//@Table(name = "user", comment = "用户表")
public class User extends BaseBean {
//    @Column(comment = "姓名")
    private String name;
//    @Column(comment = "年龄")
    private int age;
}
