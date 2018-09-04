package com.ninemax.jpa.code.model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ResultHandler extends DefaultHandler {

    private String data = null;
    private String tag;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
            if ("result".equalsIgnoreCase(tag)) {
                this.data = data;
            }
        }
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String name,
                             Attributes attributes) throws SAXException {
        tag = name;
    }


}