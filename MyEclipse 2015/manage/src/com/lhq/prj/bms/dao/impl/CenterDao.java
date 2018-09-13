package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ICenterDao;
import com.lhq.prj.bms.po.Center;

/**
 * DeptDao.java Create on 2008-9-16 ����10:43:05
 * 
 * �ֹ�˾�־ò�ʵ��
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class CenterDao extends SqlMapClientDaoSupport implements ICenterDao {

	public Object saveCenter(Center center) {
		return getSqlMapClientTemplate().insert("Center.save", center);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("Center.findAll");
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Center.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Center.findByPage", page);
	}

	public Integer update(Center center) throws Exception {
		return getSqlMapClientTemplate().update("Center.update", center);
	}

	public Integer deleteById(Integer centerId) {
		return getSqlMapClientTemplate().delete("Center.deleteById", centerId);
	}

}
