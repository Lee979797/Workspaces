package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IUserDao;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.po.Zuser;

/**
 * UserDao.java Create on 2008-9-19 ����01:44:58
 * <p>
 * �û�����־ò�ʵ��
 * <p>
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0
 */
public class UserDao extends SqlMapClientDaoSupport implements IUserDao {

    public Integer deleteById(Integer userId) {
        return getSqlMapClientTemplate().delete("User.deleteById", userId);
    }

    public int findByCount(Page page) {
        return (Integer) getSqlMapClientTemplate().queryForObject("User.findByCount", page);
    }

    public List findByPage(Page page) {
        return getSqlMapClientTemplate().queryForList("User.findByPage", page);
    }

    public Object saveUser(User user) {
        return getSqlMapClientTemplate().insert("User.save", user);
    }

    public Object regUser(User user) {
        return getSqlMapClientTemplate().insert("User.reg", user);
    }

    public Integer update(User user) throws Exception {
        return getSqlMapClientTemplate().update("User.update", user);
    }

    public Integer updateSet(User user) throws Exception {
        return getSqlMapClientTemplate().update("User.updateSet", user);
    }

    public User login(User user) {
        return (User) getSqlMapClientTemplate().queryForObject("User.login", user);
    }

    public boolean updatePwd(String userPwdOld, User user) {
        String pwd = (String) getSqlMapClientTemplate().queryForObject("User.findUserPwdOld", user);
        if (!pwd.equals(userPwdOld)) {
            return false;
        }
        int a = getSqlMapClientTemplate().update("User.updatePwd", user);
        return true;
    }

    public List findByExample(User user) {
        return getSqlMapClientTemplate().queryForList("User.findByExample", user);
    }

}
