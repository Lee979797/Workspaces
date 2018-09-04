package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.GsDAO;
import com.ninemax.jpa.code.dao.TJgdmDAO;
import com.ninemax.jpa.code.dao.TQzjgdmDAO;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-21
 * Time: 下午2:06
 */
public class GsBus {

    private static Logger log = Logger.getLogger(GsBus.class);

    private GsDAO dao = new GsDAO();
    private TJgdmDAO jgdmDAO = new TJgdmDAO();
    private HandleBus handleBus = new HandleBus();

    public String isQiyeFindZch(String jgdm, String type) {
        if (InitSysParams.system.getIsGs()) {
            TJgdm tJgdm = null;
            if (type.equals("innerIn")) {
                List<TQzjgdm> tjList = new TQzjgdmDAO().findByProperty("jgdm", jgdm);
                if (tjList != null && tjList.size() > 0) {
                    tJgdm = new TJgdm();
                    BeanUtilsEx.copyProperties(tJgdm, tjList.get(0));
                }
            } else {
                tJgdm = jgdmDAO.findById(jgdm);
            }
            if (tJgdm != null) {
                if ("1,2,b,B".contains(tJgdm.getJglx().trim()) || (("9").equals(tJgdm.getJglx().trim()) && tJgdm.getPzjgmc().contains("工商"))) {
                    return tJgdm.getZch();
                } else {
                    return "";
                }
            } else {
                return "";
            }
        } else {
            return "";
        }

    }

    /**
     * 根据注册号查询列表
     *
     * @param zch
     * @return
     */
    public List<Qiye> findByZch(String zch) {
        return dao.findByZch(zch);

    }

    public List<Gtgsh> findGtByZch(String zch) {
        return dao.findGtByZch(zch);

    }

    public List<Qiye> listQiye(User user, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod) {
        List<Qiye> list = null;
        try {
            String cond = handleBus.sql(user);
            String jql = "from Qiye model where  model.cdqzt='正常' and " + cond;
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("vqymc".equals(key)) {
                        value = "%" + value + "%";
                        jql += " and " + key + " like ?";
                    } else {
                        jql += " and " + key + " = ?";
                    }
                    pms.add(value);
                }
            }
            String orderByContent = "";
            if (!clsStringTool.isEmpty(orderbyColum)
                    && !clsStringTool.isEmpty(orderbyMethod)) {
                orderByContent = orderbyColum + " " + orderbyMethod;
            } else {
                orderByContent = " model.fzrq desc";
            }
            jql += " order by " + orderByContent;
            list = dao.listQiyeList(jql, pageno, rowNumsView, pages, pms);
        } catch (Exception e) {
            log.error("TFzdmBus listFzTjgdm error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    public Qiye findById(String id) {
        return dao.findById(id);
    }

    public TJgdmSave findGsTojgdm(String cwybs, String gslx) {

        Qiye qiye = null;
        if (gslx.equals("qy")) {
            qiye = findById(cwybs);
        } else if (gslx.equals("gt")) {
            Gtgsh gt = dao.findGtById(cwybs);
            qiye = new Qiye();
            BeanUtilsEx.copyProperties(qiye, gt);
        }

        TJgdmSave jgdmSave = null;

        if (qiye != null) {
            jgdmSave = new TJgdmSave();
            jgdmSave.setJgmc(qiye.getVqymc() != null ? qiye.getVqymc().trim() : "");
            jgdmSave.setJgdz(qiye.getVzs() != null ? qiye.getVzs().trim() : "");
            jgdmSave.setJyfw(qiye.getVchrJyfw() != null ? qiye.getVchrJyfw().trim() : "");
            jgdmSave.setZcrq(qiye.getDclrq());
            jgdmSave.setGsfzrq(qiye.getDjyqxz());
            jgdmSave.setZczj(qiye.getNumZczb());
            jgdmSave.setZch(qiye.getCzch() != null ? qiye.getCzch().trim() : "");
            jgdmSave.setFddbr(qiye.getVchrXm() != null ? qiye.getVchrXm().trim() : "");

        }
        return jgdmSave;
    }

}
