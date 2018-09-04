package com.ninemax.jpa.code.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.global.CheckEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.CommonPropertiesUtil;


public class HqGssj_hzServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m = request.getParameter("method");
		if(m.equals("hqGssj")){
			hqGssj(request,response);
		}
		if(m.equals("hqJksj")){
			hqJksj(request,response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m = request.getParameter("method");
		if(m.equals("hqGssj")){
			hqGssj(request,response);
		}
		if(m.equals("hqJksj")){
			hqJksj(request,response);
		}
	}
	
	public void hqGssj(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, RemoteException {
		String jgmc = request.getParameter("jgmc");
		String zch = request.getParameter("zch");
		String sql="select QYMC,GSZCH,FDDBR,FRSFZH,ZCZB,ZCDZ,JYFW,DJJG,CLRQ,HZRQ,DHHM,JYQX1,JYQX2,UPDATETIME from GS_JCXX_WORK where 1=1 ";
		if (jgmc != null && !jgmc.equals("")) {
			jgmc= URLDecoder.decode(jgmc, "UTF-8");
			sql+=" and QYMC like '%"+jgmc+"%'";
        }
		if (zch != null && !zch.equals("")) {
			zch = URLDecoder.decode(zch, "UTF-8");
			sql+=" and GSZCH = '"+zch+"'";
        }
		System.out.println(jgmc);
		System.out.println(zch);
		EntityManager em = CheckEntityManagerHelper.getEntityManager();
		List<Object[]> list = em.createNativeQuery(sql).getResultList();
		String data="2";
		if(list!=null&&list.size()>0){
			Object[] os = list.get(0);
			String jgdz2="";
			if(os[5]!=null){
			if(!os[5].toString().startsWith("山东省")){
				jgdz2="山东省"+os[5].toString();
			}else{
				jgdz2=os[5].toString();
			}
			}
			data=os[0].toString()
			+"+-"+(os[1]==null?"":os[1].toString())
			+"+-"+(os[2]==null?"":os[2].toString())
			+"+-"+(os[3]==null?"":os[3].toString())
			+"+-"+(os[4]==null?"":os[4].toString().substring(0,os[4].toString().indexOf(".")))
			+"+-"+(jgdz2)
			+"+-"+(os[6]==null?"":os[6].toString().trim())
			+"+-"+(os[7]==null?"":os[7].toString())
			+"+-"+(os[8]==null?"":os[8].toString().substring(0, 10))
			+"+-"+(os[9]==null?"":os[9].toString())
			+"+-"+(os[10]==null?"":os[10].toString())
			+"+-"+(os[11]==null?"":os[11].toString())
			+"+-"+""//(os[12]==null?"":os[12].toString().substring(0, 10))
			+"+-"+(os[13]==null?"":os[13].toString())
		;
		}
		sendResponse(response, data);
		/*
		if(companyInfo!=null&&companyInfo.getJgmc()!=null){
		    String data=companyInfo.getJgdm()
		    +"+-"+companyInfo.getJgmc()
		    +"+-"+companyInfo.getFddbr()
		    +"+-"+companyInfo.getZjhm()
		    +"+-"+companyInfo.getJgdz()
		    +"+-"+companyInfo.getYzbm()
		    +"+-"+companyInfo.getJyfw()
		    +"+-"+companyInfo.getDhhm()
		    +"+-"+companyInfo.getJjhy()
		    +"+-"+companyInfo.getJglx()
		    +"+-"+companyInfo.getZczj()
		    +"+-"+companyInfo.getHbzl()
		    +"+-"+companyInfo.getZcrq().replace("/", "-")
		    +"+-"+companyInfo.getFzrq()
		    +"+-"+companyInfo.getZch()
		    +"+-"+companyInfo.getID();
		    
    	sendResponse(response, data);
		}else{
			sendResponse(response, "2");
		}
		*/
	}
	public void hqJksj(HttpServletRequest request, HttpServletResponse response){
		EntityManager em = EntityManagerHelper.getEntityManager();
    	EntityTransaction tx = em.getTransaction();
    	String type="0";
    	try{
    		tx.begin();
    	String url=CommonPropertiesUtil.getValue("common.properties", "gsurl");
    		//String url = "http://123.234.131.164:65432/dsp/services/QydjJbxxLcDomain.QydjJbxxLcDomain.IQydjJbxxLcDomainHttpEndpoint/";
    	RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();
        serviceClient.getOptions().setProperty(HTTPConstants.CHUNKED, false);
        EndpointReference targetEPR = new EndpointReference(url);
        options.setTo(targetEPR);
        QName opAddEntry;
        //1:简单类型：字符串传输
        /////////////////////////////////////////
        opAddEntry = new QName("http://loushang.ws", "getQydjJbxx2ZJ"); 
        String str = (String) serviceClient.invokeBlocking(opAddEntry,new Object[]{""},  new Class[]{String.class})[0];
    		//String str="[{\"SUPENTNAME\":\"121212\",\"FORREGCAPCUR\":null,\"EMPNUM\":15,\"CONOFCONTRPRO\":null,\"APPRNO\":null,\"ESTDATE\":{\"date\":28,\"day\":5,\"hours\":0,\"minutes\":0,\"month\":10,\"seconds\":0,\"time\":1417104000000,\"timezoneOffset\":-480,\"year\":114},\"REMARK\":\"备注\",\"ENTNAMESPELL\":null,\"OPFYEARS\":null,\"FUNDAMRMB\":null,\"SUPREGNO\":\"123456789\",\"REGNO\":\"370211100000047\",\"OPEACTTYPE\":null,\"OPLOC\":null,\"PROTYPE\":null,\"FORRECCAPCUR\":null,\"AGRSIGN\":null,\"OPETYPE\":\"FGS\",\"OLDREGNO\":null,\"CURCONAM\":null,\"BOARDCHA\":null,\"ROE\":null,\"FORREGCAPINVRAT\":null,\"ESTREGCAPUSD\":null,\"FAX\":null,\"CONGRO\":null,\"FORENTNAME\":null,\"SUPEMAIL\":null,\"LIMPARNUM\":null,\"CANDATE\":null,\"REGCAPUSD\":null,\"INDATE\":null,\"OPTO\":{\"date\":28,\"day\":5,\"hours\":0,\"minutes\":0,\"month\":10,\"seconds\":0,\"time\":1417104000000,\"timezoneOffset\":-480,\"year\":114},\"ENTSTATUS\":1,\"ENTCAT\":\"1\",\"EXENUM\":null,\"DOMEREGCAP\":null,\"CONUM\":\"1\",\"UNEMPNUM\":1,\"INVNUM\":null,\"FORREGECAP\":null,\"PRIPID\":\"370211000012014112505638\",\"FORREGCAP\":null,\"IFPROVINCENAME\":null,\"CITYSIGN\":1,\"UNIVLEAVERNUM\":1,\"CONTINENT\":null,\"CHAMECDATE\":null,\"CERTINFO\":null,\"DOMERECCAPUSD\":null,\"TEL\":\"123456\",\"CREDLEVEL\":\"A\",\"S_EXT_TIMESTAMP\":{\"date\":28,\"day\":5,\"hours\":15,\"minutes\":44,\"month\":10,\"nanos\":0,\"seconds\":22,\"time\":1417160662000,\"timezoneOffset\":-480,\"year\":114},\"BORSIGN\":1,\"EMAIL\":null,\"IFFORHELP\":null,\"REGORG\":\"370211\",\"REGCAP\":null,\"FUNDAMUSD\":null,\"COUNTRY\":null,\"SUPOPFROM\":null,\"PARFORM\":null,\"FORCAPENTSORT\":null,\"ADVSIGN\":1,\"PTBUSSCOPE\":null,\"SUPENTTYPE\":null,\"LOCALADM\":\"370211008\",\"FORBUSSCOPE\":null,\"CURRENCY\":null,\"ECOTECDEVZONE\":null,\"LEREP\":\"负责人\",\"PROVINCE\":\"370000\",\"FORCAPINDCODE\":null,\"EXAAUTH\":null,\"BALDELPER\":null,\"PARNUM\":null,\"ENTTYPE\":\"2110\",\"OUTDATE\":null,\"REGCAPRMB\":null,\"RECCAPCUR\":null,\"DOMDISTRICT\":\"370200\",\"FORDOM\":null,\"WORCAP\":null,\"FORRECCAPUSD\":null,\"OPLOCPOSTALCODE\":null,\"ECOCHR\":null,\"LCTYPE\":\"020101\",\"REGCAPCUR\":null,\"OPTYPE\":null,\"RECCAPUSD\":null,\"ACCORG\":\"370211\",\"REVDATE\":null,\"ARCHNO\":\"3702111900047\",\"DOMEREGCAPUSD\":null,\"BUSSCOPE\":\"测试（依法须经批准的项目，经相关部门批准后方可开展经营活动）\",\"ABUITEMCO\":null,\"DOM\":\"山东省青岛市黄岛区121212\",\"APPRDATE\":{\"date\":28,\"day\":5,\"hours\":0,\"minutes\":0,\"month\":10,\"seconds\":0,\"time\":1417104000000,\"timezoneOffset\":-480,\"year\":114},\"ENTNAME\":\"CC_测试\",\"OPSCOTYPE\":null,\"SCONFORM\":null,\"DOMEREGCAPCUR\":null,\"CITY\":\"370200\",\"SUPREGNORG\":null,\"HYPOTAXIS\":null,\"INDUSTRYCO\":\"0111\",\"SUPOPTO\":null,\"FUNDAM\":null,\"ORGCODE\":null,\"SANDOCNO\":null,\"INSFORM\":null,\"CONGROUSD\":null,\"RECCAPRMB\":null,\"CONGROCUR\":null,\"FORREGCAPUSD\":null,\"STREET\":\"12\",\"BUSADDSCOPE\":\"0\",\"WEBSITE\":null,\"ACCOUNTFORM\":null,\"COUNTY\":\"370211\",\"POSTALCODE\":\"123456\",\"FORRECCAPCONPROP\":null,\"TAXREGISTER\":null,\"DOORPLATE\":\"12\",\"ESTFORREGCAPUSD\":null,\"DOMERECCAPCANPROP\":null,\"MARSIGN\":null,\"STOCKDEALTYPE\":null,\"CBUITEM\":null,\"DOMPRORIGHT\":null,\"RECCAP\":null,\"STOCKNUM\":null,\"DOMERECCAP\":null,\"BUSFORM\":null,\"OPLOCDISTRICT\":null,\"INDUSTRYPHY\":\"A\",\"HIGHINDUSTRY\":\"0100\",\"OPLOCPRORIGHT\":null,\"DOMEREGCAPINVRAT\":null,\"SANDATE\":null,\"FORRECCAP\":null,\"DOMERECCAPCUR\":null,\"OPSTATE\":null,\"LOCALORG\":\"370211\",\"SAFELEVEL\":null,\"ROAD\":\"12\",\"OPFROM\":{\"date\":28,\"day\":5,\"hours\":0,\"minutes\":0,\"month\":10,\"seconds\":0,\"time\":1417104000000,\"timezoneOffset\":-480,\"year\":114},\"OPENO\":\"5fa50149e58b6db90013\",\"ITEMOFOPORCPRO\":null}]";
        JSONArray jsonArr = JSONArray.fromObject(str);  
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
        Iterator<JSONObject> it = jsonArr.iterator();  
        while(it.hasNext()){  
            JSONObject json2 = it.next();  
            JSONObject json = JSONObject.fromObject(json2.toString()); 
            TJgdmSave save=new TJgdmSave();
            save.setBzjgdm("370211");
            save.setJgmc(getGsString(json.get("ENTNAME")));
            save.setZch(getGsString(json.get("REGNO")));
            save.setYzbm(getGsString(json.get("POSTALCODE")));
            save.setDhhm(getGsString(json.get("TEL")));
            save.setEmail(getGsString(json.get("EMAIL")));
            save.setUrl(getGsString(json.get("WEBSITE")));
            save.setJyfw(getGsString(json.get("BUSSCOPE")));
            save.setPzwh(getGsString(json.get("SANDOCNO")));
            save.setFddbr(getGsString(json.get("LEREP")));
            save.setZgrs(json.get("EMPNUM").toString().equals("null")?null:(Integer)json.get("EMPNUM"));
            save.setZczj(json.get("REGCAPRMB").toString().equals("null")?null:(Double)json.get("REGCAPRMB"));
            save.setZcrq(getGsDate(json.get("ESTDATE")));
            save.setGsfzrq(getGsDate(json.get("OPFYEARS")));
            save.setBak3("1");
            save.setBak4("A");
            save.setDjblx("0");
            em.persist(save);
        }
            tx.commit();
            type="1";
    	
    	}catch (Exception e) {
			// TODO: handle exception
    		if(tx!=null){
    			tx.rollback();
    		}
		}finally{
			EntityManagerHelper.closeEntityManager();
		}
		sendResponse(response, type);
	}
	 private String getGsString(Object value){
	    	return value.toString().equals("null")?null:value.toString();
	    }
	   private Date getGsDate(Object value){
		   if(value.toString().equals("null")){
			   return null;
		   }
		   JSONObject json=(JSONObject)value;
	       Date date=new Date();
	       date.setTime((Long)json.get("time"));
	       return date;
	   }

	public void sendResponse(HttpServletResponse response, String responseText) {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(responseText);
		} catch (Exception e) {
		}
	}

}
