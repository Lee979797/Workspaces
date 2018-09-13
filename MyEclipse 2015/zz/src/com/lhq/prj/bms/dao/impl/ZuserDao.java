package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IZuserDao;
import com.lhq.prj.bms.po.Zuser;

/**
 * ZuserDao.java Create on 2012-5-5 
 * 
 * 用户管理持久层实现
 * 
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public class ZuserDao extends SqlMapClientDaoSupport implements IZuserDao {

	public Integer deleteById(Integer userid) {
		return getSqlMapClientTemplate().delete("Zuser.deleteById", userid);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Zuser.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Zuser.findByPage", page);
	}

	public Object saveZuser(Zuser zuser) {
		return getSqlMapClientTemplate().insert("Zuser.save", zuser);
	}
 
   public Object regZuser(Zuser zuser) {
		return getSqlMapClientTemplate().insert("Zuser.save", zuser);
	}

	public Integer update(Zuser zuser) throws Exception {
		return getSqlMapClientTemplate().update("Zuser.update", zuser);
	}

	public Zuser zlogin(Zuser zuser) {
		return (Zuser) getSqlMapClientTemplate().queryForObject("Zuser.zlogin",zuser);
	}

	public List findByExample(Zuser zuser) {
		return getSqlMapClientTemplate().queryForList("Zuser.findByExample",zuser);
	}
	
	public Zuser findById(Integer userid) {
		return (Zuser) getSqlMapClientTemplate().queryForObject("Zuser.findById",userid);
	}
	
	public Zuser checkByUserName(Zuser zuser) {
		return (Zuser) getSqlMapClientTemplate().queryForObject("Zuser.checkByUserName",zuser);
	}
	
	public Integer checkByJgmc(String jgmc) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Zuser.checkZuserJgmc",jgmc);
	}

	public List findUserInfo(Zuser zuser) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Zuser.findUserInfo",zuser);
	}

	public boolean updatePwd(String userPwdOld, Zuser zuser) {
		// TODO Auto-generated method stub
		String pwd = (String) getSqlMapClientTemplate().queryForObject("Zuser.findUserPwdOld",zuser);
		if(!pwd.equals(userPwdOld)){
			return false;
		}
		int a = getSqlMapClientTemplate().update("Zuser.updatePwd", zuser);
		return true;
	}

	public String findJgdmByUserid(int userid) {
		// TODO Auto-generated method stub
		return (String)getSqlMapClientTemplate().queryForObject("Zuser.findJgdmByUserid", userid);
	}

	public Integer updateByUserName(Zuser zuser) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("Zuser.updateByUserName", zuser);
	}

}
