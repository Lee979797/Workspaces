package com.lhq.prj.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IOrgDao;
import com.lhq.prj.bms.po.Org;

/**
 * OrgDao.java Create on 2012-5-12
 * 
 * 证书管理持久层实现
 * 
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public class OrgDao extends SqlMapClientDaoSupport implements IOrgDao {
	public Integer deleteById(Integer orgid) {
		return getSqlMapClientTemplate().delete("Org.deleteById", orgid);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Org.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Org.findByPage", page);
	}

	public Object saveOrg(Org org)  throws Exception {
		return getSqlMapClientTemplate().insert("Org.save", org);
	}

	public Integer update(Org org) throws Exception {
		String strOrdrid=org.getOrderid();
		if(strOrdrid=="" || "".equals(strOrdrid)){
			Map m = new HashMap();
	       //调用存储过程
			String newKey="";
			m.put("tableName","z_org_new");
			m.put("flag","NC");
		    m.put("key", "");
		
	    	getSqlMapClientTemplate().queryForObject("Org.MakeKeyProcedure",m);
	    	//得到返回值 	
	    	newKey=(String) m.get("key");
	    	org.setOrderid(newKey);
		}
		return getSqlMapClientTemplate().update("Org.update", org);
	}
    
	
	public Org findById(Integer orgid) {
		return (Org) getSqlMapClientTemplate().queryForObject("Org.findById",orgid);
	}
	
//	public List findUsernameOrg(String username){
//		//return (Org) getSqlMapClientTemplate().queryForObject("Org.findUsernameOrg",username);
//		 return  getSqlMapClientTemplate().queryForList("Org.findUsernameOrg",username);
//	}
	
	public List findUsernameOrg(Page page){
		//return (Org) getSqlMapClientTemplate().queryForObject("Org.findUsernameOrg",username);
		 return  getSqlMapClientTemplate().queryForList("Org.findUsernameOrg",page);
	}
	
	public List findOrgidOrg(Integer orgid){
		 return  getSqlMapClientTemplate().queryForList("Org.findOrgidOrg",orgid);
	}
	
	public Integer saveImageOrg(Org org) throws Exception {
		return getSqlMapClientTemplate().update("Org.saveImageOrg", org);
	}
	
	
	public List findByIdViewImg(Page page){
		 return  getSqlMapClientTemplate().queryForList("Org.findByIdViewImg",page);
	}
	
	
}
