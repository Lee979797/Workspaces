package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.PrintLog;

/**
 * IDeptDao.java Create on 2008-9-16 ����10:41:23
 * 
 * ���黹���¼�־û��ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface IPrintLogDao {
	/**
	 * ����һ���軹��ʵ�嵽��ݿ�
	 * 
	 * @param printlog  �軹��ʵ��
	 * @return ����id
	 */
	public Object savePrintLog(PrintLog printlog,String bzjgdm);


	/**
	 * ��ҳ����
	 * 
	 * @param page ����
	 * @return
	 */
	public List findByPage(Page page);

	/**
	 * ��ҳ���ҵ��ܼ�¼
	 * 
	 * @param page ����
	 * @return �ܼ�¼
	 */
	public int findByCount(Page page);

	/**
	 * �޸Ľ軹��Ϣ
	 * 
	 * @param printlog
	 * @return �޸ĵļ�¼��
	 * @throws Exception
	 */
	public Integer update(PrintLog printlog) throws Exception;

	/**
	 * ���idɾ���¼
	 * 
	 * @param logId
	 * @return ɾ��ļ�¼��
	 */
	public Integer deleteById(Integer logId);
	
	public PrintLog findById(Integer logId);

}
