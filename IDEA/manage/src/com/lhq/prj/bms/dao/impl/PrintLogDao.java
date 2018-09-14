/*
 * @(#)PrintLogDao.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IPrintLogDao;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.PrintLog;

/**
 * Create on 2008-10-11 ����06:58:31
 * 
 * �軹��־ò�ʵ����
 * 
 * @author �����
 * @version
 */
public class PrintLogDao extends SqlMapClientDaoSupport implements IPrintLogDao {

	public Integer deleteById(Integer logId) {
		return getSqlMapClientTemplate().delete("PrintLog.deleteById", logId);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("PrintLog.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("PrintLog.findByPage", page);
	}

	public Object savePrintLog(PrintLog printlog,String bzjgdm) {
		Map n = new HashMap();
		String newKey="";
		n.put("xzqhCode", bzjgdm);
		n.put("tableName","printLog");
		n.put("strKey","");
		n.put("strFlag",0);
	    n.put("key", "");
	
    	getSqlMapClientTemplate().queryForObject("PrintLog.MakeKeyProcedure",n);
    	//得到返回值 	
    	newKey=(String) n.get("key");
    	newKey=printlog.getCenterId()+"-"+newKey;
    	printlog.setPrintCode(newKey);
    	
		return getSqlMapClientTemplate().insert("PrintLog.save", printlog);
	}

	public Integer update(PrintLog printlog) throws Exception {
		return getSqlMapClientTemplate().update("PrintLog.update", printlog);
	}
	
	public PrintLog findById(Integer logId) {
		return (PrintLog) getSqlMapClientTemplate().queryForObject("PrintLog.findById",logId);
	}

}
