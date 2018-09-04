package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TywlcDAO;
import com.ninemax.jpa.code.model.TYwlc;
import com.ninemax.jpa.code.model.TYwlcLog;
import com.ninemax.jpa.code.model.vo.TywlcVO;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-10-25
 * Time: ����2:20
 */
public class TywlcBus {

    private static Logger log = Logger.getLogger(TywlcBus.class);

    private TywlcDAO dao;
    private HandleBus handleBus;

    public TywlcBus() {
        dao = new TywlcDAO();
        handleBus = new HandleBus();
    }

    /**
     * ���ݻ������룬��ѯҵ������ʵ����
     *
     * @param jgdm
     * @return
     */
    public TYwlc findByJgdm(String jgdm) {
        List<TYwlc> list = dao.findbyhql("from TYwlc model where model.jgdm = '" + jgdm + "' order by model.id desc");
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else
            return null;
    }

    /**
     * ����ҵ����ˮ�Ų�ѯҵ��ʵ����
     *
     * @param ywlsh
     * @return
     */
    public TYwlc findByYwlsh(String ywlsh) {
        List<TYwlc> list = dao.findbyhql("from TYwlc model where model.ywlsh = '" + ywlsh + "' order by model.id desc");
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else
            return null;
    }

    /**
     * ����ҵ����ˮ�ţ���ѯҵ������ʵ���� ��Ӧ֤��ģ��
     *
     * @param ywlsh
     * @return
     */
    public TYwlc findZSByYwlsh(User user, String ywlsh, String source) {
        String jql = "";
        String cond = handleBus.sql(user);
        if ("yygs".equals(source)) {
            jql = "from TYwlc model where ( model.ywlsh = '" + ywlsh + "' or model.jgdm = '" + ywlsh + "' ) and " + cond + " and model.ywlclx = 13 and model.type = '����' order by model.id desc";
        }
        if ("qxgs".equals(source)) {
            jql = "from TYwlc model where ( model.ywlsh = '" + ywlsh + "' or model.jgdm = '" + ywlsh + "' ) and " + cond + " and model.ywlclx = 13 and model.type = 'ԤԼ��ʧ' order by model.id desc";
        }
        if ("qrgs".equals(source)) {
            jql = "from TYwlc model where ( model.ywlsh = '" + ywlsh + "' or model.jgdm = '" + ywlsh + "' ) and " + cond + " and model.ywlclx = 13 and model.type = 'ԤԼ��ʧ' order by model.id desc";
        }
        log.info(jql);
        List<TYwlc> list = dao.findbyhql(jql);
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else
            return new TYwlc();
    }


    /**
     * ��ȡҵ�����̱�����id
     *
     * @return 0 ҵ����ˮ��id 1 id
     */
    public String[] getMaxId() {
        String[] array = new String[2];
        String returnValue = "";
        Object obj = dao.findbysql("select max(id) id from t_ywlc");
        if (obj != null) {
            String value = obj.toString();
            String needValue = String.valueOf(Integer.parseInt(value) + 1);
            String temp = "";
            for (int i = 0; i < (8 - needValue.length()); i++) {
                temp += "0";
            }
            returnValue = temp + needValue;
            array[0] = returnValue;
            array[1] = needValue;
            return array;
        } else {
            array[0] = "00000001";
            array[1] = "1";
            return array;
        }
    }

    /**
     * ҵ������
     *
     * @param maxId
     * @param id
     * @param bzjgdm
     * @return
     */
    public boolean handleBus(String maxId, String id, String bzjgdm, String ywlxCode, String jgmc, String jgdm,String userName) {
        boolean flag = false;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            String ywlxName = em.createNativeQuery("select type from t_ywlc_dy  where ywlclx = " + Integer.valueOf(ywlxCode) + " and  lcsx = 1 ").getSingleResult().toString();
            tx = em.getTransaction();
            tx.begin();
            String date = DateUtil.dateToStr(DateUtil.getCurrentSystemDateTime(), "yyyy-MM-dd HH:mm:ss");
            TYwlc tYwlc = new TYwlc();
            tYwlc.setId(null);
            tYwlc.setBzjgdm(bzjgdm);
            tYwlc.setYwlsh(maxId);
            tYwlc.setType(ywlxName);
            tYwlc.setClsj(new Timestamp(DateUtil.strToDatehhmmss(date).getTime()));
            tYwlc.setIsend("0");
            tYwlc.setJgmc(jgmc);
            tYwlc.setJgdm(jgdm);
            tYwlc.setYwlclx(Integer.valueOf(ywlxCode));
            tYwlc.setUserName(userName);
            em.persist(tYwlc);
            TYwlcLog ywlcLog = new TYwlcLog();
            ywlcLog.setBzjgdm(bzjgdm);
            ywlcLog.setYwlsh(maxId);
            ywlcLog.setType(ywlxName);
            ywlcLog.setClsj(new Timestamp(DateUtil.strToDatehhmmss(date).getTime()));
            ywlcLog.setIsend("0");
            ywlcLog.setJgmc(jgmc);
            ywlcLog.setJgdm(jgdm);
            ywlcLog.setYwlclx(Integer.valueOf(ywlxCode));
            em.persist(ywlcLog);
            tx.commit();
            flag = true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            flag = false;
            log.error("TywlcBus handleBus error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    /**
     * ����ҵ�����̱�ҵ��������־��
     *
     * @param jgdm
     * @param jgmc
     * @param ywlxlx
     * @param type
     * @param isend
     * @param bzjgdm
     * @param username 
     */
    public String updateYwlc(String jgdm, String jgmc, String ywlxlx, String type, String isend, String bzjgdm, String userName) {
        String ywlclsh = "";
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            TYwlc tYwlc = null;
            List<TYwlc> list = em.createQuery("select model from TYwlc model where model.jgdm = ?1 and  model.bzjgdm = ?2 and model.ywlclx =  ?3 order by model.id desc")
                    .setParameter(1, jgdm).setParameter(2, bzjgdm).setParameter(3, Integer.valueOf(ywlxlx)).getResultList();
            if (list != null && list.size() > 0) {
                tYwlc = list.get(0);
            } else {
                tYwlc = new TYwlc();
                String[] strs = this.getMaxId();
                em = EntityManagerHelper.getEntityManager();
                if (strs != null && strs.length == 2) {
                    tYwlc.setId(Long.valueOf(strs[1]));
                    tYwlc.setYwlsh(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + strs[0]);
                    tYwlc.setJgdm(jgdm);
                    tYwlc.setJgmc(jgmc);
                    tYwlc.setYwlclx(Integer.valueOf(ywlxlx));
                }
            }
            tx = em.getTransaction();
            tx.begin();
            String date = DateUtil.dateToStr(DateUtil.getCurrentSystemDateTime(), "yyyy-MM-dd HH:mm:ss");
            tYwlc.setBzjgdm(bzjgdm);
            tYwlc.setType(type);
            tYwlc.setUserName(userName);
            tYwlc.setClsj(new Timestamp(DateUtil.strToDatehhmmss(date).getTime()));
            tYwlc.setIsend(isend);
            if (list != null && list.size() > 0) {
                em.merge(tYwlc);
            } else
                em.persist(tYwlc);
            TYwlcLog ywlcLog = new TYwlcLog();
            ywlcLog.setBzjgdm(bzjgdm);
            ywlcLog.setYwlsh(tYwlc.getYwlsh());
            ywlclsh = tYwlc.getYwlsh();
            ywlcLog.setType(type);
            ywlcLog.setClsj(new Timestamp(DateUtil.strToDatehhmmss(date).getTime()));
            ywlcLog.setIsend(isend);
            ywlcLog.setJgmc(jgmc);
            ywlcLog.setJgdm(jgdm);
            ywlcLog.setYwlclx(Integer.valueOf(ywlxlx));
            em.persist(ywlcLog);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error("TywlcBus updateYwlc error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return ywlclsh;
    }
    /**
     * ����ҵ�����̱�ҵ��������־��
     *
     * @param jgdm
     * @param jgmc
     * @param ywlxlx
     * @param type
     * @param isend
     * @param bzjgdm
     * @param username 
     */
    public void updateYwlc2(String jgdm, String jgmc,String type, String isend,  String userName) {
    	EntityManager em = EntityManagerHelper.getEntityManager();
    	EntityTransaction tx = null;
    	try {
    		tx.begin();
    		 //ҵ�����̸���
        	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm+"' and isend='0' order by clsj desc").getResultList();
        	if(ywlcs!=null&&ywlcs.size()>0){
        		
        		TYwlc yw=ywlcs.get(0);
        		yw.setType(type);
        		yw.setIsend(isend);
        		yw.setJgmc(jgmc);
        		em.merge(yw);
        		
        		TYwlcLog ywlog=new TYwlcLog();
        		BeanUtilsEx.copyProperties(ywlog, yw);
        		ywlog.setId(null);
        		em.persist(ywlog);
        }
    		tx.commit();
    	} catch (Exception e) {
    		if (tx != null && tx.isActive()) {
    			tx.rollback();
    		}
    		log.error("TywlcBus updateYwlc error " + e.toString());
    	} finally {
    		EntityManagerHelper.closeEntityManager();
    	}
    }

    /**
     * ҵ�������б�
     *
     * @param params
     * @param pageno
     * @param rowNumsView
     * @param pages
     * @param orderbyColum
     * @param orderbyMethod
     * @return
     */
    public List<TYwlc> listYwlc(User user, String types, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod) {
        List<TYwlc> list = null;
        try {
            String cond = handleBus.sql(user);
            String jql = "from TYwlc model where " + cond + " and model.isend<> '2' and model.type in (" + types + ") ";
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgdm".equals(key) || "ywlsh".equals(key)) {
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
                orderByContent = " model.clsj desc";
            }
            jql += " order by " + orderByContent;
            list = dao.listYwlc(jql, pageno, rowNumsView, pages, pms);
        } catch (Exception e) {
            log.error("TywlcBus listYwlc error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return list;
    }


    public List<TywlcVO> listDelAuditYwlc(User user, String types, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod) {
        List<TywlcVO> list = null;
        try {
            String cond = handleBus.sql(user);
            String jql = "select model.ywlsh,model.jgdm,model.jgmc,model.clsj,s.flag,s.shflag from t_ywlc model left join (select flag,shflag from  t_sp  where  flag !=2 and ywlx = '00') s on model.jgdm = s.jgdm where model.isend<> '2' and model.type in (" + types + ") ";
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgdm".equals(key) || "ywlsh".equals(key)) {
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
                orderByContent = " model.clsj desc";
            }
            jql += " order by " + orderByContent;
            List<Object[]> returnList = dao.delNativeListTjgdmSave(jql, pageno, rowNumsView, pages, pms);
            if (returnList != null && returnList.size() > 0) {
                list = new ArrayList<TywlcVO>();
                TywlcVO vo = null;
                for (Object[] objects : returnList) {
                    vo = new TywlcVO();
                    vo.setYwlsh(objects[0].toString());
                    vo.setJgdm(objects[1].toString());
                    vo.setJgmc(objects[2].toString());
                    vo.setClsj(DateUtil.strToDate(objects[3].toString()));
                    vo.setFlag(objects[4] == null ? "2" : objects[4].toString());
                    vo.setShflag(objects[5] == null ? "" : objects[5].toString());
                    list.add(vo);
                }
            }
        } catch (Exception e) {
            log.error("TywlcBus listDelAuditYwlc error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    /**
     * ҵ�������б�
     *
     * @param user
     * @param params
     * @param pageno
     * @param rowNumsView
     * @param pages
     * @param orderbyColum
     * @param orderbyMethod
     * @return
     */
    public List<TYwlc> listNewYwlc(User user, String ywlclx, String type, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod) {
        List<TYwlc> list = null;
        try {
            //������֤��������鿴�Ƿ���Ȩ�޲鿴
            String cond = "";
            cond = handleBus.sql(user);
            String jql = "from TYwlc model where " + cond + " and model.isend<> '2' and model.type in (" + type + ") and model.ywlclx in (" + ywlclx + ")";

            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();

                    if ("jgdm".equals(key) || "jgmc".equals(key) || "ywlsh".equals(key)) {
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
                orderByContent = " model.clsj desc";
            }
            jql += " order by " + orderByContent;
            log.info("jql:=" + jql);
            list = dao.listYwlc(jql, pageno, rowNumsView, pages, pms);
        } catch (Exception e) {
            log.error(TywlcBus.class, e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return list;
    }


    public List<TywlcVO> listDelYwlc(User user, String type, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod) {
        List<TywlcVO> list = null;
        try {
            String cond = handleBus.sql(user);
            String jql = "select new com.ninemax.jpa.code.model.vo.TywlcVO(model.ywlsh,model.jgdm,model.jgmc,model.clsj) from TYwlc model where " + cond + "  and model.isend<> '2' and model.type in (" + type + ") ";
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgdm".equals(key) || "jgmc".equals(key) || "ywlsh".equals(key)) {
                        value = "%" + value + "%";
                        jql += " and " + key + " like ?";
                    } else
                        jql += " and " + key + " = ?";
                    pms.add(value);
                }
                String orderByContent = "";
                if (!clsStringTool.isEmpty(orderbyColum)
                        && !clsStringTool.isEmpty(orderbyMethod)) {
                    orderByContent = orderbyColum + " " + orderbyMethod;
                } else {
                    orderByContent = " model.clsj desc";
                }
                jql += " order by " + orderByContent;
            }
            list = dao.delListTjgdmSave(jql, pageno, rowNumsView, pages, pms);
        } catch (Exception e) {
            log.error("TywlcBus listDelYwlc error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return list;
    }

    //ҵ�����̱�����ɾ��
    public void delYwlcData(String id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.createQuery("delete from TYwlc model where model.jgdm = ?1 ").setParameter(1, id).executeUpdate();
            em.createQuery("delete from TYwlcLog where jgdm = ?1 ").setParameter(1, id).executeUpdate();
            tx.commit();
        } catch (Exception e) {
            log.error("TywlcBus delYwlcData exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    //ҵ�����̱�����ɾ��
    public boolean delYwlcDataByYwlsh(String ywlsh) {
        boolean flag = false;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.createQuery("delete from TYwlc model where model.ywlsh = ?1 ").setParameter(1, ywlsh).executeUpdate();
            em.createQuery("delete from TYwlcLog where ywlsh = ?1 ").setParameter(1, ywlsh).executeUpdate();
            tx.commit();
            flag = true;
        } catch (Exception e) {
            log.error("TywlcBus delYwlcDataByYwlsh exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    /**
     * ����ҵ�����̱�ҵ��������־��----�������½�ҵ��
     *
     * @param jgdm
     * @param jgmc
     * @param ywlxlx
     * @param type
     * @param isend
     * @param bzjgdm
     */
    public synchronized String updateYwlcById(String id, String jgdm, String jgmc, String ywlxlx, String type, String isend, String bzjgdm) {
        String ywlclsh = "";
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            TYwlc tYwlc = null;
            List<TYwlc> list = em.createQuery("select model from TYwlc model where model.jgdm = ?1 and  model.bzjgdm = ?2 and model.ywlclx =  ?3 order by model.id desc")
                    .setParameter(1, id).setParameter(2, bzjgdm).setParameter(3, Integer.valueOf(ywlxlx)).getResultList();
            if (list != null && list.size() > 0) {
                tYwlc = list.get(0);
                tYwlc.setJgdm(jgdm);
            } else {
                tYwlc = new TYwlc();
                String[] strs = this.getMaxId();
                em = EntityManagerHelper.getEntityManager();
                if (strs != null && strs.length == 2) {
                    tYwlc.setId(Long.valueOf(strs[1]));
                    tYwlc.setYwlsh(Calendar.getInstance().get(Calendar.YEAR) + strs[0]);
                    tYwlc.setJgdm(jgdm);
                    tYwlc.setJgmc(jgmc);
                    tYwlc.setYwlclx(Integer.valueOf(ywlxlx));
                }
            }
            tx = em.getTransaction();
            tx.begin();
            String date = DateUtil.dateToStr(DateUtil.getCurrentSystemDateTime(), "yyyy-MM-dd HH:mm:ss");
            tYwlc.setBzjgdm(bzjgdm);
            tYwlc.setType(type);
            tYwlc.setClsj(new Timestamp(DateUtil.strToDatehhmmss(date).getTime()));
            tYwlc.setIsend(isend);
            if (list != null && list.size() > 0) {
                em.merge(tYwlc);
            } else
                em.persist(tYwlc);
            TYwlcLog ywlcLog = new TYwlcLog();
            ywlcLog.setBzjgdm(bzjgdm);
            ywlcLog.setYwlsh(tYwlc.getYwlsh());
            ywlclsh = tYwlc.getYwlsh();
            ywlcLog.setType(type);
            ywlcLog.setClsj(new Timestamp(DateUtil.strToDatehhmmss(date).getTime()));
            ywlcLog.setIsend(isend);
            ywlcLog.setJgmc(jgmc);
            ywlcLog.setJgdm(jgdm);
            ywlcLog.setYwlclx(Integer.valueOf(ywlxlx));
            em.persist(ywlcLog);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error("TywlcBus updateYwlc error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return ywlclsh;
    }

    public synchronized String updateYwlcByYwlsh(String ywlsh, String jgdm, String jgmc, String ywlxlx, String type, String isend, String bzjgdm) {
        String ywlclsh = "";
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            TYwlc tYwlc = null;
            List<TYwlc> list = em.createQuery("select model from TYwlc model where model.ywlsh = ?1 and  model.bzjgdm = ?2 and model.ywlclx =  ?3 order by model.id desc")
                    .setParameter(1, ywlsh).setParameter(2, bzjgdm).setParameter(3, Integer.valueOf(ywlxlx)).getResultList();
            if (list != null && list.size() > 0) {
                tYwlc = list.get(0);
                tYwlc.setJgdm(jgdm);
            } else {
                tYwlc = new TYwlc();
                String[] strs = this.getMaxId();
                em = EntityManagerHelper.getEntityManager();
                if (strs != null && strs.length == 2) {
                    tYwlc.setId(Long.valueOf(strs[1]));
                    tYwlc.setYwlsh(Calendar.getInstance().get(Calendar.YEAR) + strs[0]);
                    tYwlc.setJgdm(jgdm);
                    tYwlc.setJgmc(jgmc);
                    tYwlc.setYwlclx(Integer.valueOf(ywlxlx));
                }
            }
            tx = em.getTransaction();
            tx.begin();
            String date = DateUtil.dateToStr(DateUtil.getCurrentSystemDateTime(), "yyyy-MM-dd HH:mm:ss");
            tYwlc.setBzjgdm(bzjgdm);
            tYwlc.setType(type);
            tYwlc.setClsj(new Timestamp(DateUtil.strToDatehhmmss(date).getTime()));
            tYwlc.setIsend(isend);
            if (list != null && list.size() > 0) {
                em.merge(tYwlc);
            } else
                em.persist(tYwlc);
            TYwlcLog ywlcLog = new TYwlcLog();
            ywlcLog.setBzjgdm(bzjgdm);
            ywlcLog.setYwlsh(tYwlc.getYwlsh());
            ywlclsh = tYwlc.getYwlsh();
            ywlcLog.setType(type);
            ywlcLog.setClsj(new Timestamp(DateUtil.strToDatehhmmss(date).getTime()));
            ywlcLog.setIsend(isend);
            ywlcLog.setJgmc(jgmc);
            ywlcLog.setJgdm(jgdm);
            ywlcLog.setYwlclx(Integer.valueOf(ywlxlx));
            em.persist(ywlcLog);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error("TywlcBus updateYwlcByYwlsh error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return ywlclsh;
    }


    public synchronized void updateYwlcLog(String ywlsh, String jgmc) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.createNativeQuery("update t_ywlc set jgmc = ?1 where ywlsh = ?2 ").setParameter(1, jgmc).setParameter(2, ywlsh).executeUpdate();
            em.createNativeQuery("update t_ywlc_log set jgmc = ?1 where ywlsh = ?2 ").setParameter(1, jgmc).setParameter(2, ywlsh).executeUpdate();
            tx.commit();
        } catch (Exception e) {
            log.error("TywlcBus updateYwlcLog exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

	public synchronized String getMaxLsh(String xzqh) {
		// TODO Auto-generated method stub
		String lsh="";
		String like=xzqh+DateUtil.dateToStr(new Date(), "yyyyMMdd");
		EntityManager em = EntityManagerHelper.getEntityManager();
		 try {
		List<TYwlc> list = em.createQuery(" from TYwlc where ywlsh like '"+like+"%' order by ywlsh desc").getResultList();
		if(list!=null&&list.size()>0){ 
			String str=list.get(0).getYwlsh();
			lsh=Long.valueOf(str.trim())+1+"";
		}else{
			lsh=like+"001";
		}
        } catch (Exception e) {
            log.error("TywlcBus updateYwlcLog exception============" + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
		return lsh; 
	}

}
