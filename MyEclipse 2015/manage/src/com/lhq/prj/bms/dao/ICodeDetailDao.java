package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.CodeDetail;

/**
 * ICodeDetailtDao.java Create on 2013-6-11
 * 
 * ���黹���¼�־û��ӿ�
 * 
 * Copyright (c) 2013 by YQ.
 * 
 * @author �����
 * @version 1.0
 */
public interface ICodeDetailDao {

	public Object saveCodeDetail(CodeDetail codeDetail);

	public List findByPage(Page page);

	public int findByCount(Page page);

	public Integer update(CodeDetail codeDetail) throws Exception;

	public Integer deleteByJgdm(String jgdm);
	
	public int findByJgdm(CodeDetail codeDetail);
	
	/**
	 * 按码段，分页查找
	 */
	public List findByDmmdPage(Page page);

	public int findByDmmdCount(Page page);

	public CodeDetail createCode(CodeDetail codeDetail);
}
