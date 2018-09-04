package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TSmTaskDAO;
import com.ninemax.jpa.code.model.TSmrw;
import com.ninemax.jpa.system.model.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * User: yzhhui
 * Date: 12-8-9
 * Time: ÏÂÎç5:34
 */
public class TSmTaskBus {

    private EntityManager em;

    public TSmTaskBus(EntityManager em) {
        this.em = em;
    }

    public List<TSmrw> findTasks(String sql) {
        return em.createQuery(sql).getResultList();
    }

    public Boolean hasTasks(User user) {
        if (user.getNeedScan() == null || user.getNeedScan()) {
            List<TSmrw> list = new TSmTaskDAO().findByDate(user);
            if ((list != null && !list.isEmpty()) && !(user.getUserName()!=null && user.getUserName().contains("admin"))) {
                return true;
            }
        }
        return false;
    }
    public Boolean hasEditTasks(User user) {
        if (user.getNeedScan() == null || user.getNeedScan()) {
            List<TSmrw> list = new TSmTaskDAO().findByDate(user);
            if ((list != null && !list.isEmpty()) && !(user.getUserName()!=null && user.getUserName().contains("admin"))) {
                return true;
            }
        }
        return false;
    }
    public TSmrw findById(Integer id) {
        return em.find(TSmrw.class, id);
    }
}
