package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.model.TZsbhb;
import com.ninemax.jpa.code.model.TZsbhbId;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.BeanUtilsEx;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: ÏÂÎç6:28
 */

public class CertNumberBus {
    private static Logger log = Logger.getLogger(CertNumberBus.class);
//    public EntityManager em = EntityManagerHelper.getEntityManager();
//    public EntityTransaction tx = em.getTransaction();

    private String saveCertNumber(String zsbh, String zslx, String bzjgdm, String jgdm, String djh, String userName) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        TZsbhb zsbhb;
        try {
            List<TZsbhb> zsbhbList = em.createQuery("select model from TZsbhb model  where model.id.zsbh='" + zsbh
                    + "' and model.id.zslx='" + zslx + "' and model.flag='0' and model.ssbzjg='" + bzjgdm + "'").getResultList();

            if (zsbhbList == null || zsbhbList.isEmpty()) {
                em.createQuery("select model from TZsbhb model where model.id.zsbh='" + zsbh + "'");
                TZsbhbId id = new TZsbhbId();
                id.setZsbh(zsbh);
                id.setZslx(zslx);
                zsbhb = em.find(TZsbhb.class, id);
                JSONObject jsonObject = null;

                    jsonObject = JSONObject.fromObject(BeanUtilsEx.describe(zsbhb));

                return jsonObject.toString();
            } else {
                em.createQuery("update TZs set zsbh='" + zsbh + "' where djh='" + djh + "' and jgdm='" + jgdm + "'").executeUpdate();
                zsbhb = zsbhbList.get(0);
                zsbhb.setFlag("1");
                zsbhb.setDysj(new Date());
                zsbhb.setCzy(userName);
                em.merge(zsbhb);
                em.flush();
                zsbhb = em.find(TZsbhb.class, zsbhb.getId());
                em.clear();
            }
        } catch (IllegalAccessException e) {
            log.error(CertNumberBus.class,e);
        } catch (InvocationTargetException e) {
            log.error(CertNumberBus.class,e);
        } catch (NoSuchMethodException e) {
            log.error(CertNumberBus.class,e);
        }finally {
            EntityManagerHelper.closeEntityManager();
        }
        return "ok";
    }
}
