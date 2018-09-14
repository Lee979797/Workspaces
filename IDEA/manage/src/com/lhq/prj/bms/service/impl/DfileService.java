package com.lhq.prj.bms.service.impl;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.Page;

import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.User;

import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.dao.IZuserDao;

import com.lhq.prj.bms.po.Dfile;
import com.lhq.prj.bms.dao.IDfileDao;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.po.Bzjg;
import com.lhq.prj.bms.dao.IBzjgDao;

import com.lhq.prj.bms.service.IDfileService;


/**
 * DfileService.java Create on 2012-5-12
 * 
 * 机构档案业务层
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public class DfileService implements IDfileService {

	private IDfileDao dfileDao;

	private IZuserDao zuserDao;
	
	private IBzjgDao bzjgDao;
	
	private ITjgdmDao tjgdmDao;

	public void setZuserDao(IZuserDao zuserDao) {
		this.zuserDao = zuserDao;
	}

	public void setDfileDao(IDfileDao dfileDao) {
		this.dfileDao = dfileDao;
	}

	public void setBzjgDao(IBzjgDao bzjgDao) {
		this.bzjgDao = bzjgDao;
	}
	
	public void setTjgdmDao(ITjgdmDao tjgdmDao) {
		this.tjgdmDao = tjgdmDao;
	}
	
	public Page findDfileByPage(Page page) {
		page.setRoot(dfileDao.findDfileByPage(page));
		page.setTotalProperty(dfileDao.findDfileByCount(page));
		return page;
	}
	
	public Page findDfileByGjPage(Page page) {
		page.setRoot(dfileDao.findDfileByGjPage(page));
		page.setTotalProperty(dfileDao.findDfileByGjCount(page));
		return page;
	}
	
	public Page findArchiveByPage(Page page) {
		page.setRoot(dfileDao.findArchiveByPage(page));
		page.setTotalProperty(dfileDao.findArchiveByCount(page));
		return page;
	}
	
	public Page findArchiveByGjPage(Page page) {
		page.setRoot(dfileDao.findArchiveByGjPage(page));
		page.setTotalProperty(dfileDao.findArchiveByGjCount(page));
		return page;
	}
	
	public Page findAllByPage(Page page) {
		page.setRoot(dfileDao.findAllByPage(page));
		page.setTotalProperty(dfileDao.findAllByCount(page));
		return page;
	}
	
	public Page findAllByGjPage(Page page) {
		page.setRoot(dfileDao.findAllByGjPage(page));
		page.setTotalProperty(dfileDao.findAllByGjCount(page));
		return page;
	}
	
	public Page findAllByZuhePage(Page page) {
		page.setRoot(dfileDao.findAllByZuhePage(page));
		page.setTotalProperty(dfileDao.findAllByZuheCount(page));
		return page;
	}
	
	
	/**
	 * 保存--归档临时数据，新增数据
	 * @param dfile
	 * @return
	 */
	public Object saveDfile(Dfile dfile) {
		return dfileDao.saveDfile(dfile);
	}
	
	/**
	 * 保存--正式数据，新增数据
	 * @param dfile
	 * @return
	 */
	public Object saveArchive(Dfile dfile) {
		return dfileDao.saveArchive(dfile);
	}
	
	/**
	 * 根据orgid修改--临时库，数据审核修改
	 * @param dfile
	 * @return
	 */
	public boolean updateDfile(Dfile dfile) throws Exception {
		Integer flag = dfileDao.update(dfile);
		if (null != flag) {
			return true;
		}
		return false;
	}
	
	/**
	 * 根据docid修改--临时库，数据清整
	 * @param dfile
	 * @return
	 */
	public boolean updateDfileByDocid(Dfile dfile) throws Exception {
		Integer flag = dfileDao.updateDfileByDocid(dfile);
		if (null != flag) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 根据docid修改--档案库，数据清整
	 * @param dfile
	 * @return
	 */
	public boolean updateArchiveByDocid(Dfile dfile) throws Exception {
		Integer flag = dfileDao.updateArchiveByDocid(dfile);
		if (null != flag) {
			return true;
		}
		return false;
	}
	/**
	 * 删除--审核入正式库时,设置t_jgdm表可上传数据
	 * @param dfile
	 * @return
	 */
	public boolean deleteDfile(String rootPath, Integer orgid) {

			Dfile dfile = dfileDao.findByDfileId(orgid);
			String strYwlx=dfile.getYwlx();
			if(dfile!=null){
				Tjgdm tjgdm = new Tjgdm();
				tjgdm.setJgdm(dfile.getJgdm());
				//YWLX为预赋码的不用上报数据
				if(strYwlx=="预赋码" || "预赋码".equals(strYwlx)){
					tjgdm.setUp_Dflag(1);
				}else{
					tjgdm.setUp_Dflag(0);
				}
				Integer newOrgid2=null;
				if(tjgdm!=null){
					try {
						newOrgid2 = tjgdmDao.update(tjgdm);
						if(newOrgid2!=null){
							Integer flag = dfileDao.deleteById(orgid);
							if (null != flag) {
								return true;
							}else{
								return false;
							}
						}else{
							return false;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		return true;
	}

	
	
	public Dfile dfileViewImg(Integer orgid){
		return dfileDao.findByIdViewImg(orgid);
	}

	public Dfile archiveViewImg(Integer orgid){
		return dfileDao.findByArchiveIdViewImg(orgid);
	}
	
	public boolean saveImageDfile(Dfile dfile) throws Exception {
		Integer flag = dfileDao.update(dfile);
		if (null != flag) {
			return true;
		}
		return false;
		/*
		String s1=dfile.getImageData();
		String packindex=dfile.getPackindex();
		String pageTypeStr=dfile.getPageTypeStr();
		Integer orgid=dfile.getOrgid();
		String s2="";
		
  		Dfile dfile2 = new Dfile();
		dfile2 = dfileDao.findByDfileId(orgid);
		if(packindex=="0" || "0".equals(packindex)){
			//System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			s2=s1;
		}else{
  			//System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			if(dfile2.getImageData()=="" || "".equals(dfile2.getImageData())){
				s2=s1;
			}else{
				s2=dfile2.getImageData()+s1;
			}
			
		}

		dfile2.setOrgid(orgid);		
		dfile2.setPageTypeStr(pageTypeStr);		
		dfile2.setImageUrl(packindex);
		dfile2.setImageData(s2);
		Integer flag = dfileDao.update(dfile2);
		System.out.println(pageTypeStr);
		if (null != flag) {
			return true;
		}
		return false;
	*/}

	public Dfile findByDfileId(Integer orgid){
		return dfileDao.findByDfileId(orgid);
	}
	
	public Dfile findByArchiveId(Integer orgid){
		return dfileDao.findByArchiveId(orgid);
	}
	
	public Dfile findArchiveByDocid(String docid){
		return dfileDao.findArchiveByDocid(docid);
	}

	@Override
	public int findDfileCount(Page page) {
		// TODO Auto-generated method stub
		
		return dfileDao.findDfileByCount(page);
	}

	@Override
	public Page findDfileByQxPage(Page page) {
		// TODO Auto-generated method stub
		page.setRoot(dfileDao.findDfileByQxPage(page));
		page.setTotalProperty(dfileDao.findDfileByQxCount(page));
		return page;
	}
	
}
