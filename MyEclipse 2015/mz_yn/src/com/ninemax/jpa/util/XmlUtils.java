package com.ninemax.jpa.util;


import com.ninemax.jpa.code.model.ResultHandler;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TJgdmHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @author hongliang.dinghl
 *         JDOM ���������XML�ĵ�
 */
public class XmlUtils {
    private static TJgdmHandler handler = new TJgdmHandler();
    private static ResultHandler rhandler = new ResultHandler();
    private static SAXParserFactory parserFactory = SAXParserFactory.newInstance();

    public static List<TJgdm> parseXML(String x) throws Exception {
        SAXParser parser = parserFactory.newSAXParser();
        parser.parse(new ByteArrayInputStream(x.getBytes()), handler);
        return handler.getList();
    }

    public static String parseXMLR(String x) throws Exception {
        SAXParser parser = parserFactory.newSAXParser();
        parser.parse(new ByteArrayInputStream(x.getBytes()), rhandler);
        return rhandler.getData();
    }

    public static void main(String[] args) throws Exception {
        String s = "<?xml version=\"1.0\" encoding=\"GBK\" ?>" +
                "<datas>" +
                "<result>1</result>" +
                "<companys>" +
                "<company id = '1015920' >" +
                "<numberstr>131126173059421</numberstr>" +
                "<ywtype>��˾����</ywtype>" +
                "<receivedate>2013-11-26 17:38:43</receivedate>" +
                "<gs1>��ҵ����</gs1>" +
                "<gs2>����������</gs2>" +
                "<gs3> ��ϵ�绰</gs3>" +
                "<gs4>���֤</gs4>" +
                "<gs5>һ�㾭Ӫ��Χ</gs5>" +
                "<gs6>��ɾ�Ӫ��Χ</gs6>" +
                "<gs7>��Ӫ����</gs7>" +
                "<gs8>1</gs8>" +
                "<gs9>ע���ʱ�</gs9>" +
                "<gs10></gs10>" +
                "<gs11></gs11>" +
                "<gs12>ʵ���ʱ�</gs12>" +
                "<gs13>����������</gs13>" +
                "<gs14>���֤��</gs14>" +
                "<gs15>ְ��</gs15>" +
                "<gs16>��ϵ�绰</gs16>" +
                "<gs17>�������</gs17>" +
                "<gs18>7</gs18>" +
                "<gs19>88</gs19>" +
                "<gs20>����Ԥ�Ⱥ�׼֪ͨ���ĺ�</gs20>" +
                "<gs21>���븱������ </gs21>" +
                "<gs22>��֯��������</gs22>" +
                "<gs23>��׼��������</gs23>" +
                "<gs24>��׼����֤�����ļ���</gs24>" +
                "<gs25>��ҵ�绰</gs25>" +
                "<gs26>֤������</gs26>" +
                "<gs27>֤�պ���</gs27>" +
                "<gs28>2013-11-27</gs28>" +
                "<gs29>10</gs29>" +
                "<gs30>��ҵ����</gs30>" +
                "<gs31>�����⼮����</gs31>" +
                "<gs32>12</gs32>" +
                "<gs33>16</gs33>" +
                "<gs34>������������</gs34>" +
                "<gs35>���֤��</gs35>" +
                "<gs36>��ϵ��ʽ</gs36>" +
                "<gs37>29</gs37>" +
                "<gs38>31</gs38>" +
                "<gs39>35</gs39>" +
                "<gs40>38</gs40>" +
                "<gs41>40,41,</gs41>" +
                "<gs42>43,</gs42>" +
                "<gs43></gs43>" +
                "<gs44>55,</gs44>" +
                "<gs45>56,</gs45>" +
                "<gs46>58,</gs46>" +
                "<gs47>60,</gs47>" +
                "<gs48>64,73,</gs48>" +
                "<gs49>74,</gs49>" +
                "<gs50></gs50>" +
                "<gs51>76,</gs51>" +
                "<gs52>79,80,</gs52>" +
                "<holders>" +
                "<holder id ='165'>" +
                "<h1>�ɶ��������ˣ�����1</h1>" +
                "<h2>֤����ַ1</h2>" +
                "<h3>֤�����Ƽ�����1</h3>" +
                "<h4>�Ͻɳ��ʶ��Ԫ��1</h4>" +
                "<h5>7</h5>" +
                "<h6>�ֹɱ�����%��1</h6>" +
                "<h7>ʵ�ɳ��ʶ��Ԫ��1</h7>" +
                "<h8>2013-11-12</h8>" +
                "<h9>0</h9>" +
                "<h10>2013-11-27</h10>" +
                "<h11>��ע1</h11>" +
                "</holder>" +
                "<holder id ='166'>" +
                "<h1>�ɶ��������ˣ�����2</h1>" +
                "<h2>֤����ַ2</h2>" +
                "<h3>֤�����Ƽ�����2</h3>" +
                "<h4>�Ͻɳ��ʶ��Ԫ��2</h4>" +
                "<h5>7</h5>" +
                "<h6>�ֹɱ�����%��2</h6>" +
                "<h7>ʵ�ɳ��ʶ��Ԫ��2</h7>" +
                "<h8>2013-11-27</h8>" +
                "<h9>0</h9>" +
                "<h10>2013-11-27</h10>" +
                "<h11>��ע2</h11>" +
                "</holder>" +
                "</holders>" +
                "<managers>" +
                "<manager id ='166'>" +
                "<m1>��������</m1>" +
                "<m2>����</m2>" +
                "<m3>�������֤��</m3>" +
                "</manager>" +
                "<manager id ='166'>" +
                "<m1>��������</m1>" +
                "<m2>����</m2>" +
                "<m3>�������֤��</m3>" +
                "</manager>" +
                "<manager id ='166'>" +
                "<m1>��������</m1>" +
                "<m2>����</m2>" +
                "<m3>�������֤��</m3>" +
                "</manager>" +
                "</managers>" +
                "</company>" +
                "</companys>" +
                "</datas>";
        List<TJgdm> jgdms = parseXML(s);
        System.out.println("jgdms = " + jgdms.size());
        for (TJgdm dm : jgdms) {
            System.out.println(dm.getJgmc());
        }
    }
}   