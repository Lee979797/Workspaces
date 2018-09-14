package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IZgbmDao;

public class ZgbmDao extends SqlMapClientDaoSupport implements IZgbmDao {

	public List findAll() {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Zgbm.findAll");
	}

	public List findByPage(Page page) {
		// TODO Auto-generated method stub
		List l = getSqlMapClientTemplate().queryForList("Zgbm.findByPage", page);
		System.out.println(page.getStart());
		System.out.println("第零项： "+l.get(0).toString());
		//return getSqlMapClientTemplate().queryForList("Zgbm.findByPage", page);
		return l;
	}

	public int findByCount(Page page) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("Zgbm.findByCount", page);
	}
	
	public String findMcByDm(String code) {
		return (String) getSqlMapClientTemplate().queryForObject("Zgbm.findMcByDm", code);
	}

}
