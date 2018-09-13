package com.lhq.prj.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IOrgnewDao;
import com.lhq.prj.bms.po.Orgnew;

/**
 * OrgnewDao.java Create on 2012-5-12
 * 
 * 证书管理持久层实现
 * 
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public class OrgnewDao extends SqlMapClientDaoSupport implements IOrgnewDao {
	public Integer deleteById(Integer orgid) {
		return getSqlMapClientTemplate().delete("Orgnew.deleteById", orgid);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Orgnew.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Orgnew.findByPage", page);
	}

//	public Object saveOrgnew(Orgnew orgnew)  throws Exception {
//		return getSqlMapClientTemplate().insert("Orgnew.save", orgnew);
//	}
	
	public Object saveOrgnew(Orgnew orgnew) {
		Map<String, Comparable> m = new HashMap();
       //调用存储过程
		String newKey="";
		m.put("xzqhCode", orgnew.getBzjgdm());
		m.put("tableName","z_org_new");
		m.put("strKey","NC");
		m.put("strFlag",1);
	    m.put("key", "");
	
    	getSqlMapClientTemplate().queryForObject("Orgnew.MakeKeyProcedure",m);
    	//得到返回值 	
    	newKey=(String) m.get("key");
    	orgnew.setOrderid(newKey);
    	System.out.println("这是提交的更新：：：：：：：：：：：：：：：：：");
    	System.out.println(orgnew);
		return getSqlMapClientTemplate().insert("Orgnew.save", orgnew);
	}
	

	public Integer update(Orgnew orgnew) throws Exception {
		String newZslsh="";
		String newDybz=orgnew.getDybz();
		String strZslsh=orgnew.getZslsh();
		if(strZslsh==null || "".equals(strZslsh)){
			if(newDybz=="Y" || "Y".equals(newDybz)){
		    	Map zsh = new HashMap();
		    	zsh.put("xzqhCode", orgnew.getBzjgdm());
				zsh.put("tableName","printLsh");
				zsh.put("strKey","");
				zsh.put("strFlag",0);
				zsh.put("key", "");
				zsh.put("centerid", "420100");
			
		    	getSqlMapClientTemplate().queryForObject("Orgnew.MakeKeyProcedure",zsh);
				newZslsh=(String) zsh.get("key");
				orgnew.setZslsh(newZslsh.trim());
			}
		}
		return getSqlMapClientTemplate().update("Orgnew.update", orgnew);
	}
    
	
	public Orgnew findById(Integer orgid) {
		return (Orgnew) getSqlMapClientTemplate().queryForObject("Orgnew.findById",orgid);
	}
	
//	public List findUsernameOrgnew(String username){
//		//return (Orgnew) getSqlMapClientTemplate().queryForObject("Orgnew.findUsernameOrgnew",username);
//		 return  getSqlMapClientTemplate().queryForList("Orgnew.findUsernameOrgnew",username);
//	}
	
	public List findUsernameOrgnew(Page page){
		//return (Orgnew) getSqlMapClientTemplate().queryForObject("Orgnew.findUsernameOrgnew",username);
		 return  getSqlMapClientTemplate().queryForList("Orgnew.findUsernameOrgnew",page);
	}
	
	public List findOrgidOrgnew(Integer orgid){
		 return  getSqlMapClientTemplate().queryForList("Orgnew.findOrgidOrgnew",orgid);
	}
	
	public Integer saveImageOrgnew(Orgnew orgnew) throws Exception {
		return getSqlMapClientTemplate().update("Orgnew.saveImageOrgnew", orgnew);
	}
	
	
	public Orgnew findByIdViewImg(Integer orgid){
		 return (Orgnew) getSqlMapClientTemplate().queryForObject("Orgnew.findByIdViewImg",orgid);
	}

	public Orgnew checkUsernameByJgdm(String strJgdm) {
		// TODO Auto-generated method stub
		return (Orgnew)getSqlMapClientTemplate().queryForObject("Orgnew.checkUsernameByJgdm",strJgdm);
	}

	public List findJgdmOrgnew(Page page) {
		// TODO Auto-generated method stub
		return  getSqlMapClientTemplate().queryForList("Orgnew.findJgdmOrgnew",page);
	}

	public List findConditionsOrgnew(Page page) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Orgnew.findConditionsOrgnew",page);
	}

}
