package com.my.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.bean.OperationLog;
import com.my.mapper.OperationLogMapper;
import com.my.service.OperationLogService;
import org.springframework.stereotype.Service;

/**
 * @author YangYunbo
 * @version 2021-06-08
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {
}
