package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.KeyLog;

/**    
 * IKeyLogService.java Create on 2008-9-16 ����10:38:57   
 *
 * 
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public interface IKeyLogService {
	/**
	 * ��Ӳ���
	 * @param keyLog
	 * @return
	 */
	Object saveKeyLog(KeyLog keyLog);

	/**
	 * �������в���
	 * @return
	 */
	List findAll();

	/**
	 * ��ҳ����
	 * @param page ��ҳ����
	 * @return
	 */
	Page findByPage(Page page);

	/**
	 * �޸Ĳ�����Ϣ
	 * @param keyLog
	 * @return
	 * @throws Exception 
	 */
	boolean updateKeyLog(KeyLog keyLog) throws Exception;

	/**
	 * ɾ����
	 * 
	 * @param keyLogId
	 * @return
	 */
	boolean deleteKeyLog(Integer keyLogId);

	/**
	 * ��ݹ�˾�������в���
	 *
	 * @param page
	 * @return
	 */
	Page findKeyLogByCenter(Page page);
}
 