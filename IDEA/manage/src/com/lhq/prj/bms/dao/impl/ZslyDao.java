/*
 * @(#)ZslyDao.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IZslyDao;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.Zsly;

/**
 * Create on 2008-10-11 ����06:58:31
 * 
 * �軹��־ò�ʵ����
 * 
 * @author �����
 * @version
 */
public class ZslyDao extends SqlMapClientDaoSupport implements IZslyDao {

	public Integer deleteById(Integer logId) {
		return getSqlMapClientTemplate().delete("Zsly.deleteById", logId);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Zsly.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Zsly.findByPage", page);
	}

	public Object saveZsly(Zsly zsly) {
		return getSqlMapClientTemplate().insert("Zsly.save", zsly);
	}

	public Integer update(Zsly zsly) throws Exception {
		return getSqlMapClientTemplate().update("Zsly.update", zsly);
	}
	
	public int findByZsbh(Zsly zsly) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Zsly.findByZsbh",zsly);
	}
}
