package com.lhq.prj.bms.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IPrintSetDao;
import com.lhq.prj.bms.po.PrintSet;

public class PrintSetDao extends SqlMapClientDaoSupport implements IPrintSetDao {

	public PrintSet findCardPrintSet(String username) {
		// TODO Auto-generated method stub
		
		return (PrintSet)getSqlMapClientTemplate().queryForObject("PrintSet.findByCondition", username);
	}

	public boolean saveCardPrintSet(String username, PrintSet printset) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int userid = (Integer)getSqlMapClientTemplate().queryForObject("User.finduserIdByuserName", username);
		printset.setUserid(userid);
		if(getSqlMapClientTemplate().queryForObject("PrintSet.findByCondition", username)==null){
			getSqlMapClientTemplate().insert("PrintSet.save", printset);
			flag = true;
		}else{
			getSqlMapClientTemplate().update("PrintSet.update", printset);
			flag = true;
		}
		
		return flag;
	}

}
