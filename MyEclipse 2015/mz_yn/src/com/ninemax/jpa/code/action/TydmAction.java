package com.ninemax.jpa.code.action;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletResponse;

import net.sf.cglib.beans.BeanCopier;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import sun.misc.BASE64Encoder;
import com.ninemax.jpa.code.action.GSDataAction;
import com.ninemax.jpa.code.action.ScanTaskAction;
import com.ninemax.jpa.code.model.Page;
import com.ninemax.jpa.code.model.TBgk;
import com.ninemax.jpa.code.model.TBgk_tydm;
import com.ninemax.jpa.code.model.TFzdm_tydm;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.code.model.TJgdm_tydm;
import com.ninemax.jpa.code.model.TSpdmtemp;
import com.ninemax.jpa.code.model.XTtyshxydm;
import com.ninemax.jpa.global.CheckEntityManagerHelper;
import com.ninemax.jpa.global.CodeEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.CommonPropertiesUtil;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.ImageUtil;
import com.ninemax.jpa.util.UserPropertiesData;
import com.ninemax.tygs.bus.TyGsBus;
import com.ninemax.tygs.dao.TyGsDao;
import com.ninemax.tygs.model.TDmsj;
import com.ninemax.tygs.model.TGssj;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 工商统一版本action
 * TyGsAction
 * @author LP
 * 2015-5-28 下午02:23:28
 * Version @1.0
 */
public class TydmAction extends ActionSupport implements SessionAware {
	private static Logger log = Logger.getLogger(TydmAction.class);

	
	public String currentPath;
	private Page page;
	

	public List<XTtyshxydm> gsList;
	public TJgdm_tydm jgdm;
	public XTtyshxydm gsdm;
	public TJgdmSave jgdmSave;
	public String reason;
	public String jglx;
	public String source;
	public List<TJgdm_tydm> jgdms;
	public String dm;
	
	public String resultMsg;
	public Date startDate;
	public Date endDate;
	public String args;
	public String hb;
	public String gb;
	public Integer zt=null;
	public TDmsj dmsj;
	public String tydm;
	public Integer gsId;
	public String ywlx;

	private static ArrayList filelist = new ArrayList();
	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	
	private Map<String, Object> session;
	
    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
	
	/**
	 * 获取数据源
	 * LP
	 * 2015-5-28
	 * @return
	 * Version @1.0
	 */
	
	private EntityManager manager() {
		return EntityManagerHelper.getEntityManager();
	}

	private void closeEntityManager() {
		EntityManagerHelper.closeEntityManager();
	}
	
	/*static{
		List<GsBzjgdm> list=EntityManagerHelper.getEntityManager().createQuery("from GsBzjgdm bzjgdm ").getResultList();
		for(GsBzjgdm bz:list){
			bzjgdmMap.put( bz.getBzjgdm(),bz.getRegOrg());
		}
		
		EntityManagerHelper.getEntityManager().close();
	}
	
*/
	
	/**
	 * 工商数据列表
	 * fh
	 * 2015-6-1
	 * @return
	 * Version @1.0
	 */
	public String tyList() {
		currentPath = "/product/jsp/certificate/tydmList.jsp";
		try{
          if (page == null) {
                page = new Page();
                page.setOrderByType("desc");
            }
	          
          User user = (User) session.get("sysUser");
          
          String bzjgdm=user.getBzjgdm();
          
          //bzjgdm="620000";
          
          
          String sql="";
          if(gsdm!=null&&!"".equals(gsdm.getJgdm())){
        	  sql+=" and model.jgdm = '"+gsdm.getJgdm()+"'";
          }
          if(gsdm!=null&&!"".equals(gsdm.getJgmc())){
        	  sql+=" and model.jgmc = '"+gsdm.getJgmc()+"'";
          }
          if("0".equals(ywlx)){
          //sql+=user.getUserCareer()!=null&&user.getUserCareer().trim().equals("admin")?" and 1=1": " and model.dmjgbm in ("+bzdm+") ";
          gsList = manager().createQuery("from XTtyshxydm model where model.ywlx='0'"+sql+" and status=0").setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
            .getResultList();
            page.setTotalRecord(((Long) manager().createQuery(" select count(*)  from XTtyshxydm  model where model.ywlx='0'"+sql+" and status=0" )
            .getResultList().get(0)).intValue());
          }else if("1".equals(ywlx)){
        	   gsList = manager().createQuery("from XTtyshxydm model where model.ywlx='1'"+sql+" and status=0").setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
               .getResultList();
               page.setTotalRecord(((Long) manager().createQuery(" select count(*)  from XTtyshxydm  model where model.ywlx='1'"+sql+" and status=0" )
               .getResultList().get(0)).intValue());
          }else if("2".equals(ywlx)){
        	  
        	   gsList = manager().createQuery("from XTtyshxydm model where model.ywlx='2'"+sql+" and status=0").setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
               .getResultList();
               page.setTotalRecord(((Long) manager().createQuery(" select count(*)  from XTtyshxydm  model where model.ywlx='2'"+sql+" and status=0" )
               .getResultList().get(0)).intValue());
          }
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			log.error("查询工商数据列表出错");
			
		}finally{
			closeEntityManager();
		}
		return ERROR;

	}
	

	public String tyShow(){
		currentPath = "/product/jsp/certificate/showGs.jsp";
		
		try{
			
			gsList=manager().createQuery("from XTtyshxydm model where model.id=:id").setParameter("id", gsId).getResultList();
			if(gsList.size()>0){
				gsdm=gsList.get(0);
				jgdm=GsToDm(gsdm);
			}
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		
		return ERROR;
	}	
	public String addTjgdm(){
		currentPath = "/product/jsp/certificate/tydmSuccess.jsp";
			List<XTtyshxydm> tydmList=manager().createQuery("from XTtyshxydm model where model.id='"+gsId+"'").getResultList();
			XTtyshxydm info=tydmList.get(0);
			TJgdm_tydm jgdm=GsToDm(info);
			jgdm.setLastdate(new Date());
			jgdm.setZgrs(0);
			jgdm.setFbsl(0);
			jgdm.setZbsl(0);
			jgdm.setFksl(0);
			jgdm.setDybz("0");
			jgdms=manager().createQuery("from TJgdm_tydm model where model.jgdm='"+jgdm.getJgdm()+"'").getResultList();
			
			if(jgdms.size()>0){
				TJgdm_tydm dm=jgdms.get(0);
				addBg1(info, dm);
				
			}else{
				add(jgdm);
			}
			System.out.println(gsId);
			updateTydm(info);
			resultMsg="校对赋码成功!";
			return SUCCESS;
		}

	public void addBg1(XTtyshxydm info,TJgdm_tydm dm){
			boolean flag=false;
		
		
			TJgdm_tydm jgdm=GsToDm(info);
			jgdm.setLastdate(new Date());
			jgdm.setZgrs(0);
			jgdm.setFbsl(0);
			jgdm.setZbsl(0);
			jgdm.setFksl(0);
			jgdm.setDybz("0");
			/* List<Investor> zxList=EntityManagerHelper.getEntityManager().createQuery("from Investor where pripid='"+info.getPriPid()+"' and inv='"+info.getLeRep()+"' and cerType='1'").getResultList();
			 if(zxList.size()>0){
				 Investor inv=zxList.get(0);
				 jgdm.setZjlx("0");
				 jgdm.setZjhm(inv.getCerNo());
			 }*/
				TBgk_tydm bgk=new TBgk_tydm();
				BeanUtilsEx.copyProperties(bgk, dm);
				add(bgk);
				updateTJgdm(jgdm);
	}
	public String addBg(){
		currentPath = "/product/jsp/certificate/tydmSuccess.jsp";
		List<XTtyshxydm> tydmList=manager().createQuery("from XTtyshxydm model where model.id='"+gsId+"'").getResultList();
	
		XTtyshxydm info=tydmList.get(0);
	
		TJgdm_tydm jgdm=GsToDm(info);
		jgdm.setLastdate(new Date());
		jgdm.setZgrs(0);
		jgdm.setFbsl(0);
		jgdm.setZbsl(0);
		jgdm.setFksl(0);
		jgdm.setDybz("0");
		/* List<Investor> zxList=EntityManagerHelper.getEntityManager().createQuery("from Investor where pripid='"+info.getPriPid()+"' and inv='"+info.getLeRep()+"' and cerType='1'").getResultList();
		 if(zxList.size()>0){
			 Investor inv=zxList.get(0);
			 jgdm.setZjlx("0");
			 jgdm.setZjhm(inv.getCerNo());
		 }*/
		jgdms=manager().createQuery("from TJgdm_tydm model where model.jgdm='"+jgdm.getJgdm()+"'").getResultList();
			if(jgdms.size()>0){
				
				TBgk_tydm bgk=new TBgk_tydm();
				BeanUtilsEx.copyProperties(bgk, dm);
				add(bgk);
				
				updateTJgdm(jgdm);
				updateTydm(info);
				resultMsg="变更代码成功!";
			}else{
				resultMsg="主库没有找到该机构代码!";
			}
			return SUCCESS;
		
	
}
	public String addFz(){
		currentPath = "/product/jsp/certificate/tydmSuccess.jsp";
		List<XTtyshxydm> tydmList=manager().createQuery("from XTtyshxydm model where model.id='"+gsId+"'").getResultList();
		
		XTtyshxydm info=tydmList.get(0);
	
		TJgdm_tydm jgdm=GsToDm(info);
		jgdm.setLastdate(new Date());
		jgdm.setZgrs(0);
		jgdm.setFbsl(0);
		jgdm.setZbsl(0);
		jgdm.setFksl(0);
		jgdm.setDybz("0");
		/* List<Investor> zxList=EntityManagerHelper.getEntityManager().createQuery("from Investor where pripid='"+info.getPriPid()+"' and inv='"+info.getLeRep()+"' and cerType='1'").getResultList();
		 if(zxList.size()>0){
			 Investor inv=zxList.get(0);
			 jgdm.setZjlx("0");
			 jgdm.setZjhm(inv.getCerNo());
		 }*/
		jgdms=manager().createQuery("from TJgdm_tydm model where model.jgdm='"+jgdm.getJgdm()+"'").getResultList();
			if(jgdms.size()>0){
				TJgdm_tydm dm=jgdms.get(0);
				TFzdm_tydm fzdm=new TFzdm_tydm();
				BeanUtilsEx.copyProperties(fzdm, dm);
				add(fzdm);
				
				del(dm.getJgdm());
				updateTydm(info);
				resultMsg="注销代码成功!";
			}else{
				resultMsg="主库没有找到该机构代码!";
			}
			return SUCCESS;
		
	
}
	public TJgdm_tydm GsToDm(XTtyshxydm gsdm){
		TJgdm_tydm jgdm=new TJgdm_tydm();
		jgdm.setJgdm(gsdm.getJgdm());
		jgdm.setZch(gsdm.getZch());
		jgdm.setJgmc(gsdm.getJgmc());
		jgdm.setFddbr(gsdm.getFddbr());
		jgdm.setZjhm(gsdm.getZjhm());
		jgdm.setZjlx(gsdm.getZjlx());
		jgdm.setJyfw(gsdm.getJyfw());
		jgdm.setZcrq(gsdm.getZcrq());
		jgdm.setPzjgdm(gsdm.getPzjgdm());
		jgdm.setPzjgmc(gsdm.getPzjgmc());
		jgdm.setXzqh(gsdm.getXzqh());
		jgdm.setJgdz(gsdm.getJgdz());
		jgdm.setYzbm(gsdm.getYzbm());
		jgdm.setNnjjhy(gsdm.getJjhy2011());
		jgdm.setNnjjlx(gsdm.getJjlx2011());
		jgdm.setDhhm(gsdm.getDhhm());
		jgdm.setMobile(gsdm.getMobile());
		jgdm.setZczj(gsdm.getZczj());
		jgdm.setHbzl(gsdm.getHbzl());
		jgdm.setWftzgb(gsdm.getWftzgb());
		jgdm.setZgrs(gsdm.getZgrs());
		jgdm.setTbrxm(gsdm.getTbrxm());
		jgdm.setBzjgdm(gsdm.getBfdwxzqh());
		jgdm.setYwlx(gsdm.getYwlx());
		jgdm.setJyzt(gsdm.getJyzt());
		jgdm.setZgdm(gsdm.getZgdm());
		jgdm.setZgmc(gsdm.getZgmc());
		jgdm.setIsmini(gsdm.getIsmini());
		jgdm.setUrl(gsdm.getUrl());
		jgdm.setEmail(gsdm.getEmail());
		jgdm.setScjyxzqh(gsdm.getScjyxzqh());
		jgdm.setBgrq(gsdm.getBgrq());
		jgdm.setBzrq(gsdm.getBzrq());
		jgdm.setHsfs(gsdm.getHsfs());
		jgdm.setJhbz(gsdm.getJhbz());
		return jgdm;
	}
	public boolean del(String jgdm){
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean status=false;
		try{
			tx.begin();
			em.createQuery("delete TJgdm model where model.jgdm=:jgdm").setParameter("jgdm", jgdm).executeUpdate();
			em.flush();
			
			tx.commit();
			status=true;
		}catch(Exception e){
			status=false;
			e.printStackTrace();
		}finally{
			em.close();
		}
		
		return status;
		
	}
	public boolean updateTJgdm(TJgdm_tydm jgdm){
		EntityManager em =EntityManagerHelper.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean status=false;
		try{
			tx.begin();
			em.merge(jgdm);
			em.flush();
			
			tx.commit();
			status=true;
		}catch(Exception e){
			status=false;
			e.printStackTrace();
		}finally{
			em.close();
		}
		
		return status;
		
	}
	public boolean updateTydm(XTtyshxydm jgdm){
		EntityManager em =EntityManagerHelper.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean status=false;
		try{
			tx.begin();
			jgdm.setStatus("1");
			em.merge(jgdm);
			em.flush();
			
			tx.commit();
			status=true;
		}catch(Exception e){
			status=false;
			e.printStackTrace();
		}finally{
			em.close();
		}
		
		return status;
		
	}
	public boolean add(Object table){
		boolean flag = true;
		EntityManager em=EntityManagerHelper.getEntityManager();
		em.clear();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(table);
			tx.commit();
		} catch (Exception e) {
			flag = false;
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			log.error("error", e);
			log.error(e);
			return flag;
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
		return flag;
	}
	public String getCurrentPath() {
		return currentPath;
	}
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public TJgdm_tydm getJgdm() {
		return jgdm;
	}

	public void setJgdm(TJgdm_tydm jgdm) {
		this.jgdm = jgdm;
	}

	public TJgdmSave getJgdmSave() {
		return jgdmSave;
	}

	public void setJgdmSave(TJgdmSave jgdmSave) {
		this.jgdmSave = jgdmSave;
	}
	public String getJglx() {
		return jglx;
	}
	public void setJglx(String jglx) {
		this.jglx = jglx;
	}
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<TJgdm_tydm> getJgdms() {
		return jgdms;
	}

	public void setJgdms(List<TJgdm_tydm> jgdms) {
		this.jgdms = jgdms;
	}


	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public String getHb() {
		return hb;
	}

	public void setHb(String hb) {
		this.hb = hb;
	}

	public String getGb() {
		return gb;
	}

	public void setGb(String gb) {
		this.gb = gb;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public List<XTtyshxydm> getGsList() {
		return gsList;
	}

	public void setGsList(List<XTtyshxydm> gsList) {
		this.gsList = gsList;
	}

	public XTtyshxydm getGsdm() {
		return gsdm;
	}

	public void setGsdm(XTtyshxydm gsdm) {
		this.gsdm = gsdm;
	}



	public Integer getGsId() {
		return gsId;
	}

	public void setGsId(Integer gsId) {
		this.gsId = gsId;
	}

	public TDmsj getDmsj() {
		return dmsj;
	}

	public void setDmsj(TDmsj dmsj) {
		this.dmsj = dmsj;
	}

	public String getTydm() {
		return tydm;
	}

	public void setTydm(String tydm) {
		this.tydm = tydm;
	}

	public String getYwlx() {
		return ywlx;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}



	
	
	
	

}
