package example;

import java.util.HashMap;
import java.util.Map;



public class TextCode4 {
	
	
	/**
	 * 根据现有代码获取下一个
	 * @param codeJgdm  现有代码
	 * @return 返回下一个代码
	 */
	public String codeNext(String codeJgdm){
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
	 public static void main(String[] argv) {
		 TextCode4  t=new TextCode4();
		// t.codeNext("MYYYYNNNN");
		 
		 
		 /**
		  * 生成代码池
		  */
		 String st="MJT30000";   //开始
		 String en="MJU19999";   //结束
		 
		 int sum=2;
		 
		 //开始代码
		 System.out.println("====:"+st);
		 while (!t.codeNext(st).equals(en)) {
			 System.out.println("====:"+t.codeNext(st));
			 sum+=1;
			 st=t.codeNext(st);
			
		}
		
		 //结束代码
		 System.out.println("====:"+en);
		 
		 //生成总量
		 System.out.println("+++:"+sum);
		 
		 System.out.println("51530103MJT465790Q".substring(1,2));
	 }

}
