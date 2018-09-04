package com.ninemax.jpa.code.bus;


import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.ScCenterDAO;
import com.ninemax.jpa.code.model.ScCenter;
import com.ninemax.jpa.global.InitSysParams;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: 下午6:21
 */
public class ScCenterBus {
    private Pattern scptn = Pattern.compile("^([1-9]+)0+$");
    private Pattern cptn = Pattern.compile("^([1-9]+0+[1-9]+)0+$");
    private ScCenterDAO dao = new ScCenterDAO();

    public List<ScCenter> findAll() {
        return dao.findAll();
    }

    public Set<String> cityFilters() {
        Set<String> citys = new HashSet<String>();
        String xzqh = InitSysParams.system.getXzqhdm();
        Matcher m = scptn.matcher(xzqh);
        if (m.find()) {
            xzqh = m.group(1);
            for (String key : InitSysParams.scCenterMap.keySet()) {
                if (key.startsWith(xzqh)) {
                    m = cptn.matcher(key);
                    if (m.find()) {
                        citys.add(m.group(1));
                    }
                }
            }
        }
        return citys;
    }

    public Map<String, String> getMap() {
        Map<String, String> hashMap = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        if (obj1 == null)
                            return -1;
                        return obj1.compareTo(obj2);
                    }
                }
        );
        List<ScCenter> list = dao.findAll();
        if (list != null && list.size() > 0) {

            for (ScCenter tNjjhy : list) {
                if (tNjjhy != null) {
                    hashMap.put(tNjjhy.getDm(), tNjjhy.getMc());
                }
            }
        }
        return hashMap;
    }

    public List<ScCenter> getListPage(String userInput, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(userInput, pageSize, pageNo, pageComponent);
    }

    /**
     * 根据dm查询实体
     *
     * @param dm
     * @return
     */
    public ScCenter findByDm(String dm) {
        System.out.println("dm = " + dm);
        ScCenter center = dao.findById(dm);
        if (center == null) {
            dm = dm.substring(0, 2) + "0000";
            System.out.println("dm = " + dm);
            center = dao.findById(dm);
        }
        return center;
    }
}
