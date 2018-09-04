package com.ninemax.jpa.system.bo;

import com.ninemax.jpa.code.model.TZrxzqh;
import com.ninemax.jpa.system.dao.BzjgdmDao;
import com.ninemax.jpa.system.model.Bzjgdm;
import com.ninemax.jpa.util.clsPageComponent;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BzjgdmBo {
    private BzjgdmDao bzjgdmDao = new BzjgdmDao();

    public List<Bzjgdm> findAll() {
        return bzjgdmDao.findAll();
    }

    public HashMap<String, Bzjgdm> getAllMapBean() {
        HashMap<String, Bzjgdm> map = new LinkedHashMap<String, Bzjgdm>();
        for (Bzjgdm bzjgdm : bzjgdmDao.findAll()) {
            map.put(bzjgdm.getDm(), bzjgdm);
        }
        return map;
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
//        HashMap<String, String> map = new LinkedHashMap<String, String>();
//        for (Bzjgdm bzjgdm : bzjgdmDao.findAll()) {
//            map.put(bzjgdm.getDm(), bzjgdm.getMc());
//        }
        List<Bzjgdm> list = bzjgdmDao.findAll();
        if (list != null && list.size() > 0) {

            for (Bzjgdm bzjgdm : list) {
                if (bzjgdm != null) {
                    map.put(bzjgdm.getDm(), bzjgdm.getMc());
                }
            }
        }
        return map;
    }
    
    public Map<String, Bzjgdm> getMapMc() {
    	Map<String, Bzjgdm> map = new TreeMap<String, Bzjgdm>(
    			new Comparator<String>() {
    				public int compare(String obj1, String obj2) {
    					if (obj1 == null)
    						return -1;
    					return obj1.compareTo(obj2);
    				}
    			}
    	);
//        HashMap<String, String> map = new LinkedHashMap<String, String>();
//        for (Bzjgdm bzjgdm : bzjgdmDao.findAll()) {
//            map.put(bzjgdm.getDm(), bzjgdm.getMc());
//        }
    	List<Bzjgdm> list = bzjgdmDao.findAll();
    	if (list != null && list.size() > 0) {
    		
    		for (Bzjgdm bzjgdm : list) {
    			if (bzjgdm != null) {
    				map.put(bzjgdm.getDm(), bzjgdm);
    			}
    		}
    	}
    	return map;
    }
    public Map<String, Bzjgdm> getMapMc1() {
    	Map<String, Bzjgdm> map = new TreeMap<String, Bzjgdm>(
    			new Comparator<String>() {
    				public int compare(String obj1, String obj2) {
    					if (obj1 == null)
    						return -1;
    					return obj1.compareTo(obj2);
    				}
    			}
    	);
//        HashMap<String, String> map = new LinkedHashMap<String, String>();
//        for (Bzjgdm bzjgdm : bzjgdmDao.findAll()) {
//            map.put(bzjgdm.getDm(), bzjgdm.getMc());
//        }
    	List<Bzjgdm> list = bzjgdmDao.findAll1();
    	if (list != null && list.size() > 0) {
    		
    		for (Bzjgdm bzjgdm : list) {
    			if (bzjgdm != null) {
    				map.put(bzjgdm.getDm(), bzjgdm);
    			}
    		}
    	}
    	return map;
    }
    public Map<String, String> getMap(String bzjg) {
        HashMap<String, String> map = new LinkedHashMap<String, String>();
        for (Bzjgdm bzjgdm : bzjgdmDao.findAll()) {
            if (bzjgdm.getDm().startsWith(bzjg))
                continue;
            map.put(bzjgdm.getDm(), bzjgdm.getMc());
        }
        return map;
    }
    public Map<String, String> getMap1() {
    	Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        if (obj1 == null)
                            return -1;
                        return obj1.compareTo(obj2);
                    }
                }
        );
//        HashMap<String, String> map = new LinkedHashMap<String, String>();
//        for (Bzjgdm bzjgdm : bzjgdmDao.findAll()) {
//            map.put(bzjgdm.getDm(), bzjgdm.getMc());
//        }
        List<Bzjgdm> list = bzjgdmDao.findAll();
        if (list != null && list.size() > 0) {

            for (Bzjgdm bzjgdm : list) {
                if (bzjgdm != null) {
                    map.put(bzjgdm.getDm(), bzjgdm.getSoMc());
                }
            }
        }
        return map;
    }

    public List<Bzjgdm> findPageList(String searchField, String searchValue, String orderbyColum, String orderbyMethod, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return bzjgdmDao.findPageList(searchField, searchValue, orderbyColum, orderbyMethod, pageSize, pageNo, pageComponent);
    }

    public boolean save(Bzjgdm bzjgdm) {
        return bzjgdmDao.save(bzjgdm);
    }

    public boolean update(Bzjgdm bzjgdm) {
        return bzjgdmDao.update(bzjgdm);
    }

    public boolean delete(Bzjgdm bzjgdm) {
        return bzjgdmDao.delete(bzjgdm);
    }

    public Bzjgdm findById(String dm) {
        return bzjgdmDao.findById(dm);
    }

    public List<Bzjgdm> findBySuperId(String id) {
        return bzjgdmDao.findBySuperId(id);
    }

    public List<Bzjgdm> findByProperty(String propertyName, final Object value) {
        return bzjgdmDao.findByProperty(propertyName, value);
    }


    public List<Bzjgdm> findJdbcBySuperId(String bzd) {
        return bzjgdmDao.findJdbcBySuperId(bzd);
    }

    /**
     * 查询办证点所属的所有办证机构
     *
     * @param bzcode
     * @return
     * @author zx
     * @date 2011.8.28
     */
    public List<Bzjgdm> findByBelongCode(String bzcode) {
        return bzjgdmDao.findByBelongCode(bzcode);
    }
}
