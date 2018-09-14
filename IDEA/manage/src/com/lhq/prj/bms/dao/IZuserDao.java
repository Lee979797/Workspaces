package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.Zuser;

/**    
 * IZuserDao.java Create on 2012-5-5
 *
 * �û�����־ò�ӿ�
 *
 * Copyright (c) 2008 by YQ.
 * @author
 * @version 1.0  
 */
public interface IZuserDao {
	/**
	 * ����һ���û�ʵ�嵽��ݿ�
	 * 
	 * @param zuser
	 *            �û�ʵ��
	 * @return ����id
	 */
	public Object saveZuser(Zuser zuser);


	/**
	 * ��ҳ����
	 * 
	 * @param page
	 *            ����
	 * @return
	 */
	public List findByPage(Page page);

	/**
	 * ҳ���ҵ��ܼ�¼
	 * 
	 * @param page
	 *            ����
	 * @return
	 */
	public int findByCount(Page page);

	/**
	 * �޸��û���Ϣ
	 * 
	 * @param zuser
	 * @return
	 * @throws Exception
	 */
	public Integer update(Zuser zuser) throws Exception;

	/**
	 * ���idɾ���û�
	 * 
	 * @param zuserId
	 * @return
	 */
	public Integer deleteById(Integer userid);


	/**
	 * �û���¼����
	 * 
	 * @param zuser
	 * @return
	 */
	public Zuser zlogin(Zuser zuser);


	/**
	 * ����û�ʾ������û�
	 *
	 * @param zuser
	 * @return
	 */
	public List findByExample(Zuser zuser);
    
	public Object regZuser(Zuser zuser);
	
	/***
	 * 根据userid获得记录
	 *
	 * @param orgid
	 * @return
	 */
	public Zuser findById(Integer userid);

}
 