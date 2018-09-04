package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.CodePartDAO;
import com.ninemax.jpa.code.model.Mdsource;
import com.ninemax.jpa.code.model.QTMdsource;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Liuzy
 */
public class CodePartBus {
    private static Logger log = Logger.getLogger(CodePartBus.class);
    private CodePartDAO dao;

    public CodePartBus() {
        dao = new CodePartDAO();
    }

    public String newCodepart(Mdsource md) {
        String resultMessage = "数据已成功保存！";
        md.setMdzt(false);
        md.setLrsj(new Date());
        List<Mdsource> mds;
        List<QTMdsource> qtmds;

        String qsmd = md.getQsmd();
        String jzmd = md.getJzmd();
        String mdType = md.getMdtype();
        try {
            String strCxjg = "";
            // String sql =
            // "select * from t_mdsource where ('"+qsmd+"' >= qsmd and '"+qsmd+"' <= jzmd) or ('"+jzmd+"' >= qsmd and '"+jzmd+"'<=jzmd) or ('"+qsmd+"'<qsmd and '"+jzmd+"' > jzmd)";

            String hql = "select md from Mdsource md where ( md.qsmd BETWEEN '" + qsmd +
                    "' and  '" + jzmd + "') or (md.jzmd BETWEEN '" + qsmd + "' and '" + jzmd
                    + "')";
            mds = dao.findMdbyhql(hql);
            if (mds != null && mds.size() > 0) {
                resultMessage = String.valueOf(String.valueOf(new StringBuffer(
                        "输入新码段失败，原因：该码段(").append(qsmd).append("--").append(
                        jzmd).append(")中的部分码段已存在系统中，请重新输入！")));
                return resultMessage;
            }

            mds = null;
            String hql2 = "select md from QTMdsource md where (md.qsmd BETWEEN '" + qsmd +
                    "' and  '" + jzmd + "') or (md.jzmd BETWEEN '" + qsmd + "' and '" + jzmd
                    + "')";
            // conndb.dbQuery(String.valueOf(String.valueOf(new
            // StringBuffer("select * from t_qtmdsource where ('").append(qsmd).append("' >=qsmd and '").append(qsmd).append("' <=jzmd) or ('").append(jzmd).append("' >=qsmd and '").append(jzmd).append("' <=jzmd) or ('").append(qsmd).append("' <qsmd and '").append(jzmd).append("'>jzmd)"))));
            qtmds = dao.findQTMdByHql(hql2);
            if (qtmds != null && qtmds.size() > 0) {
                resultMessage = String.valueOf(String.valueOf(new StringBuffer(
                        "输入新码段失败，原因：该码段(").append(qsmd).append("--").append(
                        jzmd).append(")中的部分码段已存在系统中，请重新输入！")));
                return resultMessage;
            }

            String _sql1 = "select jgdm from t_mdk where substring(jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
            List datas = dao.findMdbysql(_sql1);
            if (datas != null && datas.size() > 0) {
                resultMessage = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中的部分码段已存在系统中，请重新输入！")));
                return resultMessage;
            }

            // conndb.dbUpdate(String.valueOf(String.valueOf(new
            // StringBuffer("insert into t_mdsource(qsmd,jzmd,mdsl,mdtype) values('").append(qsmd).append("','").append(jzmd).append("',").append(Integer.toString(getMdsl(qsmd,
            // jzmd))).append(",'").append(mdType).append("')"))));
            if (CodePart.getMdsl(qsmd, jzmd) > 20000) {
                resultMessage = String.valueOf(String.valueOf(new StringBuffer("您要输入的码段数量超过20000条请重新输入!！")));
            }
            md.setMdsl(CodePart.getMdsl(qsmd, jzmd));
            dao.save(md);
            mds = null;
            mds = dao.findByProperty("mdzt", false);

            EntityManagerHelper.beginTransaction();//开启事物
            if (mds != null && mds.size() > 0) {
                for (Mdsource md2 : mds) {
                    String strQsmd = md2.getQsmd();
                    int intMdsl = Integer.parseInt(md2.getMdsl().toString());
                    String strMdType = md2.getMdtype();
                    for (int j = 0; j < intMdsl; j++) {
                        String strFcMd = CheckCode.getCheckCode(CodePart
                                .mdAddOne(strQsmd, j));
                        // conndb.dbUpdate(String.valueOf(String.valueOf(new
                        // StringBuffer("insert into t_mdk(jgdm,dmflag) values('").append(strFcMd).append("','").append(strMdType).append("')"))));
                        String sql = "insert into t_mdk(jgdm,dmflag,createTime) values('"
                                + strFcMd + "','" + strMdType + "','" + DateUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss") + "')";
                        dao.executeSql(sql);
                    }
                }
            }
            // conndb.dbUpdate("update t_mdsource set mdzt=1 where mdzt=0");
            dao.executeSql("update t_mdsource set mdzt=1 where mdzt=0");
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            log.error(CodePartBus.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return resultMessage;
    }

    public String newQTCodepart(QTMdsource md) {
        String resultMessage = "数据已成功保存！";
        md.setMdzt(false);
        md.setLrsj(new Date());
        List<Mdsource> mds = null;
        List<QTMdsource> qtmds = null;

        String qsmd = md.getQsmd();
        String jzmd = md.getJzmd();
        String mdType = md.getMdtype();
        try {
            String strCxjg = "";
            String hql = "select md from Mdsource md where ( md.qsmd BETWEEN '" + qsmd +
                    "' and  '" + jzmd + "') or (md.jzmd BETWEEN '" + qsmd + "' and '" + jzmd
                    + "')";
            mds = dao.findMdbyhql(hql);
            if (mds != null && mds.size() > 0) {
                resultMessage = String.valueOf(String.valueOf(new StringBuffer(
                        "输入新码段失败，原因：该码段(").append(qsmd).append("--").append(
                        jzmd).append(")的部分码段已存在系统中，请重新输入！")));
                return resultMessage;
            }

            mds = null;
            String hql2 = "select md from QTMdsource md where (md.qsmd BETWEEN '" + qsmd +
                    "' and  '" + jzmd + "') or (md.jzmd BETWEEN '" + qsmd + "' and '" + jzmd
                    + "')";
            qtmds = dao.findQTMdByHql(hql2);
            if (mds != null && mds.size() > 0) {
                resultMessage = String.valueOf(String.valueOf(new StringBuffer(
                        "输入新码段失败，原因：该码段(").append(qsmd).append("--").append(
                        jzmd).append(")的部分码段已存在系统中，请重新输入！")));
                return resultMessage;
            }
//-------------------------------
            List datas = null;

            String _sql1 = "select jgdm from t_mdk where substring(jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
            datas = dao.findMdbysql(_sql1);
            if (datas != null && datas.size() > 0) {
                String jgmc = datas.get(0).toString();
                resultMessage = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中主表(t_jgdm)中的机构(").append(jgmc).append(")冲突！")));
                return resultMessage;
            }
            _sql1 = "select jgmc from t_fzdm where substring(jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
            datas = dao.findMdbysql(_sql1);
            if (datas != null && datas.size() > 0) {
                String jgmc = datas.get(0).toString();
                resultMessage = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中注销表(t_fzdm)中的机构(").append(jgmc).append(")冲突！")));
                return resultMessage;
            }
            _sql1 = "select jgmc from t_qzjgdm where substring(jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
            datas = dao.findMdbysql(_sql1);
            if (datas != null && datas.size() > 0) {
                String jgmc = datas.get(0).toString();
                resultMessage = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中迁址表(t_qzjgdm)中的机构(").append(jgmc).append(")冲突！")));
                return resultMessage;
            }
            _sql1 = "select jgmc from t_ljdm where substring(jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
            datas = dao.findMdbysql(_sql1);
            if (datas != null && datas.size() > 0) {
                String jgmc = datas.get(0).toString();
                resultMessage = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中删除表(t_ljdm)中的机构(").append(jgmc).append(")冲突！")));
                return resultMessage;
            }
            _sql1 = "select jgdm from t_qtmdk where substring(jgdm,1,8) BETWEEN '" + qsmd + "' and '" + jzmd + "'";
            datas = dao.findMdbysql(_sql1);
            if (datas != null && datas.size() > 0) {
                resultMessage = String.valueOf(String.valueOf(new StringBuffer("输入新码段失败，原因：该码段(").append(qsmd).append("--").append(jzmd).append(")中其它码段库(t_qtmdk)中的机构代码冲突，您已经录入了该码段！")));
                return resultMessage;
            }
//---------------------------------
            md.setMdsl(CodePart.getMdsl(qsmd, jzmd));
            dao.save(md);
            mds = null;
            qtmds = dao.findQTMdByProperty("mdzt", false);
            EntityManagerHelper.beginTransaction();//开启事物
            if (qtmds != null && qtmds.size() > 0) {
                for (QTMdsource md2 : qtmds) {
                    String strQsmd = md2.getQsmd();
                    int intMdsl = md2.getMdsl();
                    String strMdType = (String) md2.getMdtype();
                    for (int j = 0; j < intMdsl; j++) {
                        String strFcMd = CheckCode.getCheckCode(CodePart
                                .mdAddOne(strQsmd, j));
                        String sql = "insert into t_qtmdk(jgdm,dmflag,createTime) values('"
                                + strFcMd + "','" + strMdType + "','" + DateUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss") + "')";
                        dao.executeSql(sql);
                    }
                }
            }
            dao.executeSql("update t_qtmdsource set mdzt=1 where mdzt=0");
            EntityManagerHelper.commit();
        } catch (Exception e) {
            log.error(CodePartBus.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return resultMessage;
    }

    //统计剩余码段数量
    public Map<String, String> sycodeCount() {
        Map<String, String> mp = new HashedMap();
        try {
            // String sql2 = "select count(*) as count from t_qtmdk";
            String s0 = dao.findMdbysql("select count(*) as count from t_mdk where dmflag='0'").get(0).toString();
            String s3 = dao.findMdbysql("select count(*) as count from t_mdk where dmflag='3'").get(0).toString();
//            String qt = dao.findMdbysql("select count(*) as count from t_qtmdk").get(0).toString();
            mp.put("0", s0);
            mp.put("3", s3);
//            mp.put("q", qt);
        } catch (Exception e) {
            log.error(CodePartBus.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return mp;
    }

    //统计不同码段类型的数据
    public List<Mdsource> listMdsource(Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages) {
        List<Mdsource> mds = null;
        try {
            String jql = "from Mdsource md where 1=1 ";
            if (pages == null) {
                pages = new clsPageComponent();

            }


            String orderBy = (pages.getOrderbyColum() != null && !"".equals(pages.getOrderbyColum())) ? (" order by md." + pages.getOrderbyColum() + " " + pages.getOrderbyMethod()) : "";
            List<Object> pams = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if (!clsStringTool.isEmpty(value)) {
                        if (key.equals("startDate")) {
                            jql += " and md.lrsj >= ?";
                            pams.add(DateProcess.stringToDate(value, "yyyy-MM-dd"));
                        }
                        if (key.equals("endDate")) {
                            jql += " and md.lrsj <= ?";
                            pams.add(new Date(DateProcess.stringToDate(value, "yyyy-MM-dd").getTime() + 24 * 60 * 60 * 1000));
                        }
                        if (key.equals("mdtype")) {
                            jql += " and md.mdtype = ?";
                            pams.add(value);
                        }
                        if (key.equals("dm")) {
                            jql += " and md.qsmd <= ? and md.jzmd >= ?";
                            pams.add(value);
                            pams.add(value);
                        }
                    }
                }
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

    public List<QTMdsource> listQTMdsource(Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages) {
        List<QTMdsource> qtmds = null;
        String jql = "from QTMdsource md where 1=1";
        String orderBy = (pages.getOrderbyColum() != null && !"".equals(pages.getOrderbyColum())) ? (" order by md." + pages.getOrderbyColum() + " " + pages.getOrderbyMethod()) : "";
        try {
            List<Object> pams = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if (!clsStringTool.isEmpty(value)) {
                        if (key.equals("startDate")) {
                            jql += " and md.lrsj >= ?";
                            pams.add(DateProcess.stringToDate(value, "yyyy-MM-dd"));
                        }
                        if (key.equals("endDate")) {
                            jql += " and md.lrsj <= ?";
                            pams.add(new Date(DateProcess.stringToDate(value, "yyyy-MM-dd").getTime() + 24 * 60 * 60 * 1000));
                        }
                        if (key.equals("mdtype")) {
                            jql += " and md.mdtype = ?";
                            pams.add(value);
                        }
                        if (key.equals("dm")) {
                            jql += " and md.qsmd <= ? and md.jzmd >= ?";
                            pams.add(value);
                            pams.add(value);
                        }
                    }
                }
            }
            jql += orderBy;
            qtmds = dao.findMdbyjql(jql, pageno, rowNumsView, pages, pams);

        } catch (Exception e) {
            log.error(CodePartBus.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return qtmds;
    }
}
