package com.ninemax.jpa.code.action;


import com.ninemax.jpa.code.bus.CodePartBus;
import com.ninemax.jpa.code.model.Mdsource;
import com.ninemax.jpa.code.model.QTMdsource;
import com.ninemax.jpa.code.model.TMdk;
import com.ninemax.jpa.code.model.TQtmdk;
import com.ninemax.jpa.code.model.XTmdk;
import com.ninemax.jpa.code.model.XTmdsource;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @author Liuzy
 */
public class TydmCodePartAction extends ActionSupport {
    private static Logger log = Logger.getLogger(TydmCodePartAction.class);

    private CodePartBus newCodebus;
    private String resultMsg = "";
    private String currentPath = "";
    private XTmdsource mdsource;
    private QTMdsource qtmdsource;
    private Map<String, String> mp;
    private clsPageComponent pages;
    private Integer rowNumsView = 20;
    private Integer pageno = 1;
    private List<Mdsource> mds;
    private List<QTMdsource> qtmds;
    private Integer findtype = 0;
    private Map<String, String> params = new HashedMap();

    public TydmCodePartAction() {
        if (newCodebus == null)
            newCodebus = new CodePartBus();
    }

    //新增码段
    public String newcode() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                currentPath = "/product/jsp/codepart/tydmnewcode.jsp";
                resultMsg = "数据已成功保存！";
                mdsource.setMdzt(false);
                mdsource.setLrsj(new Date());
                List<XTmdsource> mds = em.createQuery("select md from XTmdsource md where ( md.qsmd BETWEEN ?1 and  ?2) or (md.jzmd BETWEEN ?3 and ?4 )")
                        .setParameter(1, mdsource.getQsmd()).setParameter(2, mdsource.getJzmd())
                        .setParameter(3, mdsource.getQsmd()).setParameter(4, mdsource.getJzmd())
                        .getResultList();
                if (mds != null && mds.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer(
                            "输入新码段失败，原因：该码段(").append(mdsource.getQsmd()).append("--").append(
                            mdsource.getJzmd()).append(")中的部分码段已存在系统中，请重新输入！")));
                    return;
          }
             /*   List<QTMdsource> qtmds = em.createQuery("select md from QTMdsource md where ( md.qsmd BETWEEN ?1 and  ?2) or (md.jzmd BETWEEN ?3 and ?4 )")
                        .setParameter(1, mdsource.getQsmd()).setParameter(2, mdsource.getJzmd())
                        .setParameter(3, mdsource.getQsmd()).setParameter(4, mdsource.getJzmd())
                        .getResultList();
                if (qtmds != null && qtmds.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer(
                            "输入新码段失败，原因：该码段(").append(mdsource.getQsmd()).append("--").append(
                            mdsource.getJzmd()).append(")中的部分码段已存在系统中，请重新输入！")));
                    return;
    }*/
                List datas = em.createQuery("select model from XTmdk model where substring(model.jgdm,1,8) BETWEEN ?1 and ?2 ")
                        .setParameter(1, mdsource.getQsmd()).setParameter(2, mdsource.getJzmd())
                        .getResultList();
                if (datas != null && datas.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(mdsource.getQsmd()).append("--").append(mdsource.getJzmd()).append(")中的部分码段已存在系统中，请重新输入！")));
                    return;
                }
                TextCode4  t=new TextCode4();
                //t.codeNext("MYYYYNNNN");
                int sum=2;
                String st=mdsource.getQsmd();
                String en=mdsource.getJzmd();
                while (!t.codeNext(st).equals(en)) {
          			 System.out.println("====:"+t.codeNext(st));
          			 sum+=1;
          			
          			 st=t.codeNext(st);
          		}
                System.out.println(sum);

                if (sum > 20000) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer("您要输入的码段数量超过20000条请重新输入!！")));
                }
                mdsource.setMdsl(sum);
                em.persist(mdsource);
               // em.flush();
                mds = em.createQuery("select  model from XTmdsource model where model.mdzt=false ").getResultList();
               
              
                if (mds != null && mds.size() > 0) {
                    for (XTmdsource md2 : mds) {
                        //String strQsmd = md2.getQsmd();
                       
                        String strMdType = md2.getMdtype();
                        String st1=mdsource.getQsmd();
                        String en1=mdsource.getJzmd();
                        TextCode4  t1=new TextCode4();
                        	while (!t1.codeNext(st1).equals(en1)) {
                     			 System.out.println("====:"+t1.codeNext(st1));
                     		
                        		st1=t1.codeNext(st1);
                     			
                        		XTmdk mdk = new XTmdk();
                        		mdk.setCreateTime(new Date());
                        		mdk.setJgdm(st1);
                        		mdk.setDmflag(strMdType);
                        		em.persist(mdk);
                     		}
                      
                    }
                }
                System.out.println("end");
                em.createQuery("update XTmdsource model set model.mdzt = true where model.mdzt =false  ").executeUpdate();

            }
        }.template();
    }
    public boolean add(Object table){
		boolean flag = true;
		EntityManager em = EntityManagerHelper.getEntityManager();
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
 

   


    public XTmdsource getMdsource() {
		return mdsource;
	}

	public void setMdsource(XTmdsource mdsource) {
		this.mdsource = mdsource;
	}

	public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public QTMdsource getQtmdsource() {
        return qtmdsource;
    }

    public void setQtmdsource(QTMdsource qtmdsource) {
        this.qtmdsource = qtmdsource;
    }

    public Map<String, String> getMp() {
        return mp;
    }

    public void setMp(Map<String, String> mp) {
        this.mp = mp;
    }

    public clsPageComponent getPages() {
        return pages;
    }

    public void setPages(clsPageComponent pages) {
        this.pages = pages;
    }

    public List<Mdsource> getMds() {
        return mds;
    }

    public void setMds(List<Mdsource> mds) {
        this.mds = mds;
    }

    public List<QTMdsource> getQtmds() {
        return qtmds;
    }

    public void setQtmds(List<QTMdsource> qtmds) {
        this.qtmds = qtmds;
    }

    public Integer getFindtype() {
        return findtype;
    }

    public void setFindtype(Integer findtype) {
        this.findtype = findtype;
    }

    public Integer getRowNumsView() {
        return rowNumsView;
    }

    public void setRowNumsView(Integer rowNumsView) {
        this.rowNumsView = rowNumsView;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

}
