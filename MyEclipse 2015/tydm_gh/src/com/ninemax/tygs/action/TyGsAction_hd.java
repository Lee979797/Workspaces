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
import com.ninemax.tygs.model.TQybgxx;
import com.ninemax.tygs.model.TQybgxxxx;
import com.ninemax.tygs.model.TQyfzxx;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 工商统一版本action
 * TyGsAction
 * @author LP
 * 2015-5-28 下午02:23:28
 * Version @1.0
 */
public class TyGsAction_hd extends ActionSupport implements SessionAware {
	private static Logger log = Logger.getLogger(TyGsAction_hd.class);

	
	public String currentPath;
	private Page page;
	private List<TQybgxx> bgxxList;
	private TQybgxx bgxx;
	private TJgdm jgdm;
	private String resultMsg;
	private String zch;
	private List<TQybgxxxx> listDetail;
	private List<TQyfzxx> fzxxList;
	private TQyfzxx fzxx;
	public TJgdm getJgdm() {
		return jgdm;
	}

	public void setJgdm(TJgdm jgdm) {
		this.jgdm = jgdm;
	}

	public List<TQybgxx> getBgxxList() {
		return bgxxList;
	}

	public void setBgxxList(List<TQybgxx> bgxxList) {
		this.bgxxList = bgxxList;
	}

	public TQybgxx getBgxx() {
		return bgxx;
	}

	public void setBgxx(TQybgxx bgxx) {
		this.bgxx = bgxx;
	}

	private static ArrayList filelist = new ArrayList();
	
	
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

	
	/**
	 * 工商数据列表
	 * fh
	 * 2015-6-1
	 * @return
	 * Version @1.0
	 */
	public String list1() {
		currentPath = "/product/jsp/tygs/bglist.jsp";
		try{
          if (page == null) {
                page = new Page();
                page.setOrderByType("desc");
            }
	          
          User user = (User) session.get("sysUser");
          
          String bzjgdm=user.getBzjgdm();
          
          //bzjgdm="620000";
          
          
          String sql="";
          if(bgxx!=null&&!"".equals(bgxx.getRegno())){
        	  sql+=" and model.regno = '"+bgxx.getRegno()+"'";
          }
          if(bgxx!=null&&!"".equals(bgxx.getEntName())){
        	  sql+=" and model.entName = '"+bgxx.getEntName()+"'";
          }
          
          //sql+=user.getUserCareer()!=null&&user.getUserCareer().trim().equals("admin")?" and 1=1": " and model.dmjgbm in ("+bzdm+") ";
          bgxxList = manager().createQuery("from TQybgxx model where model.status='0'"+sql).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
            .getResultList();
            page.setTotalRecord(((Long) manager().createQuery(" select count(model)  from TQybgxx  model where model.status='0'"+sql )
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
	public String list2() {
		currentPath = "/product/jsp/tygs/fzlist.jsp";
		try{
          if (page == null) {
                page = new Page();
                page.setOrderByType("desc");
            }
	          
          User user = (User) session.get("sysUser");
          
          String bzjgdm=user.getBzjgdm();
          
          //bzjgdm="620000";
          
          
          String sql="";
          if(fzxx!=null&&!"".equals(fzxx.getRegno())){
        	  sql+=" and model.regno = '"+fzxx.getRegno()+"'";
          }
          if(fzxx!=null&&!"".equals(fzxx.getEntName())){
        	  sql+=" and model.entName = '"+fzxx.getEntName()+"'";
          }
          
          //sql+=user.getUserCareer()!=null&&user.getUserCareer().trim().equals("admin")?" and 1=1": " and model.dmjgbm in ("+bzdm+") ";
          fzxxList = manager().createQuery("from TQyfzxx model where model.status='0'"+sql).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
            .getResultList();
            page.setTotalRecord(((Long) manager().createQuery(" select count(model)  from TQyfzxx  model where model.status='0'"+sql )
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
	public String tyDaoru(){
		try{
		System.out.println(zch);
		List<TJgdm> dmlist= manager().createQuery("from TJgdm model where model.zch='"+zch+"'").getResultList();
		if(dmlist.size()>0){
			jgdm=dmlist.get(0);
			jgdm.setBak3("A");
			listDetail=manager().createQuery("from TQybgxxxx model where model.pripid='"+zch+"'").getResultList();
			currentPath = "/product/jsp/dailybusiness/update_noBusiness_szhy.jsp";
		}
		else{
			resultMsg="主库中不存在此信息，请核实！！";
			currentPath = "/product/jsp/tygs/bglist.jsp";
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeEntityManager();
		}
		return SUCCESS;
	}

	
	public String tyfzDaoru(){
		try{
		System.out.println(zch);
		List<TJgdm> dmlist= manager().createQuery("from TJgdm model where model.zch='"+zch+"'").getResultList();
		if(dmlist.size()>0){
			jgdm=dmlist.get(0);
			jgdm.setBak3("A");
		
			currentPath = "/product/jsp/dailybusiness/validateBusiness_szhy.jsp";
		}
		else{
			resultMsg="主库中不存在此信息，请核实！！";
			currentPath = "/product/jsp/tygs/fzlist.jsp";
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeEntityManager();
		}
		return SUCCESS;
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

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getZch() {
		return zch;
	}

	public void setZch(String zch) {
		this.zch = zch;
	}

	public List<TQybgxxxx> getListDetail() {
		return listDetail;
	}

	public void setListDetail(List<TQybgxxxx> listDetail) {
		this.listDetail = listDetail;
	}

	public List<TQyfzxx> getFzxxList() {
		return fzxxList;
	}

	public void setFzxxList(List<TQyfzxx> fzxxList) {
		this.fzxxList = fzxxList;
	}

	public TQyfzxx getFzxx() {
		return fzxx;
	}

	public void setFzxx(TQyfzxx fzxx) {
		this.fzxx = fzxx;
	}

}
