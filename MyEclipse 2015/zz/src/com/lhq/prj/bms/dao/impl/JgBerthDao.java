package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IJgBerthDao;
import com.lhq.prj.bms.po.JgBerth;

public class JgBerthDao extends SqlMapClientDaoSupport implements IJgBerthDao {

	public List findByPage(Page page) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("JgBerth.findByPage", page);
	}

	public int findByCount(Page page) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("JgBerth.findByCount", page);
	}

	public Object saveJgBerth(JgBerth jb){
		return getSqlMapClientTemplate().insert("JgBerth.save", jb);
	}

	public int updateJgBerth(JgBerth jb) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().update("JgBerth.update", jb);
	}
	
	public JgBerth findJgBerthByJgmc(JgBerth jb){
		return (JgBerth) getSqlMapClientTemplate().queryForObject("JgBerth.findJgBerthByJgmc", jb);
	}

	public int delJgBerth(JgBerth jb) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().delete("JgBerth.deleteByJgid", jb);
	}
}
