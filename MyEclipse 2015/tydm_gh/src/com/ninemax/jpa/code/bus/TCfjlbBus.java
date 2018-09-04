package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TCfjlbDAO;
import com.ninemax.jpa.code.model.TCfjlb;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: 下午4:24
 */
public class TCfjlbBus {
    private static Logger log = Logger
            .getLogger(TCfjlbBus.class);
    private TCfjlbDAO dao = new TCfjlbDAO();

    public List<TCfjlb> findCfjl(String jgdm) {
        Map<String, Object> pros = new HashMap<String, Object>();
        pros.put("jgdm", jgdm);
        pros.put("cfbz", false);
        return dao.findByPropertys(pros);
    }
    public List<TCfjlb> findCfjlByzjhm(String zjhm) {
        Map<String, Object> pros = new HashMap<String, Object>();
        pros.put("zjhm", zjhm);
        pros.put("cfbz", false);
        return dao.findByPropertys(pros);
    }
    public boolean saveByJgdm(String jgdm) {

        try {
            List<TCfjlb> cfjlbs = this.findCfjl(jgdm);
            for (int i = 0; i < cfjlbs.size(); i++) {
                TCfjlb cfjlb = cfjlbs.get(i);
                cfjlb.setCfbz(true);
                dao.update(cfjlb);
            }
        } catch (Exception e) {
            log.error("erro", e);
            return false;
        }
        return true;
    }

    public String check(String jgdm) {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("jgdm", jgdm);
        List<TCfjlb> cfjlbList = this.findCfjl(jgdm);
        if ((cfjlbList != null) && (cfjlbList.size() > 0)) {
            return "false:机构代码(" + jgdm + ")需完成处罚后才能办理该业务！";
        } else {
            return "true";
        }
    }

    public Boolean isExit(String jgdm, Boolean isCf) {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("jgdm", jgdm);
        props.put("cfbz", isCf);
        List<TCfjlb> cfjlbList = this.findCfjl(jgdm);
        return (cfjlbList != null) && (cfjlbList.size() > 0);
    }

}
