package com.ninemax.sys.service.realm;

import com.ninemax.sys.dao.SysUserDao;
import com.ninemax.sys.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class ShiroUserRealm extends AuthorizingRealm {
    @Resource
    private SysUserDao sysUserDao;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        System.out.println("==doGetAuthenticationInfo==");
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //2. 从 UsernamePasswordToken 中来获取 username
        String username = upToken.getUsername();
        //判断用户名是否存在，若存在，返回user对象
        SysUser user = sysUserDao.findUserByUserName(username);
        if (user == null)
            throw new AuthenticationException("此用户不存在");
        //盐值.
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        //自动完成密码比对   - 密码的比对:
        //通过 AuthenticatingRealm 的 credentialsMatcher 属性来进行的密码的比对!
        return new SimpleAuthenticationInfo(username, user.getPassword(), credentialsSalt, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}

