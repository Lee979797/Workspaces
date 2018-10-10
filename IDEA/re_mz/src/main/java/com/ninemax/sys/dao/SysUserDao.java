package com.ninemax.sys.dao;

import com.ninemax.sys.entity.SysUser;

public interface SysUserDao {
    /**
     * 根据用户名查找用户信息
     */
    SysUser findUserByUserName(String username);

}
