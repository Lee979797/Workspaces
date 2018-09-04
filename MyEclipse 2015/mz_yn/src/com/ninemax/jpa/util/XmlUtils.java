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
 *         JDOM 生成与解析XML文档
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
                "<ywtype>公司新增</ywtype>" +
                "<receivedate>2013-11-26 17:38:43</receivedate>" +
                "<gs1>企业名称</gs1>" +
                "<gs2>经办人姓名</gs2>" +
                "<gs3> 联系电话</gs3>" +
                "<gs4>身份证</gs4>" +
                "<gs5>一般经营范围</gs5>" +
                "<gs6>许可经营范围</gs6>" +
                "<gs7>经营场所</gs7>" +
                "<gs8>1</gs8>" +
                "<gs9>注册资本</gs9>" +
                "<gs10></gs10>" +
                "<gs11></gs11>" +
                "<gs12>实收资本</gs12>" +
                "<gs13>法定代表人</gs13>" +
                "<gs14>身份证号</gs14>" +
                "<gs15>职务</gs15>" +
                "<gs16>联系电话</gs16>" +
                "<gs17>任免机构</gs17>" +
                "<gs18>7</gs18>" +
                "<gs19>88</gs19>" +
                "<gs20>名称预先核准通知书文号</gs20>" +
                "<gs21>申请副本数量 </gs21>" +
                "<gs22>组织机构代码</gs22>" +
                "<gs23>批准设立机关</gs23>" +
                "<gs24>批准设立证明或文件号</gs24>" +
                "<gs25>企业电话</gs25>" +
                "<gs26>证照名称</gs26>" +
                "<gs27>证照号码</gs27>" +
                "<gs28>2013-11-27</gs28>" +
                "<gs29>10</gs29>" +
                "<gs30>从业人数</gs30>" +
                "<gs31>其中外籍人数</gs31>" +
                "<gs32>12</gs32>" +
                "<gs33>16</gs33>" +
                "<gs34>财务负责人姓名</gs34>" +
                "<gs35>身份证号</gs35>" +
                "<gs36>联系方式</gs36>" +
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
                "<h1>股东（发起人）姓名1</h1>" +
                "<h2>证件地址1</h2>" +
                "<h3>证件名称及号码1</h3>" +
                "<h4>认缴出资额（万元）1</h4>" +
                "<h5>7</h5>" +
                "<h6>持股比例（%）1</h6>" +
                "<h7>实缴出资额（万元）1</h7>" +
                "<h8>2013-11-12</h8>" +
                "<h9>0</h9>" +
                "<h10>2013-11-27</h10>" +
                "<h11>备注1</h11>" +
                "</holder>" +
                "<holder id ='166'>" +
                "<h1>股东（发起人）姓名2</h1>" +
                "<h2>证件地址2</h2>" +
                "<h3>证件名称及号码2</h3>" +
                "<h4>认缴出资额（万元）2</h4>" +
                "<h5>7</h5>" +
                "<h6>持股比例（%）2</h6>" +
                "<h7>实缴出资额（万元）2</h7>" +
                "<h8>2013-11-27</h8>" +
                "<h9>0</h9>" +
                "<h10>2013-11-27</h10>" +
                "<h11>备注2</h11>" +
                "</holder>" +
                "</holders>" +
                "<managers>" +
                "<manager id ='166'>" +
                "<m1>董事姓名</m1>" +
                "<m2>董事</m2>" +
                "<m3>董事身份证号</m3>" +
                "</manager>" +
                "<manager id ='166'>" +
                "<m1>监事姓名</m1>" +
                "<m2>监事</m2>" +
                "<m3>监事身份证号</m3>" +
                "</manager>" +
                "<manager id ='166'>" +
                "<m1>经理姓名</m1>" +
                "<m2>经理</m2>" +
                "<m3>经理身份证号</m3>" +
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