package com.lhq.prj.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
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

	public List findByCountList(Page page) {
		return getSqlMapClientTemplate().queryForList("Orgnew.findByCountList", page);
	}
	
	public List verifyFieldByJgdm(String jgdm) {
		return getSqlMapClientTemplate().queryForList("Orgnew.verifyFieldByJgdm", jgdm);
	}
	
	public List findByPage(Page page) {
		System.out.println("//////////////"+page);
		return getSqlMapClientTemplate().queryForList("Orgnew.findByPage", page);
	}

	public int findShenheXcByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Orgnew.findShenheXcByCount", page);
	}

	public List findShenheXcByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Orgnew.findShenheXcByPage", page);
	}
	
	
	public int findShenheNetByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Orgnew.findShenheNetByCount", page);
	}

	public List findShenheNetByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Orgnew.findShenheNetByPage", page);
	}
	
	
	public Object saveOrgnew(Orgnew orgnew) {
		
//根据业务类型生成证书流水号		
//		String newZslsh="";
//		String ywlx=orgnew.getYwlx();
//	    if(ywlx=="新办" || "新办".equals(ywlx)|| ywlx=="换证" || "换证".equals(ywlx) || ywlx=="变更" || "变更".equals(ywlx) || ywlx=="补证"  || "补证".equals(ywlx)|| ywlx=="迁入"  || "迁入".equals(ywlx)){
//	    	Map zsh = new HashMap();
//			zsh.put("tableName","printLsh");
//			zsh.put("strKey","");
//			zsh.put("strFlag",0);
//			zsh.put("key", "");
//		
//	    	getSqlMapClientTemplate().queryForObject("PrintLog.MakeKeyProcedure",zsh);
//			newZslsh=(String) zsh.get("key");
//			orgnew.setZslsh(newZslsh.trim());
//		}
		
	    Map m = new HashMap();
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
		return getSqlMapClientTemplate().insert("Orgnew.save", orgnew);
	}

	public Integer update(Orgnew orgnew) throws Exception {
		//根据流水号是否为空，且是否需要打印，来决定是否生成流水号
		String newZslsh="";
		String newDybz=orgnew.getDybz();
		String strZslsh=orgnew.getZslsh();
		String strYwlx = orgnew.getYwlx();
		System.out.println("班长机构代码：：："+orgnew.getBzjgdm());
		if(strZslsh==null || "".equals(strZslsh)){
			if(newDybz=="Y" || "Y".equals(newDybz)){
		    	Map zsh = new HashMap();
		    	zsh.put("xzqhCode", orgnew.getBzjgdm());
				zsh.put("tableName","printLsh");
				zsh.put("strKey","");
				zsh.put("strFlag",0);
				zsh.put("key", "");
			
		    	getSqlMapClientTemplate().queryForObject("PrintLog.MakeKeyProcedure",zsh);
				newZslsh=(String) zsh.get("key");
				orgnew.setZslsh(newZslsh.trim());
			}
		}
	    return getSqlMapClientTemplate().update("Orgnew.update", orgnew);
	}
	
	public Orgnew findById(Integer orgid) {
		return (Orgnew) getSqlMapClientTemplate().queryForObject("Orgnew.findById",orgid);
	}
	
	public Orgnew findByIdViewImg(Integer orgid){
		 return (Orgnew) getSqlMapClientTemplate().queryForObject("Orgnew.findByIdViewImg",orgid);
	}
	
	public List findOrgnewByOrgid(Integer orgid){
		 return  getSqlMapClientTemplate().queryForList("Orgnew.findOrgnewByOrgid",orgid);
	}
	
	public Orgnew findByOrgnewJgdm(String jgdm) {
		return (Orgnew) getSqlMapClientTemplate().queryForObject("Orgnew.findByOrgnewJgdm",jgdm);
	}

	@Override
	public Integer updateDybzByOrgid(Orgnew orgnew) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("Orgnew.update", orgnew);
	}

	@Override
	public List findShenheNetByPageCenterid(Page page) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Orgnew.findShenheNetByPageCenterid", page);
	}

	@Override
	public int findShenheNetByCountCenterid(Page page) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("Orgnew.findShenheNetByCountCenterid", page);
	}

	@Override
	public String findByOrgnew(Orgnew orgnew) {
		// TODO Auto-generated method stub
		return (String) getSqlMapClientTemplate().queryForObject("Orgnew.findByOrgnew", orgnew);
	}

	@Override
	public List findAllExcpOrgnew(Page page) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Orgnew.findAllOrgnew", page);
	}

	@Override
	public int findAllExcpOrgnewCount(Page page) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("Orgnew.findAllOrgnewCount", page);
	}

	@Override
	public Integer updateExceptionOrgnew(Orgnew orgnew) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("Orgnew.update", orgnew);
	}

	@Override
	public List findByQxPage(Page page) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Orgnew.findByQxPage", page);
	}

	@Override
	public int findByQxCount(Page page) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("Orgnew.findByQxCount", page);
	}

	@Override
	public List findByYwqxPage(Page page) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Orgnew.findByYwqxPage", page);
	}

	@Override
	public int findByYwqxCount(Page page) {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("Orgnew.findByYwqxCount", page);
	}

	@Override
	public List validateJgmc(Orgnew orgnew) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Orgnew.validateJgmc", orgnew);
	}

}
