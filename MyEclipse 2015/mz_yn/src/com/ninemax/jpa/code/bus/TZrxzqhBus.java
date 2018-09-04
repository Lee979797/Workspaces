package com.ninemax.jpa.code.bus;


import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.TZrxzqhDAO;
import com.ninemax.jpa.code.model.TZrxzqh;
import com.ninemax.jpa.system.model.User;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: 下午6:21
 */
public class TZrxzqhBus {

    private TZrxzqhDAO dao = new TZrxzqhDAO();

    public List<TZrxzqh> findAll() {
        return dao.findAll();
    }

    public Map<String, String> getMap() {
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        if (obj1 == null)
                            return -1;
                        return obj1.compareTo(obj2);
                    }
                }
        );
        List<TZrxzqh> list = dao.findAll();
        if (list != null && list.size() > 0) {

            for (TZrxzqh zrxzqh : list) {
                if (zrxzqh != null) {
                    map.put(zrxzqh.getXzqh(), zrxzqh.getMc());
                }
            }
        }
        return map;
    }

    public Map<String, TZrxzqh> getTZrxzqhMap() {
        Map<String, TZrxzqh> map = null;
        List<TZrxzqh> list = dao.findAll();
        if (list != null && list.size() > 0) {
            map = new TreeMap<String, TZrxzqh>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {
                            if (obj1 == null)
                                return -1;
                            return obj1.compareTo(obj2);
                        }
                    }
            );
            for (TZrxzqh zrxzqh : list) {
                if (zrxzqh != null) {
                    map.put(zrxzqh.getXzqh(), zrxzqh);
                }
            }
        }
        return map;
    }

    public List<TZrxzqh> getListPage(String userInput, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(userInput, pageSize, pageNo, pageComponent);
    }

    private Boolean isMain(String bzjgdm) {
        TZrxzqh zrxzqh = dao.find(TZrxzqh.class, bzjgdm.trim());
        return zrxzqh.getBzjgflag() == null ? true : zrxzqh.getBzjgflag();
    }

    public List<String> getXzqhs(User user) {
        if (user.getUserName().contains("admin")) {
            return new ArrayList<String>();
        }
        String bzjgdm = user.getBzjgdm();
        List<String> bzjgdms = new ArrayList<String>();
        if (isMain(bzjgdm)) {
            List<TZrxzqh> xzqhs = dao.findByProperty("csxzqh", bzjgdm.trim());
            for (TZrxzqh zrxzqh : xzqhs) {
                bzjgdms.add(zrxzqh.getXzqh().trim());
            }
        }
        bzjgdms.add(bzjgdm.trim());
        return bzjgdms;
    }

    public String sql(String name, User user) {
        if (user.getUserName().contains("admin")) {
            return " 1=1 ";
        }
        String sql = "";
        String bzjgdm = user.getBzjgdm();
        List<String> xzqhs = getXzqhs(user);
        if (isMain(bzjgdm) || xzqhs == null || xzqhs.isEmpty() || xzqhs.size() <= 1) {
            sql = " " + name + "='" + bzjgdm + "' ";
        } else {
            sql = " " + name + " in ('";
            for (String jgdm : xzqhs) {
                sql += jgdm + "','";
            }
            sql += bzjgdm + "'";
            sql += " ) ";
        }
        return sql;
    }

    public String checkIsInner(String jgdm) {
        List<TZrxzqh> xzqhs = dao.findByProperty("xzqh", jgdm);
        if (xzqhs == null || xzqhs.isEmpty()) {
            return "false:只能在省（或计划单列市）内迁址!";
        }
        return "true";
    }

    /**
     * 根据dm查询实体
     *
     * @param dm
     * @return
     */
  /*  public TZrxzqh findByDm(String dm) {
        return dao.findById(dm);
    }*/

    public Boolean isMcUsedById(String mc, String xzqh) {
        List<TZrxzqh> list = dao.findByProperty("mc", mc);
        return !(list == null || list.isEmpty() || (list.size() == 1 && xzqh.equals(list.get(0).getXzqh())));
    }

    public static void main(String[] args) {
        // System.out.println(new TZrxzqhBus().findByDm("530102").getMc());
    }
}
