package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ISysConfigDao;
import com.lhq.prj.bms.po.SysConfig;

/**
 * SysConfigDao.java Create on 2013-4-18 下午03:20:57
 * 
 * 系统参数设置 持久层
 * 
 * Copyright (c) 2013 by YQ.
 * 
 * @author yangqi
 * @version 1.0
 */
public class SysConfigDao extends SqlMapClientDaoSupport implements ISysConfigDao {

	public Integer deleteById(Integer pzjgid) {
		return getSqlMapClientTemplate().delete("SysConfig.deleteById", pzjgid);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("SysConfig.findAll");
	}
	
	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("SysConfig.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("SysConfig.findByPage", page);
	}
	
	public SysConfig findById(Integer configId) {
		return (SysConfig) getSqlMapClientTemplate().queryForObject("SysConfig.findById", configId);
	}
	
	public Object saveSysConfig(SysConfig pzjg) {
		return getSqlMapClientTemplate().insert("SysConfig.save", pzjg);
	}

	public Integer update(SysConfig sysConfig) throws Exception {
		return getSqlMapClientTemplate().update("SysConfig.update", sysConfig);
	}
	public String findMcByDm(String configCode) {
		return (String) getSqlMapClientTemplate().queryForObject("SysConfig.findMcByDm", configCode);
	}
}
