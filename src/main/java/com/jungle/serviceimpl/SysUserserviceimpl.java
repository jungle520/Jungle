package com.jungle.serviceimpl;

import com.jungle.dao.SysUserMapper;
import com.jungle.mapper.SysUser;
import com.jungle.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by wangjiang on 2019/10/22.
 */

@Service
public class SysUserserviceimpl  implements SysUserService {


   @Autowired(required=false)
    private SysUserMapper sysUserMapper;


    @Override
    public List findAllUser() {
        return null;
    }

    @Override
    public SysUser findByUserid(String userAccount) {
        return sysUserMapper.selectByUserAccount(userAccount);
    }


}
