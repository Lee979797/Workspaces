/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.collection.model.Xzqh;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.Bzjgdm;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.CheckCode;
import com.opensymphony.xwork2.ActionSupport;

import java.lang.Object;
import java.util.*;

import javax.persistence.EntityManager;

import org.objectweb.asm.xwork.tree.IntInsnNode;

/**
 * @author yanzh
 */
public class CommonToolsAction extends ActionSupport {
    private static final String path = "/product/jsp/commonTools/";
    private String currentPath;
    private String dm;
    private String mc;
    private String id;
    private String zfdm;
    private String bzjgdm;
    private String jglx;
    private String message;
    private String table;
    private Page page;
    private List<Model> models;
    private TXzqh xzqh;
    private Bzjgdm bzjgObj;
    private TNNJjhy tjjhy;
    private ScXzqhdz xzqhDz;
    private TNNjjlx tjjlx;
    public CommonToolsAction() {
    }

    public String verifyCode() {
        currentPath = path + "verifyCode.jsp";
        if (dm != null) {
            dm = new CheckCode().getCheckCode(dm);
            message = "您输入的数字(" + dm.substring(0, 8) + ")的校验位是" + dm.substring(8, 9) + ",对应的机构代码为(" + dm + ")";
        }
        return this.SUCCESS;
    }

    public String add() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                currentPath = path + "add.jsp";
            }
        }.nSyTemplate();
    }

    public String save_add() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                message = "添加标准成功！";
                currentPath = path + "success.jsp";
                if ("sc_zw".equals(table)) {
                    ScZw zw = new ScZw();
                    zw.setDm(dm);
                    zw.setMc(mc);
                    zw.setJglx(jglx);
                    em.persist(zw);
                    InitSysParams.zwList.add(zw);
                    return;
                }
                if ("sc_lx".equals(table)) {
                    TNNjjlx lx = new TNNjjlx();
                    lx.setDm(dm);
                    lx.setMc(mc);
                    lx.setJglx(jglx);
                    em.persist(lx);
                    InitSysParams.tnnJjlxList.add(lx);
                    return;
                }
                if ("sc_xzqh".equals(table)) {
                	mc=xzqh.getMc();
                	em.persist(xzqh);
                	InitSysParams.xzqhMapNoSJ.put(xzqh.getDm(), xzqh.getMc());
                	return;
                }
                if ("sc_jjhy".equals(table)) {
                	em.persist(tjjhy);
                	InitSysParams.jjhy2k1Map2.put(tjjhy.getDm(), tjjhy);
                	return;
                }
                
                if ("sc_bzjgdm".equals(table)) {
                	mc=bzjgObj.getMc();
                	em.persist(bzjgObj);
                	
                	InitSysParams.bzjgdmMapMc.put(bzjgObj.getDm(), bzjgObj);
                	InitSysParams.bzjgdmMap.put(bzjgObj.getDm(), bzjgObj.getMc());
                	return;
                }
                
                if ("sc_xzqhdz".equals(table)) {
                	em.persist(xzqhDz);
                	InitSysParams.xzqhdzMap.put(xzqhDz.getDm(), xzqhDz);
                	return;
                }
                
                
                if ("sc_lx".equals(table)) {
                    TNNjjlx jjlx_2011=new TNNjjlx();
                    jjlx_2011.setDm(dm);
                    jjlx_2011.setMc(mc);
                    jjlx_2011.setJglx(jglx);
                    em.persist(jjlx_2011);
                    InitSysParams.jjlx2k1Map.put(dm, mc);
                    return;
                }
                
                String sql = "insert into " + table + "(mc) values('" + mc + "')";

                int i = em.createNativeQuery(sql).executeUpdate();
                if (i == 1) {
                    if ("sc_dzzlx".equals(table)) {
                    	ScDzzlx dzzlx=(ScDzzlx) getEntity(em,ScDzzlx.class,mc);
                    	InitSysParams.dzzlxList.add(dzzlx);
                    }
                    if ("sc_mz".equals(table)) {
                    	ScMz scMz=(ScMz) getEntity(em,ScMz.class,mc);
                        InitSysParams.mzList.add(scMz);
                    }
                    if ("sc_zzmm".equals(table)) {
                    	ScZzmm scZzmm=(ScZzmm) getEntity(em,ScZzmm.class,mc);
                        InitSysParams.zzmmList.add(scZzmm);
                    }
                    if ("sc_lx".equals(table)) {
                        InitSysParams.jjlx2k1Map.put(dm, mc);
                    }
                    if ("sc_wjdyy".equals(table)) {
                    	ScWjdyy scWjdyy=(ScWjdyy) getEntity(em,ScWjdyy.class.getName(),mc);
                        InitSysParams.yyList.add(scWjdyy);
                    }

                }
                
                message = "添加标准（" + mc + "）成功！";
                currentPath = path + "success.jsp";

            }
        }.template();
    }

    public String save_modify() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                message = "修改成功！";
                currentPath = path + "success.jsp";
                System.out.println(dm);
            	Integer dmId=dm==null?0:Integer.parseInt(dm);
                if ("sc_dzzlx".equals(table)) {
                	ScDzzlx dzzlx=(ScDzzlx) getEntityDm(em,ScDzzlx.class,dmId);
                	InitSysParams.dzzlxList.remove(dzzlx);
                }
                if ("sc_mz".equals(table)) {
                	ScMz scMz=(ScMz) getEntityDm(em,ScMz.class,dmId);
                    InitSysParams.mzList.remove(scMz);
                }
                if ("sc_zzmm".equals(table)) {
                	ScZzmm scZzmm=(ScZzmm) getEntityDm(em,ScZzmm.class,dmId);
                    InitSysParams.zzmmList.remove(scZzmm);
                }
                if ("sc_lx".equals(table)) {
                    InitSysParams.jjlx2k1Map.remove(dm);
                }
                if ("sc_wjdyy".equals(table)) {
                	ScWjdyy scWjdyy=(ScWjdyy) getEntityDm(em,ScWjdyy.class,dmId);
                    InitSysParams.yyList.remove(scWjdyy);
                }
                
                if ("sc_zw".equals(table)) {
                	ScZw scZw=(ScZw) getEntityId(em,ScZw.class,Integer.parseInt(id));
                    InitSysParams.zwList.remove(scZw);
                }

                if ("sc_jjhy".equals(table)) {
                	TNNJjhy jjhy=(TNNJjhy) getEntityId(em,TNNJjhy.class,tjjhy.getId());
                	InitSysParams.jjhy2k1Map2.remove(jjhy.getDm());
                }

                
                String sql = "update " + table + " set mc ='" + mc + "' where dm ='" + dm + "'";
                if ("sc_zw".equals(table)) {
                    sql = "update " + table + " set mc ='" + mc + "', dm = '" + dm + "',jglx='"+jglx+"' where id='" + id+ "'";
                }
                if ("sc_lx".equals(table)) {
                    sql = "update " + table + " set mc ='" + mc + "', dm = '" + dm + "',jglx='"+jglx+"' where dm='" + dm+ "'";
                }
                if ("sc_xzqh".equals(table)) {
                	em.merge(xzqh);
                	return;
                }
                
                if ("sc_bzjgdm".equals(table)) {
                	em.merge(bzjgObj);
                	
                	InitSysParams.bzjgdmMapMc.put(bzjgObj.getDm(), bzjgObj);
                	InitSysParams.bzjgdmMap.put(bzjgObj.getDm(), bzjgObj.getMc());
                	InitSysParams.bzjgdmMapMc1.put(bzjgObj.getDm(), bzjgObj.getSoMc());
                	return;
                }
                
                if ("sc_jjhy".equals(table)) {
                	em.merge(tjjhy);
                	return;
                }
                
                if ("sc_xzqhdz".equals(table)) {
                	em.merge(xzqhDz);
                	return;
                }
                

                int i = em.createNativeQuery(sql).executeUpdate();
                if (i == 1) {
                    if ("sc_dzzlx".equals(table)) {
                    	ScDzzlx dzzlx=(ScDzzlx) getEntityDm(em,ScDzzlx.class,dmId);
                    	InitSysParams.dzzlxList.add(dzzlx);
                    }
                    if ("sc_mz".equals(table)) {
                    	ScMz scMz=(ScMz) getEntityDm(em,ScMz.class,dmId);
                        InitSysParams.mzList.add(scMz);
                    }
                    if ("sc_zzmm".equals(table)) {
                    	ScZzmm scZzmm=(ScZzmm) getEntityDm(em,ScZzmm.class,dmId);
                        InitSysParams.zzmmList.add(scZzmm);
                    }

                    if ("sc_wjdyy".equals(table)) {
                    	ScWjdyy scWjdyy=(ScWjdyy) getEntityDm(em,ScWjdyy.class,dmId);
                        InitSysParams.yyList.add(scWjdyy);
                    }
                    if ("sc_zw".equals(table)) {
                    	ScZw scZw=(ScZw) getEntityId(em,ScZw.class,dmId);
                        InitSysParams.zwList.add(scZw);
                    }
                    if ("sc_lx".equals(table)) {
                    	TNNjjlx jjlx=(TNNjjlx) getEntityIdlx(em,TNNjjlx.class,String.valueOf(dmId));
                        InitSysParams.tnnJjlxList.add(jjlx);
                    }
                    if ("sc_xzqh".equals(table)) {
                    	InitSysParams.xzqhMapNoSJ.put(xzqh.getDm(), xzqh.getMc());
                    }
                    if ("sc_jjhy".equals(table)) {
                    	TNNJjhy jjhy=(TNNJjhy) getEntityId(em,TNNJjhy.class,tjjhy.getId());
                    	InitSysParams.jjhy2k1Map2.put(jjhy.getDm(), jjhy);
                    }
                    
                    if ("sc_xzqhdz".equals(table)) {
                    	ScXzqhdz dz=(ScXzqhdz) getEntityId(em,ScXzqhdz.class,xzqhDz.getId());
                    	InitSysParams.xzqhdzMap.put(dz.getDm(), dz);
                    }
                    
                }

            }
        }.template();
    }

    
    public Object getEntity(EntityManager em,Object table,String mc){
    	table=table.toString().replace("class ", "");
    	List<Object> list=em.createQuery("from "+table+" model where model.mc=:mc").setParameter("mc", mc).getResultList();
    	Object obj=null;
    	if(list.size()>0){
    		obj=list.get(0);
    	}
    	return obj;
    }
    
    public Object getEntityDm(EntityManager em,Object table,Integer dm){
    	table=table.toString().replace("class ", "");
    	Object obj=null;
    	try{
    	List<Object> list=em.createQuery("from "+table+" model where model.dm=:dm").setParameter("dm", dm).getResultList();
    	if(list.size()>0){
    		obj=list.get(0);
    	}
    	}catch(Exception e){
    		List<Object> list=em.createQuery("from "+table+" model where model.id=:id").setParameter("id", dm).getResultList();
        	if(list.size()>0){
        		obj=list.get(0);
        	}
    	}
    	return obj;
    }
    public Object getEntityId(EntityManager em,Object table,Integer id){
    	table=table.toString().replace("class ", "");
    	Object obj=null;
   		List<Object> list=em.createQuery("from "+table+" model where model.id=:ids").setParameter("ids", id).getResultList();
		if(list.size()>0){
			obj=list.get(0);
		}
    	return obj;
    }
    public Object getEntityIdlx(EntityManager em,Object table,String id){
    	table=table.toString().replace("class ", "");
    	Object obj=null;
   		List<Object> list=em.createQuery("from "+table+" model where model.dm=:ids").setParameter("ids", id).getResultList();
		if(list.size()>0){
			obj=list.get(0);
		}
    	return obj;
    }
    public String del() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                String sql = "";
                if ("sc_zw".equals(table)) {
                    sql = "delete from " + table + " where id =" + dm ;
                }  else if ("sc_xzqh".equals(table)) {
                    sql = "delete from " + table + " where dm ='" + dm + "'";
                } else if ("sc_bzjgdm".equals(table)) {
                    sql = "delete from " + table + " where bzjg_id ='" + dm + "'";
                }else if ("sc_jjhy".equals(table)) {
                    sql = "delete from " + table + " where id ='" + dm + "'";
                }else if ("sc_xzqhdz".equals(table)) {
                    sql = "delete from " + table + " where id ='" + dm + "'";
                }else
                    sql = "delete from " + table + " where dm ='" + dm + "'";

                	Integer dmId=dm==null?0:Integer.parseInt(dm.trim());
                    if ("sc_dzzlx".equals(table)) {
                    	ScDzzlx dzzlx=(ScDzzlx) getEntityDm(em,ScDzzlx.class,dmId);
                    	InitSysParams.dzzlxList.remove(dzzlx);
                    }
                    if ("sc_mz".equals(table)) {
                    	ScMz scMz=(ScMz) getEntityDm(em,ScMz.class,dmId);
                        InitSysParams.mzList.remove(scMz);
                    }
                    if ("sc_zzmm".equals(table)) {
                    	ScZzmm scZzmm=(ScZzmm) getEntityDm(em,ScZzmm.class,dmId);
                        InitSysParams.zzmmList.remove(scZzmm);
                    }
/*                    if ("sc_lx".equals(table)) {
                        InitSysParams.jjlx2k1Map.remove(dm);
                    }*/
                    if ("sc_wjdyy".equals(table)) {
                    	ScWjdyy scWjdyy=(ScWjdyy) getEntityDm(em,ScWjdyy.class,dmId);
                        InitSysParams.yyList.remove(scWjdyy);
                    }
                    if ("sc_zw".equals(table)) {
                    	ScZw scZw=(ScZw) getEntityId(em,ScZw.class,dmId);
                        InitSysParams.zwList.remove(scZw);
                    }
                    if ("sc_lx".equals(table)) {
                    	TNNjjlx jjlx=(TNNjjlx) getEntityIdlx(em,TNNjjlx.class,String.valueOf(dmId));
                        InitSysParams.tnnJjlxList.remove(jjlx);
                    }
                    if ("sc_xzqh".equals(table)) {
                    	//Xzqh xzqh=(Xzqh) getEntityDm(em,Xzqh.class,dmId);
                    	InitSysParams.xzqhMapNoSJ.remove(dmId);
                    }
                    if ("sc_jjhy".equals(table)) {
                    	TNNJjhy jjhy=(TNNJjhy) getEntityId(em,TNNJjhy.class,dmId);
                    	InitSysParams.jjhy2k1Map2.remove(jjhy.getDm());
                    }
                    if ("sc_xzqhdz".equals(table)) {
                    	ScXzqhdz dz=(ScXzqhdz) getEntityId(em,ScXzqhdz.class,dmId);
                    	InitSysParams.xzqhdzMap.remove(dz.getDm());
                    }
                    if ("sc_bzjgdm".equals(table)) {
                    	InitSysParams.bzjgdmMap.remove(dmId.toString());
                    	InitSysParams.bzjgdmMapMc.remove(dmId.toString());
                    }

                    int i = em.createNativeQuery(sql).executeUpdate();
                    
               // message = "标准（" + mc + "）删除成功！";
                message = "删除成功！";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String modify() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                String sql = "select mc from " + table + " where dm= '" + dm + "'";

                if ("sc_zw".equals(table)) {
                	sql = "select mc,jglx,dm,id from " + table + " where id= '" + dm + "'";
                    Object[] gjs = (Object[]) em.createNativeQuery(sql).getSingleResult();
                    mc = "" + gjs[0];
                    jglx = "" + gjs[1];
                    dm="" + gjs[2];
                    id="" + gjs[3];
                    
                }else if ("sc_xzqh".equals(table)) {
                    List<TXzqh> xzqhList=em.createQuery("from TXzqh model where model.dm=:dm").setParameter("dm", dm).getResultList();
                    if(xzqhList.size()>0){
                    	xzqh=xzqhList.get(0);
                    }
                }else if ("sc_bzjgdm".equals(table)) {
                	List<Bzjgdm> bzjgdmList=em.createQuery("from Bzjgdm model where model.dm=:dm").setParameter("dm", dm).getResultList();
                	if(bzjgdmList.size()>0){
                		bzjgObj=bzjgdmList.get(0);
                	}
                	
                } else if ("sc_jjhy".equals(table)) {
                	List<TNNJjhy> jjhyList=em.createQuery("from TNNJjhy model where model.id=:dm").setParameter("dm", Integer.parseInt(dm)).getResultList();
                	if(jjhyList.size()>0){
                		tjjhy=jjhyList.get(0);
                	}
                	
                } else if ("sc_xzqhdz".equals(table)) {
                	List<ScXzqhdz> xzqhList=em.createQuery("from ScXzqhdz model where model.id=:dm").setParameter("dm", Integer.parseInt(dm)).getResultList();
                	if(xzqhList.size()>0){
                		xzqhDz=xzqhList.get(0);
                	}
                	
                } else if("sc_lx".equals(table)){
                	sql = "select mc,jglx,dm from " + table + " where dm= '" + dm + "'";
                    Object[] gjs = (Object[]) em.createNativeQuery(sql).getSingleResult();
                    mc = "" + gjs[0];
                    jglx = "" + gjs[1];
                    dm="" + gjs[2].toString();
                } else
                    mc = (String) em.createNativeQuery(sql).getSingleResult();
                currentPath = path + "edit.jsp";
            }
        }.template();
    }

    public String standard_query_manage() {
        currentPath = path + "standard_query_manage.jsp";
        return list();
    }

//lvwei 2017-07-31 添加管理修改界面 -----start---
    public String standard_update_manage() {
        currentPath = path + "standard_update_manage.jsp";
        return list();
    }
//lvwei 2017-07-31 添加管理修改界面 -----end---
    
    public String standardQuery() {
        currentPath = path + "standardQuery.jsp";
        return list();
    }

    public String list() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("dm");
                    page.setOrderByType("asc");
                    page.setTotalRecord(0);
                }
                String sql = " where model.dm like '%" + dm + "%' or model.mc like '%" + dm + "%' ";
                String sql2 = " where (model.pzjgdm like '%" + dm + "%' or model.jglx like '%" + dm + "%')";
                models = new ArrayList<Model>();
                if (dm == null)
                    dm = "";

                if (table == null)
                    return;

                System.out.println("page = " + page.getOrderByField());
                if ("t_pzjg".equals(table)) {
                    if (page.getOrderByField() != null &&
                            ("dm".equals(page.getOrderByField().trim()) || "zfdm".equals(page.getOrderByField()) || "jglx".equals(page.getOrderByField()))) {
                        page.setOrderByField("bzjg_id");
                    } else if (page.getOrderByField() != null &&
                            ("mc".equals(page.getOrderByField()))) {
                        page.setOrderByField("bzjg_name");
                    }


                } else if ("sc_jglx_pzjg".equals(table)) {
                    if (page.getOrderByField() != null && ("bzjgdm".equals(page.getOrderByField()) ||"dm".equals(page.getOrderByField()) || "zfdm".equals(page.getOrderByField()))) {
                        page.setOrderByField("pzjgdm");
                    }  else if (page.getOrderByField() != null &&
                            ("mc".equals(page.getOrderByField()))) {
                        page.setOrderByField("pzjgmc");
                    }
                } else {
                    if (page.getOrderByField() != null && ("dm".equals(page.getOrderByField()) || "pzjgmc".equals(page.getOrderByField()) || "bzjgdm".equals(page.getOrderByField()) || "jglx".equals(page.getOrderByField()))) {
                        page.setOrderByField("dm");
                    }
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";


                if ("sc_dzzlx".equals(table)) {
                    sql = "from ScDzzlx model " + sql;
                    List<ScDzzlx> dzzlxList = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                            .getResultList();
                    page.setTotalRecord(((Long) em.createQuery("select count (model )" + sql)
                            .getResultList().get(0)).intValue());

                    if (dzzlxList != null && !dzzlxList.isEmpty()) {
                        for (ScDzzlx list : dzzlxList) {
                            Model model = new Model();
                            model.setColumn1(list.getMc());
                            model.setColumn2(list.getDm().toString());
                            models.add(model);
                        }
                    }
                }
                if ("sc_mz".equals(table)) {
                	sql = "from ScMz model " + sql;
                	List<ScMz> mzList = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                	.getResultList();
                	page.setTotalRecord(((Long) em.createQuery("select count (model )" + sql)
                			.getResultList().get(0)).intValue());
                	
                	if (mzList != null && !mzList.isEmpty()) {
                		for (ScMz list : mzList) {
                			Model model = new Model();
                			model.setColumn1(list.getMc());
                			model.setColumn2(list.getDm().toString());
                			models.add(model);
                		}
                	}
                }
                if ("sc_wjdyy".equals(table)) {
                	sql = "from ScWjdyy model " + sql;
                	List<ScWjdyy> wjdyyList = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                	.getResultList();
                	page.setTotalRecord(((Long) em.createQuery("select count (model )" + sql)
                			.getResultList().get(0)).intValue());
                	
                	if (wjdyyList != null && !wjdyyList.isEmpty()) {
                		for (ScWjdyy list : wjdyyList) {
                			Model model = new Model();
                			model.setColumn1(list.getMc());
                			model.setColumn2(list.getDm().toString());
                			models.add(model);
                		}
                	}
                }
                
                if ("sc_zzmm".equals(table)) {
                	sql = "from ScZzmm model " + sql;
                	List<ScZzmm> zzList = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                	.getResultList();
                	page.setTotalRecord(((Long) em.createQuery("select count (model )" + sql)
                			.getResultList().get(0)).intValue());
                	
                	if (zzList != null && !zzList.isEmpty()) {
                		for (ScZzmm list : zzList) {
                			Model model = new Model();
                			model.setColumn1(list.getMc());
                			model.setColumn2(list.getDm().toString());
                			models.add(model);
                		}
                	}
                }
                if ("sc_zw".equals(table)) {
                	sql = "from ScZw model " + sql;
                	List<ScZw> zwList = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                	.getResultList();
                	page.setTotalRecord(((Long) em.createQuery("select count (model )" + sql)
                			.getResultList().get(0)).intValue());
                	
                	if (zwList != null && !zwList.isEmpty()) {
                		for (ScZw list : zwList) {
                			Model model = new Model();
                			model.setColumn1(list.getMc());
                			model.setColumn2(list.getDm().toString());
                			model.setColumn3(list.getJglx());
                			model.setColumn4(list.getId().toString());
                			models.add(model);
                		}
                	}
                }
                if ("sc_xzqh".equals(table)) {
                	sql = "from TXzqh model " + sql;
                	List<TXzqh> xzqhList = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                	.getResultList();
                	page.setTotalRecord(((Long) em.createQuery("select count (model )" + sql)
                			.getResultList().get(0)).intValue());
                	
                	if (xzqhList != null && !xzqhList.isEmpty()) {
                		for (TXzqh list : xzqhList) {
                			Model model = new Model();
                			model.setColumn1(list.getMc());
                			model.setColumn2(list.getDm().toString());
                			model.setColumn3(list.getDepth());
                			model.setColumn4(list.getDmF());
                			models.add(model);
                		}
                	}
                }
                if ("sc_bzjgdm".equals(table)) {
                	sql = "from Bzjgdm model " + sql;
                	List<Bzjgdm> bzjgdmList = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                	.getResultList();
                	page.setTotalRecord(((Long) em.createQuery("select count (model )" + sql)
                			.getResultList().get(0)).intValue());
                	
                	if (bzjgdmList != null && !bzjgdmList.isEmpty()) {
                		for (Bzjgdm list : bzjgdmList) {
                			Model model = new Model();
                			model.setColumn1(list.getMc());
                			model.setColumn2(list.getDm().toString());
                			model.setColumn3(list.getDepth());
                			model.setColumn4(list.getDmF());
                			models.add(model);
                		}
                	}
                }
                if("sc_lx".equals(table)){
                	sql = "from TNNjjlx model " + sql;
                	List<TNNjjlx> lxList = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                	.getResultList();
                	page.setTotalRecord(((Long) em.createQuery("select count (model )" + sql)
                			.getResultList().get(0)).intValue());
                	
                	if (lxList != null && !lxList.isEmpty()) {
                		for (TNNjjlx list : lxList) {
                			Model model = new Model();
                			model.setColumn1(list.getMc());
                			model.setColumn2(list.getDm().toString());
                			model.setColumn3(list.getJglx());
                			models.add(model);
                		}
                	}
                }
                if ("sc_jjhy".equals(table)) {
                	sql = "from TNNJjhy model " + sql;
                	List<TNNJjhy> jjhyList = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                	.getResultList();
                	page.setTotalRecord(((Long) em.createQuery("select count (model )" + sql)
                			.getResultList().get(0)).intValue());
                	
                	if (jjhyList != null && !jjhyList.isEmpty()) {
                		for (TNNJjhy list : jjhyList) {
                			Model model = new Model();
                			model.setColumn1(list.getMc());
                			model.setColumn2(list.getDm().toString());
                			model.setColumn3(list.getId().toString());
                			model.setColumn4(list.getMemo());
                			models.add(model);
                		}
                	}
                }
                
                if ("sc_xzqhdz".equals(table)) {
                	sql = "from ScXzqhdz model " + sql;
                	List<ScXzqhdz> xzqhdzList = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                	.getResultList();
                	page.setTotalRecord(((Long) em.createQuery("select count (model )" + sql)
                			.getResultList().get(0)).intValue());
                	
                	if (xzqhdzList != null && !xzqhdzList.isEmpty()) {
                		for (ScXzqhdz list : xzqhdzList) {
                			Model model = new Model();
                			model.setColumn1(list.getMc());
                			model.setColumn2(list.getDm().toString());
                			model.setColumn3(list.getYzbm());
                			model.setColumn4(list.getDhqh());
                			model.setColumn5(list.getId().toString());
                			models.add(model);
                		}
                	}
                }
                
               
                em.clear();
            }
        }.nSyTemplate();
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    public String getZfdm() {
        return zfdm;
    }

    public void setZfdm(String zfdm) {
        this.zfdm = zfdm;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TXzqh getXzqh() {
		return xzqh;
	}

	public void setXzqh(TXzqh xzqh) {
		this.xzqh = xzqh;
	}

	public Bzjgdm getBzjgObj() {
		return bzjgObj;
	}

	public void setBzjgObj(Bzjgdm bzjgObj) {
		this.bzjgObj = bzjgObj;
	}

	public TNNJjhy getTjjhy() {
		return tjjhy;
	}

	public void setTjjhy(TNNJjhy tjjhy) {
		this.tjjhy = tjjhy;
	}

	public ScXzqhdz getXzqhDz() {
		return xzqhDz;
	}

	public void setXzqhDz(ScXzqhdz xzqhDz) {
		this.xzqhDz = xzqhDz;
	}

	public TNNjjlx getTjjlx() {
		return tjjlx;
	}

	public void setTjjlx(TNNjjlx tjjlx) {
		this.tjjlx = tjjlx;
	}

	

	
	
    
    
}