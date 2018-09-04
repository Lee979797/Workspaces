package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.*;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.*;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.directwebremoting.json.parse.JsonDecoder;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: 下午3:42
 */
public class TSpBus {
    private static Logger log = Logger.getLogger(TSpBus.class);

    private TSpDAO dao = new TSpDAO();
    private TSppzDAO sppzDao = new TSppzDAO();
    private TSpdmtempDAO spdmDao = new TSpdmtempDAO();
    private TJgdmDAO jgdmDao = new TJgdmDAO();
    private TFzdmDAO fzdmDao = new TFzdmDAO();
    private TQzjgdmDAO qzjgdmDao = new TQzjgdmDAO();

    public TSp getZycp(String dm) {
        return dao.findById(dm);
    }

    public boolean hasAudia(String jgdm) {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("jgdm", jgdm);
        props.put("ywlx", "01");
        List<TSp> sps = dao.findByPropertys(props);

        if (sps.size() > 0) { 
            TSp sp = sps.get(0);
            if ("1".equals(sp.getFlag())) {
                if ("1".equals(sp.getShflag())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否重名审核
     *
     * @return
     */
    public TSp checkRepeatAudia(String jgdm) {
        String hql = "from TSp model where model.jgdm='" + jgdm + "' and (model.ywlx in ('02') ) ORDER BY model.shtime desc";
        List<TSp> list = dao.findbyhql(hql);
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else
            return null;
    }

    public String checkforAudia(String jgdm, String typeName) {
        try {
            TSppz sppz=new TSppz();
            //申请表删除
            if ("sqbscsh".equals(typeName)) {
                sppz = sppzDao.findById("00");
            } else if ("fzsh".equals(typeName)) {
                sppz = sppzDao.findById("01");
                if (jgdmDao.findById(jgdm) == null) {
                    return "0:机构（" + jgdm + "）不存在，或者已经做了其他操作！";
                }
                //换证
            } else if ("hzsh".equals(typeName)) {
                sppz = sppzDao.findById("02");
            } else if ("deletesh".equals(typeName)) {
                sppz = sppzDao.findById("03");
                if (jgdmDao.findById(jgdm) == null) {
                    return "0:机构（" + jgdm + "）不存在，或者已经做了其他操作！";
                }         //注销恢复
            } else if ("fzhfsh".equals(typeName)) {
            	sppz.setYwmc("注销恢复");
            	sppz.setYwlx("04");
               // sppz = sppzDao.findById("04");
                if (fzdmDao.findById(jgdm) == null) {
                    return "0:机构（" + jgdm + "）不存在或者没有被注销，不需要恢复！";
                }       //迁址
            } else if ("qzsh".equals(typeName)) {
                sppz = sppzDao.findById("05");
                List<TQzjgdm> qzjgdms = qzjgdmDao.findByProperty("jgdm", jgdm);
                if (qzjgdms == null || qzjgdms.isEmpty()) {
                    return "0:机构（" + jgdm + "）不存在或者没有做迁址，不需要恢复！";
                }
            } else if ("bgsh".equals(typeName)) {
                /*sppz = sppzDao.findById("07");
                if (jgdmDao.findById(jgdm) == null) {
                    return "0:机构（" + jgdm + "）不存在，或者已经做了其他操作！";
                }*/
                sppz.setYwlx("07");
                sppz.setYwmc("重名");
                
            } else {
                sppz = sppzDao.findById(typeName);
            }

            List<TSp> sps = dao.findbyhql("select model from TSp model where model.tyshxydm='" + jgdm + "' and model.flag <> '2'");
            if (sps != null && !sps.isEmpty()&&sps.size()>0) {
                TSp sp = sps.get(0);
                int index = ("04".equals(sp.getYwlx()) || "05".equals(sp.getYwlx())) ? 4 : 2;
                String name = sp.getSubmitType() == 0 ? "" : sp.getSubmitType() == 1 ? "重名" : sp.getSubmitType() == 2 ? "重注册号" : "重名重注册号";
                if ("0".equals(sp.getFlag().trim())) {
                   // sppz = sppzDao.findById(sp.getYwlx());
                    return "1:机构（" + jgdm + "）" + "已经于" + DateUtil.dateToStr(sp.getSendtime()) + "由" + sp.getSendman() + "发送了" + sppz.getYwmc().substring(0, sppz.getYwmc().length() - index) + name + sppz.getYwmc().substring(sppz.getYwmc().length() - index) + "请求,正在等待审核！";
                } else if ("1".equals(sp.getFlag().trim())) {
                    if ("1".equals(sp.getShflag().trim())) {
                        log.info(sppz.getYwlx() + ":" + sp.getYwlx());
                        if (sp.getYwlx().equals(sppz.getYwlx())) {
                            return "2:机构（" + jgdm + "）" + "已经于" + DateUtil.dateToStr(sp.getSendtime()) + "进行了审核,允许" + name + sppz.getYwmc().substring(sppz.getYwmc().length() - index) + "此机构代码！";
                        } else {
                            sppz = sppzDao.findById(sp.getYwlx());
                            return "1:机构（" + jgdm + "）" + "已经于" + DateUtil.dateToStr(sp.getSendtime()) + "由" + sp.getShman() + "进行了审核,需完成该(" + sppz.getYwmc().substring(0, sppz.getYwmc().length() - index) + name + sppz.getYwmc().substring(sppz.getYwmc().length() - index) + ")审核业务才能进行当前业务";
                        }
                    } else {
                        if (sp.getYwlx().equals(sppz.getYwlx())) {
                            return "3:机构（" + jgdm + "）" + "已经于" + DateUtil.dateToStr(sp.getSendtime()) + "进行了审核,不允许" + name + sppz.getYwmc().substring(sppz.getYwmc().length() - index) + "此机构代码！重新提交申请？";
                        }
                       // sppz = sppzDao.findById(sp.getYwlx());
                        return "4: 将机构（" + jgdm + "） " + sppz.getYwmc() + "需要经过省中心的审核，向省中心发送" + sppz.getYwmc() + "请求。";
                    }


                } else {
                    return "4: 将机构（" + jgdm + "） " + sppz.getYwmc() + "需要经过省中心的审核，向省中心发送" + sppz.getYwmc() + "请求。";

                }
            } else {
                return "4: 将机构（" + jgdm + "） " + sppz.getYwmc() + "需要经过省中心的审核，向省中心发送" + sppz.getYwmc() + "请求。";
            }
        } catch (Exception e) {
            log.error(TSpBus.class, e);
        }
        return "";
    }

    public String isAudiaAll(String jgdm, String ywlx) {
        List<TSp> sps = dao.findbyhql("select model from TSp model where model.tyshxydm='" + jgdm + "' and model.flag <> '2'");
        if (sps != null && !sps.isEmpty()) {
            TSp sp = sps.get(0);
            int index = ("04".equals(sp.getYwlx()) || "05".equals(sp.getYwlx())) ? 4 : 2;
           // TSppz sppz = sppzDao.findById(sp.getYwlx());
            String name = sp.getSubmitType() == 0 ? "" : sp.getSubmitType() == 1 ? "重名" : sp.getSubmitType() == 2 ? "重注册号" : "重名重注册号";
            if("5".equals(sp.getSubmitType())){
            	 return "1:机构（" + jgdm + "）" + "已经于" + DateUtil.dateToStr(sp.getSendtime()) + "由" + sp.getSendman() + "发送了法人重名请求,正在等待审核！";
            }
            if ("0".equals(sp.getFlag().trim())) {
                return "1:机构（" + jgdm + "）" + "已经于" + DateUtil.dateToStr(sp.getSendtime()) + "由" + sp.getSendman() + "发送了请求,正在等待审核！";
            } else if ("1".equals(sp.getFlag().trim())) {
                if ("1".equals(sp.getShflag().trim())) {
                    if (sp.getYwlx().equals(ywlx))
                        return "0:";
                    return "1:机构（" + jgdm + "）" + "已经于" + DateUtil.dateToStr(sp.getSendtime()) + "由" + sp.getShman() + "进行了审核,需先完成该审核业务才能办理当前业务";
                }
                return "0:";
            } else {
                return "0:";
            }
        } else {
            return "0:";
        }
    }

    /**
     * zx 获取删除信息，用于提示用户
     *
     * @param jgdm
     * @return
     */
    public String getDelMessage(String jgdm) {
        String delMessage = "";
        String strSendTime = "";
        String strSendMan = "";
        String hql = "from TSp model where model.jgdm='" + jgdm + "' and (model.flag='0' or model.flag='1')";
        List<TSp> list = dao.findbyhql(hql);
        if (list != null && list.size() > 0) {
            TSp tsp = list.get(0);
            if ("0".equals(tsp.getFlag())) {
                strSendTime = String.valueOf(tsp.getSendtime());
                strSendMan = tsp.getSendman();
                delMessage = "0;机构（" + jgdm + "）" + "已经于" + strSendTime + "由" + strSendMan + "发送了删除请求,至今未作审核！";
            } else {
                String shTime = String.valueOf(tsp.getShtime());
                String shMan = tsp.getShman();
                if (tsp.getShflag().trim().equals("1")) {
                    delMessage = "1;机构（" + jgdm + "）" + "已经于" + shTime + "由" + shMan + "进行了审核,允许删除此机构代码！";
                } else {
                    delMessage = "3;" + "机构（" + jgdm + "）" + "已经于" + shTime + "由" + shMan + "进行了审核,不允许删除此机构代码！";
                }
            }
        } else {
            delMessage = "2" + ";" + "申请表删除需要经过省中心的审核，向省中心发送删除请求。";
        }
        return delMessage;
    }

    /**
     * 发送申请表删除请求
     *
     * @param jgdm
     * @param reason 0 系统异常，发送失败 1 成功 2 已经发送，不要在发送
     * @return
     */
    public int sendDelRequest(String jgdm, String reason, User user, String yw) {
        String ywlx = "";
        String tableSource = "";

        if ("1".equals(yw)) {
            ywlx = "08";
            tableSource = "t_jgdm_save";
        }
        if ("2".equals(yw)) {
            ywlx = "09";
            tableSource = "t_jgdm_save";
        }
        if ("4".equals(yw)) {
            ywlx = "00";
            tableSource = "t_jgdm";
        }
        int result = 0;
        List<TSp> list = dao.findbyhql("select model from TSp model where model.jgdm = '" + jgdm + "' and model.shflag <> '0' and model.flag <> '1' ");
        if (list != null && list.size() > 0) {
            result = 2;
        } else {
            EntityManager em = EntityManagerHelper.getEntityManager();

            EntityTransaction tx = null;
            try {
                tx = em.getTransaction();
                tx.begin();
                String strSql = "insert into t_spdmtemp(jgdm,jgmc,jglx,njglx,fddbr,zjlx,zjhm,jyfw,jjhy,jjhy2011,njjhy,jjlx,jjlx2011,njjlx,zcrq,zgdm,pzjgdm,xzqh,jgdz,yzbm,dhhm,scbzrq,bzrq,zfrq,bzjgdm,zycp1,zycp2,zycp3,zczj,hbzl,wftzgb,zgrs,fbsl,zslsh,bgbj,bgrq,lry,njrq,njr,njqx,xgr,zbsl,zch,qzbz,zgmc,pzjgmc,gslsh,gstbr,wjwlsh,pzwh,pwrq,wjwtbr,gk,fkbz,fksl,email,url,mobile,czreason,czyj,memo,memo2,tbrxm,tbrsfzh,tbrlxfs,gsfzrq,jydz,jyyb,jydh,jfly,khyh,khzh,jgxydm)";
                strSql = strSql + " select jgdm,jgmc,jglx,njglx,fddbr,zjlx,zjhm,jyfw,jjhy,jjhy2011,njjhy,jjlx,jjlx2011,njjlx,zcrq,zgdm,pzjgdm,xzqh,jgdz,yzbm,dhhm,scbzrq,bzrq,zfrq,bzjgdm,zycp1,zycp2,zycp3,zczj,hbzl,wftzgb,zgrs,fbsl,zslsh,bgbj,bgrq,lry,njrq,njr,njqx,xgr,zbsl,zch,qzbz,zgmc,pzjgmc,gslsh,gstbr,wjwlsh,pzwh,pwrq,wjwtbr,gk,fkbz,fksl,email,url,mobile,'" + reason + "','',memo,memo2,tbrxm,tbrsfzh,tbrlxfs,gsfzrq,jydz,jyyb,jydh,jfly,khyh,khzh,jgxydm from " + tableSource + " where jgdm='" + jgdm + "'";
                em.createNativeQuery(strSql).executeUpdate();
                em.flush();
                strSql = "select lsh from t_spdmtemp where jgdm='" + jgdm + "' order by lsh desc";
                List lshList = em.createNativeQuery(strSql).getResultList();
                String lsh = "";
                if (lshList != null && lshList.size() > 0) {
                    lsh = lshList.get(0).toString();
                }
                strSql = "delete from t_sp where jgdm = '" + jgdm + "' and ywlx = '" + ywlx + "' and shflag = '0' and flag = '1' ";
                em.createNativeQuery(strSql).executeUpdate();
                strSql = "insert into t_sp(ywlx,jgdm,sendxzqh,sendman,sendtime,recexzqh,flag,gllsh,submitType) values(";
                strSql = strSql + "'" + ywlx + "','" + jgdm + "','" + user.getBzjgdm() + "','" + user.getUserName() + "','" + DateUtil.getCurrentDateTime() + "','" + InitSysParams.system.getXzqhdm().trim() + "','0'," + lsh + ",0)";
                em.createNativeQuery(strSql).executeUpdate();
                result = 1;
                tx.commit();
            } catch (Exception e) {
                log.error(e);
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                result = 0;
            } finally {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return result;
    }

    /**
     * 证书审核提交
     *
     * @param tjgdm
     * @param user
     * @return
     */
    public int sendCertAudit(TJgdm tjgdm, User user, String type) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        String ywlx = "02";
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.createQuery("delete from TSpdmtemp where lsh in (select model.gllsh from TSp model where model.jgdm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1')))")
                    .setParameter("jgdm", tjgdm.getJgdm()).setParameter("ywlx", ywlx).executeUpdate();
            em.createQuery("update  TSp model set model.flag='2' where model.jgdm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1'))")
                    .setParameter("jgdm", tjgdm.getJgdm()).setParameter("ywlx", ywlx).executeUpdate();

            TSpdmtemp spdm = new TSpdmtemp();
            BeanUtilsEx.copyProperties(spdm, tjgdm);
            em.persist(spdm);
            TSp sp = new TSp();
            sp.setGllsh(spdm.getLsh());
            sp.setFlag("0");
            sp.setShflag("0");
            sp.setYwlx(ywlx);
            sp.setJgdm(tjgdm.getJgdm());
            sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
            sp.setSendxzqh(tjgdm.getBzjgdm());
            sp.setSendman(user.getUserName());
            sp.setSendtime(new Date());
            sp.setSubmitType(Integer.parseInt(type));
            em.persist(sp);
            result = 1;
            tx.commit();
        } catch (Exception e) {
            log.error(e);
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            result = 0;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result;
    }

    /**
     * 重名审核提交
     *
     * @param tjgdm
     * @param user
     * @return
     */
    public int sendSaveAudit(TJgdmSave tjgdm, User user, String type, String ywlxType,String jglx) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        //申请表新增
        String ywlx = ywlxType;
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            if (tjgdm.getId() == null) {
                em.persist(tjgdm);
                em.flush();
            }
            String jgdmOrId = (tjgdm.getTyshxydm() == null || "".equals(tjgdm.getTyshxydm().trim())) ? tjgdm.getId().toString() : tjgdm.getTyshxydm();
            System.out.println("jgdmOrId = " + jgdmOrId);
            em.createQuery("delete from TSpdmtemp where lsh in (select model.gllsh from TSp model where model.tyshxydm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1')))")
                    .setParameter("jgdm", jgdmOrId).setParameter("ywlx", ywlx).executeUpdate();
            em.createQuery("update  TSp model set model.flag='2' where model.tyshxydm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1'))")
                    .setParameter("jgdm", jgdmOrId).setParameter("ywlx", ywlx).executeUpdate();
            em.flush();
            TSpdmtemp spdm = new TSpdmtemp();
            BeanUtilsEx.copyProperties(spdm, tjgdm);
            if("11".equals(ywlx)){
            	
            	spdm.setTyshxydm(tjgdm.getJgdm());
            	spdm.setJgdm(tjgdm.getJgdm());
            }else{
            	   spdm.setTyshxydm(jgdmOrId);
            }
            em.persist(spdm);
            TSp sp = new TSp();
            sp.setGllsh(spdm.getLsh());
            sp.setFlag("0");
            sp.setShflag("0");
            sp.setJglx(jglx);
         /*   if(!"".equals(tjgdm.getJgdm())){
            	sp.setTyshxydm(tjgdm.getJgdm());
            }else{*/
            	sp.setTyshxydm(jgdmOrId);
           // }
            	if("11".equals(ywlx)){
            		sp.setYwlx(ywlx);
            		sp.setTyshxydm(tjgdm.getJgdm());
            		
            	}else if("13".equals(ywlx)){
            		sp.setYwlx(ywlx);
            	}else{
            		sp.setYwlx("07");
            	}
            sp.setRecexzqh("");
            sp.setJgmc(tjgdm.getJgmc());
            sp.setSendxzqh(tjgdm.getBzjgdm());
            sp.setSendman(user.getUserName());
            sp.setSendtime(new Date());
            sp.setSubmitType(Integer.parseInt(type));
            em.persist(sp);
            em.flush();
            result = 1;
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            result = 0;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result;
    }


    /**
     * 重名审核提交
     *
     * @param tjgdm
     * @param user
     * @return
     */
    public int sendAudit(TJgdm tjgdm, User user, String type) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        String ywlx = "16";
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            String jgdmOrId = tjgdm.getTyshxydm();
            em.createQuery("delete from TSpdmtemp where lsh in (select model.gllsh from TSp model where model.tyshxydm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1')))")
                    .setParameter("jgdm", jgdmOrId).setParameter("ywlx", ywlx).executeUpdate();
            em.createQuery("update  TSp model set model.flag='2' where model.tyshxydm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1'))")
                    .setParameter("jgdm", jgdmOrId).setParameter("ywlx", ywlx).executeUpdate();

            TSpdmtemp spdm = new TSpdmtemp();
            BeanUtilsEx.copyProperties(spdm, tjgdm);
            spdm.setJgdm(tjgdm.getJgdm());
            em.persist(spdm);
            TSp sp = new TSp();
            sp.setGllsh(spdm.getLsh());
            sp.setFlag("0");
            sp.setShflag("0");
            sp.setYwlx(ywlx);
            sp.setJglx(tjgdm.getJglx());
            sp.setJgmc(tjgdm.getJgmc());
            //sp.setJgdm(tjgdm.getJgdm());
            sp.setTyshxydm(tjgdm.getTyshxydm());
            //sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
            sp.setSendxzqh(tjgdm.getBzjgdm());
            sp.setSendman(user.getUserName());
            sp.setSendtime(new Date());
            sp.setSubmitType(Integer.parseInt(type));
            em.persist(sp);
            result = 1;
            tx.commit();
        } catch (Exception e) {
            log.error(e);
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            result = 0;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result;
    }

    /**
     * author:zx
     * 删除审核表数据
     */
    public void delSptempData(TJgdmSave tjgdm, String ywlx) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            String jgdmOrId = clsStringTool.isEmpty(tjgdm.getTyshxydm()) ? tjgdm.getId().toString() : tjgdm.getTyshxydm();
            em.createQuery("delete from TSpdmtemp where lsh in (select model.gllsh from TSp model where model.tyshxydm=:jgdm and (model.ywlx in (" + ywlx + ") or (model.flag='1' and model.shflag <> '1')))")
                    .setParameter("jgdm", jgdmOrId).executeUpdate();
            em.createQuery("delete from TSp model where model.tyshxydm=:jgdm and (model.ywlx in (" + ywlx + ") or (model.flag='1' and model.shflag <> '1'))  ")
                    .setParameter("jgdm", jgdmOrId).executeUpdate();
            tx.commit();
        } catch (Exception e) {
            log.error(e);
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    /**
     * author:zx
     * 删除审核表数据
     */
    public void delSptempTjgdmData(String jgdm, String ywlx) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.createQuery("delete from TSpdmtemp where lsh in (select model.gllsh from TSp model where model.tyshxydm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1')))")
                    .setParameter("jgdm", jgdm).setParameter("ywlx", ywlx).executeUpdate();
            em.createQuery("delete from TSp model where model.tyshxydm=:jgdm and (model.ywlx =:ywlx or (model.flag='1' and model.shflag <> '1'))  ")
                    .setParameter("jgdm", jgdm).setParameter("ywlx", ywlx).executeUpdate();
            tx.commit();
        } catch (Exception e) {
            log.error(e);
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    /**
     * zx 删除申请表
     *
     * @param jgdm
     * @param user
     * @return int 2 要恢复的机构代码不存在!  0 失败 1 成功
     */
    public String delApplyForm(String jgdm, User user) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            //申请表记录插入到删除代码表
            String strsql = "insert into t_djgdm(jgdm,jgmc,jglx,njglx,fddbr,zjlx,zjhm,jyfw,jjhy,jjhy2011,njjhy,jjlx,jjlx2011,njjlx,zcrq,zgdm,pzjgdm,xzqh,jgdz,yzbm,dhhm,scbzrq,bzrq,zfrq,bzjgdm,zycp1,zycp2,zycp3,zczj,hbzl,wftzgb,zgrs,fbsl,zslsh,bgbj,bgrq,lry,njrq,njr,njqx,xgr,zbsl,zch,qzbz,zgmc,pzjgmc,gslsh,gstbr,wjwlsh,pzwh,pwrq,wjwtbr,gk,fkbz,fksl,dybz,email,url,mobile,djblx,lastdate,scrq,scr,memo,memo2,tbrxm,tbrsfzh,tbrlxfs,gsfzrq,jydz,jyyb,jydh,jfly,khyh,khzh,jgxydm)";
            strsql = strsql + " select jgdm,jgmc,jglx,njglx,fddbr,zjlx,zjhm,jyfw,jjhy,jjhy2011,njjhy,jjlx,jjlx2011,njjlx,zcrq,zgdm,pzjgdm,xzqh,jgdz,yzbm,dhhm,scbzrq,bzrq,zfrq,bzjgdm,zycp1,zycp2,zycp3,zczj,hbzl,wftzgb,zgrs,fbsl,zslsh,bgbj,bgrq,lry,njrq,njr,njqx,xgr,zbsl,zch,qzbz,zgmc,pzjgmc,gslsh,gstbr,wjwlsh,pzwh,pwrq,wjwtbr,gk,fkbz,fksl,dybz,email,url,mobile,djblx,lastdate,'" + DateUtil.getCurrentDateTime() + "','" + user.getUserName() + "',memo,memo2,tbrxm,tbrsfzh,tbrlxfs,gsfzrq,jydz,jyyb,jydh,jfly,khyh,khzh,jgxydm from t_spdmtemp where jgdm='" + jgdm + "'";
            em.createNativeQuery(strsql).executeUpdate();
            //查看登记表类型
            strsql = "select djblx from t_jgdm";
            strsql = strsql + " where bzjgdm='" + user.getBzjgdm() + "' and jgdm='" + jgdm + "'";
            List djbList = em.createNativeQuery(strsql).getResultList();
            String djblx = "";
            if (djbList != null && djbList.size() > 0) {
                djblx = djbList.get(0).toString();
            }
            //登记表类型为其它部门赋码删除t_jgdm表记录，并删除ic卡信息里面此机构代码记录.其它登记表类型的还要回收机构代码

            List czjl=em.createNativeQuery("SELECT * from t_czjl where type='1A' and jgdm='"+jgdm+"'").getResultList();
            if (djblx.equals("1")) {
            } else {
                if (czjl.size()==0) {
                    //码段临时表中是否有此机构代码记录，如果有标示此机构代码3是用于个体 否则0用于非个体  然后插入到码段回收临时表
                    strsql = "select jgdm,dmflag from t_mdktemp where jgdm='" + jgdm + "'";
                    List mdkTemp = em.createNativeQuery(strsql).getResultList();
                    if (mdkTemp != null && mdkTemp.size() > 0) {
                        strsql = "insert into t_tempmd (jgdm,dmflag,tempdate,bzjgdm) values ('" + jgdm + "','3','" + DateUtil.getCurrentDateTime() + "','" + user.getBzjgdm() + "')";
                        em.createNativeQuery(strsql).executeUpdate();
                    } else {
                        strsql = "insert into t_tempmd (jgdm,dmflag,tempdate,bzjgdm) values ('" + jgdm + "','0','" + DateUtil.getCurrentDateTime() + "','" + user.getBzjgdm() + "')";
                        em.createNativeQuery(strsql).executeUpdate();
                    }
                }

            }
            //记录操作日志
            strsql = "insert into t_czjl(name,type,date,jgdm,xzqh) values ('" + user.getUserName() + "','7','" + DateUtil.getCurrentDateTime() + "','" + jgdm + "','" + user.getBzjgdm() + "')";
            em.createNativeQuery(strsql).executeUpdate();
            //清除此机构代码处罚记录
            strsql = "delete from t_cfjlb where jgdm='" + jgdm + "' and  cfbz=0";
            em.createNativeQuery(strsql).executeUpdate();

            if (czjl.size()==0) {
                //删除码段临时表中此机构代码记录
                strsql = "delete from t_mdktemp where jgdm='" + jgdm + "'";
                em.createNativeQuery(strsql).executeUpdate();
                String strDmflag = "";
                //查询码段临时表，如果没有记录返回result2 要恢复的机构代码不存在,否则获得代码标志
                strsql = "select tempdate,bzjgdm,dmflag from t_tempmd where jgdm='" + jgdm + "'";
                List<Object[]> mdList = em.createNativeQuery(strsql).getResultList();
                if (mdList == null || mdList.size() <= 0) {
                    result = 2;
                    return ""+result;
                } else {
                    Object[] objs = mdList.get(0);
                    strDmflag = objs[2].toString();
                }
            /*strsql = "select scrq,xzqh from t_djgdm where jgdm = '" + jgdm + "'";
            List<Object[]> djList = em.createNativeQuery(strsql).getResultList();
            String strScrq = "";
            String strXzqh1 = "";
            if (djList != null && djList.size() > 0) {
                Object[] objs = djList.get(0);
                strScrq = objs[0].toString();
                strXzqh1 = objs[1].toString();
            }*/
                //回收机构代码插入到码段资源表
                if (jgdm.startsWith("L") || jgdm.startsWith("l")) {
                    strDmflag = "3";
                }
                strsql = "insert into t_mdk(jgdm,dmflag) values('" + jgdm + "','" + strDmflag + "')";
                em.createNativeQuery(strsql).executeUpdate();
                //删除码段临时表此机构代码记录
                strsql = "delete from t_tempmd where jgdm='" + jgdm + "'";
                em.createNativeQuery(strsql).executeUpdate();
            } else {
                TJgdm dm = em.find(TJgdm.class, jgdm);
                em.clear();
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put(Constants.OrganizationCode, dm.getJgdm());
                parameters.put(Constants.OrganizationName, dm.getJgmc());
                parameters.put(Constants.RegisterNumber, dm.getZch());
                parameters.put(Constants.OrganizationAddress, dm.getJgdz());
                String rs = new CodeAssignClient().assign(PropertiesUtils.getValue("url").toString(), "cancel", parameters);
                JSONObject object = JSONObject.fromObject(rs);
                String message = "";
                for (Object key : object.keySet()) {
                    if ("flag".equals(key)) {
                        Object value = object.get(key);
                        if (!"1".equals(value)) {
                            result = 3;

                        }

                    }
                    if ("info".equals(key)) {
                        Object value = object.get(key);
                        if (value != null) {
                            message = value.toString();
                        }
                    }
                }
                if (result == 3) {
                    return result+":"+message;
                }
            }
            strsql = "delete from t_jgdm where jgdm='" + jgdm + "'";
            em.createNativeQuery(strsql).executeUpdate();

            strsql = "delete from tk_kxxk where jgdm='" + jgdm + "'";
            em.createNativeQuery(strsql).executeUpdate();
            //记录操作日志
            strsql = "insert into t_czjl(name,type,date,jgdm,xzqh) values ('" + user.getUserName() + "','O','" + DateUtil.getCurrentDateTime() + "','" + jgdm + "','" + user.getBzjgdm() + "')";
            em.createNativeQuery(strsql).executeUpdate();
            //查询审核状态审核表 flag 0 未审核 1 已审核 2 清楚审核信息

            strsql = "select top 1 lsh,gllsh from t_sp where jgdm='" + jgdm + "' and flag='1' and ywlx='00' order by lsh desc";
            List<Object[]> lshList = em.createNativeQuery(strsql).getResultList();
            String strLsh = "";
            String strGllsh = "";
            if (lshList != null && lshList.size() > 0) {
                Object[] objs = lshList.get(0);
                strLsh = objs[0].toString();
                strGllsh = objs[1].toString();
                strsql = "delete from t_sp where lsh=" + strLsh;
                em.createNativeQuery(strsql).executeUpdate();
                //删除审批代码临时表
                strsql = "delete from t_spdmtemp where lsh=" + strGllsh;
                em.createNativeQuery(strsql).executeUpdate();
            }

            strsql = "delete from TSmrw model where model.jgdm = '" + jgdm + "' ";
            em.createQuery(strsql).executeUpdate();
            result = 1;
            tx.commit();
        } catch (Exception e) {
            log.error(e);
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            result = 0;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result+"";
    }


    public List<TSp> getTspList(String jgdm, String ywlx) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tyshxydm", jgdm);
        map.put("ywlx", ywlx);
        map.put("flag", "1");
        return dao.findByPropertys(map);
    }

    public Map<String, String> getMap() {
        List<TSppz> sppzs = EntityManagerHelper.getEntityManager().createQuery("select model from TSppz model").getResultList();
        Map<String, String> ywlxs = new HashMap<String, String>();
        for (TSppz pz : sppzs) {
            ywlxs.put(pz.getYwlx().trim(), pz.getYwmc().trim());
        }
        EntityManagerHelper.closeEntityManager();
        return ywlxs;
    }

    public void delAuditNOPass(String jgdm) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            String strsql = "";
            strsql = "delete from t_sp where jgdm= '" + jgdm + "' and flag = '1' and shflag = '0' ";
            em.createNativeQuery(strsql).executeUpdate();
            //删除审批代码临时表
            strsql = "delete from t_spdmtemp where jgdm= '" + jgdm + "'";
            em.createNativeQuery(strsql).executeUpdate();
            em.createNativeQuery(strsql).executeUpdate();
            tx.commit();
        } catch (Exception e) {
            log.error(e);
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}