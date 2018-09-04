package com.ninemax.jpa.util;

import java.util.HashMap;
import java.util.Map;

public class CodePart {
    public static String mdAddOne(String Qsmd, int distance) {
       if(distance==0)
           return Qsmd;
        int index = -1;
        for (int i = 0; i < Qsmd.length(); i++) {
            if (((byte) Qsmd.charAt(i) >= 48) && ((byte) Qsmd.charAt(i) <= 57))
                continue;
            index = i;
        }
        String Qsmd_qz;
        String Qsmd_hz;
        if (index > -1) {
            Qsmd_qz = Qsmd.substring(0, index + 1);
            Qsmd_hz = Qsmd.substring(index + 1, Qsmd.length());
        } else {
            Qsmd_qz = "";
            Qsmd_hz = Qsmd;
        }

        String Qsmd_hz_int = Integer.toString(Integer.parseInt(Qsmd_hz) + distance);
        return Qsmd_qz + charReplicate('0', Qsmd_hz.length() - Qsmd_hz_int.length()) + Qsmd_hz_int;
    }

    public static String charReplicate(char char_in, int i) {
        String Result = "";
        for (int j = 1; j <= i; j++) {
            Result = Result + char_in;
        }
        return Result;
    }

    public static int getMdsl(String Qsmd, String Jzmd) {
        int Result = 0;
        int index = 0;

        int qs=0;
        int jz=0;
        for (int i = 0; i < Qsmd.length(); i++) {
        	qs=qs+(byte) Qsmd.charAt(i)*(Integer.parseInt("1"+(8-i)));
        }
        
        for (int i = 0; i < Jzmd.length(); i++) {
        	jz=jz+(byte) Jzmd.charAt(i)*(Integer.parseInt("1"+(8-i)));
        }

        if(qs>jz){
        	return -1;
        }
        
        if(Qsmd.equals(Jzmd)){
        	return 1;
        }
        
        Jzmd=codeNext(Jzmd);
        while (!Qsmd.equals(Jzmd)) {
			 index=index+1;
			 Qsmd=codeNext(Qsmd);
		}
        
        System.out.println(qs);
        System.out.println(jz);
        return index;
    }
    
    public static int getMdsl_bak(String Qsmd, String Jzmd) {
    	int Result = 0;
    	int index = -1;
    	
    	for (int i = 0; i < Qsmd.length(); i++) {
    		if (((byte) Qsmd.charAt(i) >= 48) && ((byte) Qsmd.charAt(i) <= 57))
    			continue;
    		index = i;
    	}
    	int Jzmd_hz;
    	int Qsmd_hz;
    	
    	if (index > -1) {
    		Qsmd_hz = Integer.parseInt(Qsmd.substring(index + 1, Qsmd.length()));
    		Jzmd_hz = Integer.parseInt(Jzmd.substring(index + 1, Jzmd.length()));
    	} else {
    		Qsmd_hz = Integer.parseInt(Qsmd);
    		Jzmd_hz = Integer.parseInt(Jzmd);
    	}
    	Result = Jzmd_hz - Qsmd_hz + 1;
    	return Result;
    }

    public static int getZssl(String qsbh, String jzbh) {
        int Result = 0;
        int index = -1;
        for (int i = 0; i < qsbh.length(); i++)
            if (((byte) qsbh.charAt(i) < 48) || ((byte) qsbh.charAt(i) > 57))
                index = i;
        long qsbh_hz;
        long jzbh_hz;
        if (index > -1) {
            qsbh_hz = Long.parseLong(qsbh.substring(index + 1, qsbh.length()));
            jzbh_hz = Long.parseLong(jzbh.substring(index + 1, jzbh.length()));
        } else {
            qsbh_hz = Long.parseLong(qsbh);
            jzbh_hz = Long.parseLong(jzbh);
        }
        Result = (int) (jzbh_hz - qsbh_hz + 1L);
        return Result;
    }

    public static String bhAddOne(String Qsmd, int distance) {
        String Result = "";

        int index = -1;
        for (int i = 0; i < Qsmd.length(); i++) {
            if (((byte) Qsmd.charAt(i) >= 48) && ((byte) Qsmd.charAt(i) <= 57))
                continue;
            index = i;
        }
        String Qsmd_qz;
        String Qsmd_hz;
        if (index > -1) {
            Qsmd_qz = Qsmd.substring(0, index + 1);
            Qsmd_hz = Qsmd.substring(index + 1, Qsmd.length());
        } else {
            Qsmd_qz = "";
            Qsmd_hz = Qsmd;
        }

        String Qsmd_hz_int = Long.toString(Long.parseLong(Qsmd_hz) + distance);
        Result = Qsmd_qz + charReplicate('0', Qsmd_hz.length() - Qsmd_hz_int.length()) + Qsmd_hz_int;
        return Result;
    }
    
	/**
	 * 根据现有代码获取下一个
	 * @param codeJgdm  现有代码
	 * @return 返回下一个代码
	 */
	public static String codeNext(String codeJgdm){
		 String[] strKey = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
	                "A", "B", "C", "D", "E", "F", "G", "H",  "J", "K", "L",
	                "M", "N",  "P", "Q", "R", "T", "U", "W", "X",
	                "Y" };
	        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
	                10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
	                20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
	                30};
	        

	        String[] jgdms= new String[8];
	        Map<String, Integer> hashData = null;
	        hashData = new HashMap();
	        // 将机构代码中的各个字母,及其相应的值放到hashtable中
	        for (int j = 0; j < strKey.length; j++) {
	            hashData.put(strKey[j], values[j]);
	        }
	        //String code="MYYYYNNNN";
	        String code=codeJgdm;
	        
	        int i, sum = 0;
	        for (i = 0; i < 8; i++) {
	        	jgdms[i]= code.substring(i, i + 1);
	  
	        }
	        
	        for (i = 7; i < 8; i--) {
	        	if(i<3){
	        		if(!jgdms[i].equals("Y")){
	        			jgdms[i]=strKey[hashData.get(jgdms[i])+1];
	        			for(int k=1;k<8-i;k++){
	        				jgdms[i+k]="0";
	        			}
	        			// jgdms[i+1]="0";
	        			break ;
	        		}
	        		
	        	}else{
	        		if(!jgdms[i].equals("9")){
	        			jgdms[i]=strKey[hashData.get(jgdms[i])+1];
	        			for(int k=1;k<8-i;k++){
	        				jgdms[i+k]="0";
	        			}
	        			// jgdms[i+1]="0";
	        			break ;
	        		}
	        		
	        	}
	        }
	        
	        /**
	         * 组装机构代码
	         */
	        String code1="";
	        for(i=0;i<8;i++){
	        	code1+=jgdms[i];
	        }
	       
		//System.out.println("code1:"+code1);
		return code1;
		
	}
	
    
    public static void main(String[] args) {
    	System.out.println((byte)1);
    	System.out.println(getMdsl("M0002222","M000222Y"));
    	for(int i = 0;i<255;i++){
            char a = (char) i;
           // System.out.println(a+"........."+i);
        }
    	System.out.println((char)66);
    	System.out.println((byte)'A');
	}

}
