package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.CodePartBus;
import com.ninemax.jpa.code.model.Mdsource;
import com.ninemax.jpa.code.model.QTMdsource;
import com.ninemax.jpa.code.model.TMdk;
import com.ninemax.jpa.code.model.TQtmdk;
import com.ninemax.jpa.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Liuzy
 */
public class CodePartAction extends ActionSupport {
    private static Logger log = Logger.getLogger(CodePartAction.class);

    private CodePartBus newCodebus;
    private String resultMsg = "";
    private String currentPath = "";
    private Mdsource mdsource;
    private QTMdsource qtmdsource;
    private Map<String, String> mp;
    private clsPageComponent pages;
    private Integer rowNumsView = 20;
    private Integer pageno = 1;
    private List<Mdsource> mds;
    private List<QTMdsource> qtmds;
    private Integer findtype = 0;
    private Map<String, String> params = new HashedMap();

    public CodePartAction() {
        if (newCodebus == null)
            newCodebus = new CodePartBus();
    }

    //新增码段
    public String newcode() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                currentPath = "/product/jsp/codepart/newcode.jsp";
                resultMsg = "数据已成功保存！";
                mdsource.setMdzt(false);
                mdsource.setLrsj(new Date());
                List<Mdsource> mds = em.createQuery("select md from Mdsource md where ( md.qsmd BETWEEN ?1 and  ?2) or (md.jzmd BETWEEN ?3 and ?4 )")
                        .setParameter(1, mdsource.getQsmd()).setParameter(2, mdsource.getJzmd())
                        .setParameter(3, mdsource.getQsmd()).setParameter(4, mdsource.getJzmd())
                        .getResultList();
                if (mds != null && mds.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer(
                            "输入新码段失败，原因：该码段(").append(mdsource.getQsmd()).append("--").append(
                            mdsource.getJzmd()).append(")中的部分码段已存在系统中，请重新输入！")));
                    return;
          }
/*                List<QTMdsource> qtmds = em.createQuery("select md from QTMdsource md where ( md.qsmd BETWEEN ?1 and  ?2) or (md.jzmd BETWEEN ?3 and ?4 )")
                        .setParameter(1, mdsource.getQsmd()).setParameter(2, mdsource.getJzmd())
                        .setParameter(3, mdsource.getQsmd()).setParameter(4, mdsource.getJzmd())
                        .getResultList();
                if (qtmds != null && qtmds.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer(
                            "输入新码段失败，原因：该码段(").append(mdsource.getQsmd()).append("--").append(
                            mdsource.getJzmd()).append(")中的部分码段已存在系统中，请重新输入！")));
                    return;
    }*/
                List datas = em.createQuery("select model from TMdk model where substring(model.jgdm,1,8) BETWEEN ?1 and ?2 ")
                        .setParameter(1, mdsource.getQsmd()).setParameter(2, mdsource.getJzmd())
                        .getResultList();
                if (datas != null && datas.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(mdsource.getQsmd()).append("--").append(mdsource.getJzmd()).append(")中的部分码段已存在系统中，请重新输入！")));
                    return;
                }

                if (CodePart.getMdsl(mdsource.getQsmd(), mdsource.getJzmd()) > 20000) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer("您要输入的码段数量超过20000条请重新输入!！")));
                }
                mdsource.setMdtype("0");
                mdsource.setMdsl(CodePart.getMdsl(mdsource.getQsmd(), mdsource.getJzmd()));
                em.persist(mdsource);
                mds = em.createQuery("select  model from Mdsource model where model.mdzt=false ").getResultList();
                CodePart code=new CodePart();
                if (mds != null && mds.size() > 0) {
                    for (Mdsource md2 : mds) {
                        String strQsmd = md2.getQsmd();
                        String strJzmd=code.codeNext(md2.getJzmd());
                        int intMdsl = Integer.parseInt(md2.getMdsl().toString());
                        String strMdType = md2.getMdtype();
                        
                        while (!strQsmd.equals(strJzmd)) {
                        	
                        	 String strFcMd = CheckCode.getCheckCode(strQsmd);
	               			 TMdk mdk = new TMdk();
	                         mdk.setCreateTime(new Date());
	                         mdk.setJgdm(strFcMd);
	                         mdk.setDmflag("0");
	                         //mdk.setId(null);
	                         em.persist(mdk);
	                         strQsmd=code.codeNext(strQsmd);
                       }
                    }
                }
                em.createQuery("update Mdsource model set model.mdzt = true where model.mdzt =false  ").executeUpdate();

            }
        }.template();
    }

    //新增其它码段
    public String newqtcode() {

        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                currentPath = "/product/jsp/codepart/newqtcode.jsp";
                List<Mdsource> mds = null;
                List<QTMdsource> qtmds = null;
                String qsmd = qtmdsource.getQsmd();
                String jzmd = qtmdsource.getJzmd();
                String hql = "select md from Mdsource md where ( md.qsmd BETWEEN '" + qsmd +
                        "' and  '" + jzmd + "') or (md.jzmd BETWEEN '" + qsmd + "' and '" + jzmd
                        + "')";
                mds = em.createQuery(hql).getResultList();
                if (mds != null && mds.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer(
                            "输入新码段失败，原因：该码段(").append(qsmd).append("--").append(
                            jzmd).append(")中已有数据存在于系统中！")));
                    return;
                }
                hql = "select md from QTMdsource md where (md.qsmd BETWEEN '" + qsmd +
                        "' and  '" + jzmd + "') or (md.jzmd BETWEEN '" + qsmd + "' and '" + jzmd
                        + "')";
                qtmds = em.createQuery(hql).getResultList();
                if (qtmds != null && qtmds.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer(
                            "输入新码段失败，原因：该码段(").append(qsmd).append("--").append(
                            jzmd).append(")中已有数据存在于系统中！")));
                    return;
                }
                hql = "select mdk.jgdm from TQtmdk  mdk where substring(mdk.jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
                List<String> datas = em.createQuery(hql).getResultList();
                if (datas != null && datas.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中已有数据存在于系统中！")));
                    return;
                }
                hql = "select mdk.jgdm from TMdk mdk where substring(mdk.jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
                datas = em.createQuery(hql).getResultList();
                if (datas != null && datas.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中已有数据存在于系统中！")));
                    return;
                }
                hql = "select fzdm.jgdm from TFzdm fzdm where substring(fzdm.jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
                datas = em.createQuery(hql).getResultList();
                if (datas != null && datas.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中已有数据存在于系统中！")));
                    return;
                }
                hql = "select model.jgmc from TQzjgdm model where substring(model.jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
                datas = em.createQuery(hql).getResultList();
                if (datas != null && datas.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中已有数据存在于系统中！")));
                    return;
                }
                hql = "select model.jgmc from TLjdm model where substring(model.jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
                datas = em.createQuery(hql).getResultList();
                if (datas != null && datas.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中已有数据存在于系统中！")));
                    return;
                }
                hql = "select model.jgdm from TQtmdk  model where substring(model.jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
                datas = em.createQuery(hql).getResultList();
                if (datas != null && datas.size() > 0) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中已有数据存在于系统中！")));
                    return;
                }
                if (CodePart.getMdsl(qsmd, jzmd) > 20000) {
                    resultMsg = String.valueOf(String.valueOf(new StringBuffer("您要输入的码段数量超过20000条请重新输入!！")));
                    return;
                }
                qtmdsource.setMdsl(CodePart.getMdsl(qsmd, jzmd));
                qtmdsource.setMdzt(false);
                qtmdsource.setLrsj(new Date());
                em.persist(qtmdsource);
                qtmds = em.createQuery("select model from QTMdsource model where model.mdzt=:mdzt").setParameter("mdzt", false).getResultList();
                if (qtmds != null && qtmds.size() > 0) {
                    for (QTMdsource md2 : qtmds) {
                        String strQsmd = md2.getQsmd();
                        int intMdsl = md2.getMdsl();
                        String strMdType = md2.getMdtype();
                        for (int j = 0; j < intMdsl; j++) {
                            String strFcMd = CheckCode.getCheckCode(CodePart
                                    .mdAddOne(strQsmd, j));
                            TQtmdk qtmdk = new TQtmdk();
                            qtmdk.setJgdm(strFcMd);
                            qtmdk.setDmflag(strMdType);
                            em.persist(qtmdk);
                        }
                    }
                }
                em.createQuery("update QTMdsource model set model.mdzt=:mdzt where model.mdzt=:mdzt0").setParameter("mdzt0", false).setParameter("mdzt", true).executeUpdate();
                resultMsg = "数据已成功保存！";
            }
        }.template();
    }

    //统计码段信息和剩余码段数量
    public String countSyCode() {
        currentPath = "/product/jsp/codepart/leavingcode.jsp";
        mp = newCodebus.sycodeCount();
        if (pages == null) {
            pages = new clsPageComponent();
        }
        if (pages.getOrderbyColum() != null && !"".equals(pages.getOrderbyColum())) {

        } else {
            pages.setOrderbyColum("lrsj");
            pages.setOrderbyMethod("desc");
        }

        if (findtype == 0)
            mds = newCodebus.listMdsource(params, pageno, rowNumsView, pages);
        else
            qtmds = newCodebus.listQTMdsource(params, pageno, rowNumsView, pages);
        return this.SUCCESS;
    }

    public Mdsource getMdsource() {
        return mdsource;
    }

    public void setMdsource(Mdsource mdsource) {
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
