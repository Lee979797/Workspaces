package com.ninemax.sys.service.impl;

import com.ninemax.common.exception.ServiceException;
import com.ninemax.sys.dao.SysUserDao;
import com.ninemax.sys.entity.SysUser;
import com.ninemax.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    @Override
    public void login(String username, String password) {
        //0.参数合法性验证
        if (StringUtils.isEmpty(username))
            throw new ServiceException("用户名不能为空");
        if (StringUtils.isEmpty(password))
            throw new ServiceException("密码不能为空");
        //1.获取Subject(主体)对象
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        //3.执行身份认证
        try {
            subject.login(token);
            //此请求会提交给SecurityManager
            //SecurityManager会调用认证处理器Authenticator
            //认证处理器会去访问相关Realm对象获取认证信息
        } catch (AuthenticationException e) {
            e.printStackTrace();
            if ("Submitted".startsWith(e.getMessage().substring(0, 5))) {
                throw new ServiceException("密码错误");
            } else {
                throw new ServiceException(e.getMessage());
            }
        }
        //4.记录用户信息
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", username);
    }

    @Override
    public SysUser findUserByUserName(String username) {
        return sysUserDao.findUserByUserName(username);
    }
}
