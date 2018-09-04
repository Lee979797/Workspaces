package com.ninemax.tygs.action;

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
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.code.model.TSpdmtemp;
import com.ninemax.jpa.global.CheckEntityManagerHelper;
import com.ninemax.jpa.global.CodeEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;
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
public class TyGsAction extends ActionSupport implements SessionAware {
	private static Logger log = Logger.getLogger(TyGsAction.class);


	public String currentPath;
	private Page page;


	public List<TGssj> gsList;
	public TJgdm jgdm;
	public TGssj gsdm;
	public TJgdmSave jgdmSave;
	public String reason;
	public String jglx;
	public String source;
	public List<TJgdm> jgdms;
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
		return CodeEntityManagerHelper.getEntityManager();
	}

	private void closeEntityManager() {
		CodeEntityManagerHelper.closeEntityManager();
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
		currentPath = "/product/jsp/tygs/list.jsp";
		try{
			if (page == null) {
				page = new Page();
				page.setOrderByType("desc");
			}

			User user = (User) session.get("sysUser");

			String bzjgdm=user.getBzjgdm();

			//bzjgdm="620000";


			String sql="";
			if(gsdm!=null&&!"".equals(gsdm.getLsh())){
				sql+=" and model.lsh = '"+gsdm.getLsh()+"'";
			}
			if(gsdm!=null&&!"".equals(gsdm.getJgmc())){
				sql+=" and model.jgmc = '"+gsdm.getJgmc()+"'";
			}

			//sql+=user.getUserCareer()!=null&&user.getUserCareer().trim().equals("admin")?" and 1=1": " and model.dmjgbm in ("+bzdm+") ";
			gsList = manager().createQuery("from TGssj model where model.tqflag='0'"+sql).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
			.getResultList();
			page.setTotalRecord(((Long) manager().createQuery(" select count(model)  from TGssj  model where model.tqflag='0'"+sql )
					.getResultList().get(0)).intValue());
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
		currentPath = "/product/jsp/tygs/showGs.jsp";

		try{

			gsList=manager().createQuery("from TGssj model where model.id=:id").setParameter("id", gsId).getResultList();
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
	public String tyDaoru(){
		try{
			gsList=manager().createQuery("from TGssj model where model.id=:id").setParameter("id", gsId).getResultList();	
			gsdm=gsList.get(0);
			jgdm=GsToDm(gsdm);
			jgdmSave=new TJgdmSave();
			jgdmSave.setBak4(gsdm.getLsh());
			BeanCopier beanCopier = BeanCopier.create(TJgdm.class, TJgdmSave.class, false);
			beanCopier.copy(jgdm, jgdmSave, null);
			currentPath = "/product/jsp/certificate/addinfomationEnter.jsp";
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			manager().close();
		}

		return ERROR;
	}
	public String noPass(){
		currentPath = "/product/jsp/tygs/nopassSuccess.jsp";
		User user = (User) session.get("sysUser");
		EntityManager em = CodeEntityManagerHelper.getEntityManager();
		em.clear();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			TGssj gssj=em.find(TGssj.class, gsId);
			gssj.setTqflag("2");
			em.merge(gssj);
			tx.commit();
			resultMsg="此单位数据未接收!!!!";
		}catch(Exception e){
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			log.error("error", e);
			log.error(e);
		}finally{
			em.close();
		}
		return SUCCESS;
	}
	public String search(){
		currentPath = "/product/jsp/tygs/viewGs.jsp";
		User user = (User) session.get("sysUser");
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.clear();

		try{

			jgdm=em.find(TJgdm.class, jgdm.getJgdm());
			if("".equals(jgdm.getBak2())||jgdm.getBak2()==null){
				currentPath = "/product/jsp/tygs/gsbt.jsp";
				resultMsg="该条数据没有统一代码!!!!";
			}


		}catch(Exception e){

			log.error("error", e);
			log.error(e);
		}finally{
			em.close();
		}
		return SUCCESS;
	}
	public String tydmTs(){
		currentPath = "/product/jsp/tygs/gsbt.jsp";
		User user = (User) session.get("sysUser");
		EntityManager em = CodeEntityManagerHelper.getEntityManager();
		em.clear();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			List<TDmsj> dmsjList=em.createQuery("from TDmsj model where model.lsh='"+jgdm.getBak4()+"'").getResultList();
			if(dmsjList.size()>0){

				TDmsj dmsj=dmsjList.get(0);
				dmsj.setTydm(tydm);
				em.merge(dmsj);
				resultMsg="统一代码推送成功!";
			}else{
				resultMsg="统一代码推送失败!";
			}
			tx.commit();

		}catch(Exception e){
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			log.error("error", e);
			log.error(e);
		}finally{
			em.close();
		}
		return SUCCESS;
	}
	public TJgdm GsToDm(TGssj gsdm){
		TJgdm jgdm=new TJgdm();
		jgdm.setZch(gsdm.getZch());
		jgdm.setJglx(gsdm.getJglx());
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
		jgdm.setTbrsfzh(gsdm.getTbzjhm());
		jgdm.setZgdm(gsdm.getZgdm());
		jgdm.setZgmc(gsdm.getZgmc());
		jgdm.setPzwh(gsdm.getPzwh());
		jgdm.setBzjgdm(gsdm.getSjly());
		jgdm.setBak4(gsdm.getLsh());
		jgdm.setBak2(gsdm.getTycode());
		return jgdm;
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



	public TJgdm getJgdm() {
		return jgdm;
	}

	public void setJgdm(TJgdm jgdm) {
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

	public List<TJgdm> getJgdms() {
		return jgdms;
	}

	public void setJgdms(List<TJgdm> jgdms) {
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

	public List<TGssj> getGsList() {
		return gsList;
	}

	public void setGsList(List<TGssj> gsList) {
		this.gsList = gsList;
	}

	public TGssj getGsdm() {
		return gsdm;
	}

	public void setGsdm(TGssj gsdm) {
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








}
