package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.CodeManage;

/**
 * ICodeManageDao.java Create on 2008-9-16 ����10:41:23
 * 
 * ���Ź���־ò�ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface ICodeManageDao {
	/**
	 * ����һ������ʵ�嵽��ݿ�
	 * 
	 * @param codeDetail
	 *            ����ʵ��
	 * @return ����id
	 */
	public Object saveCodeManage(CodeManage codeDetail);

	/**
	 * �������в���
	 * 
	 * @return
	 */
	public List findAll();

	/**
	 * ��ҳ����
	 * 
	 * @param page
	 *            ����
	 * @return
	 */
	public List findByPage(Page page);

	/**
	 * ��ҳ���ҵ��ܼ�¼
	 * 
	 * @param page
	 *            ����
	 * @return
	 */
	public int findByCount(Page page);

	/**
	 * �޸Ĳ�����Ϣ
	 * 
	 * @param codeDetail
	 * @return
	 * @throws Exception
	 */
	public Integer update(CodeManage codeDetail) throws Exception;

	/**
	 * ���idɾ����
	 * 
	 * @param codeDetailId
	 * @return
	 */
	public Integer deleteById(Integer codeDetailId);

	/**
	 * ��ݷֹ�˾�Ҳ���
	 *
	 * @param center
	 * @return
	 */
	public List findCodeManageByCenter(Center center);
}
