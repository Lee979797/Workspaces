/*
 * @(#)IPrintLogService.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.service;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.PrintLog;

/**    
 * Create on 2008-10-11 ����07:08:18
 *
 * ͼ���������¼ҵ���ӿ�
 *
 * @author �����
 * @version  
 */
public interface IPrintLogService {
	/**
	 * ��Ӽ�¼
	 * 
	 * @param printlog
	 * @return
	 * @throws Exception 
	 */
	Object savePrintLog(PrintLog printlog,String bzjgdm) throws Exception;
	
	/**
	 * ��ҳ����
	 * @param page ��ҳ����
	 * @return
	 */
	Page findByPage(Page page);

	/**
	 * �޸ļ�¼��Ϣ
	 * 
	 * @param printlog
	 * @return
	 * @throws Exception
	 */
	boolean updatePrintLog(PrintLog printlog) throws Exception;

	/**
	 * ɾ���¼
	 * 
	 * @param logId
	 * @return
	 */
	boolean deletePrintLog(Integer logId);

}
 