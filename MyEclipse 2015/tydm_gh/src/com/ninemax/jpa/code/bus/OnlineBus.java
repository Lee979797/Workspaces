package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.code.model.vo.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.WsbzEntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.MD532;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;


import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 13-5-22
 * Time: 下午3:58
 */
public class OnlineBus {

    private static Logger log = Logger
            .getLogger(TJgdmSaveBus.class);

    public OnlineBus() {
    }

    /**
     * 挂失业务列表
     * @param user
     * @return
     */
    public List<OnLineVO> getGsList(String jgdm,User user,String zt,Integer pageno, Integer rowNumsView, clsPageComponent pages){
        List<OnLineVO> list = null;
        OnLineVO onLineVO = null;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            String strsql = "SELECT w_gs_id,w_gs_djh,w_gs_jgdm,w_gs_tjsj from w_gs where w_gs_zt = '"+zt+"'"+((user.getUserName()!=null && user.getUserName().contains("admin"))?"":" and w_gs_bzjgdm = '"+user.getBzjgdm()+"'  ");
            if(!clsStringTool.isEmpty(jgdm)){
                strsql += " and w_gs_jgdm =  '"+jgdm+"' ";
            }
            strsql += " order by w_gs_id desc";
            Query query = em.createNativeQuery(strsql);
            List<Object> params = new ArrayList();
            query.setFirstResult(rowNumsView * (pageno - 1));
            query.setMaxResults(rowNumsView);
            pages.setOnlineTotalSize(strsql.substring(strsql.indexOf("from"), strsql.indexOf("order")), params);
            pages.setPageSize(rowNumsView);
            pages.setTotalPages();
            pages.setLastPage();
            pages.setStartIndex(pageno);
            pages.setCurrentPage(pageno);
            List<Object[]> gsList = query.getResultList();
            if (gsList != null && gsList.size() > 0) {
                list = new ArrayList<OnLineVO>();
                for(Object[] objects: gsList){
                    onLineVO = new OnLineVO();
                    onLineVO.setId(objects[0].toString());
                    onLineVO.setDjh(objects[1]==null?"":objects[1].toString());
                    onLineVO.setJgdm(objects[2]==null?"":objects[2].toString());
                    String jgmc = this.getJgmcByJgdm(objects[2]==null?"":objects[2].toString().trim());
                    onLineVO.setJgmc(jgmc);
                    onLineVO.setTjsj(objects[3]==null?"":objects[3].toString());
                    list.add(onLineVO);
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getGsList exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    public Wgs getWgs(String id) {
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        Wgs wgs = null;
        try {
            String strsql = "SELECT w_gs_zsdjh,w_gs_gsyy,w_gs_gsyj,w_gs_tbr,w_gs_lxdh,w_gs_tjr,w_gs_ic from w_gs where w_gs_id = :id ";
            Query query = em.createNativeQuery(strsql);
            query.setParameter("id",id);
            List<Object[]> gsList = query.getResultList();
            if (gsList != null && gsList.size() > 0) {
                for(Object[] objects: gsList){
                    wgs = new Wgs();
                    wgs.setZsdjh(objects[0].toString());
                    wgs.setGsyy(objects[1].toString());
                    wgs.setGsyj(objects[2].toString());
                    wgs.setTbr(objects[3].toString());
                    wgs.setLxdh(objects[4].toString());
                    wgs.setTjr(objects[5].toString());
                    wgs.setIc(objects[6].toString());
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getGsList exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return wgs;
    }


    private String getJgmcByJgdm(String jgdm) {
        String jgmc = "";
        TjgdmBus tjgdmBus = new TjgdmBus();
        TJgdm tjgdm = tjgdmBus.findById(jgdm);
        if(tjgdm!=null){
            jgmc = tjgdm.getJgmc();
        }
        return jgmc;
    }
    
    /**
     * 年度申报更新
     * @param wnj
     * @return
     */
    public String nbUpdate(String jgdm,String id,Date njrq){
    	Wnj wnj=getNj(id);
    	TjgdmBus tjgdmBus = new TjgdmBus();
        TJgdm tjgdm = tjgdmBus.findById(wnj.getJgdm());
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
 
        try {
			tx.begin();
			upNj(id);
			tjgdm.setDhhm(wnj.getDhhm());
			tjgdm.setTbrxm(wnj.getTbrxm());
			tjgdm.setTbrsfzh(wnj.getTbrsfzh());
			tjgdm.setTbrlxfs(wnj.getTbrlxfs());
			tjgdm.setNjqx(njrq);
			tjgdm.setNjrq(DateUtil.getCurrentSystemDateTime());
			tjgdm.setLastdate(DateUtil.getCurrentSystemDateTime());
			em.merge(tjgdm);
			em.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			EntityManagerHelper.closeEntityManager();
		}
        
        return null;
    	
    }

    /**
     * 备案业务列表
     * @param user
     * @return
     */
    public List<OnLineVO> getBaList(String jgdm,User user,String zt,Integer pageno, Integer rowNumsView, clsPageComponent pages){
        List<OnLineVO> list = null;
        OnLineVO onLineVO = null;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            String strsql = "select w_ba_id,w_ba_djh,w_ba_jgdm,w_ba_barq,w_ba_bayxq, w_ba_tjsj from w_ba where w_ba_zt = '"+zt+"'"+((user.getUserName()!=null && user.getUserName().contains("admin"))?"":" and w_ba_bzjgdm = '"+user.getBzjgdm()+"'  ");
            if(!clsStringTool.isEmpty(jgdm)){
                strsql += " and w_ba_jgdm = '"+jgdm+"' ";
            }
            strsql += " order by w_ba_id desc";
            Query query = em.createNativeQuery(strsql);
            List<Object> params = new ArrayList();
            query.setFirstResult(rowNumsView * (pageno - 1));
            query.setMaxResults(rowNumsView);
            pages.setOnlineTotalSize(strsql.substring(strsql.indexOf("from"), strsql.indexOf("order")), params);
            pages.setPageSize(rowNumsView);
            pages.setTotalPages();
            pages.setLastPage();
            pages.setStartIndex(pageno);
            pages.setCurrentPage(pageno);
            List<Object[]> gsList = query.getResultList();
            if (gsList != null && gsList.size() > 0) {
                list = new ArrayList<OnLineVO>();
                for(Object[] objects: gsList){
                    onLineVO = new OnLineVO();
                    onLineVO.setId(objects[0].toString());
                    onLineVO.setDjh(objects[1].toString());
                    onLineVO.setJgdm(objects[2].toString());
                    onLineVO.setBarq(objects[3].toString());
                    onLineVO.setBayxq(objects[4].toString());
                    onLineVO.setTjsj(objects[5].toString());
                    list.add(onLineVO);
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus geBaList exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return list;
    }
    
    /**
     * 年度申报
     * @param jgdm
     * @param user
     * @param zt
     * @param pageno
     * @param rowNumsView
     * @param pages
     * @return
     */
    public List<Wnj> getNjList(String jgdm,User user,String zt,Integer pageno, Integer rowNumsView, clsPageComponent pages){
        List<Wnj> list = null;
        Wnj wnj = null;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            String strsql = "select jgdm,jgmc,tbrxm,tbrsfzh,tbrlxfs,dhhm,type,nbsj,id,bzjgdm from w_nj where type='0' "+((user.getUserName()!=null && user.getUserName().contains("admin"))?"":" and bzjgdm = '"+user.getBzjgdm()+"'  ");
  
            if(!clsStringTool.isEmpty(jgdm)){
                strsql += " and jgdm = '"+jgdm+"' ";
            }
            
            strsql += " order by id desc";
            Query query = em.createNativeQuery(strsql);
            List<Object> params = new ArrayList();
            query.setFirstResult(rowNumsView * (pageno - 1));
            query.setMaxResults(rowNumsView);
            pages.setOnlineTotalSize(strsql.substring(strsql.indexOf("from"), strsql.indexOf("order")), params);
            pages.setPageSize(rowNumsView);
            pages.setTotalPages();
            pages.setLastPage();
            pages.setStartIndex(pageno);
            pages.setCurrentPage(pageno);
            List<Object[]> gsList = query.getResultList();
            if (gsList != null && gsList.size() > 0) {
                list = new ArrayList<Wnj>();
                for(Object[] objects: gsList){
                    wnj = new Wnj();
                    wnj.setJgdm(objects[0].toString());
                    wnj.setJgmc(objects[1].toString());
                    wnj.setTbrxm(objects[2].toString());
                    wnj.setTbrsfzh(objects[3].toString());
                    wnj.setTbrlxfs(objects[4].toString());
                    wnj.setDhhm(objects[5].toString());
                    wnj.setType(objects[6].toString());
                    wnj.setNbsj(objects[7].toString());
                    wnj.setId(objects[8].toString());
                    wnj.setBzjgdm(objects[9]==null?"":objects[9].toString());
                    
                  
                    list.add(wnj);
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus geBaList exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return list;
    }
    
    /**
     * 根据id获取年检数据
     * @param id
     * @return
     */
    public Wnj getNj(String id) {
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        Wnj wnj = null;
        try {
        	 String strsql = "select jgdm,jgmc,tbrxm,tbrsfzh,tbrlxfs,dhhm,type,nbsj,id,bzjgdm from w_nj where id=:id ORDER BY nbsj DESC";
        	  
            Query query = em.createNativeQuery(strsql);
            query.setParameter("id",id);
            List<Object[]> gsList = query.getResultList();
            if (gsList != null && gsList.size() > 0) {
                for(Object[] objects: gsList){
                	wnj = new Wnj();
                    wnj.setJgdm(objects[0].toString());
                    wnj.setJgmc(objects[1].toString());
                    wnj.setTbrxm(objects[2].toString());
                    wnj.setTbrsfzh(objects[3].toString());
                    wnj.setTbrlxfs(objects[4].toString());
                    wnj.setDhhm(objects[5].toString());
                    wnj.setType(objects[6].toString());
                    wnj.setNbsj(objects[7].toString());
                    wnj.setId(objects[8].toString());
                    wnj.setBzjgdm(objects[9]==null?"":objects[9].toString());
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getWba exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return wnj;
    }

    
    public Wnj upNj(String id) {
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        Wnj wnj = null;
        EntityTransaction tx = em.getTransaction();
        try {
        	tx.begin();
        	 String strsql = "update w_nj set type='1' where id= "+id;
        	  
            em.createNativeQuery(strsql).executeUpdate();
            tx.commit();
      
        } catch (Exception e) {
        	tx.rollback();
            log.error("OnlineBus getWba exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return wnj;
    }


    /**
     * 根据id获取备案数据
     * @param id
     * @return
     */
    public Wba getWba(String id) {
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        Wba wba = null;
        try {
            String strsql = "SELECT w_ba_bazfrq,w_ba_barq,w_ba_bayxq,w_ba_bayy,w_ba_tbr,w_ba_lxdh,w_ba_tjr from w_ba where w_ba_id = :id ";
            Query query = em.createNativeQuery(strsql);
            query.setParameter("id",id);
            List<Object[]> gsList = query.getResultList();
            if (gsList != null && gsList.size() > 0) {
                for(Object[] objects: gsList){
                    wba = new Wba();
                    wba.setBazfrq(objects[0].toString());
                    wba.setBarq(objects[1].toString());
                    wba.setBayxq(objects[2].toString());
                    wba.setBayy(objects[3].toString());
                    wba.setTbr(objects[4].toString());
                    wba.setLxdh(objects[5].toString());
                    wba.setTjr(objects[6].toString());
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getWba exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return wba;
    }

    /**
     * 注销业务列表
     * @param user
     * @return
     */
    public List<OnLineVO> getZxList(String jgdm,User user,String zt,Integer pageno, Integer rowNumsView, clsPageComponent pages){
        List<OnLineVO> list = null;
        OnLineVO onLineVO = null;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            String strsql = "SELECT w_zx_id,w_zx_djh,w_zx_jgdm,w_zx_tjsj from w_zx where w_zx_zt = '"+zt+"'"+((user.getUserName()!=null && user.getUserName().contains("admin"))?"":" and w_zx_bzjgdm = '"+user.getBzjgdm()+"'  ");
            if(!clsStringTool.isEmpty(jgdm)){
                strsql += " and w_zx_jgdm = '"+jgdm+"'";
            }
            strsql += " order by w_zx_id desc";
            Query query = em.createNativeQuery(strsql);
            List<Object> params = new ArrayList();
            query.setFirstResult(rowNumsView * (pageno - 1));
            query.setMaxResults(rowNumsView);
            pages.setOnlineTotalSize(strsql.substring(strsql.indexOf("from"), strsql.indexOf("order")), params);
            pages.setPageSize(rowNumsView);
            pages.setTotalPages();
            pages.setLastPage();
            pages.setStartIndex(pageno);
            pages.setCurrentPage(pageno);
            List<Object[]> gsList = query.getResultList();
            if (gsList != null && gsList.size() > 0) {
                list = new ArrayList<OnLineVO>();
                for(Object[] objects: gsList){
                    onLineVO = new OnLineVO();
                    onLineVO.setId(objects[0].toString());
                    onLineVO.setDjh(objects[1].toString());
                    onLineVO.setJgdm(objects[2].toString());
                    String jgmc =this.getJgmcByJgdm(objects[2].toString().trim());
                    onLineVO.setJgmc(jgmc);
                    onLineVO.setTjsj(objects[3].toString());
                    list.add(onLineVO);
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getZxList exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    /**
     * 获取注销数据
     * @param id
     * @return
     */
    public Wzx getWzx(String id) {
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        Wzx wzx = null;
        try {
            String strsql = "SELECT w_zx_zxyy,w_zx_zxyj,w_zx_tbr,w_zx_lxdh,w_zx_tjr,w_zx_djh from w_zx where w_zx_id = :id ";
            Query query = em.createNativeQuery(strsql);
            query.setParameter("id",id);
            List<Object[]> gsList = query.getResultList();
            if (gsList != null && gsList.size() > 0) {
                for(Object[] objects: gsList){
                    wzx = new Wzx();
                    wzx.setZxyy(objects[0].toString());
                    wzx.setZxyj(objects[1].toString());
                    wzx.setTbr(objects[2].toString());
                    wzx.setLxdh(objects[3].toString());
                    wzx.setTjr(objects[4].toString());
                    wzx.setDjh(objects[5].toString());
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getWzx exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return wzx;
    }

    /**
     * 新办业务列表
     * @param user
     * @return
     */
    public List<OnLineVO> getXbList(String jgdm, User user,String zt,String ywlx,Integer pageno, Integer rowNumsView, clsPageComponent pages){
        List<OnLineVO> list = null;
        OnLineVO onLineVO = null;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            String strsql = "SELECT w_xb_id,w_xb_djh,w_xb_jgdm,w_xb_jgmc,w_xb_fddbr,w_xb_clrq,w_xb_zczj from w_xb where w_xb_zt = '"+zt+"'"+((user.getUserName()!=null && user.getUserName().contains("admin"))?"":" and w_xb_bzjgdm = '"+user.getBzjgdm()+"'  ");
            if(!clsStringTool.isEmpty(jgdm)){
                strsql += " and w_xb_jgdm = '"+jgdm+"'";
            }
            if(ywlx!=null&&!ywlx.equals("4")&&!ywlx.equals("5")){
                strsql += " and w_xb_lb = '"+ywlx+"'";
            }
            strsql += " order by w_xb_id desc";
            Query query = em.createNativeQuery(strsql);
            List<Object> params = new ArrayList();
            query.setFirstResult(rowNumsView * (pageno - 1));
            query.setMaxResults(rowNumsView);
            pages.setOnlineTotalSize(strsql.substring(strsql.indexOf("from"), strsql.indexOf("order")), params);
            pages.setPageSize(rowNumsView);
            pages.setTotalPages();
            pages.setLastPage();
            pages.setStartIndex(pageno);
            pages.setCurrentPage(pageno);
            List<Object[]> gsList = query.getResultList();
            if (gsList != null && gsList.size() > 0) {
                list = new ArrayList<OnLineVO>();
                for(Object[] objects: gsList){
                    onLineVO = new OnLineVO();
                    onLineVO.setId(objects[0]==null?"":objects[0].toString());
                    onLineVO.setDjh(objects[1] == null ? "" : objects[1].toString());
                    onLineVO.setJgdm(objects[2] == null ? "" : objects[2].toString());
                    onLineVO.setJgmc(objects[3] == null ? "" : objects[3].toString());
                    onLineVO.setFddbr(objects[4]==null?"":objects[4].toString());
                    onLineVO.setClrq(objects[5]==null?"":objects[5].toString());
                    onLineVO.setZczj(objects[6]==null?"":objects[6].toString());
                    list.add(onLineVO);
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getXbList exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return list;
    }
    /**
     * 新办网上业务修改列表
     * @param user
     * @return
     */
    public List<OnLineVO> getWsywList(String jgmc, User user,String zt,String ywlx,Integer pageno, Integer rowNumsView, clsPageComponent pages){
    	List<OnLineVO> list = null;
    	OnLineVO onLineVO = null;
    	EntityManager em = WsbzEntityManagerHelper.getEntityManager();
    	EntityTransaction tx = null;
    	try {
    		String strsql = "SELECT w_xb_id,w_xb_djh,w_xb_jgdm,w_xb_jgmc,w_xb_fddbr,w_xb_clrq,w_xb_zczj from w_xb where w_xb_zt = '"+zt+"'"+((user.getUserName()!=null && user.getUserName().contains("admin"))?"":" and w_xb_bzjgdm = '"+user.getBzjgdm()+"'  ");
    		if(!clsStringTool.isEmpty(jgmc)){
    			strsql += " and w_xb_jgmc like '%"+jgmc+"%'";
    		}
    		strsql += " and w_xb_lb = '"+0+"'";
    		strsql += " order by w_xb_id desc";
    		Query query = em.createNativeQuery(strsql);
    		List<Object> params = new ArrayList();
    		query.setFirstResult(rowNumsView * (pageno - 1));
    		query.setMaxResults(rowNumsView);
    		pages.setOnlineTotalSize(strsql.substring(strsql.indexOf("from"), strsql.indexOf("order")), params);
    		pages.setPageSize(rowNumsView);
    		pages.setTotalPages();
    		pages.setLastPage();
    		pages.setStartIndex(pageno);
    		pages.setCurrentPage(pageno);
    		List<Object[]> gsList = query.getResultList();
    		if (gsList != null && gsList.size() > 0) {
    			list = new ArrayList<OnLineVO>();
    			for(Object[] objects: gsList){
    				onLineVO = new OnLineVO();
    				onLineVO.setId(objects[0]==null?"":objects[0].toString());
    				onLineVO.setDjh(objects[1] == null ? "" : objects[1].toString());
    				onLineVO.setJgdm(objects[2] == null ? "" : objects[2].toString());
    				onLineVO.setJgmc(objects[3] == null ? "" : objects[3].toString());
    				onLineVO.setFddbr(objects[4]==null?"":objects[4].toString());
    				onLineVO.setClrq(objects[5]==null?"":objects[5].toString());
    				onLineVO.setZczj(objects[6]==null?"":objects[6].toString());
    				list.add(onLineVO);
    			}
    		}
    	} catch (Exception e) {
    		log.error("OnlineBus getXbList exception============" + e.toString());
    	} finally {
    		WsbzEntityManagerHelper.closeEntityManager();
    	}
    	return list;
    }
    
    /**
     * 重置密码

     * @return
     */
    public List<Wzcyh> initPassWord(String yhm, User user,String dm,String ywlx,Integer pageno, Integer rowNumsView, clsPageComponent pages){
    	List<Wzcyh> list = null;
    	Wzcyh zcyh = null;
    	EntityManager em = WsbzEntityManagerHelper.getEntityManager();
    	EntityTransaction tx = null;
    	try {
    		String strsql = "SELECT w_zcyh_id,w_zcyh_yhm,w_zcyh_mm,w_zcyh_jgdm from w_zcyh where 1=1 ";
    		if(!clsStringTool.isEmpty(yhm)){
    			strsql += " and w_zcyh_yhm like '%"+yhm+"%'";
    		}
    		if(!clsStringTool.isEmpty(dm)){
    			strsql += " and w_zcyh_jgdm = '"+dm+"'"; 
    		}
    		
    		strsql += " order by w_zcyh_id desc";
    		Query query = em.createNativeQuery(strsql);
    		List<Object> params = new ArrayList();
    		query.setFirstResult(rowNumsView * ((pageno==0?1:pageno) - 1));
    		query.setMaxResults(rowNumsView);
    		pages.setOnlineTotalSize(strsql.substring(strsql.indexOf("from"), strsql.indexOf("order")), params);
    		pages.setPageSize(rowNumsView);
    		pages.setTotalPages();
    		pages.setLastPage();
    		pages.setStartIndex(pageno);
    		pages.setCurrentPage(pageno);
    		List<Object[]> gsList = query.getResultList();
    		if (gsList != null && gsList.size() > 0) {
    			list = new ArrayList<Wzcyh>();
    			for(Object[] objects: gsList){
    				zcyh = new Wzcyh();
    				zcyh.setZcyhId(objects[0]==null?"":objects[0].toString());
    				zcyh.setZcyhYhm(objects[1] == null ? "" : objects[1].toString());
    				zcyh.setZcyhMm(objects[2] == null ? "" : objects[2].toString());
    				zcyh.setZcyhJgdm(objects[3] == null ? "" : objects[3].toString());
    				
    				list.add(zcyh);
    			}
    		}
    	} catch (Exception e) {
    		log.error("OnlineBus getXbList exception============" + e.toString());
    	} finally {
    		WsbzEntityManagerHelper.closeEntityManager();
    	}
    	return list;
    }

    public String createPassWord(String id){
     	EntityManager em = WsbzEntityManagerHelper.getEntityManager();
    	EntityTransaction tx = em.getTransaction();
    	String ps=MD532.createPassword("123456");
    	try {
    		tx = em.getTransaction();
            tx.begin();
    		String strsql = "update w_zcyh set w_zcyh_mm='"+ps+"' where w_zcyh_id="+id;

    		
    		em.createNativeQuery(strsql).executeUpdate();
    		tx.commit();
    	} catch (Exception e) {
    		log.error("OnlineBus getXbList exception============" + e.toString());
    	} finally {
    		WsbzEntityManagerHelper.closeEntityManager();
    	}
    	return null;
    }

    /**
     * 获取新办数据
     * @param id
     * @return
     */
    public WXb getWxb(String id) {
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        WXb wxb = null;
        try {
            wxb = em.find(WXb.class,Integer.parseInt(id));
        } catch (Exception e) {
            log.error("OnlineBus getWxb exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return wxb;
    }

    
    /**
     * 获取证书挂失登记号
     * @param jgdm
     * @return
     */
    public List<String> getDjhs(String jgdm) {
        List<String> list = new ArrayList<String>();
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        try {
            String djhs = "";
            String strsql = "select w_gs_zsdjh,w_gs_id from w_gs where w_gs_jgdm =:jgdm ";
            List<Object[]> gsList =  em.createNativeQuery(strsql).setParameter("jgdm",jgdm).getResultList();
            if(gsList!=null&&gsList.size()>0){
                for(Object[] objects:gsList){
                    djhs = objects[0].toString().trim();
                }
            }
            String[] strs = djhs.split(",");
            if(strs.length<=0){
                list=null;
            }else{
                for(int i=0;i<strs.length;i++){
                    strsql = "select djh from t_zs where lsh=:lsh ";
                    Object obj = entityManager.createNativeQuery(strsql).setParameter("lsh",strs[i]).getSingleResult();
                    String djh =  obj.toString();
                    list.add(djh);
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getDjhs exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    /**
     * 根据机构代码获取证书登记号
     * @param jgdm
     * @return
     */
    public List<String> getDjhsFromTjgdm(String jgdm) {
        List<String> list = new ArrayList<String>();
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        try {
            String strsql = "select djh,jgdm from t_zs where jgdm =:jgdm and flag = '1' ";
            List<Object[]> objs = entityManager.createNativeQuery(strsql).setParameter("jgdm",jgdm).getResultList();
            if(objs!=null&&objs.size()>0){
                list = new ArrayList<String>();
                for(Object[] obj:objs){
                    list.add(obj[0].toString());
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getDjhsFromTjgdm exception============" + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    /**
     * 根据用户名获取提醒内容列表
     * @param userName
     * @return
     */
    public List<TxnrVO> getTxnrList(String userName) {
        List<TxnrVO> list = null;
        EntityManager entityManager = WsbzEntityManagerHelper.getEntityManager();
        try {
            String strsql = "select nrID,nrContent,nrTitle from w_txnr where nrInputPerson = :userName or nrIsSuper = '1' ";
            List<Object[]> objs = entityManager.createNativeQuery(strsql).setParameter("userName",userName).getResultList();
            if(objs!=null&&objs.size()>0){
                list = new ArrayList<TxnrVO>();
                for(Object[] obj:objs){
                    TxnrVO txnrVO = new TxnrVO();
                    txnrVO.setId(obj[0].toString());
                    txnrVO.setContent(obj[1].toString());
                    txnrVO.setTitle(obj[2].toString());
                    list.add(txnrVO);
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getDjhsFromTjgdm exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    public String[] getXbclInfo(String id) {
        String[] xbinfos = new String[2];
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        try {
            String strXbcl = "";
            String strClmc = "";
            String strsql = "select w_xb_djh,w_xb_id from w_xb where w_xb_id =:id ";
            String djh = "";
            List<Object[]> list =  em.createNativeQuery(strsql).setParameter("id",id).getResultList();
            if(list!=null&&list.size()>0){
                for(Object[] objects:list){
                    djh = objects[0].toString().trim();
                }
            }
            strsql = "select w_xbcl_wjm,w_xbcl_mc from w_xbcl where w_xbcl_bj = 0 and  w_xbcl_xbid = :xbid and w_xbcl_cllb = 4";
            list = em.createNativeQuery(strsql).setParameter("xbid",djh).getResultList();
            if(list!=null&&list.size()>0){
                for(Object[] objects:list){
                    strXbcl = strXbcl + "$" + objects[0].toString();
			        strClmc = strClmc + ";" + objects[1].toString();
                }
            }
            strsql = "select w_xbcl_wjm,w_xbcl_mc from w_xbcl where w_xbcl_bj = 0 and  w_xbcl_xbid = :xbid and w_xbcl_cllb <> 4";
            list = em.createNativeQuery(strsql).setParameter("xbid",djh).getResultList();
            if(list!=null&&list.size()>0){
                for(Object[] objects:list){
                    strXbcl = strXbcl + "$" + objects[0].toString();
			        strClmc = strClmc + ";" + objects[1].toString();
                }
            }
            if(!strXbcl.equals("")){
			  strXbcl = (String)strXbcl.subSequence(1, strXbcl.length());
			  strClmc = (String)strClmc.substring(1,strClmc.length());
		    }
            xbinfos[0]=strXbcl;
            xbinfos[1]=strClmc;
        } catch (Exception e) {
            log.error("OnlineBus getXbclInfo exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return xbinfos;
    }
    public String[] getZxclInfo(String jgdm) {
    	String[] xbinfos = new String[2];
    	EntityManager em = WsbzEntityManagerHelper.getEntityManager();
    	try {
    		String strXbcl = "";
            String strClmc = "";
    		String 	strsql = "select w_zxcl_wjm,w_zxcl_mc from w_zxcl where w_zxcl_jgdm= :jgdm";
    		List<Object[]>  list = em.createNativeQuery(strsql).setParameter("jgdm",jgdm).getResultList();
    		if(list!=null&&list.size()>0){
    			for(Object[] objects:list){
    				strXbcl = strXbcl + "$" + objects[0].toString();
    				strClmc = strClmc + ";" + objects[1].toString();
    			}
    		}
    		if(!strXbcl.equals("")){
    			strXbcl = (String)strXbcl.subSequence(1, strXbcl.length());
    			strClmc = (String)strClmc.substring(1,strClmc.length());
    		}
    		xbinfos[0]=strXbcl;
    		xbinfos[1]=strClmc;
    	} catch (Exception e) {
    		log.error("OnlineBus getXbclInfo exception============" + e.toString());
    	} finally {
    		WsbzEntityManagerHelper.closeEntityManager();
    	}
    	return xbinfos;
    }

    /**
     * 添加提醒
     * @param txbt
     * @param txnr
     * @param userName
     * @return
     */
    public boolean saveSpNote(String txbt, String txnr, String userName) {
        boolean flag = false;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            //回收机构代码
            em.createNativeQuery("INSERT INTO w_txnr(nrContent,nrInputPerson,nrTitle,nrIsSuper) VALUES (?1,?2,?3,'0')")
                    .setParameter(1, txnr).setParameter(2,userName).setParameter(3,txbt).executeUpdate();
            flag = true;
            tx.commit();
        } catch (Exception e) {
            log.error("OnlineBus saveSpNote exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    /**
     * 删除提醒
     * @param txbt
     * @param userName
     * @return
     */
    public boolean delSpNote(String txbt, String userName) {
        boolean flag = false;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            //回收机构代码
            int i = em.createNativeQuery("delete from w_txnr where nrTitle = '"+txbt+"' and  nrInputPerson= '"+userName+"' and nrIsSuper <> '1'").executeUpdate();
            if(i>0){
                flag = true;
            }
            tx.commit();
        } catch (Exception e) {
            log.error("OnlineBus delSpNote exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    /**
     * 新办更新
     * @param id
     * @param state
     * @return
     */
    public boolean updateXB(String id, String state,Map<String, Object> session) {
        boolean flag = false;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            int lsh = 0;
            String strSql = "";
            tx = em.getTransaction();
            tx.begin();
            if("3".equals(state)){
                WXb wxb = em.find(WXb.class,Integer.valueOf(id));
                if(wxb!=null){
                    lsh = saveBack(em, lsh, wxb);
                    /*TjgdmOnLineVO onLineVO = (TjgdmOnLineVO) session.get("onLineVO");
                    strSql = "update t_wsywb set wftzgb='"+ onLineVO.getWftzgb() +"',jglx='"+onLineVO.getJglx()+"',njjhy='"+
					        onLineVO.getNjjhy()+"',njjlx='"+onLineVO.getNjjlx()+"',jjhy='"+onLineVO.getJjhy()+"',jjlx='"+onLineVO.getJjlx()
					        +"',njqx='"+onLineVO.getNjqx()+"',memo2='"+onLineVO.getMemo2()+"' where lsh="+lsh;
                    em.createNativeQuery(strSql).executeUpdate();*/
                }

            }
            em.createNativeQuery("update w_xb set w_xb_zt =?1 where w_xb_id = ?2").setParameter(1, state).setParameter(2,id).executeUpdate();
            flag = true;
            tx.commit();
        } catch (Exception e) {
            log.error("OnlineBus updateXB exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    /**
     * 年检更新
     * @param id
     * @param state
     * @return
     */
    public boolean updateNJ(String id, String state,String jgdm,Map<String, Object> session) {
        boolean flag = false;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            int lsh = 0;
            String strSql = "";
            tx = em.getTransaction();
            tx.begin();
            if("3".equals(state)){
                WXb wxb = em.find(WXb.class,Integer.valueOf(id));
                if(wxb!=null){
                    lsh = saveBack(em, lsh, wxb);
                    /*TjgdmOnLineVO onLineVO = (TjgdmOnLineVO) session.get("onLineVO");
                    strSql = "update t_wsywb set wftzgb='"+ onLineVO.getWftzgb() +"',jglx='"+onLineVO.getJglx()+"',njjhy='"+
					        onLineVO.getNjjhy()+"',njjlx='"+onLineVO.getNjjlx()+"',jjhy='"+onLineVO.getJjhy()+"',jjlx='"+onLineVO.getJjlx()
					        +"',njqx="+onLineVO.getNjqx()
					        +",memo2='"+onLineVO.getMemo2()+"' where lsh="+lsh;
                    strSql="update t_wsywb set wftzgb='"+ onLineVO.getWftzgb() +"',njjhy='"+
						        onLineVO.getNjjhy()+"',njjlx='"+onLineVO.getNjjlx()+"',jjhy='"+onLineVO.getJjhy()+"',jjlx='"+onLineVO.getJjlx()
						        +"',njrq='"+ onLineVO.getNjrq()
						        +"',njqx='"+ onLineVO.getNjqx()
						        +"',memo2='"+onLineVO.getMemo2()
						        +"',jgdm='"+ jgdm
						        +"',wsywlx='1',lastdate='"+DateUtil.getCurrentDateTime()
						        +"' where lsh="+lsh;
                    em.createNativeQuery(strSql).executeUpdate();*/
                }

            }
            em.createNativeQuery("update w_xb set w_xb_zt =?1 where w_xb_id = ?2").setParameter(1, state).setParameter(2,id).executeUpdate();
            flag = true;
            tx.commit();
        } catch (Exception e) {
            log.error("OnlineBus updateNJ exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return flag;
    }


    /**
     * 变更更新
     * @param id
     * @param state
     * @return
     */
    public boolean updateBG(String id, String state,String jgdm,Map<String, Object> session) {
        boolean flag = false;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        TjgdmBus tjgdmBus = null;
        try {
            int lsh = 0;
            String strSql = "";
            tx = em.getTransaction();
            tx.begin();
            if("3".equals(state)){
                WXb wxb = em.find(WXb.class,Integer.valueOf(id));
                if(wxb!=null){
                    lsh = saveBack(em, lsh, wxb);
                    /*TjgdmOnLineVO onLineVO = (TjgdmOnLineVO) session.get("onLineVO");
                    strSql = "update t_wsywb set wftzgb='"+ onLineVO.getWftzgb() +"',jglx='"+onLineVO.getJglx()+"',njjhy='"+
					        onLineVO.getNjjhy()+"',njjlx='"+onLineVO.getNjjlx()+"',jjhy='"+onLineVO.getJjhy()+"',jjlx='"+onLineVO.getJjlx()
					        +"',njqx="+onLineVO.getNjqx()
					        +",memo2='"+onLineVO.getMemo2()+"' where lsh="+lsh;
                    strSql="update t_wsywb set wftzgb='"+ onLineVO.getWftzgb() +"',njjhy='"+
						        onLineVO.getNjjhy()+"',njjlx='"+onLineVO.getNjjlx()+"',jjhy='"+onLineVO.getJjhy()+"',jjlx='"+onLineVO.getJjlx()
						        +"',njrq='"+ onLineVO.getNjrq()
						        +"',njqx='"+ onLineVO.getNjqx()
						        +"',memo2='"+onLineVO.getMemo2()
						        +"',jgdm='"+ jgdm
						        +"',wsywlx='2',lastdate='"+DateUtil.getCurrentDateTime()
						        +"' where lsh="+lsh;
                    em.createNativeQuery(strSql).executeUpdate();*/
                    tjgdmBus = new TjgdmBus();
                    TJgdm tJgdm =  tjgdmBus.findById(jgdm);
                    tJgdm.setDybz("1");
                    tjgdmBus.updateTjgdm(tJgdm);
                }

            }
            em.createNativeQuery("update w_xb set w_xb_zt =?1 where w_xb_id = ?2").setParameter(1, state).setParameter(2,id).executeUpdate();
            flag = true;
            tx.commit();
        } catch (Exception e) {
            log.error("OnlineBus updateNJ exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    /**
     * 换证更新
     * @param id
     * @param state
     * @return
     */
    public boolean updateHZ(String id, String state,String jgdm,Map<String, Object> session) {
        boolean flag = false;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            int lsh = 0;
            String strSql = "";
            tx = em.getTransaction();
            tx.begin();
            if("3".equals(state)){
                WXb wxb = em.find(WXb.class,Integer.valueOf(id));
                if(wxb!=null){
                    lsh = saveBack(em, lsh, wxb);
                    /*TjgdmOnLineVO onLineVO = (TjgdmOnLineVO) session.get("onLineVO");
                    strSql = "update t_wsywb set wftzgb='"+ onLineVO.getWftzgb() +"',jglx='"+onLineVO.getJglx()+"',njjhy='"+
					        onLineVO.getNjjhy()+"',njjlx='"+onLineVO.getNjjlx()+"',jjhy='"+onLineVO.getJjhy()+"',jjlx='"+onLineVO.getJjlx()
					        +"',njqx="+onLineVO.getNjqx()
					        +",memo2='"+onLineVO.getMemo2()+"' where lsh="+lsh;
                    strSql="update t_wsywb set wftzgb='"+ onLineVO.getWftzgb() +"',njjhy='"+
						        onLineVO.getNjjhy()+"',njjlx='"+onLineVO.getNjjlx()+"',jjhy='"+onLineVO.getJjhy()+"',jjlx='"+onLineVO.getJjlx()
						        +"',njrq='"+ onLineVO.getNjrq()
						        +"',njqx='"+ onLineVO.getNjqx()
						        +"',memo2='"+onLineVO.getMemo2()
						        +"',jgdm='"+ jgdm
						        +"',wsywlx='3',lastdate='"+DateUtil.getCurrentDateTime()
						        +"' where lsh="+lsh;
                    em.createNativeQuery(strSql).executeUpdate();*/
                }

            }
            em.createNativeQuery("update w_xb set w_xb_zt =?1 where w_xb_id = ?2").setParameter(1, state).setParameter(2,id).executeUpdate();
            flag = true;
            tx.commit();
        } catch (Exception e) {
            log.error("OnlineBus updateHZ exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    /**
     * 挂失更新
     * @param id
     * @param state
     * @return
     */
    public boolean updateGS(String id, String state,String jgdm,Map<String, Object> session) {
        boolean flag = false;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            int lsh = 0;
            String strSql = "";
            tx = em.getTransaction();
            tx.begin();
            if("3".equals(state)){
                Wgs wgs = null;
                strSql = "select w_gs_gsyy,w_gs_gsyj,w_gs_tbr,w_gs_lxdh,w_gs_bzjgdm from w_gs where w_gs_id = " + id;
                List<Object[]> list = em.createNativeQuery(strSql).getResultList();
                if(list!=null&&list.size()>0){
                    Object[] objs = list.get(0);
                    wgs = new Wgs();
                    wgs.setGsyy(objs[0].toString());
                    wgs.setGsyj(objs[1].toString());
                    wgs.setTbr(objs[2].toString());
                    wgs.setLxdh(objs[3].toString());
                    wgs.setBzjgdm(objs[4].toString());
                }
                if(false){
                    ins(jgdm, session, em, lsh);
                    TjgdmOnLineVO onLineVO = (TjgdmOnLineVO) session.get("onLineVO");
                    strSql = "update t_wsywb set memo = '"+ wgs.getGsyy() +"', memo2 = '" + wgs.getGsyj()+"',gsdjh='"+ onLineVO.getDjh() +"',Ic="+onLineVO.getGsIc()+",bzjgdm='"+ wgs.getBzjgdm() + "' where jgdm = '"+ jgdm +"' and wsywlx = 4";
                    em.createNativeQuery(strSql).executeUpdate();
                }
            }
            em.createNativeQuery("update w_gs set w_gs_zt =?1 where w_gs_id = ?2").setParameter(1, state).setParameter(2,id).executeUpdate();
            flag = true;
            new TZsBus().wsLost(jgdm, null);
            tx.commit();
        } catch (Exception e) {
            log.error("OnlineBus updateGS exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    /**
     * 备案更新
     * @param id
     * @param state
     * @return
     */
    public boolean updateBA(String id, String state,String jgdm,Map<String, Object> session) {
        boolean flag = false;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            int lsh = 0;
            String strSql = "";
            tx = em.getTransaction();
            tx.begin();
            if("3".equals(state)){
                Wba wba = null;
                strSql = "select w_ba_bazfrq,w_ba_bayy,w_ba_bzjgdm from w_ba where w_ba_id where w_ba_id = " + id;
                List<Object[]> list = em.createNativeQuery(strSql).getResultList();
                if(list!=null&&list.size()>0){
                    Object[] objs = list.get(0);
                    wba = new Wba();
                    wba.setBazfrq(objs[0].toString());
                    wba.setBayy(objs[1].toString());
                    wba.setBzjgdm(objs[2].toString());
                }
                if(false){
                   // lsh = ins(jgdm, session, em, lsh);
                	//lsh = saveBack(em, lsh, wxb);
                    TjgdmOnLineVO onLineVO = (TjgdmOnLineVO) session.get("onLineVO");
                    strSql = "update t_wsywb set qzrq = '"+wba.getBazfrq()+"',bgrq = '"+onLineVO.getBarq()+"',pwrq = '"+onLineVO.getBayxq()+"'," +
                            "memo2 ='"+onLineVO.getMemo2()+"',bzjgdm = '"+wba.getBzjgdm()+"' where lsh="+lsh;
                    em.createNativeQuery(strSql).executeUpdate();
                }
            }
            em.createNativeQuery("update w_ba set w_ba_zt =?1 where w_ba_id = ?2").setParameter(1, state).setParameter(2,id).executeUpdate();
            flag = true;
            tx.commit();
        } catch (Exception e) {
            log.error("OnlineBus updateBA exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return flag;
    }


    /**
     * 注销更新
     * @param id
     * @param state
     * @return
     */
    public boolean updateZX(String id, String state,String jgdm,Map<String, Object> session) {
        boolean flag = false;
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            String strSql = "";
            tx = em.getTransaction();
            tx.begin();
            em.createNativeQuery("update w_zx set w_zx_zt =?1 where w_zx_id = ?2").setParameter(1, state).setParameter(2,id).executeUpdate();
            flag = true;
            tx.commit();
        } catch (Exception e) {
            log.error("OnlineBus updateZX exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    private int ins(String jgdm, Map<String, Object> session, EntityManager em, int lsh) {
        String strSql;
        strSql = "select top 1 lsh,jgdm from t_wsywb order by lsh desc";
        List<Object[]> lshList = em.createNativeQuery(strSql).getResultList();
        if(lshList!=null&&lshList.size()>0){
            Object[] objects = lshList.get(0);
            lsh = Integer.parseInt(objects[0].toString());
            lsh = lsh + 1;
        }
        User user = (User) session.get("sysUser");
        strSql = "insert into t_wsywb(lsh,wsywlx,lastdate,jgdm,bzjgdm,jgmc,jglx,fddbr,zjlx,zjhm,jyfw,jjhy,jjlx,zgdm,zcrq,zgmc,zycp1,zycp2,zycp3,zgrs,yzbm,jgdz,dhhm,email,url,mobile,hbzl,zczj,wftzgb,xzqh,pzjgdm,pzjgmc,pzwh,zch,njqx,gk,fkbz,fksl,fbsl,zbsl,qzbz,bgbj,njjhy,njjlx,memo,memo2,tbrxm,tbrsfzh,tbrlxfs,gsfzrq,jydz,jyyb,jydh,jfly,khyh,khzh) ";
        strSql = strSql + "select " + lsh +",'4','" + DateUtil.getCurrentDateTime() + "','" + jgdm + "','" + user.getBzjgdm() + "',";
        strSql = strSql + "jgmc,jglx,fddbr,zjlx,zjhm,jyfw,jjhy,jjlx,zgdm,zcrq,zgmc,zycp1,zycp2,zycp3,zgrs,yzbm,jgdz,dhhm,email,url,mobile,hbzl,zczj,wftzgb,xzqh,pzjgdm,pzjgmc,pzwh,zch,njqx,gk,fkbz,fksl,fbsl,zbsl,'0','0',njjhy,njjlx,memo,memo2,tbrxm,tbrsfzh,tbrlxfs,gsfzrq,jydz,jyyb,jydh,jfly,khyh,khzh";
        strSql = strSql + " from t_jgdm where jgdm='" + jgdm + "'";
        em.createNativeQuery(strSql).executeUpdate();
        return lsh;
    }

    private int saveBack(EntityManager em, int lsh, WXb wxb) {
        String strSql;
        strSql = "select top 1 lsh,jgdm from t_wsywb order by lsh desc";
        List<Object[]> list = em.createNativeQuery(strSql).getResultList();
        if(list!=null&&list.size()>0){
            Object[] objs = list.get(0);
            lsh = Integer.parseInt(objs[0].toString());
            lsh = lsh + 1;
        }else
            lsh = 1;
        int val = lsh;
        strSql = "insert into t_wsywb(lsh,wsywlx,lastdate,jgdm,bzjgdm,jgmc,jglx,fddbr,zjlx,zjhm,jyfw,jjhy,jjlx,zgdm,zcrq,zgmc,zycp1,zycp2,zycp3" +
                ",zgrs,yzbm,jgdz,dhhm,email,url,mobile,hbzl,zczj,wftzgb,xzqh,pzjgdm,pzjgmc,pzwh,zch,njqx,gk," +
                "fkbz,fksl,fbsl,zbsl,qzbz,bgbj,njjhy,njjlx,memo,memo2,tbrxm,tbrsfzh,tbrlxfs,gsfzrq,jydz,jyyb,jydh,jfly,khyh,khzh) ";
        strSql = strSql + "VALUES( '"+val+"' ,'0','" + DateUtil.getCurrentDateTime() + "','" + wxb.getJgdm() + "','" + wxb.getBzjgdm() + "'," +
                "'" + wxb.getJgmc() + "','" + wxb.getJglx() + "','" + wxb.getFddbr() + "','" + wxb.getZjlx() + "','" + wxb.getZjhm() + "','" + wxb.getJyfw() +
                "','" + wxb.getJjhy() + "','" + wxb.getJjlx() + "','" + wxb.getZgdm() + "','','" + wxb.getZgjgmc() + "','" + wxb.getZycp1() + "','" + wxb.getZycp2() +
                "','" + wxb.getZycp3() + "'," + wxb.getZgrs() + ",'" + wxb.getYzbm() + "','" + wxb.getJgdz() + "','" + wxb.getDhhm() + "','" + wxb.getEmail() + "'," +
                "'" + wxb.getUrl() + "','" + wxb.getMobile() + "','" + wxb.getHbzl() + "'," + wxb.getZczj() + ",'" + wxb.getWftzgb() + "','" + wxb.getXzqh() + "','" + wxb.getPzjgdm() + "',''," +
                "'" + wxb.getZch() + "','','','','','0'," + wxb.getFbsl() + ",1,'0','0','" + wxb.getNjjhy() + "','" +
                wxb.getNjjlx() + "','','N','" + wxb.getTbrxm() + "','','" + wxb.getTbrlxfs() + "','','" + wxb.getJydz() + "','"
                + wxb.getJyyb() + "','" + wxb.getJydh() + "','" + wxb.getJfly() + "','" + wxb.getKhyh() + "','" + wxb.getKhzh() + "')";
        em.createNativeQuery(strSql).executeUpdate();
        return lsh;
    }

    public boolean updateData(String tjr, String jgdm, String txbt, String txnr, String opt,String userName) {
        boolean flag = false;
        String option ="";
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            if(!("qzsp").equals(opt))
		    {
		    	option = "1";
		    }else
		    {
		    	option = "0";
		    }
            tx = em.getTransaction();
            tx.begin();
            em.createNativeQuery("insert into w_tx (w_tx_jsyhm,w_tx_jgdm,w_tx_bt,w_tx_nr,w_tx_ydbj,w_tx_cjsj,w_tx_fsyhm,w_tx_lb) values " +
                    "('" + tjr + "','" + jgdm + "','" + txbt + "','" + txnr + "','" + 0 + "','" + DateUtil.getCurrentDateTime() + "','" + userName + "','" + option + "')").executeUpdate();
            flag = true;
            tx.commit();
        } catch (Exception e) {
            log.error("OnlineBus updateData exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    public String[] getNoteView(String jgdm, String ywlx) {
        String[] xbinfos = new String[2];
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        try {
            String bt = "";
            String nr = "";
            String strsql = "select top 1 w_tx_bt,w_tx_nr from w_tx where w_tx_jgdm =:jgdm  and w_tx_lb = :ywlx order by w_tx_id desc ";
            List<Object[]> list =  em.createNativeQuery(strsql).setParameter("jgdm",jgdm).setParameter("ywlx",ywlx).getResultList();
            if(list!=null&&list.size()>0){
                Object[] objs = list.get(0);
                if(objs!=null){
                    xbinfos[0]=objs[0].toString();
                    xbinfos[1]=objs[1].toString();
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getXbclInfo exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return xbinfos;
    }

    /**
     *获取经费来源名称
     * @param jfly
     * @return
     */
    public String getJflyName(String jfly) {
        String jflyName = "";
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        try {
            String strsql = "select w_jyly_id,w_jyly_mc from w_jyly where w_jyly_id =:jfly ";
            List<Object[]> list =  em.createNativeQuery(strsql).setParameter("jfly",jfly).getResultList();
            if(list!=null&&list.size()>0){
                for(Object[] objects:list){
                    jflyName = objects[1].toString().trim();
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getJflyName exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return jflyName;
    }

	public String getWxbMc(String dm) {
		// TODO Auto-generated method stub
		EntityManager em = WsbzEntityManagerHelper.getEntityManager();
       String jgmc= "";
        try {
        	String strsql = "select w_xb_jgmc,w_xb_id from w_xb where w_xb_jgdm =:dm ";
            List<Object[]> list =  em.createNativeQuery(strsql).setParameter("dm",dm).getResultList();
            if(list!=null&&list.size()>0){
                for(Object[] objects:list){
                    jgmc = objects[0].toString().trim();
                }
            }
        } catch (Exception e) {
            log.error("OnlineBus getWxb exception============" + e.toString());
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
        return jgmc;
	}

}
