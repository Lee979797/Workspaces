package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IKeyLogDao;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.KeyLog;

/**
 * KeyLogDao.java Create on 2008-9-16 ����10:43:05
 * 
 * ���ų־ò�ʵ��
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class KeyLogDao extends SqlMapClientDaoSupport implements IKeyLogDao {

	public Integer deleteById(Integer logId) {
		return getSqlMapClientTemplate().delete("KeyLog.deleteById", logId);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("KeyLog.findAll");
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("KeyLog.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("KeyLog.findByPage", page);
	}

	public Object saveKeyLog(KeyLog keyLog) {
		return getSqlMapClientTemplate().insert("KeyLog.save", keyLog);
	}

	public Integer update(KeyLog keyLog) throws Exception {
		return getSqlMapClientTemplate().update("KeyLog.update", keyLog);
	}

	public List findKeyLogByCenter(Center center) {
		return getSqlMapClientTemplate().queryForList("KeyLog.findKeyLogByCenter",center);
	}

}
