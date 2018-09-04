package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.model.TSmrw;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-9
 * Time: обнГ5:34
 * To change this template use File | Settings | File Templates.
 */
public class TSmrwBus {

    private EntityManager em;

    public TSmrwBus(EntityManager em) {
        this.em = em;
    }

    public List<TSmrw> findTasks(String sql) {
        return em.createQuery(sql).getResultList();
    }

    public TSmrw findById(Integer id) {
        return em.find(TSmrw.class, id);
    }
}
