package com.my.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my.domain.MpUser;

import java.util.List;

/**
 * @Description TODO
 * @Author marshal
 * @Date 11/12/19 9:01 AM
 */
public interface MpUserService extends IService<MpUser> {

    List<MpUser> queryAdult();

}
