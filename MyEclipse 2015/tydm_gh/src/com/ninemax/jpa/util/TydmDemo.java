package com.ninemax.jpa.util;

import java.util.HashMap;
import java.util.Map;


/**
 * ͳһ���ô������
 * TydmDemo
 * @author LP
 * 2015-7-1 ����06:06:55
 * Version @1.0
 */
public class TydmDemo {
	
	   /**
     * getCheckCode()����,���� ���ܣ�����ͳһ���ô���ļ�����,�����ǰ17λ,ת��Ϊ18λ�����ô���
     *
     * @param sCode String ���������ǰ17λ
     * @return String ������������ô���
     */
    public static String getCheckCode(String sCode) {
        sCode = sCode.toUpperCase();
       int[] wi = {1,3,9,27,19,26,16,17,20,29,25,13,8,24,10,30,28};
        
        String[] strKey = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "A", "B", "C", "D", "E", "F", "G", "H",  "J", "K", "L",
                "M", "N",  "P", "Q", "R",  "T", "U",  "W",  "X","Y","0"
                };
        int i, sum = 0;

        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
                30,31};
        String strCheck = "";

        Map<String, Integer> hashData = null;
        hashData = new HashMap();
        // �����������еĸ�����ĸ,������Ӧ��ֵ�ŵ�hashtable��
        for (int j = 0; j < strKey.length; j++) {
            hashData.put(strKey[j], values[j]);
        }
        // ���ռ����㷨��������
        for (i = 0; i < 17; i++) {
            strCheck = sCode.substring(i, i + 1);
            sum = sum + wi[i] * hashData.get(strCheck);
        }
        System.out.println(sum);
        sum = 31 - sum % 31;

        System.out.println("sum:"+sum);
        
        strCheck= sCode+ strKey[sum];
        return strCheck;

    }

    
	public static void main(String[] args) {
    /*		17λ����	                                 �����㷨����
		91440300342940975	914403003429409755
		91440300699067670	914403006990676707
		91440300L83341734	91440300L83341734R
		91440300342940932	91440300342940932P
		91440300342940887	91440300342940887N
		91440300561517704	914403005615177045
		91440300L40363351	91440300L40363351Y
		91440300L83341427	91440300L833414271
		9144030008874058X	9144030008874058X0*/
		
		
		//CheckCodeTest test=new CheckCodeTest();
		//System.out.println(test.getCheckCode("9144030008874058X"));
		
	}

}
