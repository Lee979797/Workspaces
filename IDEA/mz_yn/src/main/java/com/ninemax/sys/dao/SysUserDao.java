package com.ninemax.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ninemax.sys.entity.SysUser;

public interface SysUserDao {
    /**
     * 根据用户名查找用户信息
     */
    SysUser findUserByUserName(String username);

    /**
     * 根据用户id查找用户权限标识信息
     * 例如：com.ninemax.sys:role:view,com.ninemax.sys:role:add
     */
    List<String> findUserPermissions(String username);


    int updateObject(SysUser entity);

    /**
     * 根据用户id查找用户对象
     */
    SysUser findObjectById(Integer id);

    int insertObject(SysUser entity);

    int getRowCount(@Param("username") String username);

    List<SysUser> findPageObjects(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize, @Param("username") String username);

    int getRowCountForDean(@Param("username") String username);

    List<SysUser> findPageObjectsForDean(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize, @Param("username") String username);

    int validById(@Param("id") Integer id, @Param("valid") Integer valid);

    String findRoleByUsername(@Param("username") String username);
}
