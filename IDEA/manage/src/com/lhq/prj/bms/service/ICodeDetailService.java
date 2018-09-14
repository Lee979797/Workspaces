/*
 * @(#)ICodeDetailService.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.service;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.CodeDetail;

/**    
 * Create on 2008-10-11 ����07:08:18
 *
 * ͼ���������¼ҵ���ӿ�
 *
 * @author �����
 * @version  
 */
public interface ICodeDetailService {
	/**
	 * ��Ӽ�¼
	 * 
	 * @param codeDetail
	 * @return
	 * @throws Exception 
	 */
	Object saveCodeDetail(CodeDetail codeDetail) throws Exception;
	
	/**
	 * ��ҳ����
	 * @param page ��ҳ����
	 * @return
	 */
	Page findByPage(Page page);

	/**
	 * �޸ļ�¼��Ϣ
	 * 
	 * @param codeDetail
	 * @return
	 * @throws Exception
	 */
	boolean updateCodeDetail(CodeDetail codeDetail) throws Exception;

	/**
	 * ɾ���¼
	 * 
	 * @param logId
	 * @return
	 */
	boolean deleteCodeDetail(String jgdm);
	
	/**
	 * 按代码段分页查找
	 * @param page 分页对象
	 * @return
	 */
	Page findByDmmdPage(Page page);
	
	CodeDetail createCode(CodeDetail codeDetail);
}
 