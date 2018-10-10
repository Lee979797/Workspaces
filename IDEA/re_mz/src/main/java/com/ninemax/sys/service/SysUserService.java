package com.ninemax.sys.service;

import com.ninemax.sys.entity.SysUser;

public interface SysUserService {
    /**
     * 执行登录业务处理
     */
    void login(String username, String password);

    SysUser findUserByUserName(String username);
}
