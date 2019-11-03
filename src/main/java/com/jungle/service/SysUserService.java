package com.jungle.service;

import com.jungle.dao.SysUserMapper;
import com.jungle.mapper.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjiang on 2019/10/22.
 */

public interface SysUserService  {
    List findAllUser();

    SysUser findByUserid(String userID);
}
