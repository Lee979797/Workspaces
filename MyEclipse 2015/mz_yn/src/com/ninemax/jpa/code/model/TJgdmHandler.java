package com.ninemax.jpa.code.model;

import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.util.DateUtil;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class TJgdmHandler extends DefaultHandler {

    private TJgdm jgdm = null;
    private String tag;
    private List<TJgdm> list = null;


    public List<TJgdm> getList() {
        return list;
    }

    public void setList(List<TJgdm> list) {
        this.list = list;
    }


    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String data = new String(ch, start, length);
        if (null != tag) {
            /*
            企业名称、
            联系电话、
            经营范围、
            经营场所、
            注册资本、
            法定代表人、
            身份证号（法人身份证号）、
            从业人数（职工人数）、批准设立机关、证照号码（注册号）、营业期限
            * */
            if ("gs1".equalsIgnoreCase(tag)) {
                jgdm.setJgmc(data);
            } else if ("gs3".equalsIgnoreCase(tag)) {
                jgdm.setDhhm(data);
            } else if ("gs14".equalsIgnoreCase(tag)) {
                jgdm.setZjhm(data);
            } else if ("gs5".equalsIgnoreCase(tag)) {
                jgdm.setJyfw(data);
            } else if ("gs6".equalsIgnoreCase(tag)) {
                jgdm.setJyfw(jgdm.getJyfw() + data);
            } else if ("gs7".equalsIgnoreCase(tag)) {
                jgdm.setJgdz(data);
            } else if ("gs9".equalsIgnoreCase(tag)) {

                try {
                    jgdm.setZczj(Double.parseDouble(data));
                } catch (Exception e) {
                    jgdm.setZczj(null);
                }
            } else if ("gs13".equalsIgnoreCase(tag)) {
                jgdm.setFddbr(data);
            } else if ("gs30".equalsIgnoreCase(tag)) {
                try {
                    jgdm.setZgrs(Integer.valueOf(data));
                } catch (Exception e) {
                    jgdm.setZgrs(null);
                }

            } else if ("gs23".equalsIgnoreCase(tag)) {
                jgdm.setPzjgmc(data);
            } else if ("gs27".equalsIgnoreCase(tag)) {
                jgdm.setZch(data);
            } else if ("gs10".equalsIgnoreCase(tag)) {
                try {
                    jgdm.setGsfzrq(DateUtil.strToDate(data));
                } catch (Exception e) {
                    jgdm.setGsfzrq(null);
                }
            }
        }
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        if ("company".equalsIgnoreCase(name)) {
            list.add(jgdm);
            jgdm = null;
        }
        tag = null;
    }

    @Override
    public void startDocument() throws SAXException {
        list = new ArrayList<TJgdm>();
    }

    @Override
    public void startElement(String uri, String localName, String name,
                             Attributes attributes) throws SAXException {
        if ("company".equals(name)) {
            jgdm = new TJgdm();
        }
        tag = name;
    }


}