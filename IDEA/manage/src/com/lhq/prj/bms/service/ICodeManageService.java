package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.CodeManage;

/**    
 * ICodeManageService.java Create on 2008-9-16 ����10:38:57   
 *
 * 
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public interface ICodeManageService {
	/**
	 * ��Ӳ���
	 * @param codeManage
	 * @return
	 */
	Object saveCodeManage(CodeManage codeManage);

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
	 * @param codeManage
	 * @return
	 * @throws Exception 
	 */
	boolean updateCodeManage(CodeManage codeManage) throws Exception;

	/**
	 * ɾ����
	 * 
	 * @param codeManageId
	 * @return
	 */
	boolean deleteCodeManage(Integer codeManageId);

	/**
	 * ��ݹ�˾�������в���
	 *
	 * @param page
	 * @return
	 */
	Page findCodeManageByCenter(Page page);
}
 