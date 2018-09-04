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
            ��ҵ���ơ�
            ��ϵ�绰��
            ��Ӫ��Χ��
            ��Ӫ������
            ע���ʱ���
            ���������ˡ�
            ���֤�ţ��������֤�ţ���
            ��ҵ������ְ������������׼�������ء�֤�պ��루ע��ţ���Ӫҵ����
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