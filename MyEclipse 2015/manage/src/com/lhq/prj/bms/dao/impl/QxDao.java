package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.dao.IQxDao;
import com.lhq.prj.bms.po.Qx;

public class QxDao extends SqlMapClientDaoSupport implements IQxDao {

	public void deleteByBzjgCode(Qx qx) {
		getSqlMapClientTemplate().delete("Qx.deleteByBzjgCode", qx);
	}

	public int saveQxSet(Qx qx) {
		return (Integer)getSqlMapClientTemplate().insert("Qx.save", qx);
	}

	public List findByBzjgCode(Qx qx) {
		return getSqlMapClientTemplate().queryForList("Qx.findByBzjgCode", qx);
	}
}
