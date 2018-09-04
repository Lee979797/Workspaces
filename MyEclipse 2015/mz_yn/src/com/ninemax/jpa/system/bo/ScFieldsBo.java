package com.ninemax.jpa.system.bo;

import com.ninemax.jpa.system.dao.ScFieldsDAO;
import com.ninemax.jpa.system.model.ScFields;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ScFieldsBo {
    private ScFieldsDAO scFieldsDAO = new ScFieldsDAO();

    //filenames
    public List<ScFields> selectAll() {
        return scFieldsDAO.selectAll();
    }

    //dwr
    public String selectAl(String[] str, String[] str2) {

        return scFieldsDAO.selectAl(str, str2);
    }

    public List<ScFields> getAllEnterprise() {
        return scFieldsDAO.selectByBelongTo("db_enterpriseinfo");
    }

    public List<ScFields> getAllProduct() {
        return scFieldsDAO.selectByBelongTo("db_productinfo");
    }

    public Map<String, String> getRrequiredItems() {
//        List<ScFields> fields = scFieldsDAO.findByBelongTable("t_jgdm", true);
        Map<String, String> items = new LinkedHashMap<String, String>();
       /* for (int i = 0; i < fields.size(); i++) {
            ScFields field = fields.get(i);
            items.put(field.getFieldCode(), field.getFieldName());
        }*/
        return items;
    }

}
