package com.lhq.prj.bms.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.dao.ILeafHelpDao;
import com.lhq.prj.bms.po.LeafHelp;

public class LeafHelpDao extends SqlMapClientDaoSupport implements ILeafHelpDao {

	@Override
	public int findByLeafId(String leafId) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("LeafHelp.findByLeafId", leafId);
	}

	@Override
	public Object save(LeafHelp lh) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().insert("LeafHelp.save", lh);
	}

	@Override
	public Integer update(LeafHelp lh) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("LeafHelp.update", lh);
	}

}
