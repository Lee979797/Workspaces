package test;

import java.util.HashMap;
import java.util.Map;

public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String resultCode = "{flag:'1',code:'',info:'{orgName:中科通图,regNum:601092874,orgAddress:北京市海淀区学清路,code:12029761x },{orgName:中科通图,regNum:601092882,orgAddress:北京市海淀区学清路,code:10029841x }'}";
		//{flag:'0',code:'10009882x',info:''}
		resultCode = resultCode.substring(1, resultCode.length()-1);
		//"flag:'0',code:'10009882x',info:''"
		resultCode = resultCode.replaceAll("'", "");
		//"flag:0,code:10009882x,info:"
		String[] rs = resultCode.split(",",3);
		//"flag:0","code:10009882x","info:"
		
		Map<String,String> m = new HashMap<String,String>();
		for(int i = 0; i < rs.length;i++){
			System.out.println(rs[i]);
			String[] strRs = rs[i].split(":",2);
			if(strRs.length==2){
				m.put(strRs[0],strRs[1]);
				System.out.println(strRs[0]+" "+strRs[1]);
			}else{
				m.put(strRs[0], "");
				System.out.println(strRs[0]);
			}
		}
		System.out.println("["+m.get("flag")+"]");
		System.out.println("["+m.get("code")+"]");
		System.out.println("["+m.get("info")+"]");
		System.out.println("======================");
		String str = m.get("info");
		String[] strInfo = str.split("},");
		for(int i = 0; i < strInfo.length;i++){
			String s = strInfo[i].replace('{', ' ').replace('}', ' ').trim();
			System.out.println(s);
		}
	}

}
