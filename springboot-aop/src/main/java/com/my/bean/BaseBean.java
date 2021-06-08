package com.my.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsAutoIncrement;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsKey;
import lombok.Data;

import java.util.Date;

/**
 * @author YangYunbo
 * @version 2021-06-08
 */
@Data
public class BaseBean {
    /**
     * 主键
     */
//    @TableId(type = IdType.AUTO)    // mybatis-plus主键注解
//    @IsKey                          // actable主键注解
//    @IsAutoIncrement                // 自增
//    @Column(comment = "主键ID")                        // 对应数据库字段，不配置name会直接采用属性名作为字段名
    private Long id;

    /**
     * 逻辑删除
     */
    @TableLogic
//    @Column(comment = "逻辑删除", defaultValue = "0")
    private Integer deleted;

    /**
     * 创建时间
     */
//    @Column(name = "create_time", comment = "创建时间") // name指定数据库字段名，comment为备注
    private Date createTime;

    /**
     * 最后修改时间
     */
//    @Column(name = "update_time", comment = "最后修改时间")
    private Date updateTime;
}
