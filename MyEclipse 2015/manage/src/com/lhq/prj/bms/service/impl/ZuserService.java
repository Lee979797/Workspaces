package com.lhq.prj.bms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Pzjg;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.dao.IZuserDao;
import com.lhq.prj.bms.service.IZuserService;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.dao.IOrgnewDao;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.po.Pzjg;
import com.lhq.prj.bms.dao.IPzjgDao;


/**
 * ZuserService.java Create on 2012-5-5
 * 
 * 用户管理业务层实现类
 * 
 * Copyright (c) 2008 by MTA.
 * @author
 * @version 1.0
 */
public class ZuserService implements IZuserService {

	private IZuserDao zuserDao;

	public void setZuserDao(IZuserDao zuserDao) {
		this.zuserDao = zuserDao;
	}
    
	private IOrgnewDao orgnewDao;
	private ITjgdmDao tjgdmDao;
	private IPzjgDao pzjgDao;

	public void setOrgnewDao(IOrgnewDao orgnewDao) {
		this.orgnewDao = orgnewDao;
	}
	
	public void setTjgdmDao(ITjgdmDao tjgdmDao) {
		this.tjgdmDao = tjgdmDao;
	}
	
	public void setPzjgDao(IPzjgDao pzjgDao) {
		this.pzjgDao = pzjgDao;
	}
	
	public boolean deleteZuser(Integer userid) {
		Integer flag = zuserDao.deleteById(userid);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Page findByPage(Page page) {
		
		String bzjgdm=page.getBzjgdm();
		String userName=page.getUsername();
		
		if(userName=="admin" || "admin".equals(userName)){
			
		}else{
			List pzjgList=pzjgDao.findByBzjgdm(bzjgdm);
			List pzjgdmList = new ArrayList();
			Pzjg pzjg=new Pzjg();
			for (int i = 0; i < pzjgList.size(); i++) {
				System.out.println(pzjgList.size());
				pzjg=(Pzjg) pzjgList.get(i);
				String pzjgdm=pzjg.getPzjgdm();
				pzjgdmList.add(pzjgdm);
			}
			page.setPzjgdmConditions(pzjgdmList);
		}
		
		page.setRoot(zuserDao.findByPage(page));
		page.setTotalProperty(zuserDao.findByCount(page));
		return page;
	}

	public Object saveZuser(Zuser zuser) {
		return zuserDao.saveZuser(zuser);
	}

	public Object regZuser(Zuser zuser) {
			return zuserDao.regZuser(zuser);
	}
	
	public boolean updateZuser(Zuser zuser) throws Exception {
		Integer flag = zuserDao.update(zuser);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Zuser zlogin(Zuser zuser) {
		return zuserDao.zlogin(zuser);
	}

	public List findByExample(Zuser zuser) {
		return zuserDao.findByExample(zuser);
	}
	
	//审查通过
	public boolean returnZuserOk(Zuser zuser) throws Exception {
		zuser = zuserDao.findById(zuser.getUserid());
		//把State由字符转为数字
		String strState=zuser.getState();
		Integer intOrgid=0;
		Integer flag = null;
		if(strState=="0" || "0".equals(strState)||strState=="" || "".equals(strState)||strState==null){
			//???? yangqi 在zz客户系统中增加如下方法：用户注册的时候，需要用户表，是否有此机构和注册号的用户注册，如有则不可注册
        	//在审核用户的时候，应该增加一个新方法findByJgdm，如是新证书用户则插入空数据，如是老证书用户，则取出数据
			if(zuser.getOrgCode()=="" || "".equals(zuser.getOrgCode()) || null==zuser.getOrgCode()){
				Orgnew orgnew = new Orgnew();
        		orgnew.setUserid(zuser.getUserid());
        		orgnew.setUsername(zuser.getUserName());
        		orgnew.setName(zuser.getName());
        		orgnew.setFddbr(zuser.getName());
        		orgnew.setJgmc(zuser.getOrgName());
        		
        		orgnew.setPzjgmc(zuser.getPzjgmc());
        		orgnew.setPzjgdm(zuser.getPzjgdm());
        		
        		orgnew.setZjhm(zuser.getSfzHao());
        		orgnew.setJgdz(zuser.getAddress());
        		orgnew.setZch(zuser.getOrgZch());
        		orgnew.setEmail(zuser.getEmail());
        		orgnew.setYzbm(zuser.getPostalcode());
        		orgnew.setDhhm(zuser.getTel());
        		orgnew.setJglx(zuser.getOrgType());
        		orgnew.setZjlx(zuser.getZjlx());
        		orgnew.setXzqhCode(zuser.getXzqhCode());
        		orgnew.setXzqhName(zuser.getXzqhName());
        		orgnew.setState("0");
        		////??????20120615  flag 返回值正确吗?????? yangqi
				//flag = (Integer) orgnewService.saveOrgnew(orgnew)
        		intOrgid=(Integer)orgnewDao.saveOrgnew(orgnew);
        		
        		zuser.setState("1");
        		zuser.setOrgid(intOrgid);
        		flag = zuserDao.update(zuser);
			}else{
				
				Tjgdm tjgdm = new Tjgdm();
        		tjgdm.setJgmc(zuser.getOrgName());
        		tjgdm.setJgdm(zuser.getOrgCode());
        		tjgdm = tjgdmDao.findByJgdm(tjgdm);
        		//flag = tjgdmDao.findByJgdm(tjgdm);
        		if(tjgdm!= null ){
        			//?????????????此处从旧表来的数据不完全，需要添加
        			Orgnew orgnew = new Orgnew();
	        		orgnew.setJgdm(tjgdm.getJgdm());
	        		orgnew.setJgmc(tjgdm.getJgmc());
	        		orgnew.setZch(tjgdm.getZch());
	        		orgnew.setXzqhCode(tjgdm.getXzqhCode());
	        		orgnew.setXzqhName(tjgdm.getXzqhName());
	        		orgnew.setJglx(tjgdm.getJglx());
	        		orgnew.setFddbr(tjgdm.getFddbr());
	        		orgnew.setZczj(tjgdm.getZczj());
	        		orgnew.setZgrs(tjgdm.getZgrs());
	        		orgnew.setNjrq(tjgdm.getNjrq());
	        		orgnew.setDhhm(tjgdm.getDhhm());
	        		orgnew.setZycp1(tjgdm.getZycp1());
	        		orgnew.setZycp2(tjgdm.getZycp2());
	        		orgnew.setZycp3(tjgdm.getZycp3()); 
	        		orgnew.setEmail(tjgdm.getEmail());
	        		orgnew.setPzjgmc(tjgdm.getPzjgmc());
	        		orgnew.setPzjgdm(tjgdm.getPzjgdm());
	        		orgnew.setUserid(zuser.getUserid());
	        		orgnew.setName(zuser.getName());
	        		orgnew.setUsername(zuser.getUserName());
	        		orgnew.setState("100");
	        		//Integer orgid;
	        		intOrgid=(Integer)orgnewDao.saveOrgnew(orgnew);
	        		
	        		zuser.setState("11");
	        		zuser.setOrgid(intOrgid);
	        		flag = zuserDao.update(zuser);
	        		
        		}else{
        			//不用校验了
        			Orgnew orgnew = new Orgnew();
            		orgnew.setUserid(zuser.getUserid());
            		orgnew.setUsername(zuser.getUserName());
            		orgnew.setName(zuser.getName());
            		orgnew.setFddbr(zuser.getName());
            		orgnew.setJgmc(zuser.getOrgName());
            		orgnew.setJgdm(zuser.getOrgCode());
            		orgnew.setPzjgmc(zuser.getPzjgmc());
            		orgnew.setPzjgdm(zuser.getPzjgdm());
            		orgnew.setZjhm(zuser.getSfzHao());
            		orgnew.setJgdz(zuser.getAddress());
            		orgnew.setZch(zuser.getOrgZch());
            		orgnew.setEmail(zuser.getEmail());
            		orgnew.setYzbm(zuser.getPostalcode());
            		orgnew.setDhhm(zuser.getTel());
            		orgnew.setJglx(zuser.getOrgType());
            		orgnew.setZjlx(zuser.getZjlx());
            		orgnew.setXzqhCode(zuser.getXzqhCode());
            		orgnew.setXzqhName(zuser.getXzqhName());
            		orgnew.setState("100");
            		////??????20120615  flag 返回值正确吗?????? yangqi
    				//flag = (Integer) orgnewService.saveOrgnew(orgnew)
            		intOrgid=(Integer)orgnewDao.saveOrgnew(orgnew);
            		
            		zuser.setState("11");
            		zuser.setOrgid(intOrgid);
            		flag = zuserDao.update(zuser);
        		}	

        	}
		}
		return flag == null ? false:true;
	}


	
	//审查驳回
	public boolean returnZuserNo(Zuser zuser) throws Exception {
		zuser = zuserDao.findById(zuser.getUserid());
		//把State由字符转为数字
		//String strState=zuser.getState();	
        //if(strState=="0"){
        //	zuser.setState("1");
       // }
		//自动发电子邮件通知
		
		
		zuser.setState("9");
		Integer flag = zuserDao.update(zuser);
		return flag == null ? false:true;
	}
	
}
