package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.tjgdm.clsTJgdmClkDAO;
import com.ninemax.jpa.code.dao.*;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.code.model.vo.TjgdmCommon;
import com.ninemax.jpa.code.model.vo.TjgdmVO;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.CheckEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.*;

//import flex.messaging.io.ArrayList;
import net.sf.cglib.beans.BeanCopier;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.sql.Timestamp;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-6
 * Time: 下午2:53
 */
public class TJgdmSaveBus {

    private static Logger log = Logger
            .getLogger(TJgdmSaveBus.class);

    private TJgdmSaveDAO dao;
    private HandleBus handleBus;
    
    static String checkName = CommonPropertiesUtil.getValue("common.properties", "checkName");
    static{
    	if("0".equals(checkName)){
    		CheckEntityManagerHelper.getEntityManager();
    	}
    	
    }

    public TJgdmSaveBus() {
        dao = new TJgdmSaveDAO();
        handleBus = new HandleBus(); 
    }
    /**
     * add by ZSL 20160917
     */
    @SuppressWarnings("unchecked")
	public List<TJgdm> jgsjPage(String userName,Date startDate,Date endDate,Integer rowNumsView,Integer pageno, clsPageComponent pages) {
      
    	List<TJgdm> mds = null;
        
        try {
        	
            String jql = "from TJgdm md where memo1=null and md.lry='"+userName+"'";
            if (pages == null) {
                pages = new clsPageComponent();
            }
            String orderBy = (pages.getOrderbyColum() != null && !"".equals(pages.getOrderbyColum())) ? (" order by md." + pages.getOrderbyColum() + " " + pages.getOrderbyMethod()) : "";
            List<Object> pams = new ArrayList();
            if (startDate != null) {
            	jql += " and md.bzrq >= ?";
            	pams.add(startDate);
            }
            if(endDate !=null){
            	jql += " and md.bzrq < ?";
            	pams.add(DateProcess.getDateFromLongTime((endDate.getTime()+ + 24 * 60 * 60 * 1000L)));
            }
            jql += orderBy;
            mds = dao.findMdbyjql(jql, pageno, rowNumsView, pages, pams);
        } catch (Exception e) {
            log.error(CodePartBus.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return mds;
    }
    @SuppressWarnings("unchecked")
   	public String changeStatus(String[] arr) {
    	   EntityManager em=null;
           try {
        	   em = EntityManagerHelper.getEntityManager();
               if(arr!=null){
            	  for(int i=0;i<arr.length;i++){
            		  EntityManagerHelper.beginTransaction();
            		  String sql = "update t_jgdm set memo1='1' where tyshxydm='"+arr[i]+"'";
            		  em.createNativeQuery(sql).executeUpdate();
                      EntityManagerHelper.commit();
            	  }
               }
           } catch (Exception e) {
               log.error(CodePartBus.class,e);
           }finally{
        	   em.clear();
           }

           return "成功";
       }
    

    
    
    /**
     * 
     * @param jgdmSave
     * @return
     */
    public int AddTjgdmSave(TJgdmSave jgdmSave) {
 
    	if (dao.save(jgdmSave)) {
            //TODO     CheckEntityManagerHelper.getEntityManager().createNativeQuery("update " + tableName + " set state='1' " + " where " + idName + "='" + jgdmSave.getBak5() + "'").executeUpdate();
            return 1;
        } else
            return 0;
    }
    
    //xiaruibo 20180321  将信息补录的数据直接存到t_jgdm主表中
    public int AddTjgdm(TJgdm jgdm,TFzr fzr) {

    	if (dao.save(jgdm)) {
    		AddTjgdmFzr(fzr,jgdm.getTyshxydm().toString());
    		return 1;
    	} else
    		return 0;
    }
    
    
    public int AddTjgdmSave(TJgdmSave jgdmSave,TFzr fzr) {
    	
    	if (dao.save(jgdmSave)) {
    		AddTjgdmFzr(fzr,jgdmSave.getId().toString());
    		return 1;
    	} else
    		return 0;
    }
    
    public int AddTjgdmFzr(TFzr fzr,String  tydm) {
    	if(fzr==null){
    		delFzr(null,tydm.toString());
    		return 1;
    	}
       	List<TFzr> list=new ArrayList();
       	String []names=fzr.getXm().split(",");
       	String []rzsj=fzr.getMemo1().split(",");
       	delFzr(fzr.getId(),tydm.toString());
       	for(int i=0;i<names.length;i++){
       		TFzr fzrValue=new TFzr();
       		
       		
       		fzrValue.setTyshxydm(tydm);
       		fzrValue.setXm(getArr(fzr.getXm(),i));
       		fzrValue.setZw(getArr(fzr.getZw(),i));
       		//fzrValue.setJgmc(fzr.getJgmc().split(",")[i]);
       		fzrValue.setXb(getArr(fzr.getXb(),i));
       		fzrValue.setGj(getArr(fzr.getGj(),i));
       		fzrValue.setZzmm(getArr(fzr.getZzmm(),i));
       		fzrValue.setRzsj(DateUtil.strToDate(getArr(fzr.getMemo1(),i)));
       		fzrValue.setDzdw(getArr(fzr.getDzdw(),i));
       		fzrValue.setLxdh(getArr(fzr.getLxdh(),i));
       		fzrValue.setYb(getArr(fzr.getYb(),i));
       		fzrValue.setZjlx(getArr(fzr.getZjlx(),i));
       		fzrValue.setZjhm(getArr(fzr.getZjhm(),i));
       		fzrValue.setTxdz(getArr(fzr.getTxdz(),i));
       		fzrValue.setMz(getArr(fzr.getMz(),i));
       		fzrValue.setLxmobile(getArr(fzr.getLxmobile(), i));
       		fzrValue.setEmail(getArr(fzr.getEmail(), i));
       		fzrValue.setIszz(getArr(fzr.getIszz(),i));
       		if(getArr(fzr.getId(),i)!=null&&!"".equals(getArr(fzr.getId(),i))){
       			fzrValue.setLsh(Integer.parseInt(getArr(fzr.getId(),i)));
       			dao.update(fzrValue);
       		}else{
       			dao.save(fzrValue);
       		}
       	}
       	return 0;
    }
    
    public int AddTjgdmFzr(EntityManager em,TFzr fzr,String  tydm) {
    	if(fzr==null){
    		delFzr(em,null,tydm.toString());
    		return 1;
    	}
    	List<TFzr> list=new ArrayList();
    	String []names=fzr.getXm().split(",");
    	String []rzsj=fzr.getMemo1().split(",");
    	String fzrid="";
    	System.out.println(fzr.getId());
    	fzrid=fzr.getId();
    	if(!"".equals(fzr.getId())){
    		for(int i=0;i<fzrid.length();i++){
    		String id=fzrid.trim().substring(fzrid.trim().length()-1, fzrid.trim().length());
        	
        	if(",".equals(id)){
        		fzrid=fzrid.trim().substring(0, fzrid.trim().length()-1);
        	}
    	   }
    	}
    	System.out.println(fzrid);
    	delFzr(em,fzrid,tydm.toString());
    	for(int i=0;i<names.length;i++){
    		TFzr fzrValue=new TFzr();
    		
    		
    		fzrValue.setTyshxydm(tydm);
    		fzrValue.setXm(getArr(fzr.getXm(),i));
    		fzrValue.setZw(getArr(fzr.getZw(),i));
    		//fzrValue.setJgmc(fzr.getJgmc().split(",")[i]);
    		fzrValue.setXb(getArr(fzr.getXb(),i));
    		fzrValue.setGj(getArr(fzr.getGj(),i));
    		fzrValue.setZzmm(getArr(fzr.getZzmm(),i));
    		fzrValue.setRzsj(DateUtil.strToDate(getArr(fzr.getMemo1(),i)));
    		fzrValue.setDzdw(getArr(fzr.getDzdw(),i));
    		fzrValue.setLxdh(getArr(fzr.getLxdh(),i));
    		fzrValue.setYb(getArr(fzr.getYb(),i));
    		fzrValue.setZjlx(getArr(fzr.getZjlx(),i));
    		fzrValue.setZjhm(getArr(fzr.getZjhm(),i));
    		fzrValue.setTxdz(getArr(fzr.getTxdz(),i));
    		fzrValue.setMz(getArr(fzr.getMz(),i));
    		fzrValue.setLxmobile(getArr(fzr.getLxmobile(), i));
       		fzrValue.setEmail(getArr(fzr.getEmail(), i));
       		fzrValue.setIszz(getArr(fzr.getIszz(),i));
    		if(getArr(fzr.getId(),i)!=null&&!"".equals(getArr(fzr.getId(),i))){
    			fzrValue.setLsh(Integer.parseInt(getArr(fzr.getId(),i)));
    			em.merge(fzrValue);
    		}else{
    			em.persist(fzrValue);
    		}
    	}
    	return 0;
    }
    
    
    
    public String getArr(String val,int index){
    	if(val==null){
    		return null;
    	}
    	return val.split(",")[index].trim().replaceAll("\\s*", "");
    }
    
    public List<TFzr> fzrList(EntityManager em,String id){
    	
            List<TFzr> instances = em.createQuery("SELECT model from TFzr  model where model.tyshxydm =:tyshxydm")
            .setParameter("tyshxydm", id).getResultList();
             return instances;
       
        
    }
    
    public List<TFzr> fzrList(String id){
    	try {
    		List<TFzr> instances = EntityManagerHelper.getEntityManager().createQuery("SELECT model from TFzr  model where model.tyshxydm =:tyshxydm")
    		.setParameter("tyshxydm", id).getResultList();
    		return instances;
    	} catch (RuntimeException re) {
    		throw re;
    	} finally {
    		EntityManagerHelper.closeEntityManager();
    	}
    	
    }
    
    
    
    public boolean delFzr(String lsh,String tydm) {
        boolean flag = true;
        EntityManager em = EntityManagerHelper.getEntityManager();
        em.clear();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            String sql="";
            if(lsh==null){
            	sql="delete TFzr model where model.tyshxydm=:tydm";
            }else{
            	sql="delete TFzr model where model.lsh not in("+lsh+") and model.tyshxydm=:tydm";
            	
            }
            em.createQuery(sql).setParameter("tydm", tydm).executeUpdate();
            tx.commit();
        } catch (Exception e) {
            flag = false;
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            return flag;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }
    
    public boolean delFzr(EntityManager em,String lsh,String tydm) {
    	boolean flag = true;

    		String sql="";
    		if(lsh==null||"".equals(lsh)){
    			sql="delete TFzr model where model.tyshxydm=:tydm";
    		}else{
    			sql="delete TFzr model where model.lsh not in("+lsh+") and model.tyshxydm=:tydm";
    			
    		}

    		em.createQuery(sql).setParameter("tydm", tydm).executeUpdate();
    		em.flush();
    	return flag;
    }
    
    /**
     * 赋码成功更新id 
     * LP
     * 2016-3-24
     * @param id
     * @param tydm
     * @return
     * Version @1.0
     */
    public boolean upFzr(String id,String tydm) {
    	boolean flag = true;
    	EntityManager em = EntityManagerHelper.getEntityManager();
    	em.clear();
    	EntityTransaction tx = em.getTransaction();
    	try {
    		tx.begin();
    		em.createQuery("update TFzr model set model.tyshxydm=:tydm where model.tyshxydm=:id").setParameter("tydm", tydm).setParameter("id", id).executeUpdate();
    		tx.commit();
    	} catch (Exception e) {
    		flag = false;
    		if (tx != null && tx.isActive()) {
    			tx.rollback();
    		}
    		return flag;
    	} finally {
    		EntityManagerHelper.closeEntityManager();
    	}
    	return flag;
    }
    

    public int updateTjgdmSave(TJgdmSave jgdmSave) {
        if (dao.update(jgdmSave)) {
            return 1;
        } else
            return 0;
    }
    
    public int updateTjgdmSave(TJgdmSave jgdmSave,TFzr fzr) {
    	if (dao.update(jgdmSave)) {
    		AddTjgdmFzr(fzr,jgdmSave.getId().toString());
    		return 1;
    	} else
    		return 0;
    }

    public int deleteTjgdmSave(int id) {
        if (dao.deleteById(TJgdmSave.class, id)) {
            return 1;
        } else
            return 0;
    }

    public TJgdmSave findByJgdm(String jgdm) {
        List<TJgdmSave> list = dao.findByProperty("jgdm", jgdm);
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
    //-----------
    public List<TJgdm> findByDate(Date startDate,Date endDate){
    	EntityManager em = EntityManagerHelper.getEntityManager();
    	em.clear();
    	EntityTransaction tx = em.getTransaction();
    	 String strsql = "SELECT tyhxydm,jgmc,jgdm,jgdz,fddbr,zjhm FROM TJgdm WHERE bzrq>=" + startDate + " AND bzrq<=" + endDate ;
         List<TJgdm> list = em.createNativeQuery(strsql).getResultList();
    	
    	if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
    
    //------------


    /**
     * 删除预赋码表单，收回机构代码
     *
     * @param save
     * @return
     */
    public int deleteAndGetTjgdmSave(TJgdmSave save) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            String jgdm = save.getJgdm();
            if (jgdm != null && jgdm.trim().length() == 9) {
                //回收机构代码
                em.createNativeQuery("INSERT INTO t_mdk(jgdm,dmflag) VALUES (?1,'0')").setParameter(1, jgdm).executeUpdate();
                TCzjl czjl = new TCzjl();
                czjl.setDate(DateUtil.getCurrentSystemDateTime());
                czjl.setJgdm(jgdm);
                czjl.setName(save.getUserid());
                czjl.setType("P1");
                //修改xzqh  bzjgdm 
                czjl.setXzqh(save.getBzjgdm());
                czjl.setMemo("预赋码(" + jgdm + ")已删除，代码已回收，通知单已作废!");
                em.persist(czjl);
            } else {
                jgdm = save.getId().toString();
            }

            em.remove(em.getReference(TJgdmSave.class, save.getId()));
            String strsql = "SELECT top 1 lsh,gllsh FROM t_sp WHERE jgdm='" + jgdm + "' AND flag='1' AND ywlx='09' ORDER BY lsh DESC";
            List<Object[]> lshList = em.createNativeQuery(strsql).getResultList();
            String strLsh = "";
            String strGllsh = "";
            if (lshList != null && lshList.size() > 0) {
                Object[] objs = lshList.get(0);
                strLsh = objs[0].toString();
                strGllsh = objs[1].toString();
                strsql = "DELETE FROM t_sp WHERE lsh=" + strLsh;
                em.createNativeQuery(strsql).executeUpdate();
                //删除审批代码临时表
                strsql = "DELETE FROM t_spdmtemp WHERE lsh=" + strGllsh;
                em.createNativeQuery(strsql).executeUpdate();
            }
            result = 1;
            tx.commit();
        } catch (Exception e) {
            log.error("TJgdmSaveBus deleteAndGetTjgdmSave exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result;
    }

    /**
     * 其它部门赋码删除
     *
     * @param save
     * @return
     */
    public int deleteElseTJgdmSave(TJgdmSave save) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            String jgdm = save.getJgdm();
            TCzjl czjl = new TCzjl();
            czjl.setDate(DateUtil.getCurrentSystemDateTime());
            czjl.setJgdm(jgdm);
            czjl.setName(save.getUserid());
            czjl.setType("D1");
            czjl.setXzqh(save.getXzqh());
            czjl.setMemo("其它部门赋码(" + jgdm + ")已删除!");
            em.persist(czjl);
            em.remove(em.getReference(TJgdmSave.class, save.getId()));
            String strsql = "SELECT top 1 lsh,gllsh FROM t_sp WHERE jgdm='" + jgdm + "' AND flag='1' AND ywlx='08' ORDER BY lsh DESC";
            List<Object[]> lshList = em.createNativeQuery(strsql).getResultList();
            String strLsh = "";
            String strGllsh = "";
            if (lshList != null && lshList.size() > 0) {
                Object[] objs = lshList.get(0);
                strLsh = objs[0].toString();
                strGllsh = objs[1].toString();
                strsql = "DELETE FROM t_sp WHERE lsh=" + strLsh;
                em.createNativeQuery(strsql).executeUpdate();
                //删除审批代码临时表
                strsql = "DELETE FROM t_spdmtemp WHERE lsh=" + strGllsh;
                em.createNativeQuery(strsql).executeUpdate();
            }
            result = 1;
            tx.commit();
        } catch (Exception e) {
            log.error("TJgdmSaveBus deleteAndGetTjgdmSave exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result;
    }

    public TJgdmSave findById(Integer id) {
        return dao.findById(id);
    }

    public boolean canFm(int id) {
        return DateUtil.dayAfter(DateUtil.strToDate(DateUtil.dateToStr(findById(id).getBzrq())), InitSysParams.system.getFmqx()).compareTo(DateUtil.strToDate(DateUtil.dateToStr(new Date()))) <= 0;
    }

    private boolean nameCanUse(String codeName, String jgdm) {
        if (jgdm == null || "".equals(jgdm))
            return false;
        TSpcfDAO spcfDAO = new TSpcfDAO();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jgmc", codeName);
        map.put("jgdm", jgdm);
        List<TSpcf> spcfs = spcfDAO.findByPropertys(map);

        return !spcfs.isEmpty() && spcfs.get(0).getCanUse();
    }

    private boolean zchCanUse(String zch, String jgdm) {
        if (jgdm == null || "".equals(jgdm))
            return false;
        TSpcfDAO spcfDAO = new TSpcfDAO();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("zch", zch);
        map.put("jgdm", jgdm);
        List<TSpcf> spcfs = spcfDAO.findByPropertys(map);
        return !spcfs.isEmpty() && spcfs.get(0).getCanUse();
    }

    /**
     * 是否存在机构名称
     *
     * @param codeName
     * @return
     */

    public String isExistCodeName(String codeName, String jgdm, String arg) {
      /*  if (nameCanUse(codeName, jgdm))
            return "";*/
    	
    	System.out.println("codeName="+codeName);
    	System.out.println("jgdm="+jgdm);
    	System.out.println("arg="+arg);
	    if("unvalidate".equals(arg)){
		  //return "";
    	}
        if (new TjgdmBus().isExistCodeName(codeName, jgdm)) {
            return "true:有效库";
        }
        
        if (new TjgdmBus().isExistCodeNameBs(codeName, jgdm)) {
            return "true:代码有效库";
        }
        
        if (!arg.endsWith("In")) {
            if (new TQzjgdmBus().isExistCodeName(codeName, jgdm)) {
                return "true:迁址库";
            }
        }
        if (new TFzdmBus().isExistCodeName(codeName, jgdm)) {
            return "true:注销库";
        }
        
        if (new TFzdmBus().isExistCodeNameBs(codeName, jgdm)) {
        	return "true:代码注销库";
        }
        
        if (this.hasRecord(codeName, jgdm)) {
            return "true:临时表";
        }       
        String res = new clsTJgdmClkDAO().findJgdmByJgmc(codeName,jgdm);
        if(res!=""&& res!=null){
        	String dm = res;
        	return "true:存量库"+dm;
        }
        return "";
    }
    public String getYzbm(String xzqh){
		if(!clsStringTool.isEmpty(xzqh)){
			return dao.getYzbm(xzqh);
		}
		return "";
	}
    public String getZgdm(String zgmc){
		if(!clsStringTool.isEmpty(zgmc)){
			return dao.getZgdm(zgmc);
		}
		return "";
	}
    public String getZgmc(String zgdm){
		if(!clsStringTool.isEmpty(zgdm)){
			return dao.getZgmc(zgdm);
		}
		return "";
	}
    /**
     * 是否存在法人代表
     *
     * @param frdb
     * @return
     */

    public boolean isExistFrdb(String frdb, String jgdm) {

        if (new TjgdmBus().isExistFrdb(frdb, jgdm)) {
            return true;
        } else if (new TQzjgdmBus().isExistFrdb(frdb, jgdm)) {
            return true;
        } else if (new TFzdmBus().isExistFrdb(frdb, jgdm)) {
            return true;
        } else if (this.hasFrdbRecord(frdb, jgdm)) {
            return true;
        } else
            return false;
    }

    /**
     * 是否存在证件号码
     *
     * @param zjlx
     * @param zjhm
     * @param jgdm
     * @return
     */
    public String isExistZjhm(String zjlx, String zjhm, String jgdm,String jglx) {
    	if("3".equals(jglx)){
    		if (new TjgdmBus().isExistZjhm(zjlx, zjhm, jgdm, jglx)) {
    			return "true:有效库";
    		}else if(new TjgdmBus().isExistZjhmBs(zjlx, zjhm, jgdm, jglx)){
    			return "true:代码有效库";
    		}else if (this.hasZjhmRecord(zjlx, zjhm, jgdm,jglx)) {
    			return "true:临时库";
    		}  else if (new TFzdmBus().isExistZjhm(zjlx, zjhm, jgdm,jglx)) {
    			return "true:注销库";
    		}else if(new TFzdmBus().isExistZjhmBs(zjlx, zjhm, jgdm,jglx)) {
    			return "true:代码注销库";
    		} else
    			return "";
    	}else{
    		
    		if (new TjgdmBus().isExistZjhm(zjlx, zjhm, jgdm, jglx)) {
    			return "true:有效库";
    		}else if (this.hasZjhmRecord(zjlx, zjhm, jgdm,jglx)) {
    			return "true:临时库";
    		}  else if (new TFzdmBus().isExistZjhm(zjlx, zjhm, jgdm,jglx)) {
    			return "true:注销库";
    		}  else
    			return "";
    	}
    	
    }

    //判断是否存在机构代码
    public boolean isExistJgdm(String jgdm) {
        if (new TjgdmBus().isExit(jgdm)) {
            return true;
        } else if (new TFzdmBus().isExitJgdm(jgdm)) {
            return true;
        } else return this.checkJgdm(jgdm);
    }
    
   // xiaruibo 20180321 判断是否存在统一代码
    public boolean isExistTydm(String tydm) {
        if (new TjgdmBus().isExitTydm(tydm)) {
            return true;
        } else if (new TFzdmBus().isExitTydm(tydm)) {
            return true;
        } 
        return false;
    }
    
    //提取BS库信息
    public TJgdm findJgdmBs(String jgdm){
    	TJgdm dm=new TJgdm();
    	TJgdmBs dmBs=new TjgdmBus().findByIdBs(jgdm);
    	if(dmBs!=null){
    		dm.setJgmc(dmBs.getJgmc());
    		dm.setJgdz(dmBs.getJgdz());
    		dm.setFddbr(dmBs.getFddbr());
    		dm.setJyfw(dmBs.getJyfw());
    		dm.setZczj(dmBs.getZczj());
    		dm.setMemo5(DateUtil.dateToStr(dmBs.getZcrq()));
    	}else{
    		TFzdmBs fzBs=new TFzdmBus().findByIdBs(jgdm);
    		if(fzBs==null){
    			return null;
    		}
    		dm.setJgmc(fzBs.getJgmc());
    		dm.setJgdz(fzBs.getJgdz());
    		dm.setFddbr(fzBs.getFddbr());
    		dm.setJyfw(fzBs.getJyfw());
    		dm.setZczj(fzBs.getZczj());
    		dm.setMemo5(DateUtil.dateToStr(fzBs.getZcrq()));
    	}
    	
    	return dm;
    	
    }

    private boolean hasRecord(String codeName, String jgdm) {
        List<TJgdmSave> list = dao.findByProperty("jgmc", codeName);
        if (list == null || list.isEmpty() || (list.size() == 1 &&
                (list.get(0).getId().toString().equals(jgdm) || jgdm.equals(list.get(0).getJgdm())))) {
            return false;
        } else
            return true;
    }

    private boolean hasFrdbRecord(String fddbr, String jgdm) {
        List<TJgdmSave> list = dao.findByProperty("fddbr", fddbr);
        if (list == null || list.isEmpty() || (list.size() == 1 &&
                (list.get(0).getId().toString().equals(jgdm) || jgdm.equals(list.get(0).getJgdm())))) {
            return false;
        } else
            return true;
    }

    private boolean hasZjhmRecord(String zjlx, String zjhm, String jgdm,String jglx) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("zjlx", zjlx);
        map.put("zjhm", zjhm);
        List<TJgdmSave> list = dao.findByPropertys(map,jglx);
        if (list == null || list.isEmpty() || (list.size() == 1 &&
                (list.get(0).getId().toString().equals(jgdm) || jgdm.equals(list.get(0).getJgdm())))) {
            return false;
        } else
            return true;
    }


    public boolean checkJgdm(String jgdm) {
        List<TJgdmSave> list = dao.findByProperty("jgdm", jgdm);
        if (list == null || list.size() <= 0) {
            return false;
        } else
            return true;
    }

    public String valifyZch(String zch, String jjlx) {
        if (zch.length() != 15)
            return "false:注册号长度不为15位！";
        String xzqh = zch.substring(0, 6);
        String type = zch.substring(6, 7);
        if (InitSysParams.xzqhAllMap.get(xzqh) == null) {
            return "false:注册号编码错误，不属于任何行政机构！";
        }
        if (jjlx == null || "".equals(jjlx))
            return "false:请先输入有效的经济类型";
        if (!((jjlx.matches("[49].*$") && type.matches("[6789].*$")) ||
                (jjlx.matches("^[12356].*$") && type.matches("[0123].*$")) ||
                (jjlx.matches("^[78].*$") && type.matches("[45].*$")))) {
            return "false:注册码与经济类型不匹配";
        }
        if (valify(zch)) {
            return "true";
        }
        return "false:注册号校验错误！";

    }

    private Boolean valify(String zch) {
        return (getValify(zch) + Integer.valueOf(zch.substring(14, 15))) % 10 == 1;
    }

    private int getValify(String zch) {
        int p = 10;
        for (int i = 0; i < 14; i++) {
            p += Integer.valueOf(zch.substring(i, i + 1));
            p %= 10;
            p = p == 0 ? 10 : p;
            p <<= 1;
            p %= 11;
        }
        return p;
    }

    /**
     * 是否存在注册号
     *
     * @param zch
     * @return
     */
    public String isExistZch(String zch, String jgdm, String jglx, String formType, String... args) {
        if (zchCanUse(zch, jgdm))
            return "";
        String flag = "";
        TJglxBus tJglxBo = new TJglxBus();
        TJglx tJglx = tJglxBo.findTjglx(jglx);
        if (tJglx.isZchyxc()) {
            return flag;
        }
        List<TJgdm> tJgdmList = new TjgdmBus().isExistZch(zch, jglx);
        if (tJgdmList == null || tJgdmList.isEmpty() || (tJgdmList.size() > 0 && jgdm.equals(tJgdmList.get(0).getJgdm()))) {
        } else {
            flag = "true:机构代码表";
        }
        if (!(args.length > 0 && args[0].endsWith("In")) && "".equals(flag)) {
            List<TQzjgdm> tQzjgdmList = new TQzjgdmBus().isExistZch(zch, jglx);
            if (tQzjgdmList == null || tQzjgdmList.isEmpty() || (tQzjgdmList.size() > 0 && jgdm.equals(tQzjgdmList.get(0).getJgdm()))) {
            } else {
                flag = "true:迁址库";
            }
        }
        if ("".equals(flag)) {
            List<TFzdm> tfzdmList = new TFzdmBus().isExistZch(zch, jglx);
            if (tfzdmList == null || tfzdmList.isEmpty() || (tfzdmList.size() > 0 && jgdm.equals(tfzdmList.get(0).getJgdm()))) {
            } else {
                flag = "true:注销库";
            }
        }
        if ("".equals(flag)) {
            Map<String, Object> params = new HashedMap();
            params.put("zch", zch);
            if (!"".equals(jgdm)) {
                if ("0".equals(formType)) {
                    params.put("id", Integer.valueOf(jgdm));
                } else {
                    params.put("jgdm", jgdm);
                }
            }
            List<TJgdmSave> JgdmSaveList = dao.findByPropertys(params);
            if ((JgdmSaveList == null) || JgdmSaveList.isEmpty() ||
                    ((JgdmSaveList.size() > 0) && (JgdmSaveList.get(0).getId().toString().equals(jgdm) || jgdm.equals(JgdmSaveList.get(0).getJgdm())))) {
            } else {
                flag = "true:机构代码临时表";
            }
        }
        return flag;
    }

    //lvwei 20170904 注册号存量库校验
    public String isExistCodeZch(String zch,String jgdm, String arg) {    	
	    if("unvalidate".equals(arg)){
		  //return "";
    	} 	
    	if(new clsTJgdmClkDAO().findJgdmByZch(zch,jgdm)!=""&& new clsTJgdmClkDAO().findJgdmByZch(zch,jgdm)!=null){
        	String dm = new clsTJgdmClkDAO().findJgdmByZch(zch,jgdm);
        	System.out.println("dm="+dm);
        	return "true:存量库"+dm;
        }
     	return null;
    }
    
    
  
    /**
     * 预付码列表
     *
     * @param params
     * @param pageno
     * @param rowNumsView
     * @param pages
     * @return
     */
    public List<TjgdmVO> listYfm(User user, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod) {
        List<TjgdmVO> list = null;
        try {
            String jql = "select model.id,model.jgdm,model.jgmc,model.bzrq,s.flag,s.shflag,model.fddbr,model.zjhm,model.pzwh from t_jgdm_save model left join (select jgdm,flag,shflag from  t_sp  where  flag !=2 and ywlx in ('10','11','15') ) s on (CAST(model.id AS VARCHAR) = s.jgdm or  model.jgdm = s.jgdm) where ";
            String cond = "";
            //包含办证机构代码查看是否有权限查看
            cond = handleBus.sql(user);
            jql += cond;
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgmc".equals(key)) {
                        value = "%" + value + "%";
                        jql += " and " + key + " like ?";
                    } else
                        jql += " and model." + key + " = ?";
                    pms.add(value);
                }
            }
            String orderByContent = "";
            if (!clsStringTool.isEmpty(orderbyColum)
                    && !clsStringTool.isEmpty(orderbyMethod)) {
                if ("jgdm".equals(orderbyColum)) {
                    orderByContent = "model.jgdm" + " " + orderbyMethod;
                } else
                    orderByContent = orderbyColum + " " + orderbyMethod;
            } else {
                orderByContent = " model.id desc";
            }
            jql += " order by " + orderByContent;
            List<Object[]> returnList = dao.listTjgdmSave(jql, pageno, rowNumsView, pages, pms);
            if (returnList != null && returnList.size() > 0) {
                list = new ArrayList<TjgdmVO>();
                TjgdmVO vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmVO();
                    vo.setId(Integer.parseInt(objects[0].toString()));
                    vo.setJgdm(objects[1] == null ? "" : objects[1].toString());
                    vo.setJgmc(objects[2].toString());
                    vo.setBzrq(DateUtil.strToDate(objects[3].toString()));
                    vo.setFlag(objects[4] == null ? "" : objects[4].toString());
                    vo.setShflag(objects[5] == null ? "" : objects[5].toString());
                    vo.setFddbr(objects[6] == null ? "" : objects[6].toString());
                    vo.setZjhm(objects[7] == null ? "" : objects[7].toString());
                    vo.setPzwh(objects[8] == null ? "" : objects[8].toString());
                    list.add(vo);
                }
            }
        } catch (Exception e) {
            log.error("TJgdmSaveBus listTjgdmSave error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return list;
    }

    /**
     * 发证申请表列表
     *
     * @param params
     * @param pageno
     * @param rowNumsView
     * @param pages
     * @return
     */
    public List<TjgdmVO> listTjgdmSave(User user, String formType, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod,String jglx) {
        List<TjgdmVO> list = null;
        try {
            String jql = "";
            String cond = "";
            cond = handleBus.sql(user);
             if ("0".equals(formType)) {
                //jql = "select model.id,model.jgdm,model.jgmc,model.bzrq,model.fddbr,model.zjhm from t_jgdm_save model  where jglx='"+jglx+"'";
            	jql = "select model.id,model.tyshxydm,model.jgmc,model.bzrq,s.flag,s.shflag,model.fddbr,model.zjhm,model.jgdm from t_jgdm_save model left join (select tyshxydm,flag,shflag from  t_sp  where  flag !=2 and ywlx in ('07','11','13','15') ) s on convert(varchar,model.id) = s.tyshxydm where jglx='"+jglx+"' and"+cond;
            	
            }else{
            	jql = "select model.id,model.tyshxydm,model.jgmc,model.bzrq,s.flag,s.shflag,model.fddbr,model.zjhm,model.jgdm from t_jgdm_save model left join (select tyshxydm,flag,shflag from  t_sp  where  flag !=2 and ywlx in ('07','11','13','15') ) s on model.jgdm = ltrim(s.tyshxydm) where jglx='"+jglx+"' and"+cond;
            	
            } 
            //包含办证机构代码查看是否有权限查看
        
            if ("2".equals(formType)) {
                jql += " and  model.jgdm is not null and  rtrim(model.jgdm) !='' ";
            }
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                  if ("jgmc".equals(key)) {
                        value = "%" + value + "%";
                        jql += " and " + key + " like ?";
                    } else
                        jql += " and model." + key + " = ?";
                    pms.add(value);
                }
            }
            String orderByContent = "";
            if (!clsStringTool.isEmpty(orderbyColum)
                    && !clsStringTool.isEmpty(orderbyMethod)) {
                if ("jgdm".equals(orderbyColum)) {
                    orderByContent = "model.jgdm" + " " + orderbyMethod;
                } else
                    orderByContent = orderbyColum + " " + orderbyMethod;
            } else {
                orderByContent = " model.id desc";
            }
            jql += " order by " + orderByContent;
            List<Object[]> returnList = dao.listTjgdmSave(jql, pageno, rowNumsView, pages, pms);
            if (returnList != null && returnList.size() > 0) {
                list = new ArrayList();
                TjgdmVO vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmVO();
                    vo.setId(Integer.parseInt(objects[0].toString()));
                    vo.setJgdm(objects[8] == null ? "" : objects[8].toString());
                    vo.setJgmc(objects[2].toString());
                    vo.setBzrq(DateUtil.strToDate(objects[3].toString()));
                    vo.setFlag(objects[4] == null ? "" : objects[4].toString());
                    vo.setShflag(objects[5] == null ? "" : objects[5].toString());
                    vo.setFddbr(objects[6] == null ? "" : objects[6].toString());
                    vo.setZjhm(objects[7] == null ? "" : objects[7].toString());
                    
                    list.add(vo);
                }
            }
        } catch (Exception e) {
            log.error("TJgdmSaveBus listTjgdmSave error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return list;
    }
   
    public boolean isBeiAn(String jgdm, User user) {
        boolean flag = false;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            String jql = "from TBajlb model where model.jgdm = '" + jgdm + "' and ";
            String cond = "";
            cond = handleBus.sql(user);
            cond += " order by model.yxrq desc";
            jql += cond;
            Query query = em.createQuery(jql);
            List<TBajlb> list = query.getResultList();
            if (list != null && list.size() > 0) {
                TBajlb bajlb = list.get(0);
                if (bajlb.getYxrq().after(DateUtil.strToDate(DateUtil.getCurrentDateTime(), "yyyy-MM-dd")) || DateUtil.dateToStr(bajlb.getYxrq(), "yyyy-MM-dd").equals(DateUtil.getCurrentDateTime().substring(0, 10))) {
                    flag = true;
                }
            }
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    /**
     * 其他部门赋码删除，预赋码删除列表
     *
     * @param params
     * @param pageno
     * @param rowNumsView
     * @param pages
     * @return
     */
    public List<TjgdmVO> delListTjgdmSave(User user, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod) {
        List<TjgdmVO> list = null;
        try {
            String cond = handleBus.sql(user);
            String jql = "select new com.ninemax.jpa.code.model.vo.TjgdmVO(model.id,model.jgdm,model.jgmc,model.bzrq) from TJgdmSave model where jgdm is not null and " + cond;
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgmc".equals(key)) {
                        value = "%" + value + "%";
                        jql += " and " + key + " like ?";
                    } else
                        jql += " and " + key + " = ?";
                    pms.add(value);
                }
                String orderByContent = "";
                if ("jgdm".equals(orderbyColum)) {
                    orderbyColum = "model.jgdm";
                }
                if (!clsStringTool.isEmpty(orderbyColum)
                        && !clsStringTool.isEmpty(orderbyMethod)) {
                    orderByContent = orderbyColum + " " + orderbyMethod;
                } else {
                    orderByContent = " model.id desc";
                }
                jql += " order by " + orderByContent;
            }
            list = dao.delListTjgdmSave(jql, pageno, rowNumsView, pages, pms);
        } catch (Exception e) {
            log.error("TJgdmSaveBus delListTjgdmSave error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return list;
    }

    /**
     * 其他部门赋码删除，预赋码删除列表带审核部分
     *
     * @param params
     * @param pageno
     * @param rowNumsView
     * @param pages
     * @return
     */
    public List<TjgdmVO> delListTjgdmSaveAudit(User user, Map<String, String> params, String ywlx, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod) {
        List<TjgdmVO> list = null;
        try {
            String cond = handleBus.sql(user);
            String sql = "select model.id,model.jgdm,model.jgmc,model.bzrq,s.flag,s.shflag from t_jgdm_save model left join (select jgdm,flag,shflag from  t_sp  where  flag !=2 and ywlx = '" + ywlx + "' ) s on model.jgdm = s.jgdm where " + cond;
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgmc".equals(key)) {
                        value = "%" + value + "%";
                        sql += " and model." + key + " like ?";
                    } else
                        sql += " and model." + key + " = ?";
                    pms.add(value);
                }
            }
            String orderByContent = "";
            if ("jgdm".equals(orderbyColum)) {
                orderbyColum = "model.jgdm";
            }
            if (!clsStringTool.isEmpty(orderbyColum)
                    && !clsStringTool.isEmpty(orderbyMethod)) {
                orderByContent = orderbyColum + " " + orderbyMethod;
            } else {
                orderByContent = " model.id desc";
            }
            sql += " order by " + orderByContent;
            List<Object[]> returnList = dao.delNativeListTjgdmSave(sql, pageno, rowNumsView, pages, pms);
            if (returnList != null && returnList.size() > 0) {
                list = new ArrayList();
                TjgdmVO vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmVO();
                    vo.setId(Integer.parseInt(objects[0].toString()));
                    vo.setJgdm(objects[1].toString());
                    vo.setJgmc(objects[2].toString());
                    vo.setBzrq(DateUtil.strToDate(objects[3].toString()));
                    vo.setFlag(objects[4] == null ? "2" : objects[4].toString());
                    vo.setShflag(objects[5] == null ? "" : objects[5].toString());
                    list.add(vo);
                }
            }
        } catch (Exception e) {
            log.error("TJgdmSaveBus delListTjgdmSaveAudit error " + e.toString());
        } /*finally {
            EntityManagerHelper.closeEntityManager();
        }*/
        return list;
    }

    /**
     * 申请表删除列表带审核部分
     *
     * @param params
     * @param pageno
     * @param rowNumsView
     * @param pages
     * @return
     */
    public List<TjgdmVO> delApplyListTjgdmSaveAudit(User user, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod) {
        List<TjgdmVO> list = null;
        try {
            String cond = handleBus.sql(user);
            String sql = "select model.jgdm,model.jgmc,model.bzrq,s.flag,s.shflag from t_jgdm model left join (select jgdm,flag,shflag from  t_sp  where  flag !=2 and ywlx = '00') s on model.jgdm = s.jgdm where " + cond + " and model.dybz='0' and model.djblx <> '1' ";
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgmc".equals(key)) {
                        value = "%" + value + "%";
                        sql += " and model." + key + " like ?";
                    } else
                        sql += " and model." + key + " = ?";
                    pms.add(value);
                }
            }
            String orderByContent = "";
            if ("jgdm".equals(orderbyColum)) {
                orderbyColum = "model.jgdm";
            }
            if (!clsStringTool.isEmpty(orderbyColum)
                    && !clsStringTool.isEmpty(orderbyMethod)) {
                orderByContent = orderbyColum + " " + orderbyMethod;
            } else {
                orderByContent = " model.bzrq desc";
            }
            sql += " order by " + orderByContent;
            List<Object[]> returnList = dao.delNativeListTjgdmSave(sql, pageno, rowNumsView, pages, pms);
            if (returnList != null && returnList.size() > 0) {
                list = new ArrayList<TjgdmVO>();
                TjgdmVO vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmVO();
                    vo.setJgdm(objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setBzrq(DateUtil.strToDate(objects[2].toString()));
                    vo.setFlag(objects[3] == null ? "2" : objects[3].toString());
                    vo.setShflag(objects[4] == null ? "" : objects[4].toString());
                    list.add(vo);
                }
            }
        } catch (Exception e) {
            log.error("TJgdmSaveBus delApplyListTjgdmSaveAudit error " + e.toString());
        } /*finally {
            EntityManagerHelper.closeEntityManager();
        }*/
        return list;
    }

    /**
     * 申请表删除列表
     *
     * @param params
     * @param pageno
     * @param rowNumsView
     * @param pages
     * @return
     */
    public List<TjgdmVO> delApplyListTjgdmSave(User user, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod) {
        List<TjgdmVO> list = null;
        try {
            String cond = handleBus.sql(user);
            String jql = "select new com.ninemax.jpa.code.model.vo.TjgdmVO(model.jgdm,model.jgmc,model.bzrq) from TJgdm model where " + cond + " and model.dybz='0' and model.djblx <> '1'";
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgmc".equals(key)) {
                        value = "%" + value + "%";
                        jql += " and " + key + " like ?";
                    } else
                        jql += " and " + key + " = ?";
                    pms.add(value);
                }
            }
            String orderByContent = "";
            if (!clsStringTool.isEmpty(orderbyColum)
                    && !clsStringTool.isEmpty(orderbyMethod)) {
                orderByContent = orderbyColum + " " + orderbyMethod;
            } else {
                orderByContent = " model.bzrq desc";
            }
            jql += " order by " + orderByContent;
            list = dao.delListTjgdmSave(jql, pageno, rowNumsView, pages, pms);
        } catch (Exception e) {
            log.error("TJgdmSaveBus delApplyListTjgdmSave error " + e.toString());
        }/* finally {
            EntityManagerHelper.closeEntityManager();
        }*/

        return list;
    }

    /**
     * 校对
     * 把t_jgdm_save值复制到t_jgdm,去t_mdk取机构类型对应的jgdm，找到第一个赋值给对应的t_jgdm，删除t_jgdm_save,然后删除这条记录，t_jgdm设置打印标志为0并记入日志
     *
     * @param id
     * @return result 0 失败 1 成功 2 无可用的码段,请到国家中心下载码段! 3 机构代码已经存在，不能赋码  4您的数据不完整,请到外经委赋码模块更新您的数据!
     */
    public synchronized String revision(String id, String formType, User user ,String jglx) {
        Integer result = 0;
        TJgdmSave jgdmSave = this.findById(Integer.valueOf(id));
        //如果是预赋码 要判断数据的完整性
        /*if ("2".equals(formType)) {
            String jglx = jgdmSave.getJglx();
            if (clsStringTool.isEmpty(jglx)) {
                result = 4;
                return result.toString();
            }
        }*/
        //如果是其它部门赋码或预赋码不用在去取jgdm
        //如果机构类型是B的，用dmFlag=3的去查，否则用0去查
        String codeId = "";
        String tydm="";
        String tyxydm="";
        //申请表登记
        if ("0".equals(formType)) {
            List<TMdk> list = null;
            if ("B".equals(jgdmSave.getJglx()) || "b".equals(jgdmSave.getJglx())) {
                list = new TMdkDAO().findAll();
                if (list != null && list.size() > 0) {
                    codeId = list.get(0).getJgdm();
                } else
                    result = 2;
            } else {
                list = new TMdkDAO().findAll();
                if (list != null && list.size() > 0) {
                    codeId = list.get(0).getJgdm();
                } else
                    result = 2;
            }
        }
        //其它部门赋码或者预赋码
        if ("1".equals(formType) || "2".equals(formType)) {
            codeId = jgdmSave.getJgdm();
        }
        if (result != 2) {
            //判断机构代码是否在主库，注销库，迁址库，垃圾库
            TJgdm tjgdm = new TJgdmDAO().findById(codeId);
            if (tjgdm != null) {
                result = 3;
            }
            TFzdm tFzdm = new TFzdmDAO().findById(codeId);
            if (tFzdm != null) {
                result = 3;
            }
          /*  List qzList = new TQzjgdmDAO().findbysql("select jgdm from t_qzjgdm where jgdm = '" + codeId + "' and qzbz != '0'");
            if (qzList != null && qzList.size() > 0) {
                result = 3;
            }
            TLjdm ljdm = new TLjdmDAO().findById(codeId);
            if (ljdm != null) {
                result = 3;
            }*/
            if (result != 3) {
                TJgdm jgdm = new TJgdm();
                if (jgdmSave != null) {
                    BeanCopier beanCopier = BeanCopier.create(TJgdmSave.class, TJgdm.class, false);
                    beanCopier.copy(jgdmSave, jgdm, null);
                }
              /*  //预赋码
                if ("2".equals(formType)) {
                   
                    jgdm.setLastdate(DateUtil.getCurrentSystemDateTime());
                 
                }*/
                jgdm.setJgdm(codeId);
                TydmDemo demo = new TydmDemo();
                String lx=CommonPropertiesUtil.getValue("common.properties", "tydm");
                String xzqh=user.getZrxzqu();
                System.out.println(xzqh);
                System.out.println(lx+"1"+xzqh+codeId);
                if("1".equals(jglx)){
                	tydm=demo.getCheckCode(lx+"1"+xzqh.trim()+codeId);
                }
                if("2".equals(jglx)){
                	tydm=demo.getCheckCode(lx+"2"+xzqh.trim()+codeId);
                }
                if("3".equals(jglx)){
                	tydm=demo.getCheckCode(lx+"3"+xzqh.trim()+codeId);
                }
                tyxydm=tydm;
                jgdm.setTyshxydm(tydm);
                //xiaruibo  20170215 数据上报时设置0
                jgdm.setDflag(0);
                //xiaruibo 20180228 数据新办并校对赋码时，给业务类型(ywlx)，经营状态(jyzt)，交换接口保存类型(savetype)赋值
                jgdm.setYwlx("0");	//业务类型(ywlx)：0成立，1变更，2换证，3注销，4撤销，-1删除
                jgdm.setJyzt("1");  //机构状态(jyzt)：1正常(存续),2注销，3撤销，-1删除
                jgdm.setSavetype(0); //民政部数据交换保存类型：0未传送或者传送失败，1传送成功
                
                jgdm.setLastdate(new Date());
                EntityManager em = EntityManagerHelper.getEntityManager();
                EntityTransaction tx = null;
                try {
                    tx = em.getTransaction();
                    tx.begin();
                 /*   if(jgdm.getBak3()!=null&&jgdm.getBak3().length()>16){
                    	em.createNativeQuery("update t_ywlc set jgdm='"+jgdm.getJgdm()+"',jgmc='"+jgdm.getJgmc()+"',ywlclx='1',type='校对赋码',isend='1' where ywlsh='"+jgdm.getBak3().trim()+"'").executeUpdate();
                    	jgdm.setBak3("");
                    }*/
                    em.persist(jgdm);
                    em.flush();
                    TSystem system = InitSysParams.system;

                    /*if (system.getIsSmTask() && system.getHzSmTask()) {
                        List<TSmrw> rws = em.createQuery("select model from TSmrw model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ")
                                .setParameter(1, "4")
                                .setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date()))).setParameter(3, jgdm.getJgdm()).getResultList();
                        if (rws.isEmpty() && rws.size() <= 0) {
                            if ("0".equals(formType)) {
                                if (system.getIsSmTask() && system.getAddJgdmSmTask()) {
                                    TSmrw task = new TSmrw();
                                    BeanUtilsEx.copyProperties(task, jgdm);
                                    task.setId(null);
                                    task.setCreateTime(new Date());
                                    task.setStatus(false);
                                    task.setType(formType);
                                    task.setCzr(user.getUserName());
                                    em.persist(task);
                                }
                            }
                            if ("1".equals(formType)) {
                                if (system.getIsSmTask() && system.getQtfmSmTask()) {
                                    TSmrw task = new TSmrw();
                                    BeanUtilsEx.copyProperties(task, jgdm);
                                    task.setId(null);
                                    task.setCzr(user.getUserName());
                                    task.setCreateTime(new Date());
                                    task.setStatus(false);
                                    task.setType(SmTaskType.其他赋码.getValue().toString());
                                    em.persist(task);
                                }
                            }
                            if ("2".equals(formType)) {
                                if (system.getIsSmTask() && system.getAddJgdmSmTask()) {
                                    TSmrw task = new TSmrw();
                                    BeanUtilsEx.copyProperties(task, jgdm);
                                    task.setId(null);
                                    task.setCreateTime(new Date());
                                    task.setStatus(false);
                                    task.setCzr(user.getUserName());
                                    task.setType(SmTaskType.预赋码更新.getValue().toString());
                                    em.persist(task);
                                }
                            }
                        }
                    }*/
                    //如果发卡，插入卡信息
                  /*  if ("1".equals(jgdmSave.getFkbz())) {
                        int fksl = jgdmSave.getFksl();
                        for (int i = 0; i < fksl; i++) {
                            //插入ic卡信息表
                            TkKxxk kxxk = new TkKxxk();
                                kxxk.setLsh(Integer.valueOf(num));
                            kxxk.setCzy(user.getUserName());
                            kxxk.setJgdm(jgdm.getJgdm());
                            kxxk.setBkbz("1");
                            kxxk.setCzsj(DateUtil.getCurrentSystemDateTime());
                            kxxk.setSqsj(new Date());
                            kxxk.setFkbz("0");
                            kxxk.setFlag("0");
                            kxxk.setGsbz("0");
                            kxxk.setSbbz("0");
                            kxxk.setXzqh(user.getBzjgdm());
                            kxxk.setXgbz("0");
                            kxxk.setHaveDown("0");
                            em.persist(kxxk);
                            //插入操作日志
                            TCzjl czjl = new TCzjl();
                            czjl.setDate(DateUtil.getCurrentSystemDateTime());
                            czjl.setJgdm(codeId);
                            czjl.setName(user.getUserName());
                            czjl.setType("Q");
                            czjl.setXzqh(user.getBzjgdm());
                            czjl.setKlsh(kxxk.getLsh().longValue());
                            em.persist(czjl);
                        }
//                        em.createNativeQuery("UPDATE s_serial SET flow_id = flow_id + ?1 WHERE xzqh_code = ?2 AND table_type = ?3 ").setParameter(1, fksl).setParameter(2, "100000").setParameter(3, 1).executeUpdate();
                    }
*/
                    //新办超期处罚
                    /*if ("2".equals(formType) || (!"2".equals(formType) && (!"B".equals(jgdmSave.getJglx()) || !"b".equals(jgdmSave.getJglx())))) {
                        //新办超期时间
                        //新办是否处罚
                        Boolean xbcqcf = InitSysParams.system.getXbsfcf();
                        int xbcqsz = InitSysParams.system.getXbcqsz();

                        if (xbcqcf && xbcqsz > 0) {
                            String strsql = "SELECT * FROM t_jgdm WHERE datediff(DAY,zcrq,bzrq)>" + xbcqsz + " AND jgdm='" + codeId + "'";
                            List cfList = em.createNativeQuery(strsql).getResultList();
                            if (cfList != null && cfList.size() > 0) {
                                strsql = "INSERT INTO t_cfjlb(jgdm,bzjgdm,jgmc,jglx,fddbr,jgdz,zfrq,lrrq,lrr,zjhm,zjlx,njqx,zcrq,cflx,cfbz) VALUES('" + codeId + "','" + jgdmSave.getBzjgdm() + "','" + jgdmSave.getJgmc() + "','" + jgdmSave.getJglx() + "','" + jgdmSave.getFddbr() + "','" + jgdmSave.getJgdz() + "','" + jgdmSave.getZfrq() + "','" + DateUtil.getCurrentDateTime() + "','" + user.getUserName() + "','" + jgdmSave.getZjhm() + "','" + jgdmSave.getZjlx() + "','" + jgdmSave.getNjqx() + "','" + jgdmSave.getZcrq() + "','01','0')";
                                em.createNativeQuery(strsql).executeUpdate();
                            }
                        }

                    }*/
                    //删除机构代码临时表,如果是申请表，也要删除对应的码段库
                    em.remove(em.getReference(TJgdmSave.class, Integer.valueOf(id)));
                    if ("0".equals(formType)) {
                        em.remove(em.getReference(TMdk.class, codeId));
                        em.flush();
                    }
                    TCzjl czjl = new TCzjl();
                    czjl.setDate(DateUtil.getCurrentSystemDateTime());
                    czjl.setTyshxydm(tyxydm);
                    czjl.setName(user.getUserName());
                    if ("0".equals(formType)) {
                        czjl.setType("1");
                        if("1".equals(jglx)){
                        	
                        	czjl.setMemo("社团新办校对!");
                        }else if("2".equals(jglx)){
                        	czjl.setMemo("民非新办校对!");
                        }else if("3".equals(jglx)){
                        	czjl.setMemo("基金会新办校对!");
                        }
                    } else if ("2".equals(formType)) {
                        czjl.setType("1");
                        czjl.setMemo("预赋码校对!");
                    } else {
                        czjl.setType("1");
                        czjl.setMemo("其它部门赋码校对!");
                    }
                    czjl.setXzqh(user.getBzjgdm());
                    em.persist(czjl);
                    result = 1;
                    tx.commit();
                } catch (Exception e) {
                    log.error("TJgdmSaveBus revision exception============" + e.toString());
                    if (tx != null && tx.isActive()) {
                        tx.rollback();
                    }
                } finally {
                    EntityManagerHelper.closeEntityManager();
                }
            }

        }
        if (result.equals(1)) {
            return result + ":" + tyxydm;
        }
        return result.toString();
    }
    
    /**
     * 手动赋码
     *
     * @param id
     * @param formType
     * @param user
     * @param sslCode  webService  获得的机构代码
     * @return
     */
    public synchronized String revision2(String id, String formType, User user, String sslCode) {
    	Integer result = 0;
    	TJgdmSave jgdmSave = this.findById(Integer.valueOf(id));
    	//如果是预赋码 要判断数据的完整性
    	if ("2".equals(formType)) {
    		String jglx = jgdmSave.getJglx();
    		if (clsStringTool.isEmpty(jglx)) {
    			result = 4;
    			return result.toString();
    		}
    	}
    	//如果是其它部门赋码或预赋码不用在去取jgdm
    	//如果机构类型是B的，用dmFlag=3的去查，否则用0去查
    	String codeId = "";
    	//申请表登记
    	/*if ("0".equals(formType)) {
            List<TMdk> list = null;
            if ("B".equals(jgdmSave.getJglx()) || "b".equals(jgdmSave.getJglx())) {
                list = new TMdkDAO().findByProperty("dmflag", "3");
                if (list != null && list.size() > 0) {
                    codeId = list.get(0).getJgdm();
                } else
                    result = 2;
            } else {
                list = new TMdkDAO().findByProperty("dmflag", "0");
                if (list != null && list.size() > 0) {
                    codeId = list.get(0).getJgdm();
                } else
                    result = 2;
            }
        }*/
    	//其它部门赋码或者预赋码
    	if ("1".equals(formType) || "2".equals(formType)) {
    		codeId = jgdmSave.getJgdm();
    	} else{
    		codeId = sslCode;
    	}
    	//赋值ssl
    	
    	if (result != 2) {
    		if (result != 3) {
    			TJgdm jgdm = new TJgdm();
    			if (jgdmSave != null) {
    				BeanCopier beanCopier = BeanCopier.create(TJgdmSave.class, TJgdm.class, false);
    				beanCopier.copy(jgdmSave, jgdm, null);
    			}
    			//预赋码
    			if ("2".equals(formType)) {
    				jgdm.setCzflag("1");
    				jgdm.setLastdate(DateUtil.getCurrentSystemDateTime());
    				jgdm.setDybz("0");
    				jgdm.setQzbz("0");
    				jgdm.setBgbj("0");
    				jgdm.setYjflag("0");
    				jgdm.setSjzt("0");
    			}
    			jgdm.setJgdm(codeId);
    			jgdm.setDybz("0");
    			
    			jgdm.setLastdate(new Date());
    			EntityManager em = EntityManagerHelper.getEntityManager();
    			EntityTransaction tx = null;
    			try {
    				tx = em.getTransaction();
    				tx.begin();
    				if(jgdmSave.getBak3().trim().equals("3")){
    					em.createNativeQuery("update t_dzda_ysm set jgdm='"+codeId+"' where jgdm='"+jgdmSave.getId()+"'").executeUpdate();
    					jgdm.setBak1("");
    					jgdm.setBak2("");
    					jgdm.setBak3("");
    				}
    				em.persist(jgdm);
    				em.flush();
    				TSystem system = InitSysParams.system;
    				
    				if (system.getIsSmTask() && system.getHzSmTask()) {
    					List<TSmrw> rws = em.createQuery("select model from TSmrw model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ")
    					.setParameter(1, "4")
    					.setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date()))).setParameter(3, jgdm.getJgdm()).getResultList();
    					if (rws.isEmpty() && rws.size() <= 0) {
    						if ("0".equals(formType)) {
    							if (system.getIsSmTask() && system.getAddJgdmSmTask()) {
    								TSmrw task = new TSmrw();
    								BeanUtilsEx.copyProperties(task, jgdm);
    								task.setId(null);
    								task.setCreateTime(new Date());
    								task.setStatus(false);
    								task.setType(formType);
    								task.setCzr(user.getUserName());
    								em.persist(task);
    							}
    						}
    						if ("1".equals(formType)) {
    							if (system.getIsSmTask() && system.getQtfmSmTask()) {
    								TSmrw task = new TSmrw();
    								BeanUtilsEx.copyProperties(task, jgdm);
    								task.setId(null);
    								task.setCreateTime(new Date());
    								task.setStatus(false);
    								task.setType(SmTaskType.其他赋码.getValue().toString());
    								task.setCzr(user.getUserName());
    								em.persist(task);
    							}
    						}
    						if ("2".equals(formType)) {
    							if (system.getIsSmTask() && system.getAddJgdmSmTask()) {
    								TSmrw task = new TSmrw();
    								BeanUtilsEx.copyProperties(task, jgdm);
    								task.setId(null);
    								task.setCreateTime(new Date());
    								task.setStatus(false);
    								task.setType(SmTaskType.预赋码更新.getValue().toString());
    								task.setCzr(user.getUserName());
    								em.persist(task);
    							}
    						}
    					}
    				}
    				//如果发卡，插入卡信息
    				if ("1".equals(jgdmSave.getFkbz())) {
    					int fksl = jgdmSave.getFksl();
    					for (int i = 0; i < fksl; i++) {
    						
    						
    						//插入ic卡信息表
    						TkKxxk kxxk = new TkKxxk();
    						/*kxxk.setLsh(Integer.valueOf(num));*/
    						kxxk.setCzy(user.getUserName());
    						kxxk.setJgdm(jgdm.getJgdm());
    						kxxk.setBkbz("1");
    						kxxk.setCzsj(DateUtil.getCurrentSystemDateTime());
    						kxxk.setSqsj(new Date());
    						kxxk.setFkbz("0");
    						kxxk.setFlag("0");
    						kxxk.setGsbz("0");
    						kxxk.setSbbz("0");
    						kxxk.setXzqh(user.getBzjgdm());
    						kxxk.setXgbz("0");
    						kxxk.setHaveDown("0");
    						em.persist(kxxk);
    						 
    						//插入操作日志
    						TCzjl czjl = new TCzjl();
    						czjl.setDate(DateUtil.getCurrentSystemDateTime());
    						czjl.setJgdm(codeId);
    						czjl.setName(user.getUserName());
    						czjl.setType("Q");
    						czjl.setXzqh(user.getBzjgdm());
    						czjl.setKlsh(kxxk.getLsh().longValue());
    						em.persist(czjl);
    					}
//                        em.createNativeQuery("UPDATE s_serial SET flow_id = flow_id + ?1 WHERE xzqh_code = ?2 AND table_type = ?3 ").setParameter(1, fksl).setParameter(2, "100000").setParameter(3, 1).executeUpdate();
    				}
    				
    				/*//新办超期处罚
                    if ("2".equals(formType) || (!"2".equals(formType) && (!"B".equals(jgdmSave.getJglx()) || !"b".equals(jgdmSave.getJglx())))) {
                        //新办超期时间
                        //新办是否处罚
                        Boolean xbcqcf = InitSysParams.system.getXbsfcf();
                        int xbcqsz = InitSysParams.system.getXbcqsz();

                        if (xbcqcf && xbcqsz > 0) {
                            String strsql = "SELECT * FROM t_jgdm WHERE datediff(DAY,zcrq,bzrq)>" + xbcqsz + " AND jgdm='" + codeId + "'";
                            List cfList = em.createNativeQuery(strsql).getResultList();
                            if (cfList != null && cfList.size() > 0) {
                                strsql = "INSERT INTO t_cfjlb(jgdm,bzjgdm,jgmc,jglx,fddbr,jgdz,zfrq,lrrq,lrr,zjhm,zjlx,njqx,zcrq,cflx,cfbz) VALUES('" + codeId + "','" + jgdmSave.getBzjgdm() + "','" + jgdmSave.getJgmc() + "','" + jgdmSave.getJglx() + "','" + jgdmSave.getFddbr() + "','" + jgdmSave.getJgdz() + "','" + jgdmSave.getZfrq() + "','" + DateUtil.getCurrentDateTime() + "','" + user.getUserName() + "','" + jgdmSave.getZjhm() + "','" + jgdmSave.getZjlx() + "','" + jgdmSave.getNjqx() + "','" + jgdmSave.getZcrq() + "','01','0')";
                                em.createNativeQuery(strsql).executeUpdate();
                            }
                        }

                    }*/
    				//删除机构代码临时表,如果是申请表，也要删除对应的码段库
    				em.remove(em.getReference(TJgdmSave.class, Integer.valueOf(id)));
    				/* if ("0".equals(formType)) {
                        em.remove(em.getReference(TMdk.class, codeId));
                        em.flush();
                    }*/
    				TCzjl czjl = new TCzjl();
    				czjl.setDate(DateUtil.getCurrentSystemDateTime());
    				czjl.setJgdm(codeId);
    				czjl.setName(user.getUserName());
    				if ("0".equals(formType)) {
    					czjl.setType("1A");
    					czjl.setMemo("普通新办校对!");
    				} else if ("2".equals(formType)) {
    					czjl.setType("1");
    					czjl.setMemo("预赋码校对!");
    				} else {
    					czjl.setType("1");
    					czjl.setMemo("其它部门赋码校对!");
    				}
    				czjl.setXzqh(user.getBzjgdm()); 
    				em.persist(czjl);
    				result = 1;
    				
    				tx.commit();
    			} catch (Exception e) {
    				log.error("TJgdmSaveBus revision exception============" + e.toString());
    				if (tx != null && tx.isActive()) {
    					tx.rollback();
    				}
    			} finally {
    				EntityManagerHelper.closeEntityManager();
    			}
    		}
    		
    	}
    	
    	if (result.equals(1)) {
    		return result + ":" + codeId;
    	}
    	return result.toString();
    }

    /**
     * 预赋码插入,去t_mdk取dmflag为0对应的jgdm，找到第一个赋值给对应的t_jgdm_save。去t_jgdm中判断是否存在jgdm,存在提示机构代码已存在，否则赋码并插入到t_jgdm_save表,删除t_mdk这条记录
     * 更新s_serial表 flowid + 1
     *
     * @param jgdmSave
     * @return result 0 失败 1 成功 2 无可用的码段 3 机构代码已经存在，不能赋码
     */
    public int AddTjgdmSavePart(TJgdmSave jgdmSave, String sslcode) {
        int result = 0;
        String codeId = "";
        if (sslcode != null && !"".equals(sslcode.trim())) {
            codeId = sslcode.trim();
        } else {
            List<TMdk> list = new TMdkDAO().findByProperty("dmflag", "0");
            if (list != null && list.size() > 0) {
                codeId = list.get(0).getJgdm();
            } else
                result = 2;
        }
        if (result != 2) {
            TJgdm tjgdm = new TJgdmDAO().findById(codeId);
            if (tjgdm != null) {
                result = 3;
            }
            if (result != 3) {
                EntityManager em = EntityManagerHelper.getEntityManager();
                EntityTransaction tx = null;
                try {
                    tx = em.getTransaction();
                    tx.begin();
                    jgdmSave.setJgdm(codeId);
                    if (jgdmSave.getId() == null) {
                        em.persist(jgdmSave);
                    } else {
                        em.merge(jgdmSave);
                        em.flush();
                        em.createQuery("update TSpcf model set model.jgdm=?1 where model.jgdm=?2").setParameter(1, jgdmSave.getJgdm())
                                .setParameter(2, "" + jgdmSave.getId()).executeUpdate();

                    }
                    if (sslcode != null && !"".equals(sslcode.trim())) {
                    } else {
                        em.remove(em.getReference(TMdk.class, codeId));
                    }
                    em.createNativeQuery("UPDATE s_serial SET flow_id = flow_id + 1 WHERE table_type = ?1 ").setParameter(1, "3").executeUpdate();
                    TCzjl czjl = new TCzjl();
                    czjl.setDate(DateUtil.getCurrentSystemDateTime());
                    czjl.setJgdm(codeId);
                    czjl.setName(jgdmSave.getUserid());
                    if (sslcode != null && !"".equals(sslcode.trim())) {
                        czjl.setType("P");
                    }else{
                        czjl.setType("P");
                    }
                    czjl.setMemo("预赋码(" + codeId + ")!");
                    //修改xzqh  bzjgdm
                    czjl.setXzqh(jgdmSave.getBzjgdm());

                    em.persist(czjl);
                    result = 1;
                    //保存成功，判断是否开启扫描任务，如果开启并设置了预赋码扫描，添加到扫描任务里
                    TSystem system = InitSysParams.system;

                    if (system.getIsSmTask() && system.getYfmSmTask()) {
                        List<TSmrw> rws = em.createQuery("select model from TSmrw model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ")
                                .setParameter(1, "4")
                                .setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date()))).setParameter(3, codeId).getResultList();
                        if (rws.isEmpty() && rws.size() <= 0) {
                            TSmrw task = new TSmrw();
                            BeanUtilsEx.copyProperties(task, jgdmSave);
                            task.setId(null);
                            task.setCreateTime(new Date());
                            task.setStatus(false);
                            task.setType(SmTaskType.预赋码.getValue().toString());
                            task.setCzr(jgdmSave.getLry());
                            em.persist(task);
                        }
                    }
                    tx.commit();
                } catch (Exception e) {
                    result = 4;
                    log.error(TJgdmSaveBus.class, e);
                    if (tx != null && tx.isActive()) {
                        tx.rollback();
                    }
                } finally {
                    EntityManagerHelper.closeEntityManager();
                }
            }
        }

        return result;
    }

    public List<TjgdmCommon> getFrdbList(String fddbr) {
        List<TjgdmCommon> list = new ArrayList<TjgdmCommon>();
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
//            String sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'机构代码临时表' AS sjly,'t_jgdm_save' AS tablename,zjhm,zfrq, id,lry FROM t_jgdm_save WHERE fddbr='" + fddbr + "' ORDER BY zjhm ";
            String sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'机构代码临时表' AS sjly,'t_jgdm_save' AS tablename,zjhm,id,lry FROM t_jgdm_save WHERE fddbr='" + fddbr + "' ORDER BY zjhm ";
            Query query = em.createNativeQuery(sql);
            List<Object[]> returnList = query.getResultList();
            if (returnList != null && returnList.size() > 0) {
                TjgdmCommon vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    for(int i=0;i<objects.length;i++){
                    	if(objects[i]==null){
                    		objects[i]="";
                    	}
                    }
                    vo.setJgdm(objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(fddbr);
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
//                    vo.setZfrq((Date) objects[7]);
                    vo.setId(objects[7].toString());
                    vo.setLry(objects[8].toString());
                    list.add(vo);
                }
            }
//            sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'机构代码表' AS sjly,'t_jgdm' AS tablename,zjhm,zfrq FROM t_jgdm WHERE fddbr='" + fddbr + "' ORDER BY zjhm";
//            sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'机构代码表' AS sjly,'t_jgdm' AS tablename,zjhm FROM t_jgdm WHERE fddbr='" + fddbr + "' ORDER BY zjhm";
            sql = "SELECT tyshxydm,jgmc,fddbr,bzjgdm,'机构代码表' AS sjly,'t_jgdm' AS tablename,zjhm FROM t_jgdm WHERE fddbr='" + fddbr + "' ORDER BY zjhm";
            query = em.createNativeQuery(sql);
            returnList = query.getResultList();
            if (returnList != null && returnList.size() > 0) {
                TjgdmCommon vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setTyshxydm(objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(fddbr);
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
//                    vo.setZfrq((Date) objects[7]);
                    list.add(vo);
                }
            }

           /* sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'迁址库' AS sjly,'t_qzjgdm' AS tablename,zjhm,zfrq FROM t_qzjgdm WHERE fddbr='" + fddbr + "' ORDER BY zjhm";
            query = em.createNativeQuery(sql);
            returnList = query.getResultList();
            if (returnList != null && returnList.size() > 0) {
                TjgdmCommon vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setJgdm(objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(fddbr);
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
                    vo.setZfrq((Date) objects[7]);
                    list.add(vo);
                }
            }*/

//            sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'注销库' AS sjly,'t_fzdm' AS tablename,zjhm,zfrq FROM t_fzdm WHERE fddbr='" + fddbr + "' ORDER BY zjhm";
            sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'注销库' AS sjly,'t_fzdm' AS tablename,zjhm FROM t_fzdm WHERE fddbr='" + fddbr + "' ORDER BY zjhm";
            query = em.createNativeQuery(sql);
            returnList = query.getResultList();
            if (returnList != null && returnList.size() > 0) {
                TjgdmCommon vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setJgdm(objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(fddbr);
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
//                    vo.setZfrq((Date) objects[7]);
                    list.add(vo);
                }
            }
        } catch (Exception e) {
            log.error(TJgdmSaveBus.class, e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    public List<TjgdmCommon> getZjhmList(String zjlx, String zjhm) {
        List<TjgdmCommon> list = new ArrayList();
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            String sql = "SELECT tyshxydm,jgmc,fddbr,bzjgdm,'临时表' AS sjly,'t_jgdm_save' AS tablename,zjhm,yxqxe, id FROM t_jgdm_save WHERE zjlx= '" + zjlx + "' AND zjhm = '" + zjhm + "' ORDER BY zjhm ";
            Query query = em.createNativeQuery(sql);
            List<Object[]> returnList = query.getResultList();
            TjgdmCommon vo = null;
            if (returnList != null && returnList.size() > 0) {

                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setTyshxydm(objects[0] == null ? null : objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(objects[2].toString());
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
                    vo.setZfrq((Date) objects[7]);
                    vo.setId(objects[8].toString());
                    list.add(vo);
                }
            }
            sql = "SELECT tyshxydm,jgmc,fddbr,bzjgdm,'有效库' AS sjly,'t_jgdm' AS tablename,zjhm,yxqxe FROM t_jgdm WHERE zjlx= '" + zjlx + "' AND zjhm = '" + zjhm + "' ORDER BY zjhm";
            query = em.createNativeQuery(sql);
            returnList = query.getResultList();
            if (returnList != null && returnList.size() > 0) {
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setTyshxydm(objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(objects[2].toString());
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
                    vo.setZfrq((Date) objects[7]);
                    list.add(vo);
                }
            }
        
        /*    sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'迁址库' AS sjly,'t_qzjgdm' AS tablename,zjhm,zfrq FROM t_qzjgdm WHERE zjlx= '" + zjlx + "' AND zjhm = '" + zjhm + "' ORDER BY zjhm";
            query = em.createNativeQuery(sql);
            returnList = query.getResultList();
            if (returnList != null && returnList.size() > 0) {
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setJgdm(objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(objects[2].toString());
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
                    vo.setZfrq((Date) objects[7]);
                    list.add(vo);
                }
            }*/

            sql = "SELECT tyshxydm,jgmc,fddbr,bzjgdm,'注销库' AS sjly,'t_fzdm' AS tablename,zjhm,yxqxe FROM t_fzdm WHERE zjlx= '" + zjlx + "' AND zjhm = '" + zjhm + "' ORDER BY zjhm";
            query = em.createNativeQuery(sql);
            returnList = query.getResultList();
            if (returnList != null && returnList.size() > 0) {
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setTyshxydm(objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(objects[2].toString());
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
                    vo.setZfrq((Date) objects[7]);
                    list.add(vo);
                }
            }
            EntityManager em1 = CheckEntityManagerHelper.getEntityManager();
            sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'代码有效库' AS sjly,'t_jgdm_bs' AS tablename,zjhm,zcrq FROM t_jgdm WHERE zjlx= '" + zjlx + "' AND zjhm = '" + zjhm + "' ORDER BY zjhm";
            Query query1 = em1.createNativeQuery(sql);
            returnList = query1.getResultList();
            if (returnList != null && returnList.size() > 0) {
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setTyshxydm(objects[0] == null ? null : objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(objects[2].toString());
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
                    vo.setZfrq((Date) objects[7]);
                    list.add(vo);
                }
            }
            sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'代码注销库' AS sjly,'t_fzdm_bs' AS tablename,zjhm,zcrq FROM t_fzdm WHERE zjlx= '" + zjlx + "' AND zjhm = '" + zjhm + "' ORDER BY zjhm";
            query1 = em1.createNativeQuery(sql);
            returnList = query1.getResultList();
            if (returnList != null && returnList.size() > 0) {
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setTyshxydm(objects[0] == null ? null : objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(objects[2].toString());
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3] == null ? null : objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
                    vo.setZfrq((Date) objects[7]);
                    list.add(vo);
                }
            }
        } catch (Exception e) {
            log.error(TJgdmSaveBus.class, e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    public List<TjgdmCommon> getMcList(String type, String value) {
        List<TjgdmCommon> list = new ArrayList();
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManager checkEm = CheckEntityManagerHelper.getEntityManager();
            String sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'临时表' AS sjly,'t_jgdm_save' AS tablename,zjhm, id,zch FROM t_jgdm_save WHERE " + type + "= '" + value + "'  ORDER BY zjhm ";
            Query query = em.createNativeQuery(sql);
            List<Object[]> returnList = query.getResultList();
            if (returnList != null && returnList.size() > 0) {
                TjgdmCommon vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setJgdm(objects[0] == null ? null : objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(objects[2].toString());
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
                   // vo.setZfrq((Date) objects[7]);
                    vo.setId(objects[7].toString());
                    //vo.setZch(objects[9].toString());
                    list.add(vo);
                }
            }
            sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'有效库' AS sjly,'t_jgdm' AS tablename,zjhm,zch,tyshxydm FROM t_jgdm WHERE " + type + "= '" + value + "' ORDER BY zjhm";
            query = em.createNativeQuery(sql);
            returnList = query.getResultList();
            if (returnList != null && returnList.size() > 0) {
                TjgdmCommon vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setJgdm(objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(objects[2] == null ? null:objects[2].toString());
                    vo.setSjly(objects[4] == null ? null:objects[4].toString());
                    vo.setBzjgdm(objects[3] == null ? null:objects[3].toString());
                    vo.setTableName(objects[5] == null ? null:objects[5].toString());
                    vo.setZjhm(objects[6] == null ? null:objects[6].toString());
                   // vo.setZfrq((Date) objects[7]);
                    //vo.setZch(objects[8].toString());

                    vo.setTyshxydm(objects[8].toString());
                    list.add(vo);
                }
            }

         

            sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'注销库' AS sjly,'t_fzdm' AS tablename,zjhm,fzrq,zch,tyshxydm FROM t_fzdm WHERE " + type + "= '" + value + "' ORDER BY zjhm";
            query = em.createNativeQuery(sql);
            returnList = query.getResultList();
            if (returnList != null && returnList.size() > 0) {
                TjgdmCommon vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setJgdm(objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(objects[2] == null ? null:objects[2].toString());
                    vo.setSjly(objects[4] == null ? null:objects[4].toString());
                    vo.setBzjgdm(objects[3] == null ? null:objects[3].toString());
                    vo.setTableName(objects[5] == null ? null:objects[5].toString());
                    vo.setZjhm(objects[6] == null ? null:objects[6].toString());
                    vo.setZfrq((Date) objects[7]);
                    vo.setZch(objects[8]==null?"":objects[8].toString());
                    vo.setTyshxydm(objects[9]==null?"":objects[9].toString());
                    list.add(vo);
                }
            }
            
            if("0".equals(checkName)){

                sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'代码有效库' AS sjly,'t_jgdm' AS tablename,zjhm,zch,tyshxydm FROM t_jgdm WHERE " + type + "= '" + value + "' ORDER BY zjhm";
                query = checkEm.createNativeQuery(sql);
                returnList = query.getResultList();
                if (returnList != null && returnList.size() > 0) {
                    TjgdmCommon vo = null;
                    for (Object[] objects : returnList) {
                        vo = new TjgdmCommon();
                        vo.setJgdm(objects[0] == null ? "": objects[0].toString());
                        vo.setJgmc(objects[1] == null ? "": objects[1].toString());
                        vo.setFddbr(objects[2] == null ? "": objects[2].toString());
                        vo.setSjly(objects[4].toString());
                        vo.setBzjgdm(objects[3] == null ? "": objects[3].toString());
                        vo.setTableName(objects[5].toString());
                        vo.setZjhm(objects[6] == null ? "": objects[6].toString());
                        //vo.setZfrq((Date) objects[7]);
                        vo.setZch(objects[7]==null?"":objects[7].toString());

                        vo.setTyshxydm(objects[8]==null?"":objects[8].toString());
                        list.add(vo);
                    }
                }

             

                sql = "SELECT jgdm,jgmc,fddbr,bzjgdm,'代码注销库' AS sjly,'t_fzdm' AS tablename,zjhm,fzrq,zch FROM t_fzdm WHERE " + type + "= '" + value + "' ORDER BY zjhm";
                query = checkEm.createNativeQuery(sql);
                returnList = query.getResultList();
                if (returnList != null && returnList.size() > 0) {
                    TjgdmCommon vo = null;
                    for (Object[] objects : returnList) {
                        vo = new TjgdmCommon();
                        vo.setJgdm(objects[0] == null ? "": objects[0].toString());
                        vo.setJgmc(objects[1] == null ? "": objects[1].toString());
                        vo.setFddbr(objects[2] == null ? "": objects[2].toString());
                        vo.setSjly(objects[4].toString());
                        vo.setBzjgdm(objects[3] == null ? "": objects[3].toString());
                        vo.setTableName(objects[5].toString());
                        vo.setZjhm(objects[6] == null ? "": objects[6].toString());
                        vo.setZfrq((Date) objects[7]);
                        vo.setZch(objects[8]==null?"":objects[8].toString());
                        list.add(vo);
                    }
                }
                
            }
            
            
        } catch (Exception e) {
            log.error(TJgdmSaveBus.class, e);
        } finally {
            EntityManagerHelper.closeEntityManager();
            CheckEntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    public List<TjgdmCommon> getHzcqList(String value) {
        List<TjgdmCommon> list = new ArrayList();
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            String sql = "select model.jgdm,model.jgmc,model.fddbr,model.bzjgdm,'机构代码表' as sjly,'t_jgdm' as name,model.zjhm ,model.zfrq from  Hzcq model where zjhm= '" + value + "'  order by model.zjhm ";
            Query query = em.createQuery(sql);
            List<Object[]> returnList = query.getResultList();
            if (returnList != null && returnList.size() > 0) {
                TjgdmCommon vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmCommon();
                    vo.setJgdm(objects[0] == null ? null : objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setFddbr(objects[2].toString());
                    vo.setSjly(objects[4].toString());
                    vo.setBzjgdm(objects[3].toString());
                    vo.setTableName(objects[5].toString());
                    vo.setZjhm(objects[6].toString());
                    vo.setZfrq((Date) objects[7]);
                    list.add(vo);
                }
            }

        } catch (Exception e) {
            log.error(TJgdmSaveBus.class, e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    /**
     * 集中赋码
     *
     * @param id
     * @param formType
     * @param user
     * @param sslCode  webService  获得的机构代码
     * @return
     */
/*    public synchronized String revision(String id, String formType, User user, String sslCode) {
        Integer result = 0;
        TJgdmSave jgdmSave = this.findById(Integer.valueOf(id));
        //如果是预赋码 要判断数据的完整性
        if ("2".equals(formType)) {
            String jglx = jgdmSave.getJglx();
            if (clsStringTool.isEmpty(jglx)) {
                result = 4;
                return result.toString();
            }
        }
        //如果是其它部门赋码或预赋码不用在去取jgdm
        //如果机构类型是B的，用dmFlag=3的去查，否则用0去查
        String codeId = "";
        //申请表登记
        if ("0".equals(formType)) {
            List<TMdk> list = null;
            if ("B".equals(jgdmSave.getJglx()) || "b".equals(jgdmSave.getJglx())) {
                list = new TMdkDAO().findByProperty("dmflag", "3");
                if (list != null && list.size() > 0) {
                    codeId = list.get(0).getJgdm();
                } else
                    result = 2;
            } else {
                list = new TMdkDAO().findByProperty("dmflag", "0");
                if (list != null && list.size() > 0) {
                    codeId = list.get(0).getJgdm();
                } else
                    result = 2;
            }
        }
        //其它部门赋码或者预赋码
        if ("1".equals(formType) || "2".equals(formType)) {
            codeId = jgdmSave.getJgdm();
        } else{
            codeId = sslCode;
        }
        //赋值ssl

        if (result != 2) {
            if (result != 3) {
                TJgdm jgdm = new TJgdm();
                if (jgdmSave != null) {
                    BeanCopier beanCopier = BeanCopier.create(TJgdmSave.class, TJgdm.class, false);
                    beanCopier.copy(jgdmSave, jgdm, null);
                }
                //预赋码
                if ("2".equals(formType)) {
                    jgdm.setCzflag("1");
                    jgdm.setLastdate(DateUtil.getCurrentSystemDateTime());
                    jgdm.setDybz("0");
                    jgdm.setQzbz("0");
                    jgdm.setBgbj("0");
                    jgdm.setYjflag("0");
                    jgdm.setSjzt("0");
                }
                
                jgdm.setJgdm(codeId);
                jgdm.setDybz("0");
                jgdm.setLastdate(new Date());
                EntityManager em = EntityManagerHelper.getEntityManager();
                EntityTransaction tx = null;
                try {
                    tx = em.getTransaction();
                    tx.begin();
                    if(jgdm.getBak3()!=null&&jgdm.getBak3().length()>15){
                    	em.createNativeQuery("update t_ywlc set jgdm='"+jgdm.getJgdm()+"',jgmc='"+jgdm.getJgmc()+"',ywlclx='1',type='校对赋码',isend='1' where ywlsh='"+jgdm.getBak3().trim()+"'").executeUpdate();
                    	jgdm.setBak3(""); 
                    }
                    em.persist(jgdm);
                    em.flush();
                    TSystem system = InitSysParams.system;

                    if (system.getIsSmTask() && system.getHzSmTask()) {
                        List<TSmrw> rws = em.createQuery("select model from TSmrw model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ")
                                .setParameter(1, "4")
                                .setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date()))).setParameter(3, jgdm.getJgdm()).getResultList();
                        if (rws.isEmpty() && rws.size() <= 0) {
                            if ("0".equals(formType)) {
                                if (system.getIsSmTask() && system.getAddJgdmSmTask()) {
                                    TSmrw task = new TSmrw();
                                    BeanUtilsEx.copyProperties(task, jgdm);
                                    task.setId(null);
                                    task.setCreateTime(new Date());
                                    task.setStatus(false);
                                    task.setType(formType);
                                    task.setCzr(user.getUserName());
                                    em.persist(task);
                                }
                            }
                            if ("1".equals(formType)) {
                                if (system.getIsSmTask() && system.getQtfmSmTask()) {
                                    TSmrw task = new TSmrw();
                                    BeanUtilsEx.copyProperties(task, jgdm);
                                    task.setId(null);
                                    task.setCreateTime(new Date());
                                    task.setStatus(false);
                                    task.setType(SmTaskType.其他赋码.getValue().toString());
                                    task.setCzr(user.getUserName());
                                    em.persist(task);
                                }
                            }
                            if ("2".equals(formType)) {
                                if (system.getIsSmTask() && system.getAddJgdmSmTask()) {
                                    TSmrw task = new TSmrw();
                                    BeanUtilsEx.copyProperties(task, jgdm);
                                    task.setId(null);
                                    task.setCreateTime(new Date());
                                    task.setStatus(false);
                                    task.setType(SmTaskType.预赋码更新.getValue().toString());
                                    task.setCzr(user.getUserName());
                                    em.persist(task);
                                }
                            }
                        }
                    }
                    //如果发卡，插入卡信息
                    if ("1".equals(jgdmSave.getFkbz())) {
                        int fksl = jgdmSave.getFksl();
                        for (int i = 0; i < fksl; i++) {
                            //插入ic卡信息表
                            TkKxxk kxxk = new TkKxxk();
                                kxxk.setLsh(Integer.valueOf(num));
                            kxxk.setCzy(user.getUserName());
                            kxxk.setJgdm(jgdm.getJgdm());
                            kxxk.setBkbz("1");
                            kxxk.setCzsj(DateUtil.getCurrentSystemDateTime());
                            kxxk.setSqsj(new Date());
                            kxxk.setFkbz("0");
                            kxxk.setFlag("0");
                            kxxk.setGsbz("0");
                            kxxk.setSbbz("0");
                            kxxk.setXzqh(user.getBzjgdm());
                            kxxk.setXgbz("0");
                            kxxk.setHaveDown("0");
                            em.persist(kxxk);
                            //插入操作日志
                            TCzjl czjl = new TCzjl();
                            czjl.setDate(DateUtil.getCurrentSystemDateTime());
                            czjl.setJgdm(codeId);
                            czjl.setName(user.getUserName());
                            czjl.setType("Q");
                            czjl.setXzqh(user.getBzjgdm());
                            czjl.setKlsh(kxxk.getLsh().longValue());
                            em.persist(czjl);
                        }
//                        em.createNativeQuery("UPDATE s_serial SET flow_id = flow_id + ?1 WHERE xzqh_code = ?2 AND table_type = ?3 ").setParameter(1, fksl).setParameter(2, "100000").setParameter(3, 1).executeUpdate();
                    }

                    //新办超期处罚
                    if ("2".equals(formType) || (!"2".equals(formType) && (!"B".equals(jgdmSave.getJglx()) || !"b".equals(jgdmSave.getJglx())))) {
                        //新办超期时间
                        //新办是否处罚
                        Boolean xbcqcf = InitSysParams.system.getXbsfcf();
                        int xbcqsz = InitSysParams.system.getXbcqsz();

                        if (xbcqcf && xbcqsz > 0) {
                            String strsql = "SELECT * FROM t_jgdm WHERE datediff(DAY,zcrq,bzrq)>" + xbcqsz + " AND jgdm='" + codeId + "'";
                            List cfList = em.createNativeQuery(strsql).getResultList();
                            if (cfList != null && cfList.size() > 0) {
                                strsql = "INSERT INTO t_cfjlb(jgdm,bzjgdm,jgmc,jglx,fddbr,jgdz,zfrq,lrrq,lrr,zjhm,zjlx,njqx,zcrq,cflx,cfbz) VALUES('" + codeId + "','" + jgdmSave.getBzjgdm() + "','" + jgdmSave.getJgmc() + "','" + jgdmSave.getJglx() + "','" + jgdmSave.getFddbr() + "','" + jgdmSave.getJgdz() + "','" + jgdmSave.getZfrq() + "','" + DateUtil.getCurrentDateTime() + "','" + user.getUserName() + "','" + jgdmSave.getZjhm() + "','" + jgdmSave.getZjlx() + "','" + jgdmSave.getNjqx() + "','" + jgdmSave.getZcrq() + "','01','0')";
                                em.createNativeQuery(strsql).executeUpdate();
                            }
                        }

                    }
                    //删除机构代码临时表,如果是申请表，也要删除对应的码段库
                    em.remove(em.getReference(TJgdmSave.class, Integer.valueOf(id)));
                    if ("0".equals(formType)) {
                        em.remove(em.getReference(TMdk.class, codeId));
                        em.flush();
                    }
                    TCzjl czjl = new TCzjl();
                    czjl.setDate(DateUtil.getCurrentSystemDateTime());
                    czjl.setJgdm(codeId);
                    czjl.setName(user.getUserName());
                    if ("0".equals(formType)) {
                        czjl.setType("1A");
                        czjl.setMemo("普通新办校对!");
                    } else if ("2".equals(formType)) {
                        czjl.setType("1");
                        czjl.setMemo("预赋码校对!");
                    } else {
                        czjl.setType("1");
                        czjl.setMemo("其它部门赋码校对!");
                    }
                    czjl.setXzqh(user.getBzjgdm());
                    em.persist(czjl);
                    result = 1;
                    tx.commit();
                } catch (Exception e) {
                    log.error("TJgdmSaveBus revision exception============" + e.toString());
                    if (tx != null && tx.isActive()) {
                        tx.rollback();
                    }
                } finally {
                    EntityManagerHelper.closeEntityManager();
                }
            }

        }
        if (result.equals(1)) {
            return result + ":" + codeId;
        }
        return result.toString();
    }*/

}
