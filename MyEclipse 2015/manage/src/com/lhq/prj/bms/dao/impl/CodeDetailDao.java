/*
 * @(#)CodeDetailDao.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ICodeDetailDao;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.CodeDetail;

/**
 * Create on 2008-10-11 ����06:58:31
 * 
 * �軹��־ò�ʵ����
 * 
 * @author �����
 * @version
 */
public class CodeDetailDao extends SqlMapClientDaoSupport implements ICodeDetailDao {

	public Integer deleteByJgdm(String jgdm) {
		return getSqlMapClientTemplate().delete("CodeDetail.deleteByJgdm", jgdm);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("CodeDetail.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("CodeDetail.findByPage", page);
	}

	public Object saveCodeDetail(CodeDetail codeDetail) {
		return getSqlMapClientTemplate().insert("CodeDetail.save", codeDetail);
	}

	public Integer update(CodeDetail codeDetail) throws Exception {
		return getSqlMapClientTemplate().update("CodeDetail.update", codeDetail);
	}
	
	public int findByJgdm(CodeDetail codeDetail) {
		return (Integer) getSqlMapClientTemplate().queryForObject("CodeDetail.findByJgdm",codeDetail);
	}
	
	public int findByDmmdCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("CodeDetail.findByDmmdCount", page);
	}

	public List findByDmmdPage(Page page) {
		return getSqlMapClientTemplate().queryForList("CodeDetail.findByDmmdPage", page);
	}
	
	public CodeDetail createCode(CodeDetail codeDetail) {
		//调用存储过程
		Map n = new HashMap();
		n.put("jgmc",codeDetail.getJgmc());
		n.put("zch",codeDetail.getZch());
		n.put("dmlx",codeDetail.getDmlx());
	    n.put("bzjgdm",codeDetail.getBzjgdm());
	    n.put("fumaUsername",codeDetail.getFumaName());
	    n.put("fumaName", codeDetail.getFumaName());
	    n.put("isFuma", "0");
	    n.put("code", "");
	    n.put("flag", "");
    	getSqlMapClientTemplate().queryForObject("CodeDetail.CreateCodeProcedure",n);
    	//得到返回值 	
    	codeDetail.setJgdm((String) n.get("code"));
    	codeDetail.setFlag((String) n.get("flag"));
	    	
		return codeDetail;
	}
}
