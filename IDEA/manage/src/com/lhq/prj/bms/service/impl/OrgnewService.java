package com.lhq.prj.bms.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;


import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.Page;

import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.dao.IZuserDao;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.dao.IOrgnewDao;
import com.lhq.prj.bms.po.Ywset;
import com.lhq.prj.bms.dao.IYwsetDao;
import com.lhq.prj.bms.po.Qx;
import com.lhq.prj.bms.po.Jglx;
import com.lhq.prj.bms.po.PrintLog;
import com.lhq.prj.bms.dao.IPrintLogDao;
import com.lhq.prj.bms.po.Dfile;
import com.lhq.prj.bms.dao.IDfileDao;
import com.lhq.prj.bms.po.Pzjg;
import com.lhq.prj.bms.dao.IPzjgDao;
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
	private IZuserDao zuserDao;
	private IPzjgDao pzjgDao;
	private IYwsetDao ywsetDao;
	private IPrintLogDao printLogDao;
	private IDfileDao dfileDao;
	private ITjgdmDao tjgdmDao;
	private Map appSysConfig;

	public void setZuserDao(IZuserDao zuserDao) {
		this.zuserDao = zuserDao;
	}

	public void setOrgnewDao(IOrgnewDao orgnewDao) {
		this.orgnewDao = orgnewDao;
	}
	
	public void setPzjgDao(IPzjgDao pzjgDao) {
		this.pzjgDao = pzjgDao;
	}
	
	public void setYwsetDao(IYwsetDao ywsetDao) {
		this.ywsetDao = ywsetDao;
	}
	
	public void setPrintLogDao(IPrintLogDao printLogDao) {
		this.printLogDao = printLogDao;
	}
	
	public void setDfileDao(IDfileDao dfileDao) {
		this.dfileDao = dfileDao;
	}
	
	public void setTjgdmDao(ITjgdmDao tjgdmDao) {
		this.tjgdmDao = tjgdmDao;
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
		String strBzjgdm=page.getBzjgdm();
		String strUserName=page.getUsername();

		if(strUserName=="admin" || "admin".equals(strUserName)){
			strBzjgdm=null;
		}
		page.setBzjgdm(strBzjgdm);
		page.setRoot(orgnewDao.findByPage(page));
		page.setTotalProperty(orgnewDao.findByCount(page));
		return page;
	}

	//msg 定时刷新
	public List findCountByPage(Page page) {
		String strBzjgdm=page.getBzjgdm();
		String strUserName=page.getUsername();

		if(strUserName=="admin" || "admin".equals(strUserName)){
			strBzjgdm=null;
		}
		page.setBzjgdm(strBzjgdm);
		List msgCountList = orgnewDao.findByCountList(page);
		return msgCountList;
	}
	
	//审核字段校对
	public List verifyFieldByJgdm(String jgdm) {
		List verifyFieldList = orgnewDao.verifyFieldByJgdm(jgdm);
		return verifyFieldList;
	}
	
	
	
	//分中心现场审核查询
	//现场办证，如“某业务类型”设置为中心审核，则由中心审核后，办证机构进行办理；否则就直接办理本办证点的档案
	//中心不需要审核本中心的现场办证，只审核由下属办证机构办理的档案
	public Page findShenheXcByPage(Page page) {		
		page.setRoot(orgnewDao.findShenheXcByPage(page));
		page.setTotalProperty(orgnewDao.findShenheXcByCount(page));
		return page;
	}
	
	
	//网上办证审核查询
	//网上办证如“某业务类型”设置为中心审核，则由中心审核，办证机构不能审核
	//中心不光审核本中心的网审，也审核由下属办证机构办理的档案
	public Page findShenheNetByPage(Page page) {
		/*String bzjgdm=page.getBzjgdm();
		String userName=page.getUsername();
		//System.out.println(userName!="admin" && !"admin".equals(userName));
		if(userName!="admin" && !"admin".equals(userName)){
			//判断网审业务是否属于核定机构专办业务，如设定分中心为网审新办全部办理
			appSysConfig = ActionContext.getContext().getApplication();
			if("1".equals(appSysConfig.get("sysNetWorkMode"))){
				
				
				List noYwlxList = new ArrayList();
				noYwlxList=ywsetDao.findYwsetByNotBzjg(bzjgdm); //不是本办证机构办理的业务为1、8
				
				String ywlxStr = "新办,年检,变更,换证,补证,迁入,迁出,预赋码,注销,批量注销"; 
				List ywlxList = new ArrayList();
				MyUtils.addToCollection(ywlxList, MyUtils.split(ywlxStr, " ,"));
				
				Ywset ywset=new Ywset();
				if(noYwlxList.size()>0){
						//新办,预赋码
						List ywlxListConditions = new ArrayList();
						for (int k = 0; k < ywlxList.size(); k++) {
							String strYwlx=(String) ywlxList.get(k);
							boolean b = false; 
							for (int j = 0; j < noYwlxList.size(); j++) { //循环过滤ywlx的值，如果不等于，则b就TRUE
								ywset=(Ywset) noYwlxList.get(j);
								String ywlx=ywset.getYwlx();
								//System.out.println(ywlxdm);
								if(strYwlx==ywlx  || strYwlx.equals(ywlx)){
									b=false;
									break;
								}else{
									b=true;
								}						
							}
							System.out.println(b);
							if(b){
								ywlxListConditions.add(strYwlx);
							}	
						}
						page.setYwlxConditions(ywlxListConditions); //年检,变更,换证,补证,迁入,迁出,注销,批量注销
						
						List pzjgList = new ArrayList();
						pzjgList=pzjgDao.findByBzjgdm(bzjgdm);
						if(pzjgList.size()>0){
							List pzjgdmList = new ArrayList();
							Pzjg pzjg=new Pzjg();
							for (int i = 0; i < pzjgList.size(); i++) {
								pzjg=(Pzjg) pzjgList.get(i);
								String pzjgdm=pzjg.getPzjgdm();
								pzjgdmList.add(pzjgdm);
							}
							page.setPzjgdmConditions(pzjgdmList);
						}else{
							List pzjgdmList = new ArrayList();
							pzjgdmList.add("0000000000");
							page.setPzjgdmConditions(pzjgdmList);
						}
	
				}else{
					
					List ywlxList2 = new ArrayList();
					ywlxList2=ywsetDao.findYwsetByBzjg(bzjgdm); //是本办证机构办理的业务为1、8
	
					Ywset ywset2=new Ywset();
					if(ywlxList2.size()>0){
						//新办,预赋码
						List ywlxListConditions = new ArrayList();
						List ywlxListConditions2 = new ArrayList();
						for (int x = 0; x < ywlxList.size(); x++) {
							String strYwlx2=(String) ywlxList.get(x);
							boolean a = false; 
							for (int y = 0; y < ywlxList2.size(); y++) { //循环过滤ywlx的值，如果不等于，则b就TRUE
								ywset2=(Ywset) ywlxList2.get(y);
								String ywlx2=ywset2.getYwlx();
								//System.out.println(ywlxdm);
								if(strYwlx2==ywlx2  || strYwlx2.equals(ywlx2)){
									a=false;
									break;
								}else{
									a=true;
								}						
							}
							if(a){
								ywlxListConditions.add(strYwlx2);
							}else{
								ywlxListConditions2.add(strYwlx2);		
							}
						}
						page.setYwlxConditions(ywlxListConditions); //新办，预赋码
						page.setYwlxConditions2(ywlxListConditions2); //年检,变更,换证,补证,迁入,迁出,注销,批量注销
						
						List pzjgList = new ArrayList();
						pzjgList=pzjgDao.findByBzjgdm(bzjgdm);
						if(pzjgList.size()>0){
							List pzjgdmList = new ArrayList();
							Pzjg pzjg=new Pzjg();
							for (int i = 0; i < pzjgList.size(); i++) {
								pzjg=(Pzjg) pzjgList.get(i);
								String pzjgdm=pzjg.getPzjgdm();
								pzjgdmList.add(pzjgdm);
							}
							page.setPzjgdmConditions(pzjgdmList);
						}else{
							List pzjgdmList = new ArrayList();
							pzjgdmList.add("0000000000");
							page.setPzjgdmConditions(pzjgdmList);
						}
					}	
				}
			}else{
				//不进行中心审核时候，各办证中心自己办理自己所属批准机构机构
				List pzjgList = new ArrayList();
				pzjgList=pzjgDao.findByBzjgdm(bzjgdm);
				if(pzjgList.size()>0){
					List pzjgdmList = new ArrayList();
					Pzjg pzjg=new Pzjg();
					for (int i = 0; i < pzjgList.size(); i++) {
						pzjg=(Pzjg) pzjgList.get(i);
						String pzjgdm=pzjg.getPzjgdm();
						pzjgdmList.add(pzjgdm);
					}
					page.setPzjgdmConditions(pzjgdmList);
				}else{
					List pzjgdmList = new ArrayList();
					pzjgdmList.add("0000000000");
					page.setPzjgdmConditions(pzjgdmList);
				}
			}
		}*/
		if(page.getStateConditions().size()==2){
			page.setRoot(orgnewDao.findShenheNetByPageCenterid(page));
			page.setTotalProperty(orgnewDao.findShenheNetByCountCenterid(page));
		}else{
			page.setRoot(orgnewDao.findShenheNetByPage(page));
			page.setTotalProperty(orgnewDao.findShenheNetByCount(page));
		}
		return page;
	}
	
	public Page findAllOrgnewOrTjgdmByPage(Page page) {
		Integer iCount=orgnewDao.findByCount(page);
		if(iCount!=0){
			page.setRoot(orgnewDao.findByPage(page));
			page.setTotalProperty(iCount);
		}else{
			page.setRoot(tjgdmDao.findByPage(page));
			page.setTotalProperty(tjgdmDao.findByCount(page));
		}
		return page;
	}

	
	public Object saveOrgnew(Orgnew orgnew) {
		String ywlx=orgnew.getYwlx();
		String moveoutCenter=orgnew.getMoveoutCenter();
		String centerid=orgnew.getCenterid();
		String strJgdm=orgnew.getJgdm();
		//迁址标记----0：省内入；1：省内出；3：省间出；4：省间入
		if("迁出".equals(ywlx)){
			if(moveoutCenter.equals(centerid)){
				orgnew.setQzbz("1");
			}else{
				orgnew.setQzbz("3");
			}
		}else{
			if("迁入".equals(ywlx)){
				//根据省内是否有此机构代码，来判断迁址标志
				Tjgdm tjgdm = new Tjgdm();
				tjgdm.setJgdm(strJgdm);
				tjgdm.setYwlx("迁出");
				Tjgdm tjgdm3 = new Tjgdm();
				tjgdm3=tjgdmDao.findByJgdmQz(tjgdm);
				if(tjgdm3!=null){
					orgnew.setQzbz("0");
				}else{
					orgnew.setQzbz("4");
				}
			}else{
				orgnew.setQzbz(null);
			}
		}
		return orgnewDao.saveOrgnew(orgnew);
	}

	public boolean updateOrgnew(Orgnew orgnew) throws Exception {
		String ywlx=orgnew.getYwlx();
		String moveoutCenter=orgnew.getMoveoutCenter();
		String centerid=orgnew.getCenterid();
		String strJgdm=orgnew.getJgdm();
		//迁址标记----0：省内入；1：省内出；3：省间出；4：省间入
		if("迁出".equals(ywlx)){
			if(moveoutCenter.equals(centerid)){
				orgnew.setQzbz("1");
			}else{
				orgnew.setQzbz("3");
			}
		}else{
			if("迁入".equals(ywlx)){
				//根据省内是否有此机构代码，来判断迁址标志
				Tjgdm tjgdm = new Tjgdm();
				tjgdm.setJgdm(strJgdm);
				tjgdm.setYwlx("迁出");
				Tjgdm tjgdm3 = new Tjgdm();
				tjgdm3=tjgdmDao.findByJgdmQz(tjgdm);
				if(tjgdm3!=null){
					orgnew.setQzbz("0");
				}else{
					orgnew.setQzbz("4");
				}
			}else{
				orgnew.setQzbz(null);
			}
		}
		System.out.println("跟踪OrgnewService：updateOrgnew："+orgnew.getBzjgdm());
		Integer flag = orgnewDao.update(orgnew);
		if (null != flag) {
			return true;
		}
		return false;
	}
    
	//业务提交
	public boolean returnOrgnew(Orgnew orgnew) throws Exception {
		orgnew = orgnewDao.findById(orgnew.getOrgid());
		String strState=orgnew.getState();
		Integer flag = null;
		if(strState=="0" || "0".equals(strState)){
			//Tjgdm tjgdm = new Tjgdm();
			//tjgdm.setJgmc(orgnew.getJgmc());
			//增加方法  findByJgdmJgmc 检测此单位是否已办证
			//tjgdm = tjgdmDao.findByJgdm(tjgdm);
            //如过老库中没有此用户则审核通过
			//if(tjgdm == null){
				orgnew.setState("1");
				flag = orgnewDao.update(orgnew);
			//}
		}
		return flag == null ? false:true;
	}
	
	
	//新办网审驳回NO
	public boolean returnOrgnewNo(Orgnew orgnew) throws Exception {
		String newAuditUsername=orgnew.getAuditUsername();
		String newAuditUserid=orgnew.getAuditUserid();
		String newAuditName=orgnew.getAuditName();
		orgnew = orgnewDao.findById(orgnew.getOrgid());
		//把State由字符转为数字
		Integer inte=Integer.parseInt(orgnew.getState());	
		Integer newUserState=0;
	    //Integer intObj = new Integer(strState);
	    //int inte = intObj.intValue(); 

		switch(inte) {
		case 2: 
			inte=inte+2;
			newUserState=inte+1;
			break;
		case 3: 
			inte=inte+1;
			newUserState=inte;
			break;
		case 11: 
			inte=inte+2;
			newUserState=inte+1;
			break; 
		case 21: 
			inte=inte+2;
			newUserState=inte+1;
			break; 
		default: 
			System.out.println("工单审查驳回错误！");
		}
		
        //转换数字状态为字符串
		String newState=String.valueOf(inte);
		orgnew.setState(newState);
		orgnew.setAuditUserid(String.valueOf(newAuditUserid));
		orgnew.setAuditUsername(newAuditUsername);// 设置办理人用户名
		orgnew.setAuditName(newAuditName);// 设置办理人姓名
		orgnew.setAuditDate(new Date());
		
		Integer flag = orgnewDao.update(orgnew);
		return flag == null ? false:true;
	}
	
	//网上办证的审核通过OK
	public boolean returnOrgnewOk(Orgnew orgnew) throws Exception {
		String newAuditUsername=orgnew.getAuditUsername();
		String newAuditUserid=orgnew.getAuditUserid();
		String newAuditName=orgnew.getAuditName();
		orgnew = orgnewDao.findById(orgnew.getOrgid());
		String strYwlx=null;
		String strJgdm=orgnew.getJgdm();
		String strFddbr=orgnew.getFddbr();
		String strJglx=orgnew.getJglx();
		String strJgdz=orgnew.getJgdz();
		String strPzjgmc=orgnew.getPzjgmc();
		Date dateZfrq=new Date();
		Tjgdm tjgdm = new Tjgdm();
		tjgdm.setJgdm(strJgdm);
		
		if(strYwlx==null || strYwlx=="" || "".equals(strYwlx) || "null".equals(strYwlx)){
			System.out.println(strJgdm!=null && strJgdm.trim()!="" && !strJgdm.trim().equals(""));
			System.out.println(strJgdm.trim()!="" && !strJgdm.trim().equals(""));
			if(strJgdm!=null && strJgdm.trim()!="" && !strJgdm.trim().equals("")){
				Tjgdm tjgdm3 = new Tjgdm();
				tjgdm3=tjgdmDao.findByJgdm(tjgdm);
				if(tjgdm3!=null){
					if(strPzjgmc==tjgdm3.getPzjgmc() || strPzjgmc.equals(tjgdm3.getPzjgmc())){
						//打印相差天数
						boolean flag = tjgdm3.getZfrq().before(dateZfrq);
						if(!flag){
							System.out.print("还没到期");
							System.out.print(MyUtils.daysBetween(dateZfrq,tjgdm3.getZfrq()));
							if(MyUtils.daysBetween(dateZfrq,tjgdm3.getZfrq())<30 ){
								strYwlx="换证";
							}else{
								if(!strFddbr.equals(tjgdm3.getFddbr()) || !strJglx.equals(tjgdm3.getJglx()) || !strJgdz.equals(tjgdm3.getJgdz())){
									strYwlx="变更";
								}else{
									strYwlx="年检";
									//orgnew.setNjrq(new Date());
								}
							}
						}
						else{
							strYwlx="换证";
							System.out.print("到期换证");
						}
					}else{
						strYwlx="迁入";
					}
				}else{
					strYwlx="迁入";
				}
			
			}else{
				strYwlx="新办";
			}
		}
		Integer inte=Integer.parseInt(orgnew.getState());
		
		
		
		switch(inte) {
		case 2: 
			inte=inte+3;
			break; 
		case 3: 
			inte=inte+2;
			break; 
		case 11: 
			inte=inte+1;
			break;
		default: 
			System.out.println("错误！");
		}
        //转换数字状态为字符串
		String newState=String.valueOf(inte);
		
		
		orgnew.setState(newState);
		orgnew.setYwlx(strYwlx);
		orgnew.setAuditUserid(String.valueOf(newAuditUserid));
		orgnew.setAuditUsername(newAuditUsername);// 设置审核人用户名
		orgnew.setAuditName(newAuditName);// 设置审核人姓名
		orgnew.setAuditDate(new Date());
		
		Integer flag = orgnewDao.update(orgnew);

		return flag == null ? false:true;
	}
	
	public boolean returnOrgnewCode(Orgnew orgnew) throws Exception {
		orgnew = orgnewDao.findById(orgnew.getOrgid());
//		orgnew.setState("4");
//		orgnew.setJgdm("10888888-X");
		Integer flag = orgnewDao.update(orgnew);
		return flag == null ? false:true;
	}
	
	public Orgnew orgnewViewImg(Integer orgid){
		return orgnewDao.findByIdViewImg(orgid);
	}
	
	public List findOrgnewByOrgid(Integer orgid){
		return orgnewDao.findOrgnewByOrgid(orgid);
	}

	//保存图片名称和标识到库中
	public boolean saveImageOrgnew(Orgnew orgnew) throws Exception {
     	Integer flag = orgnewDao.update(orgnew);
		if (null != flag) {
			return true;
		}
		return false;
	}
	
	//审核归档
	public boolean returnOrgnewCreate(Orgnew orgnew2) throws Exception {
		Orgnew orgnew = new Orgnew();
		orgnew = orgnewDao.findById(orgnew2.getOrgid());
		String strState=orgnew.getState();
		String strYwlx=orgnew.getYwlx();
		Integer intOrgid=orgnew.getOrgid();
		Integer flag = null;
		Dfile dfile = new Dfile();
		String newState="";
		Integer userid=null;
		String newDybz=orgnew.getDybz();
		if(strYwlx=="注销" || "注销".equals(strYwlx)){
			newState="200";//为注销状态
		}else{
			if(strYwlx=="迁出" || "迁出".equals(strYwlx)){
				newState="300";
			}else{
				newState="100";
			}
		}
		
		if(newDybz!="Y" || !"Y".equals(newDybz)){
			if(strState=="6" || "6".equals(strState) || strState=="16" || "16".equals(strState)){
				
				Tjgdm tjgdm = new Tjgdm();
				tjgdm.setJgdm(orgnew.getJgdm());
				
				Tjgdm tjgdm2 = new Tjgdm();
				tjgdm2=tjgdmDao.findByJgdm(tjgdm);
				
				tjgdm.setOrderid(orgnew.getOrderid());
				tjgdm.setCenterid(orgnew.getCenterid());
				tjgdm.setDocid(orgnew.getDocid());
				tjgdm.setJgmc(orgnew.getJgmc());
				tjgdm.setJglx(orgnew.getJglx());
				tjgdm.setJglxdm(orgnew.getJglxdm());
				tjgdm.setJglxOld(orgnew.getJglxOld());
				tjgdm.setJglxdmOld(orgnew.getJglxdmOld());
				tjgdm.setFddbr(orgnew.getFddbr());
				tjgdm.setZjlx(orgnew.getZjlx());
				tjgdm.setZjhm(orgnew.getZjhm());
				tjgdm.setQyjj(orgnew.getQyjj());
				tjgdm.setJyfw(orgnew.getJyfw());
				tjgdm.setZcrq(orgnew.getZcrq());
				tjgdm.setXzqhCode(orgnew.getXzqhCode());
				tjgdm.setXzqhName(orgnew.getXzqhName());
				tjgdm.setXzqhCode2(orgnew.getXzqhCode2());
				tjgdm.setXzqhName2(orgnew.getXzqhName2());
				tjgdm.setJgdz(orgnew.getJgdz());
				tjgdm.setYzbm(orgnew.getYzbm());
				tjgdm.setDhhm(orgnew.getDhhm());
				tjgdm.setScbzrq(orgnew.getScbzrq());
				tjgdm.setZycp1(orgnew.getZycp1());
				tjgdm.setZycp2(orgnew.getZycp2());
				tjgdm.setZycp3(orgnew.getZycp3());
				tjgdm.setZczj(orgnew.getZczj());
				tjgdm.setWftzgb(orgnew.getWftzgb());
				tjgdm.setWftzgbdm(orgnew.getWftzgbdm());
				tjgdm.setZgrs(orgnew.getZgrs());
				tjgdm.setLry(orgnew.getLry());
				tjgdm.setLrName(orgnew.getLrName());
				tjgdm.setLrDate(orgnew.getLrDate());
				tjgdm.setZch(orgnew.getZch());
				tjgdm.setQzbz(orgnew.getQzbz());
				tjgdm.setQzrq(orgnew.getQzrq() );
				tjgdm.setZgmc(orgnew.getZgmc());
				tjgdm.setPzjgmc(orgnew.getPzjgmc());
				tjgdm.setPzjgdm(orgnew.getPzjgdm());
				tjgdm.setPzwh(orgnew.getPzwh());
				tjgdm.setPwrq(orgnew.getPwrq());
				tjgdm.setGk(orgnew.getGk());
				tjgdm.setIsca(orgnew.getIsca());
				tjgdm.setFkbz(orgnew.getFkbz());
				tjgdm.setFksl(orgnew.getFksl());
				tjgdm.setIsxw(orgnew.getIsxw());
				tjgdm.setEmail(orgnew.getEmail());
				tjgdm.setWeburl(orgnew.getWeburl());
				tjgdm.setMobile(orgnew.getMobile());
				tjgdm.setYjflag(orgnew.getYjflag());
				tjgdm.setTbrxm(orgnew.getTbrxm());
				tjgdm.setTbrsfzh(orgnew.getTbrsfzh());
				tjgdm.setTbrlxfs(orgnew.getTbrlxfs());
				tjgdm.setJydz(orgnew.getJydz());
				tjgdm.setJyyb(orgnew.getJyyb());
				tjgdm.setJydh(orgnew.getJydh());
				tjgdm.setJfly(orgnew.getJfly());
				tjgdm.setKhyh(orgnew.getKhyh());
				tjgdm.setKhzh(orgnew.getKhzh());
				tjgdm.setZsbfrq(orgnew.getZsbfrq());
				tjgdm.setZszfrq(orgnew.getZszfrq());
				tjgdm.setFbsl(orgnew.getFbsl());
				tjgdm.setZbsl(orgnew.getZbsl());
				tjgdm.setBzrq(orgnew.getBzrq());
				tjgdm.setZfrq(orgnew.getZfrq());
				tjgdm.setZslsh(orgnew.getZslsh());
				tjgdm.setNjr(orgnew.getNjr());
				tjgdm.setNjrq(orgnew.getNjrq());
				tjgdm.setNjqx(orgnew.getNjqx());
				tjgdm.setJjlx(orgnew.getJjlx());
				tjgdm.setJjlxdm(orgnew.getJjlxdm());
				tjgdm.setJjlxOld(orgnew.getJjlxOld());
				tjgdm.setJjlxdmOld(orgnew.getJjlxdmOld());
				tjgdm.setJjhymc(orgnew.getJjhymc());
				tjgdm.setJjhydm(orgnew.getJjhydm());
				tjgdm.setJjhymcOld(orgnew.getJjhymcOld());
				tjgdm.setJjhydmOld(orgnew.getJjhydmOld());
				tjgdm.setZgdm(orgnew.getZgdm());
				tjgdm.setTbrzjlx(orgnew.getTbrzjlx());
				tjgdm.setMemo(orgnew.getMemo());
				tjgdm.setMemo2(orgnew.getMemo2());
				tjgdm.setHbzl(orgnew.getHbzl());
				tjgdm.setHbzldm(orgnew.getHbzldm());
				tjgdm.setLastdate(orgnew.getLastdate());
				tjgdm.setXgr(orgnew.getXgr());
				tjgdm.setBgrq(orgnew.getBgrq());
				tjgdm.setUserid(orgnew.getUserid());
				tjgdm.setName(orgnew.getName());
				tjgdm.setImageUrl(orgnew.getImageUrl());
				tjgdm.setUsername(orgnew.getUsername());
				
				tjgdm.setPageTypeStr(orgnew.getPageTypeStr());
				tjgdm.setXgr(orgnew.getXgr());
				tjgdm.setDybz(orgnew.getDybz());
				tjgdm.setCzshbz(0);
				tjgdm.setState(newState);
				tjgdm.setHandleUserid(orgnew.getHandleUserid());
				tjgdm.setHandleUsername(orgnew.getHandleUsername());
				tjgdm.setHandleName(orgnew.getHandleName());
				tjgdm.setHandleDate(orgnew.getHandleDate());
				tjgdm.setHandleNote(orgnew.getHandleNote());
				
				tjgdm.setMoveoutCenter(orgnew.getMoveoutCenter());
				tjgdm.setMoveoutBzjgdm(orgnew.getMoveoutBzjgdm());
				tjgdm.setMoveoutAddrss(orgnew.getMoveoutAddrss());
				tjgdm.setMoveoutReason(orgnew.getMoveoutReason());
				tjgdm.setMoveoutNote(orgnew.getMoveoutNote());
				tjgdm.setOffPzjgmc(orgnew.getOffPzjgmc());
				tjgdm.setOffPzwh(orgnew.getOffPzwh());
				tjgdm.setOffReason(orgnew.getOffReason());
				tjgdm.setOffNote(orgnew.getOffNote());
				tjgdm.setUp_Dflag(1);
				tjgdm.setPigeTime(new Date());
				tjgdm.setYwlx(orgnew.getYwlx());
				tjgdm.setBzjgdm(orgnew.getBzjgdm());
				
				Integer newOrgid2=null;
				if(tjgdm2!=null){
					newOrgid2 = (Integer) tjgdmDao.update(tjgdm);
				}else{
					newOrgid2=(Integer) tjgdmDao.saveTjgdm(tjgdm);
				}
				
				if(newOrgid2!=null){
					Tjgdm tjgdm3 = new Tjgdm();
					tjgdm3=tjgdmDao.findByJgdm(tjgdm);
					dfile.setOrderid(tjgdm3.getOrderid());
					dfile.setCenterid(tjgdm3.getCenterid());
					dfile.setDocid(tjgdm3.getDocid());
					dfile.setJgmc(tjgdm3.getJgmc());
					dfile.setJgdm(tjgdm3.getJgdm());
					dfile.setJglx(tjgdm3.getJglx());
					dfile.setJglxdm(tjgdm3.getJglxdm());
					dfile.setJglxOld(tjgdm3.getJglxOld());
					dfile.setJglxdmOld(tjgdm3.getJglxdmOld());
					dfile.setFddbr(tjgdm3.getFddbr());
					dfile.setZjlx(tjgdm3.getZjlx());
					dfile.setZjhm(tjgdm3.getZjhm());
					dfile.setQyjj(tjgdm3.getQyjj());
					dfile.setJyfw(tjgdm3.getJyfw());
					dfile.setZcrq(tjgdm3.getZcrq());
					dfile.setXzqhCode(tjgdm3.getXzqhCode());
					dfile.setXzqhName(tjgdm3.getXzqhName());
					dfile.setXzqhCode2(tjgdm3.getXzqhCode2());
					dfile.setXzqhName2(tjgdm3.getXzqhName2());
					dfile.setJgdz(tjgdm3.getJgdz());
					dfile.setYzbm(tjgdm3.getYzbm());
					dfile.setDhhm(tjgdm3.getDhhm());
					dfile.setScbzrq(tjgdm3.getScbzrq());
					dfile.setZycp1(tjgdm3.getZycp1());
					dfile.setZycp2(tjgdm3.getZycp2());
					dfile.setZycp3(tjgdm3.getZycp3());
					dfile.setZczj(tjgdm3.getZczj());
					dfile.setWftzgb(tjgdm3.getWftzgb());
					dfile.setWftzgbdm(tjgdm3.getWftzgbdm());
					dfile.setZgrs(tjgdm3.getZgrs());
					dfile.setLry(tjgdm3.getLry());
					dfile.setLrName(tjgdm3.getLrName());
					dfile.setLrDate(tjgdm3.getLrDate());
					dfile.setZch(tjgdm3.getZch());
					dfile.setQzbz(tjgdm3.getQzbz());
					dfile.setQzrq(tjgdm3.getQzrq() );
					dfile.setZgmc(tjgdm3.getZgmc());
					dfile.setPzjgmc(tjgdm3.getPzjgmc());
					dfile.setPzjgdm(tjgdm3.getPzjgdm());
					dfile.setPzwh(tjgdm3.getPzwh());
					dfile.setPwrq(tjgdm3.getPwrq());
					dfile.setGk(tjgdm3.getGk());
					dfile.setIsca(tjgdm3.getIsca());
					dfile.setFkbz(tjgdm3.getFkbz());
					dfile.setFksl(tjgdm3.getFksl());
					dfile.setIsxw(tjgdm3.getIsxw());
					dfile.setEmail(tjgdm3.getEmail());
					dfile.setWeburl(tjgdm3.getWeburl());
					dfile.setMobile(tjgdm3.getMobile());
					dfile.setYjflag(tjgdm3.getYjflag());
					dfile.setTbrxm(tjgdm3.getTbrxm());
					dfile.setTbrsfzh(tjgdm3.getTbrsfzh());
					dfile.setTbrlxfs(tjgdm3.getTbrlxfs());
					dfile.setJydz(tjgdm3.getJydz());
					dfile.setJyyb(tjgdm3.getJyyb());
					dfile.setJydh(tjgdm3.getJydh());
					dfile.setJfly(tjgdm3.getJfly());
					dfile.setKhyh(tjgdm3.getKhyh());
					dfile.setKhzh(tjgdm3.getKhzh());
					dfile.setZsbfrq(tjgdm3.getZsbfrq());
					dfile.setZszfrq(tjgdm3.getZszfrq());
					dfile.setFbsl(tjgdm3.getFbsl());
					dfile.setZbsl(tjgdm3.getZbsl());
					dfile.setBzrq(tjgdm3.getBzrq());
					dfile.setZfrq(tjgdm3.getZfrq());
					dfile.setZslsh(tjgdm3.getZslsh());
					dfile.setNjr(tjgdm3.getNjr());
					dfile.setNjrq(tjgdm3.getNjrq());
					dfile.setNjqx(tjgdm3.getNjqx());
					dfile.setJjlx(tjgdm3.getJjlx());
					dfile.setJjlxdm(tjgdm3.getJjlxdm());
					dfile.setJjlxOld(tjgdm3.getJjlxOld());
					dfile.setJjlxdmOld(tjgdm3.getJjlxdmOld());
					dfile.setJjhymc(tjgdm3.getJjhymc());
					dfile.setJjhydm(tjgdm3.getJjhydm());
					dfile.setJjhymcOld(tjgdm3.getJjhymcOld());
					dfile.setJjhydmOld(tjgdm3.getJjhydmOld());
					dfile.setZgdm(tjgdm3.getZgdm());
					dfile.setMemo(tjgdm3.getMemo());
					dfile.setTbrzjlx(tjgdm3.getTbrzjlx());
					dfile.setMemo2(tjgdm3.getMemo2());
					dfile.setHbzl(tjgdm3.getHbzl());
					dfile.setHbzldm(tjgdm3.getHbzldm());
					dfile.setLastdate(tjgdm3.getLastdate());
					dfile.setXgr(tjgdm3.getXgr());
					dfile.setBgrq(tjgdm3.getBgrq());
					dfile.setUserid(tjgdm3.getUserid());
					dfile.setName(tjgdm3.getName());
					dfile.setImageUrl(tjgdm3.getImageUrl());
					dfile.setUsername(tjgdm3.getUsername());
					dfile.setYwlx(tjgdm3.getYwlx());
					dfile.setState(newState);
					dfile.setBzjgdm(tjgdm3.getBzjgdm());
					dfile.setHandleUserid(tjgdm3.getHandleUserid());
					dfile.setHandleUsername(tjgdm3.getHandleUsername());
					dfile.setHandleName(tjgdm3.getHandleName());
					dfile.setHandleDate(tjgdm3.getHandleDate());
					dfile.setHandleNote(tjgdm3.getHandleNote());
					dfile.setAuditUserid(tjgdm3.getAuditUserid());
					dfile.setAuditUsername(tjgdm3.getAuditUsername());
					dfile.setAuditName(tjgdm3.getAuditName());
					dfile.setAuditDate(tjgdm3.getAuditDate());
					dfile.setAuditNote(tjgdm3.getAuditNote());
					dfile.setMoveoutCenter(tjgdm3.getMoveoutCenter());
					dfile.setMoveoutBzjgdm(tjgdm3.getMoveoutBzjgdm());
					dfile.setMoveoutAddrss(tjgdm3.getMoveoutAddrss());
					dfile.setMoveoutReason(tjgdm3.getMoveoutReason());
					dfile.setMoveoutNote(tjgdm3.getMoveoutNote());
					dfile.setOffPzjgmc(tjgdm3.getOffPzjgmc());
					dfile.setOffPzwh(tjgdm3.getOffPzwh());
					dfile.setOffReason(tjgdm3.getOffReason());
					dfile.setOffNote(tjgdm3.getOffNote());
					dfile.setD_flag(1);
					dfile.setUp_Dflag(tjgdm3.getUp_Dflag());
					//dfile.setUp_Aflag(tjgdm3.getUp_Aflag());
					dfile.setImageData("");
					dfile.setPageTypeStr(tjgdm3.getPageTypeStr());
					dfile.setXgr(tjgdm3.getXgr());
					dfile.setDybz(null);
					dfile.setPigeTime(new Date());
					Integer newOrgid=(Integer) dfileDao.saveDfile(dfile);
					
					if(newOrgid!=null){
						flag = orgnewDao.deleteById(intOrgid);
						if(flag!=null){
							//更改用户状态改为7已办证,且把机构代码号赋为用户
							//已建档后的用户状态都为7
							userid=orgnew.getUserid();
							if(userid!=null){
								Zuser zuser = new Zuser();
								if(strYwlx=="注销" || "注销".equals(strYwlx)){
									zuser.setState("-1");  //用户注销
								}else{
									zuser.setState("7");
								}
								zuser.setOrgCode(orgnew.getJgdm());
								zuser.setUserid(userid);
								flag = zuserDao.update(zuser);
							}
						}
					}
				}
			}
		}
			
		return flag == null ? false:true;
	}
	
	//打印
	public boolean returnOrgnewPrint(Orgnew orgnew) throws Exception {
		Integer strOrgid=orgnew.getOrgid();
		
		String strPrinterId=orgnew.getHandleUsername();
		String strPrinterName=orgnew.getHandleName();
		
		Orgnew orgnew2 = new Orgnew();
		orgnew2 = orgnewDao.findById(orgnew.getOrgid());
		orgnew2.setDybz("N");  //已经打印标志
		orgnew2.setHandleUsername(null); 
		orgnew2.setHandleName(null); 
		Integer flag = orgnewDao.update(orgnew2);
		
		if (null != flag) {
			String strCenterid=orgnew2.getCenterid();
			String strOrgName=orgnew2.getJgmc();
			String strOrgCode=orgnew2.getJgdm();
			String strOrderId=orgnew2.getOrderid();
			
			PrintLog printLog = new PrintLog();
			printLog.setCenterId(strCenterid);
			printLog.setOrderId(strOrderId);
			printLog.setOrgId(strOrgid);
			printLog.setOrgName(strOrgName);
			printLog.setOrgCode(strOrgCode);
			printLog.setPrintTime(new Date());
			printLog.setPrinterId(strPrinterId);
			printLog.setPrinterName(strPrinterName);
			printLog.setPrintTime(new Date());
	
 			Integer logId = (Integer) printLogDao.savePrintLog(printLog,orgnew2.getBzjgdm());
			
			//更改用户状态改为7已办证完毕
			Zuser zuser = new Zuser();
			zuser.setState("7");
			zuser.setUserid(orgnew.getUserid());
			flag = zuserDao.update(zuser);
			
			PrintLog printLog2 = new PrintLog();
			printLogDao.findById(logId);
			orgnew2.setMemo4(printLog2.getPrintCode());
		}
		return flag == null ? false:true;
}
	
	

	//现场业务办理的提交办理
	public boolean returnOrgnewDo(Orgnew orgnew,boolean f) throws Exception {
		Integer intOrgid=Integer.valueOf(orgnew.getOrgid());
		String handleUserid=orgnew.getHandleUserid();
		String handleUsername=orgnew.getHandleUsername();
		String handleName=orgnew.getHandleName();
		
		String lry=orgnew.getLry();
		String lrName=orgnew.getLrName();
		
		orgnew = orgnewDao.findById(intOrgid);
		Integer inte=Integer.parseInt(orgnew.getState());
		System.out.println("inte:::::::::::::"+inte);
        String  strYwlx=orgnew.getYwlx();
		//把State由字符转为数字
		Integer newUserState=0;
		String strDybz="";
		Integer flag=null;
		@SuppressWarnings("unused")
		Integer newOrgid=null;
		//strYwlx=="年检" || "年检".equals(strYwlx) || strYwlx=="迁出" || "迁出".equals(strYwlx)  || strYwlx=="预赋码" || "预赋码".equals(strYwlx) || strYwlx=="注销" || "注销".equals(strYwlx)
		if(strYwlx=="年检" || "年检".equals(strYwlx) || strYwlx=="迁出" || "迁出".equals(strYwlx) || strYwlx=="注销" || "注销".equals(strYwlx)){
			strDybz="N";	//不要打印
		}else if(strYwlx=="预赋码" || "预赋码".equals(strYwlx)){
			
			strDybz = orgnew.getState();
			if(strDybz.trim().equals("12")){
				strDybz="Y";
			}else{
				strDybz="N";
			}
			
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

		
		switch(inte) {
		case 5: 
			inte=inte+1;
			newUserState=inte+1;
			break;
		case 10: //扫描提交
			inte=inte+2;
			newUserState=inte+3;
			break;
		case 11: //扫描被驳回后，再提交
			inte=inte+1;
			newUserState=inte+1;
			break; 
		case 12: //新业务提交
			appSysConfig = ActionContext.getContext().getApplication();
			if("1".equals(appSysConfig.get("sysXcWorkMode"))){
				boolean isShenheFlag=false;
				List ywxcList = new ArrayList();
				ywxcList=(List)ActionContext.getContext().getSession().get("ywxcList");
				for (int j = 0; j < ywxcList.size(); j++) {
					Qx qx=new Qx();
					qx=(Qx)ywxcList.get(j);
					String strYwlxSet=qx.getYwlx();
					String strShbz=String.valueOf(qx.getShbz());
					if(strYwlx.equals(strYwlxSet)){//判断此业务类型需要审批
						if("0".equals(strShbz)){
							isShenheFlag=true;
							break;
						}else{
							List jglxList = new ArrayList();
							jglxList=(List)appSysConfig.get("jglxList");
							for (int i = 0; i < jglxList.size(); i++) {
								Jglx jglx=new Jglx();
								jglx=(Jglx)jglxList.get(i);
								String strJglxSet=jglx.getJglxdm();
								if(strJglxSet.equals(orgnew.getJglxdm())){//判断机构类型
									isShenheFlag=true;
									break;
								}
							}
						}

					}
				}
				
				if(isShenheFlag){//是否需要审核
					inte=13;
				}else{
					if(orgnew.getJgdm()=="" || "".equals(orgnew.getJgdm())){
						inte=15;
					}else{
						inte=16;
					}
				}
						
			}else{
				if(orgnew.getJgdm()=="" || "".equals(orgnew.getJgdm())){
					inte=15;
				}else{
					inte=16;
				}
			}
			newUserState=inte+3;
			break;
		case 14: //驳回后，再提交
			appSysConfig = ActionContext.getContext().getApplication();
			if("1".equals(appSysConfig.get("sysXcWorkMode"))){

				boolean isShenheFlag=false;
				
				List ywxcList = new ArrayList();
				ywxcList=(List)ActionContext.getContext().getSession().get("ywxcList");
				for (int j = 0; j < ywxcList.size(); j++) {
					Qx qx=new Qx();
					qx=(Qx)ywxcList.get(j);
					String strYwlxSet=qx.getYwlx();
					String strShbz=String.valueOf(qx.getShbz());
					if(strYwlx.equals(strYwlxSet)){//判断此业务类型需要审批
						if("0".equals(strShbz)){
							isShenheFlag=true;
							break;
						}else{
							List jglxList = new ArrayList();
							jglxList=(List)appSysConfig.get("jglxList");
							for (int i = 0; i < jglxList.size(); i++) {
								Jglx jglx=new Jglx();
								jglx=(Jglx)jglxList.get(i);
								String strJglxSet=jglx.getJglxdm();
								if(strJglxSet.equals(orgnew.getJglxdm())){//判断机构类型
									isShenheFlag=true;
									break;
								}
							}
						}

					}
				}
				
				if(isShenheFlag){//是否需要审核
					inte=13;
				}else{
					if(orgnew.getJgdm()=="" || "".equals(orgnew.getJgdm())){
						inte=15;
					}else{
						inte=16;
					}
				}
			}else{
				if(orgnew.getJgdm()=="" || "".equals(orgnew.getJgdm())){
					inte=15;
				}else{
					inte=16;
				}
			}
			newUserState=inte+3;
			break;
		case 15: //赋码后，再提交
			inte=16;
			newUserState=inte+1;
			break; 
		default: 
			System.out.println("工单审查驳回错误！");
		}
		
		Orgnew orgnew2=new Orgnew();
		//转换数字状态为字符串
		String newState=String.valueOf(inte);
		orgnew2.setOrgid(orgnew.getOrgid());
		orgnew2.setState(newState);
		orgnew2.setDybz(strDybz);
		/*
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		d = sdf.parse(sdf.format(d));
		*/
		if(strYwlx.equals("年检")||strYwlx.equals("新办")||strYwlx.equals("换证")||strYwlx.equals("年检")){
			orgnew2.setNjrq(new Date());
		}else{
			if(strYwlx.equals("变更") && strDybz.equals("Y")){
				orgnew2.setNjrq(new Date());
			}else{
				orgnew2.setNjrq(null);
			}
		}
		if("10".equals(newState)){
			orgnew2.setLry(lry);// 设置审核人用户名
			orgnew2.setLrName(lrName);// 设置审核人姓名
			orgnew2.setLrDate(new Date());// 设置审核日期
		}else{
			orgnew2.setHandleUsername(handleUsername);// 设置审核人用户名
			orgnew2.setHandleName(handleName);// 设置审核人姓名
			orgnew2.setHandleUserid(handleUserid);// 设置审核人用户ID
			orgnew2.setHandleDate(new Date());// 设置审核日期
		}
		//System.out.println("提交方法需要传递的bzjgdm：：："+orgnew.getBzjgdm());
		/*if(!(f&&orgnew.getYwlx().equals("年检"))){
			orgnew2.setBzjgdm(orgnew.getBzjgdm());
		}
		*/
		System.out.println(orgnew.getBzjgdm());
		System.out.println(orgnew2.getBzjgdm());
		orgnew2.setBzjgdm(orgnew.getBzjgdm());
		flag = orgnewDao.update(orgnew2);
		if(inte==4){
			if(flag!=null){
				if(orgnew.getUserid()!=null){
					Zuser zuser = new Zuser();
					zuser.setUserid(orgnew.getUserid());
					zuser.setState(String.valueOf(newUserState));  
					zuserDao.update(zuser);
				}
			}
		}
		
        
		//更改用户状态改为需办证,且把机构代码号赋为用户
		return flag == null ? false:true;
	}
	
	//现场业务(分中心)审核驳回NO
	public boolean shenheOrgnewNo(Orgnew orgnew) throws Exception {
		String newAuditUsername=orgnew.getAuditUsername();
		String newAuditUserid=String.valueOf(orgnew.getAuditUserid());
		String newAuditName=orgnew.getAuditName();
		String newAuditNote= orgnew.getAuditNote();
		orgnew = orgnewDao.findById(orgnew.getOrgid());
		//把State由字符转为数字
		String inter=orgnew.getState();	
		
		String newState="13";
		String newUserState="0";
		if("13".equals(inter)){ 
			newState="14";
			newUserState="3";
		}
		
		Zuser zuser = new Zuser();
		zuser.setUserid(orgnew.getUserid());
		zuser.setOrgid(orgnew.getOrgid());
		zuser.setState(newUserState);  
		Integer flag=zuserDao.update(zuser);
		
		if(flag!=null){
			orgnew.setState(newState);
			orgnew.setAuditUserid(String.valueOf(newAuditUserid));// 设置审核人USERID
			orgnew.setAuditUsername(newAuditUsername);// 设置审核人用户名
			orgnew.setAuditName(newAuditName);// 设置审核人姓名
			orgnew.setAuditNote(newAuditNote);
			orgnew.setAuditDate(new Date());// 设置审核日期
			flag = orgnewDao.update(orgnew);
		}
		return flag == null ? false:true;
		
	}
	
	//现场业务(分中心)审核通过OK
	public boolean shenheOrgnewOk(Orgnew orgnew) throws Exception {
		String newAuditUsername=orgnew.getAuditUsername();
		String newAuditUserid=orgnew.getAuditUserid();
		String newAuditName=orgnew.getAuditName();
		String newAuditNote= orgnew.getAuditNote();
		orgnew = orgnewDao.findById(orgnew.getOrgid());
		//此处应该监测机构名称是否存在????????yangqi 
       
		String strJgdm=orgnew.getJgdm();
		String inter=orgnew.getState(); 
		String newState="13";
		String newUserState="0";
		if("13".equals(inter)){
			if("".equals(strJgdm) || strJgdm==""){
				newState="15";
				newUserState="2";
			}else{
				newState="16";
				newUserState="2";
			}
		}
		
		Zuser zuser = new Zuser();
		zuser.setUserid(orgnew.getUserid());
		zuser.setOrgid(orgnew.getOrgid());
		zuser.setState(newUserState);  
		Integer flag=zuserDao.update(zuser);
		
		if(flag!=null){
			orgnew.setState(newState);
			orgnew.setAuditUserid(String.valueOf(newAuditUserid));
			orgnew.setAuditUsername(newAuditUsername);// 设置审核人用户名
			orgnew.setAuditName(newAuditName);// 设置审核人姓名
			orgnew.setAuditNote(newAuditNote);
			orgnew.setAuditDate(new Date());
			flag = orgnewDao.update(orgnew);
		}

		return flag == null ? false:true;
	}
	
	public Object saveOrgnewModify(Orgnew orgnew) {
		String strYwlx=orgnew.getYwlx();
		String strDybz="";
		if(strYwlx!="清整" && !"清整".equals(strYwlx) ){
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
		return orgnewDao.saveOrgnew(orgnew);
	}

	public boolean updateOrgnewModify(Orgnew orgnew) throws Exception {
		
			String strYwlx=orgnew.getYwlx();
			if(strYwlx!="清整" && !"清整".equals(strYwlx) ){
				Orgnew o = orgnewDao.findByOrgnewJgdm(orgnew.getJgdm());
				orgnew.setDybz(o.getDybz());
			}else{
				String strDybz="";
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
				orgnew.setDybz(strDybz);
			}
			/*String strYwlx=orgnew.getYwlx();
			String strDybz="";
			if(strYwlx!="清整" && !"清整".equals(strYwlx) ){
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
			orgnew.setDybz(strDybz);*/
		
		Integer flag = orgnewDao.update(orgnew);
		if (null != flag) {
			return true;
		}
		return false;
	}
	
	//数据清整的提交办理
	//如是对业务库z_org_new数据，办理清整确认的，则办理完毕不用打印,且不用更新大库
	//如对大库z_tjgdm数据，办理确认的，则更新大库
	public boolean returnOrgnewModify(Orgnew orgnew) throws Exception {
		Integer intOrgid=Integer.valueOf(orgnew.getOrgid());
		orgnew = orgnewDao.findById(intOrgid);
        String strYwlx=orgnew.getYwlx();
        String strDybz="N";
		Integer flag=null;
					
		if(strYwlx!="清整" && !"清整".equals(strYwlx) ){
			//strDybz="N";//为不要打印
			orgnew.setOrgid(orgnew.getOrgid());
			orgnew.setDybz(strDybz);
			flag = orgnewDao.update(orgnew);
		}

		if("清整".equals(strYwlx) || strYwlx=="清整"){
			
				Tjgdm tjgdm4 = new Tjgdm();
				tjgdm4.setOrderid(orgnew.getOrderid());
				tjgdm4.setDocid(orgnew.getDocid());
				tjgdm4.setJgmc(orgnew.getJgmc());
				tjgdm4.setJgdm(orgnew.getJgdm());
				tjgdm4.setJglx(orgnew.getJglx());
				tjgdm4.setJglxdm(orgnew.getJglxdm());
				tjgdm4.setJglxOld(orgnew.getJglxOld());
				tjgdm4.setJglxdmOld(orgnew.getJglxdmOld());
				tjgdm4.setFddbr(orgnew.getFddbr());
				tjgdm4.setZjlx(orgnew.getZjlx());
				tjgdm4.setZjhm(orgnew.getZjhm());
				tjgdm4.setQyjj(orgnew.getQyjj());
				tjgdm4.setJyfw(orgnew.getJyfw());
				tjgdm4.setZcrq(orgnew.getZcrq());
				tjgdm4.setXzqhCode(orgnew.getXzqhCode());
				tjgdm4.setXzqhName(orgnew.getXzqhName());
				tjgdm4.setXzqhCode2(orgnew.getXzqhCode2());
				tjgdm4.setXzqhName2(orgnew.getXzqhName2());
				tjgdm4.setJgdz(orgnew.getJgdz());
				tjgdm4.setYzbm(orgnew.getYzbm());
				tjgdm4.setDhhm(orgnew.getDhhm());
				tjgdm4.setScbzrq(orgnew.getScbzrq());
				tjgdm4.setZycp1(orgnew.getZycp1());
				tjgdm4.setZycp2(orgnew.getZycp2());
				tjgdm4.setZycp3(orgnew.getZycp3());
				tjgdm4.setZczj(orgnew.getZczj());
				tjgdm4.setWftzgb(orgnew.getWftzgb());
				tjgdm4.setWftzgbdm(orgnew.getWftzgbdm());
				tjgdm4.setZgrs(orgnew.getZgrs());
				tjgdm4.setLry(orgnew.getLry());
				tjgdm4.setZch(orgnew.getZch());
				tjgdm4.setQzbz(orgnew.getQzbz());
				tjgdm4.setQzrq(orgnew.getQzrq() );
				tjgdm4.setZgmc(orgnew.getZgmc());
				tjgdm4.setPzjgmc(orgnew.getPzjgmc());
				tjgdm4.setPzjgdm(orgnew.getPzjgdm());
				tjgdm4.setPzwh(orgnew.getPzwh());
				tjgdm4.setPwrq(orgnew.getPwrq());
				tjgdm4.setGk(orgnew.getGk());
				tjgdm4.setIsca(orgnew.getIsca());
				tjgdm4.setFkbz(orgnew.getFkbz());
				tjgdm4.setFksl(orgnew.getFksl());
				tjgdm4.setIsxw(orgnew.getIsxw());
				tjgdm4.setEmail(orgnew.getEmail());
				tjgdm4.setWeburl(orgnew.getWeburl());
				tjgdm4.setMobile(orgnew.getMobile());
				tjgdm4.setYjflag(orgnew.getYjflag());
				tjgdm4.setTbrxm(orgnew.getTbrxm());
				tjgdm4.setTbrsfzh(orgnew.getTbrsfzh());
				tjgdm4.setTbrlxfs(orgnew.getTbrlxfs());
				tjgdm4.setJydz(orgnew.getJydz());
				tjgdm4.setJyyb(orgnew.getJyyb());
				tjgdm4.setJydh(orgnew.getJydh());
				tjgdm4.setJfly(orgnew.getJfly());
				tjgdm4.setKhyh(orgnew.getKhyh());
				tjgdm4.setKhzh(orgnew.getKhzh());
				tjgdm4.setZsbfrq(orgnew.getZsbfrq());
				tjgdm4.setZszfrq(orgnew.getZszfrq());
				tjgdm4.setFbsl(orgnew.getFbsl());
				tjgdm4.setZbsl(orgnew.getZbsl());
				tjgdm4.setBzrq(orgnew.getBzrq());
				tjgdm4.setZfrq(orgnew.getZfrq());
				tjgdm4.setZslsh(orgnew.getZslsh());
				tjgdm4.setNjr(orgnew.getNjr());
				tjgdm4.setNjrq(orgnew.getNjrq());
				tjgdm4.setNjqx(orgnew.getNjqx());
				tjgdm4.setJjlx(orgnew.getJjlx());
				tjgdm4.setJjlxdm(orgnew.getJjlxdm());
				tjgdm4.setJjlxOld(orgnew.getJjlxOld());
				tjgdm4.setJjlxdmOld(orgnew.getJjlxdmOld());
				tjgdm4.setJjhymc(orgnew.getJjhymc());
				tjgdm4.setJjhydm(orgnew.getJjhydm());
				tjgdm4.setJjhymcOld(orgnew.getJjhymcOld());
				tjgdm4.setJjhydmOld(orgnew.getJjhydmOld());
				tjgdm4.setZgdm(orgnew.getZgdm());
				tjgdm4.setTbrzjlx(orgnew.getTbrzjlx());
				tjgdm4.setMemo(orgnew.getMemo());
				tjgdm4.setMemo2(orgnew.getMemo2());
				tjgdm4.setHbzl(orgnew.getHbzl());
				tjgdm4.setHbzldm(orgnew.getHbzldm());
				tjgdm4.setLastdate(orgnew.getLastdate());
				tjgdm4.setXgr(orgnew.getXgr());
				tjgdm4.setBgrq(orgnew.getBgrq());
				tjgdm4.setUserid(orgnew.getUserid());
				tjgdm4.setName(orgnew.getName());
				tjgdm4.setImageUrl(orgnew.getImageUrl());
				tjgdm4.setUsername(orgnew.getUsername());
				tjgdm4.setYwlx(null);
				tjgdm4.setPageTypeStr(orgnew.getPageTypeStr());
				//tjgdm4.setDybz(orgnew.getDybz());
				tjgdm4.setDybz(strDybz);
				tjgdm4.setState(null);
				tjgdm4.setBzjgdm(orgnew.getBzjgdm());
				tjgdm4.setUp_Dflag(0);
	
				flag = tjgdmDao.update(tjgdm4);
				
				if(flag==1){
					Dfile dfile = new Dfile();
					dfile.setOrderid(orgnew.getOrderid());
					dfile.setDocid(orgnew.getDocid());
					dfile.setJgmc(orgnew.getJgmc());
					dfile.setJgdm(orgnew.getJgdm());
					dfile.setJglx(orgnew.getJglx());
					dfile.setJglxdm(orgnew.getJglxdm());
					dfile.setJglxOld(orgnew.getJglxOld());
					dfile.setJglxdmOld(orgnew.getJglxdmOld());
					dfile.setFddbr(orgnew.getFddbr());
					dfile.setZjlx(orgnew.getZjlx());
					dfile.setZjhm(orgnew.getZjhm());
					dfile.setQyjj(orgnew.getQyjj());
					dfile.setJyfw(orgnew.getJyfw());
					dfile.setZcrq(orgnew.getZcrq());
					dfile.setXzqhCode(orgnew.getXzqhCode());
					dfile.setXzqhName(orgnew.getXzqhName());
					dfile.setXzqhCode2(orgnew.getXzqhCode2());
					dfile.setXzqhName2(orgnew.getXzqhName2());
					dfile.setJgdz(orgnew.getJgdz());
					dfile.setYzbm(orgnew.getYzbm());
					dfile.setDhhm(orgnew.getDhhm());
					dfile.setScbzrq(orgnew.getScbzrq());
					dfile.setZycp1(orgnew.getZycp1());
					dfile.setZycp2(orgnew.getZycp2());
					dfile.setZycp3(orgnew.getZycp3());
					dfile.setZczj(orgnew.getZczj());
					dfile.setWftzgb(orgnew.getWftzgb());
					dfile.setWftzgbdm(orgnew.getWftzgbdm());
					dfile.setZgrs(orgnew.getZgrs());
					dfile.setLry(orgnew.getLry());
					dfile.setZch(orgnew.getZch());
					dfile.setQzbz(orgnew.getQzbz());
					dfile.setQzrq(orgnew.getQzrq() );
					dfile.setZgmc(orgnew.getZgmc());
					dfile.setPzjgmc(orgnew.getPzjgmc());
					dfile.setPzjgdm(orgnew.getPzjgdm());
					dfile.setPzwh(orgnew.getPzwh());
					dfile.setPwrq(orgnew.getPwrq());
					dfile.setGk(orgnew.getGk());
					dfile.setIsca(orgnew.getIsca());
					dfile.setFkbz(orgnew.getFkbz());
					dfile.setFksl(orgnew.getFksl());
					dfile.setIsxw(orgnew.getIsxw());
					dfile.setEmail(orgnew.getEmail());
					dfile.setWeburl(orgnew.getWeburl());
					dfile.setMobile(orgnew.getMobile());
					dfile.setYjflag(orgnew.getYjflag());
					dfile.setTbrxm(orgnew.getTbrxm());
					dfile.setTbrsfzh(orgnew.getTbrsfzh());
					dfile.setTbrlxfs(orgnew.getTbrlxfs());
					dfile.setJydz(orgnew.getJydz());
					dfile.setJyyb(orgnew.getJyyb());
					dfile.setJydh(orgnew.getJydh());
					dfile.setJfly(orgnew.getJfly());
					dfile.setKhyh(orgnew.getKhyh());
					dfile.setKhzh(orgnew.getKhzh());
					dfile.setZsbfrq(orgnew.getZsbfrq());
					dfile.setZszfrq(orgnew.getZszfrq());
					dfile.setFbsl(orgnew.getFbsl());
					dfile.setZbsl(orgnew.getZbsl());
					dfile.setBzrq(orgnew.getBzrq());
					dfile.setZfrq(orgnew.getZfrq());
					dfile.setZslsh(orgnew.getZslsh());
					dfile.setNjr(orgnew.getNjr());
					dfile.setNjrq(orgnew.getNjrq());
					dfile.setNjqx(orgnew.getNjqx());
					dfile.setJjlx(orgnew.getJjlx());
					dfile.setJjlxdm(orgnew.getJjlxdm());
					dfile.setJjlxOld(orgnew.getJjlxOld());
					dfile.setJjlxdmOld(orgnew.getJjlxdmOld());
					dfile.setJjhymc(orgnew.getJjhymc());
					dfile.setJjhydm(orgnew.getJjhydm());
					dfile.setJjhymcOld(orgnew.getJjhymcOld());
					dfile.setJjhydmOld(orgnew.getJjhydmOld());
					dfile.setZgdm(orgnew.getZgdm());
					dfile.setTbrzjlx(orgnew.getTbrzjlx());
					dfile.setMemo(orgnew.getMemo());
					dfile.setMemo2(orgnew.getMemo2());
					dfile.setHbzl(orgnew.getHbzl());
					dfile.setHbzldm(orgnew.getHbzldm());
					dfile.setLastdate(orgnew.getLastdate());
					dfile.setXgr(orgnew.getXgr());
					dfile.setBgrq(orgnew.getBgrq());
					dfile.setUserid(orgnew.getUserid());
					dfile.setName(orgnew.getName());
					dfile.setImageUrl(orgnew.getImageUrl());
					dfile.setUsername(orgnew.getUsername());
					dfile.setYwlx(null);
					dfile.setPageTypeStr(orgnew.getPageTypeStr());
					//dfile.setDybz(orgnew.getDybz());
					dfile.setDybz(strDybz);
					dfile.setState(null);
					dfile.setBzjgdm(orgnew.getBzjgdm());
					dfile.setUp_Dflag(0);
		
					flag = dfileDao.updateDfileByDocid(dfile);
					if(flag==0){
						flag = dfileDao.updateArchiveByDocid(dfile);
					}
					flag = orgnewDao.deleteById(intOrgid);
				}
		}
		//更改
		return flag == 0 ? false:true;
	}
	
	public boolean returnOrgnewGo(Orgnew orgnew) throws Exception {
		orgnew = orgnewDao.findById(orgnew.getOrgid());
		//yangqi需要判断 ?????????????
		//String strState=orgnew.getState();	
		//if(strState=="6"){
			orgnew.setState("7");
			//orgnew.setCurrentReader("");// 清空当前日志
			//orgnew.setCurrentReaderId(0);
			Integer flag = orgnewDao.update(orgnew);
			//LoanLog loanLog = new LoanLog();
			//loanLog.setLogId(orgnew.getLogId());
			//loanLog.setReturnTime(new Date());
			//flag = loanLogDao.update(loanLog);
			//return flag == null ? false:true;
			return flag == null ? false:true;
		//}else{
		//	return false;
		//}	
	}

	public boolean updateDybzByOrgid(Orgnew orgnew) {
		// TODO Auto-generated method stub
		
		Integer flag = orgnewDao.updateDybzByOrgid(orgnew);
		
		return flag == null ? false:true;
	}

	@Override
	public String findByOrgnew(Orgnew orgnew) {
		// TODO Auto-generated method stub
		return orgnewDao.findByOrgnew(orgnew);
	}

	@Override
	public Page findAllExcpOrgnew(Page page) {
		// TODO Auto-generated method stub
		page.setRoot(orgnewDao.findAllExcpOrgnew(page));
		page.setTotalProperty(orgnewDao.findAllExcpOrgnewCount(page));
		return page;
	}

	@Override
	public boolean updateExceptionOrgnew(Orgnew orgnew) throws Exception {
		// TODO Auto-generated method stub
		Integer flag = orgnewDao.updateExceptionOrgnew(orgnew);
		return flag == null ? false:true;
	}

	@Override
	public boolean delExceptionOrgnew(Integer orgid) {
		// TODO Auto-generated method stub
		Integer flag = orgnewDao.deleteById(orgid);
		return flag == null ? false:true;
	}

	
	public Page findByQxPage(Page page) {
		page.setRoot(orgnewDao.findByQxPage(page));
		page.setTotalProperty(orgnewDao.findByQxCount(page));
		return page;
	}

	
	public Page findByYwqxPage(Page page) {
		page.setRoot(orgnewDao.findByYwqxPage(page));
		page.setTotalProperty(orgnewDao.findByYwqxCount(page));
		return page;
	}

	@Override
	public boolean validateJgmc(Orgnew orgnew) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List l = orgnewDao.validateJgmc(orgnew);
		System.out.println("跟踪是docid：："+orgnew.getDocid());
		if(orgnew.getDocid()==null||orgnew.getDocid().trim().equals("")){
			System.out.println("第一次保存查重");
			if(l.size()<1){
				flag = true;
			}
		}else{
			System.out.println("第二次保存查重");
			System.out.println("查询到的数据条数："+l.size());
			if(l.size()==1){
				Orgnew o = new Orgnew();
				o = (Orgnew) l.get(0);
				System.out.println(o.getDocid().equals(orgnew.getDocid()));
				if(o.getDocid().equals(orgnew.getDocid())){
					flag = true;
				}
			}else if(l.size()==0){
				flag = true;
			}
		}
		return flag;
	}
}
