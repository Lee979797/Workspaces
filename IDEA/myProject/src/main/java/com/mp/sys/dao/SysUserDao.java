package com.mp.sys.dao;

import com.mp.sys.entity.SysUser;

public interface SysUserDao {
    SysUser findUserByUserName(String username);

    int insertUser(SysUser user);
}
