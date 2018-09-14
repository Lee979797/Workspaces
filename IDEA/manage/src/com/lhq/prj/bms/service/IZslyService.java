/*
 * @(#)IZslyService.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.service;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Zsly;

/**    
 * Create on 2008-10-11 ����07:08:18
 *
 * ͼ���������¼ҵ���ӿ�
 *
 * @author �����
 * @version  
 */
public interface IZslyService {
	/**
	 * ��Ӽ�¼
	 * 
	 * @param zsly
	 * @return
	 * @throws Exception 
	 */
	Object saveZsly(Zsly zsly) throws Exception;
	
	/**
	 * ��ҳ����
	 * @param page ��ҳ����
	 * @return
	 */
	Page findByPage(Page page);

	/**
	 * �޸ļ�¼��Ϣ
	 * 
	 * @param zsly
	 * @return
	 * @throws Exception
	 */
	boolean updateZsly(Zsly zsly) throws Exception;

	/**
	 * ɾ���¼
	 * 
	 * @param logId
	 * @return
	 */
	boolean deleteZsly(Integer logId);

}
 