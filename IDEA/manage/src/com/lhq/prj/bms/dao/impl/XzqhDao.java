package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IXzqhDao;
import com.lhq.prj.bms.po.Xzqh;

/**
 * XzqhDao.java Create on 2008-9-18 下午08:20:57
 * 
 * 职务管理持久层
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author 廖瀚卿
 * @version 1.0
 */
public class XzqhDao extends SqlMapClientDaoSupport implements IXzqhDao {

	public Integer deleteById(Integer xzqhId) {
		return getSqlMapClientTemplate().delete("Xzqh.deleteById", xzqhId);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("Xzqh.findAll");
	}
	
	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Xzqh.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Xzqh.findByPage", page);
	}

	public Object saveXzqh(Xzqh xzqh) {
		return getSqlMapClientTemplate().insert("Xzqh.save", xzqh);
	}

	public Integer update(Xzqh xzqh) throws Exception {
		return getSqlMapClientTemplate().update("Xzqh.update", xzqh);
	}
	
	public String findXzqhNameByXzqhCode(String xzqhCode) {
		return (String) getSqlMapClientTemplate().queryForObject("Xzqh.findXzqhNameByXzqhCode", xzqhCode);
	}

}
