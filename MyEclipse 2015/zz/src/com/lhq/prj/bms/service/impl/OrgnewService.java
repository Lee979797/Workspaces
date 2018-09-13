package com.lhq.prj.bms.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ILoanLogDao;
import com.lhq.prj.bms.dao.IOrgnewDao;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.dao.IZuserDao;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.Ywset;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.IOrgnewService;
import com.opensymphony.xwork2.ActionContext;




/**
 * OrgnewService.java Create on 2012-5-12
 * 
 * 机构管理业务层
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public class OrgnewService implements IOrgnewService {

	private IOrgnewDao orgnewDao;

	private ILoanLogDao loanLogDao;
	
	private ITjgdmDao tjgdmDao;
	
	private IZuserDao zuserDao;

	public void setZuserDao(IZuserDao zuserDao) {
		this.zuserDao = zuserDao;
	}

	public void setLoanLogDao(ILoanLogDao loanLogDao) {
		this.loanLogDao = loanLogDao;
	}

	public void setOrgnewDao(IOrgnewDao orgnewDao) {
		this.orgnewDao = orgnewDao;
	}

	public boolean deleteOrgnew(String rootPath, Integer orgid) {
		Orgnew orgnew = orgnewDao.findById(orgid);
		Integer flag = orgnewDao.deleteById(orgid);
		if (null != flag) {
			return MyUtils.delFile(rootPath + orgnew.getImageUrl());
		}
		return false;
	}

	public Page findByPage(Page page) {
		page.setRoot(orgnewDao.findByPage(page));
		page.setTotalProperty(orgnewDao.findByCount(page));
		return page;
	}
	
//	public List findUsernameOrgnew(String username){
//		return orgnewDao.findUsernameOrgnew(username);
//	}

	public List findUsernameOrgnew(Page page){
		return orgnewDao.findUsernameOrgnew(page);
	}
	
	public List findOrgidOrgnew(Integer orgid){
		return orgnewDao.findOrgidOrgnew(orgid);
	}
	
	public Object saveOrgnew(Orgnew orgnew)  throws Exception  {
		//Object flag = orgnewDao.saveOrgnew(orgnew);
		
		Integer flag=(Integer) orgnewDao.saveOrgnew(orgnew);
		
		return flag;
	}

	
	public boolean updateOrgnew(Orgnew orgnew) throws Exception {
		Integer flag = orgnewDao.update(orgnew);
		if (null != flag) {
			return true;
		}
		return false;
	}
	
	public Orgnew orgnewViewImg(Integer orgid){
		return orgnewDao.findByIdViewImg(orgid);
	}

	
	//保存图片名称和标识到库中
	public boolean saveImageOrgnew(Orgnew orgnew) throws Exception {
     	Integer flag = orgnewDao.update(orgnew);
		if (null != flag) {
			return true;
		}
		return false;
	}

	private Map appSysConfig;
	//提交申请
	public boolean returnOrgnew(Orgnew orgnew) throws Exception {
		
		appSysConfig = ActionContext.getContext().getApplication();
		
		///////////////////////////////////////////////////////////
		orgnew = orgnewDao.findById(orgnew.getOrgid());
		Integer flag=null;
		String strImageUrl=orgnew.getImageUrl();	
		if(strImageUrl=="" || "".equals(strImageUrl) || null==strImageUrl|| strImageUrl==null){
			//没有上传原文
			flag=null;
			
		}else{
			
			String sysNetWorkMode=(String)appSysConfig.get("sysNetWorkMode");
			/*List ywnetList = new ArrayList();
			ywnetList=(List)appSysConfig.get("ywnetList");
//			System.out.println("跟踪数据：：："+ywnetList.size());
	        boolean f = false;    
        	for(int i =0;i<ywnetList.size();i++){
				Ywset ywset=new Ywset();
				ywset = (Ywset)ywnetList.get(i);
				if(ywset.getYwlx().equals(orgnew.getYwlx())){
					f = true;
					break;
				}
	        }
			
//			System.out.println("跟踪数据：：："+f+ywnetList.size());*/
//			if(sysNetWorkMode.equals("1")&&f==true){
			if(sysNetWorkMode.equals("1")){
				orgnew.setState("3");
			}else{
				orgnew.setState("2");
			}
			Zuser zuser = new Zuser();
			//zuser.setZuserId(orgnew.getUserid());//更新的条件为Userid
			zuser.setUserName(orgnew.getJgdm());
			zuser.setState(orgnew.getState()); 
			
			zuserDao.updateByUserName(zuser);
			//orgnew.setYwlx(strYwlx);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			orgnew.setLastdate(sdf.parse(sdf.format(new Date())));
			orgnew.setLrDate(sdf.parse(sdf.format(new Date())));

			String strYwlx = orgnew.getYwlx();
			String strDybz = "";
			if(strYwlx=="年检" || "年检".equals(strYwlx)){
				strDybz="N";	//不要打印
			}else{
				strDybz="Y";//需要打印
			}
			
			if(strYwlx=="变更" || "变更".equals(strYwlx)){		
				Tjgdm tjgdm = new Tjgdm();
				tjgdm.setJgdm(orgnew.getJgdm());
				
				Tjgdm tjgdm2 = new Tjgdm();
				tjgdm2=tjgdmDao.findByJgdm(tjgdm);
				
				if(tjgdm2!=null){
					String oJgdz=orgnew.getJgdz();
					String tJgdz=tjgdm2.getJgdz();
					String oJglxOld=orgnew.getJglxOld();
					String tJglxOld=tjgdm2.getJglxOld();
					
					String oJgmc=orgnew.getJgmc();
					String tJgmc=tjgdm2.getJgmc();
					
					String oFddbr=orgnew.getFddbr();
					String tFddbr=tjgdm2.getFddbr();
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String oBzrq=format.format(orgnew.getBzrq());
					String tBzrq=format.format(tjgdm2.getBzrq());
					
					String oZfrq=format.format(orgnew.getZfrq());
					String tZfrq=format.format(tjgdm2.getZfrq());


					if(oJgdz.equals(tJgdz)){
						if(oJglxOld.equals(tJglxOld)){
							if(oJgmc.equals(tJgmc)){
								if(oFddbr.equals(tFddbr)){
									if(oBzrq.equals(tBzrq)){
										if(oZfrq.equals(tZfrq)){
											strDybz="N";//为不需打印
										}else{
											strDybz="Y";//为需要打印
										}
									}else{
										strDybz="Y";//为需要打印
									}
								}else{
									strDybz="Y";//为需要打印
								}
							}else{
								strDybz="Y";//为需要打印
							}
						}else{
							strDybz="Y";//为需要打印
						}
					}else{
						strDybz="Y";//为需要打印
					}
				}else{
					strDybz="Y";//为需打印
				}
			}
			
			
			
			
			
			orgnew.setDybz(strDybz);
			flag = orgnewDao.update(orgnew);
		}
		return flag == null ? false:true;
	}

	public Map getAppSysConfig() {
		return appSysConfig;
	}

	public void setAppSysConfig(Map appSysConfig) {
		this.appSysConfig = appSysConfig;
	}

	public boolean checkUsernameByJgdm(String strJgdm, String strUsername) {
		// TODO Auto-generated method stub
		Orgnew org = orgnewDao.checkUsernameByJgdm(strJgdm);
		boolean flag = false;
		if(org!=null){
			String username = org.getUsername();
			System.out.println(username);
			System.out.println(strUsername);
			System.out.println(username=="");
			System.out.println(username==null||username.equals(strUsername)||username.equals(""));
			if(username==null||username.equals(strUsername)||username.equals("")){
				flag = true;
			}
		}
		System.out.println(flag);
		return flag;
	}

	public List findJgdmOrgnew(Page page) {
		// TODO Auto-generated method stub
		return orgnewDao.findJgdmOrgnew(page);
	}

	public List findConditionsOrgnew(Page page) {
		// TODO Auto-generated method stub
		return orgnewDao.findConditionsOrgnew(page);
	}

	public void setTjgdmDao(ITjgdmDao tjgdmDao) {
		this.tjgdmDao = tjgdmDao;
	}
	
	
}
