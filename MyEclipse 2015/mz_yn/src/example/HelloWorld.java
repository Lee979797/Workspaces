package example;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by ninemax-199 on 2014/4/2.
 */
@WebService()
public class HelloWorld {
  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }
  public static void main(String[] argv) {
    /*Object implementor = new HelloWorld ();
    String address = "http://localhost:9000/HelloWorld";
    Endpoint.publish(address, implementor);*/
	  
	 /* String a="1 1";
	  a.matches("^[\\u4e00-\\u9fa5\\w\\-^\\S]*$");
	  System.out.println(a.matches("^\\S[\\u4e00-\\u9fa5\\w\\-^]*$"));*/
	  
	/*  String str="123assume345contribute";
      //System.out.println(str.replaceAll("\\d+"));
      
      String regEx="[^0-9]";   
      Pattern p = Pattern.compile(regEx);   
      Matcher m = p.matcher(str);   
      System.out.println(m.replaceAll("").trim() );*/
	  
	  String gsUrl="注册号：210242000018300|名称：大连铭盛贸易有限公司|住所：辽宁省大连保税区泰华大厦B座503#|类型：  有限责任公司(自然人独资)|法定代表人：庄辉|公示网址：http://gsxt.lngs.gov.cn";
		;
		Map<String,String> mapJson=new HashMap<String,String>();
		String [] urls=gsUrl.split("\\|");
		
		for(String u:urls){
			System.out.println(u);
			String [] url=u.split("：");
			mapJson.put(url[0], url[1]);
		}
	  
	  
	  
  }
}
