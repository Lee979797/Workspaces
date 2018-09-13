package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IZsscDao;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Zssc;

/**
 * ZsscDao.java Create on 2008-9-16 ����10:43:05
 * 
 * ���ų־ò�ʵ��
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class ZsscDao extends SqlMapClientDaoSupport implements IZsscDao {

	public Integer deleteById(Integer zsscId) {
		return getSqlMapClientTemplate().delete("Zssc.deleteById", zsscId);
	}

	public List findAll() {
		return getSqlMapClientTemplate().queryForList("Zssc.findAll");
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Zssc.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Zssc.findByPage", page);
	}

	public Object saveZssc(Zssc zssc) {
		return getSqlMapClientTemplate().insert("Zssc.save", zssc);
	}

	public Integer update(Zssc zssc) throws Exception {
		return getSqlMapClientTemplate().update("Zssc.update", zssc);
	}

	public List findZsscByCenter(Center center) {
		return getSqlMapClientTemplate().queryForList("Zssc.findZsscByCenter",center);
	}

}
