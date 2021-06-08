package com.my.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YangYunbo
 * @version 2021-06-08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationLog extends BaseBean {
    /**
     * 模块
     */
    private String module;
    /**
     * 操作人
     */
    private String user;
    /**
     * IP
     */
    private String ip;
    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String description;
    /**
     * 结果
     */
    private String result;
}
