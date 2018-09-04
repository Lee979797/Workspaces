package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jpa.code.dao.NumberDAO;
import com.ninemax.jpa.code.model.TZsbhb;
import com.ninemax.jpa.code.model.TZsbhbId;
import com.ninemax.jpa.code.model.TZsbhsource;
import com.ninemax.jpa.code.model.TZssl;
import com.ninemax.jpa.code.model.vo.ZsbhsourceVO;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.CodePart;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Liuzy
 */
public class NumberBus {
    private static Logger log = Logger.getLogger(NumberBus.class);
    private NumberDAO dao;

    public NumberBus() {
        dao = new NumberDAO();
    }

    public String newQxNum(TZsbhsource zsSource, String bzjgdm) {
        List<TZsbhb> datas;
        String message = "�����ѳɹ����棡";
        String qsbh = zsSource.getQsbh();
        String jzbh = zsSource.getJzbh();
        String zsType = zsSource.getZstype();
        String fpBzjg = zsSource.getFpbzjg();
        try {
            if (clsStringTool.isEmpty(qsbh) || clsStringTool.isEmpty("jzbh")) {
                return "����������֤����ʼ��ţ�";
            }
            String strCxjg = "";
            DataAccess dataObject = new DataAccess();
            CachedRowSet cs = dataObject.query("select min(zsbh) minbh,max(zsbh) maxbh from t_zsbhb where flag='0' and ssds='" + bzjgdm + "' and ssbzjg is null and zslx='" + zsType + "'");
            String strMinzs = "";
            String strMaxzs = "";
            if (cs.next()) {
                strMinzs = cs.getString("minbh");
                strMaxzs = cs.getString("maxbh");
            }
            cs.close();
            if (clsStringTool.isEmpty(strMaxzs) || clsStringTool.isEmpty(strMinzs)) {
                return "�������Է���֤���ţ�ʡ����δ�������ط�����õ�֤���ţ�";
            }
            if ((qsbh.compareTo(strMinzs) < 0) || (jzbh.compareTo(strMaxzs) > 0)) {
                return "�������֤���Ŷ�(" + qsbh + "-" + jzbh + ")����ʡ���ķָ����Ŀ���֤���Ŷ�(" + strMinzs + "-" + strMaxzs + ")�У�";
            }
            CachedRowSet cs2 = dataObject.query("select zsbh,zslx from t_zsbhb where (zsbh>='" + qsbh + "' and zsbh<='" + jzbh + "' and zslx='" + zsType + "' and ssbzjg is null and ssds='" + bzjgdm + "')");
            if (!cs2.next()) {
                return "����֤���Ŵ�����Ҫ�����֤�����޷����䣡";
            }
            cs2.close();
            EntityManagerHelper.beginTransaction();

            dao.executeSql("update t_zsbhb set ssbzjg='" + fpBzjg + "',fpsj='" + new Timestamp(new Date().getTime()) + "' where ssds is not null and ssbzjg is null and zslx='" + zsType + "' and zsbh>='" + qsbh + "' and zsbh<='" + jzbh + "' and ssds='" + bzjgdm + "'");

            exe_zssl(zsSource.getZssl(), fpBzjg, zsType);
            exe_zssl(zsSource.getZssl(), fpBzjg, "2");
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            log.error(e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return message;
    }

    public List<TZsbhb> qxList(Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages) {
        List<TZsbhb> zsbhs = null;
        String jql = "from TZsbhb zs where zs.flag='0' and zs.ssds = zs.ssbzjg ";
        List<Object> pams = new ArrayList();
        if (params != null && params.size() > 0) {
            for (Entry<String, String> param : params.entrySet()) {
                if (param.getKey().equals("startDate")) {
                    jql += " and zs.fpsj >= ?";
                    pams.add(param.getValue());
                }
                if (param.getKey().equals("endDate")) {
                    jql += " and zs.fpsj <= ?";
                    pams.add(param.getValue());
                }
                if (param.getKey().equals("qsbh")) {
                    jql += " and zs.id.zsbh >= ?";
                    pams.add(param.getValue());
                }
                if (param.getKey().equals("jsbh")) {
                    jql += " and zs.id.zsbh <= ?";
                    pams.add(param.getValue());
                }
                if (param.getKey().equals("bzjg")) {
                    jql += " and zs.ssbzjg = ?";
                    pams.add(param.getValue());
                }
            }
        }

        try {
            zsbhs = dao.findZsbyhql(jql, pageno, rowNumsView, pages, pams);
        } catch (Exception e) {
            log.error(e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return zsbhs;
    }

    public List<TZsbhb> findNumList(Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages) {
        List<TZsbhb> zsbhs = null;
        String jql = "from TZsbhb zs where zs.flag='0' and zs.ssbzjg is not null ";
        List<Object> pams = new ArrayList();
        if (params != null && params.size() > 0) {
            for (Entry<String, String> param : params.entrySet()) {
                if (param.getKey().equals("startDate")) {
                    jql += " and zs.fpsj >= ?";
                    pams.add(param.getValue());
                }
                if (param.getKey().equals("endDate")) {
                    jql += " and zs.fpsj <= ?";
                    pams.add(param.getValue());
                }
                if (param.getKey().equals("zsbh")) {
                    jql += " and zs.id.zsbh = ?";
                    pams.add(param.getValue());
                }
                if (param.getKey().equals("bzjg")) {
                    jql += " and zs.ssbzjg = ?";
                    pams.add(param.getValue());
                }
            }
        }

        try {
            zsbhs = dao.findZsbyhql(jql, pageno, rowNumsView, pages, pams);
        } catch (Exception e) {
            log.error(e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return zsbhs;
    }

    public String cancelNum(String zsbh, String zslx) {
        String message;
        String lxmc;
        if ((zsbh == null) || (zsbh.equals("")) || (zslx == null) || (zslx.equals("")))
            return "�밴��ȷ����������";
        if (zslx.equals("0"))
            lxmc = "����";
        else {
            lxmc = "����";
        }
        try {
            EntityManagerHelper.beginTransaction();
            TZsbhbId id = new TZsbhbId();
            id.setZsbh(zsbh);
            id.setZslx(zslx);
            TZsbhb zsbhb = dao.find(TZsbhb.class, id);
            if (zsbhb == null || !"0".equals(zsbhb.getFlag())) {
                message = "ȡ����η��������Ҫȡ����֤����(" + zsbh + ")��" + lxmc + "�Ѿ�ʹ�û����޷�ȡ�����䣡";
                return message;
            }
            zsbhb.setSsbzjg(null);
            zsbhb.setFpsj(null);
            dao.update(zsbhb);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            log.error(e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        message = "ȡ����η�����ɣ���Ҫȡ����֤����(" + zsbh + ")��" + lxmc + "�������·����ʹ�ã�";
        return message;
    }

    public String editNumber(ZsbhsourceVO zsbhVO) {
    	EntityManager em= EntityManagerHelper.getEntityManager();
        String message = "�����ѳɹ��޸ģ�";
        String qsbh = zsbhVO.getQsbh();
        String jzbh = zsbhVO.getJzbh();
        String zsType = zsbhVO.getZstype();
        String outBzjg = zsbhVO.getOutbzjg();
        String inBzjg = zsbhVO.getInbzjg();
        List<TZsbhb> zsbhs=new ArrayList();
        int zssl = CodePart.getZssl(qsbh, jzbh);
        try {
        	 zsbhs =em.createQuery("from TZsbhb zs where zs.id.zsbh>='" + qsbh + "'  and zs.id.zsbh<='" + jzbh + "' and zs.ssbzjg='" + outBzjg + "' and zs.id.zslx='" + zsType + "'").getResultList();
           // zsbhs = dao.find("from TZsbhb zs where zs.id.zsbh>='" + qsbh + "'  and zs.id.zsbh<='" + jzbh + "' and zs.ssbzjg='" + outBzjg + "' and zs.id.zslx='" + zsType + "'");
            if (zsbhs==null||zsbhs.size() <= 0) {
                return "�޸�֤����ʧ�ܣ�ԭ�򣺴˺����֤�鲻���ڽ����֤������";
            }
            if (zsbhs.size() < zssl) {
                return "�޸�֤����ʧ�ܣ�ԭ�򣺽����֤����û���㹻��֤���Ž����";
            }
//            zsbhs = dao.find("from TZsbhb zs where zs.id.zsbh>='" + qsbh + "'  and zs.id.zsbh<='" + jzbh + "' and zs.ssbzjg='" + outBzjg + "' and flag='0' and zs.id.zslx='" + zsType + "'");
            zsbhs =em.createQuery("from TZsbhb zs where zs.id.zsbh>='" + qsbh + "'  and zs.id.zsbh<='" + jzbh + "' and zs.ssbzjg='" + outBzjg + "' and flag='0' and zs.id.zslx='" + zsType + "'").getResultList();
            if (zsbhs.size() != zssl) {
                return "�޸�֤����ʧ�ܣ�ԭ�򣺸ñ���ѱ�ռ�ã�";
            }
              EntityManagerHelper.beginTransaction();
           String sql = "update t_zsbhb set ssbzjg='" + inBzjg + "' where zsbh>='" + qsbh + "'  and zsbh<='" + jzbh + "' and ssbzjg='" + outBzjg + "' and flag='0' and zslx='" + zsType + "'";
 
           em.createNativeQuery(sql).executeUpdate();

           EntityManagerHelper.commit();

        } catch (Exception e) {
          //  EntityManagerHelper.rollback();
            log.error(e);
        } finally {
        	em.clear();
          //  EntityManagerHelper.closeEntityManager();
        }
        return message + "���" + qsbh + "��" + jzbh + "��֤���ѴӰ�֤����" + outBzjg + "ת��" + inBzjg + "������Ϊ" + String.valueOf(zssl) + "��";
    }

    private void exe_zssl(int zssl, String xzqh, String type) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try{
            List<TZssl> zssls = em.createQuery("select model from TZssl model where model.xzqh=:xzqh and model.type=:ztype")
                    .setParameter("xzqh", xzqh).setParameter("ztype", type).getResultList();
            if (zssls == null || zssls.isEmpty()) {
                TZssl tZssl = new TZssl();
                tZssl.setKcxx(1);
                tZssl.setKcsx(9999);
                tZssl.setKcsl(zssl);
                tZssl.setXzqh(xzqh);
                tZssl.setType(type);
                em.persist(tZssl);
                //em.flush();
                //em.clear();
                
            } else {
                TZssl tZssl = zssls.get(0);
                tZssl.setKcsl(tZssl.getKcsl() + zssl);
                em.merge(tZssl);
               // em.flush();
                //em.clear();
            }
        }catch (Exception e){}finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}
