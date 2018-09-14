package com.lhq.prj.bms.core;

import java.util.Hashtable;

public class CheckCode {
	/**
	 * getCheckCode()方法,方法 功能：生成机构代码的检验码,机构代码的前8位,转化为九位的机构代码
	 * 
	 * @param sCode
	 * String 机构代码的前8位
	 * @return String 带检验码的机构代码
	 */
	public static String getCheckCode(String sCode) {
		//////////////////////////////////////////////////
		String AOrgCode = sCode.toUpperCase();
		String[] C = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
				"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z" };
		int[] V = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,
	            19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
		int[] W = { 3, 7, 9, 10, 5, 8, 4, 2 };
		String[] A = {"1","2","3","4","5","6","7","8","9","X","0"};
		
		int Clength= C.length;
		int len = AOrgCode.length();
		
		String[] strArry = AOrgCode.split("");
		
		int s=0 ,j=0;
		for(int i= 0;i < 8;i++){
			int result = getIndex(C,strArry[i+1],Clength);
			j= V[result]*W[i];//alert("V*W: "+V[result]+"*"+W[i]);
			s+=j;
		}
		s = 10-(s%11);
		//alert("A[s] "+A[s]);//此为最后一位数值
		//return A[s];
		System.out.println("生成的代码：：："+AOrgCode+A[s]);
		/*if(len==9){
			if(strArry[9].equals(A[s])){
				return AOrgCode;
			}else{
				return null;
			}
			
		}else{*/
			return AOrgCode+A[s];
		//}
		
		
		
		
		
		
		//////////////////////////////////////////////////
		/*int[] wi = { 3, 7, 9, 10, 5, 8, 4, 2 };
		int i, sum = 0;
		String[] strKey = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
				"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z" };
		String[] strValue = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
				"30", "31", "32", "33", "34", "35" };
		String strCheck = "";
		Hashtable<String, String> hashData = new Hashtable<String, String>();
		// 将机构代码中的各个字母,及其相应的值放到hashtable中
		for (int j = 0; j < strKey.length; j++) {
			hashData.put(strKey[j], strValue[j]);
		}
		// 按照检验算法进行运算
		for (i = 0; i < 8; i++) {
			strCheck = sCode.substring(i, i + 1);
			strCheck = (String) hashData.get(strCheck);
			sum = sum + wi[i] * Integer.parseInt(strCheck);

		}

		sum = 11 - sum % 11;
		if (sum == 10) {
			strCheck = sCode + "X";
		} else if (sum == 11) {
			strCheck = sCode + Integer.toString(0);
		} else {
			strCheck = sCode + Integer.toString(sum);
		}
		// sCheck=sCode+Integer.toString(sum);
		hashData = null;
		System.out.println("返回值strCheck:"+strCheck);
		return strCheck;*/

	}
	public static int getIndex(String[] C,String str,int len){

		int result = 0;
		
			for(int tmp= 0;tmp< len;tmp++){
				if(C[tmp].equals(str)){
					result = tmp;
					break;
				}
			}
		
		
		return result;
	}

	/**
	 * isCheckCode()方法 功能：检验此机构代码是否满足检验要求
	 * 
	 * @param aStrCode
	 *            String 9位机构代码
	 * @return boolean
	 */

	public static boolean isCheckCode(String aStrCode) {
		String strOrigin = "";
		strOrigin = aStrCode.substring(0, 8);
		strOrigin = getCheckCode(strOrigin);
		if (strOrigin.equals(aStrCode)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * getIDCheckCode()方法,方法 功能：对于带18位的身份证号生成其带检验码的代码,检验前17位，生成检验码 ISO
	 * 7064:1983.MOD 11-2校验码
	 * 
	 * @param sCode
	 *            String 身份证的前17位
	 * @return String 带检验码的身份证号18位
	 */
	public static String getIDCheckCode(String sCode) {
		int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
		int i, sum = 0;
		String[] ai = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
		String strCheck = "";
		// 按照检验算法进行运算
		for (i = 0; i < 17; i++) {
			strCheck = sCode.substring(i, i + 1);
			sum = sum + wi[i] * Integer.parseInt(strCheck);
		}
		sum = sum % 11;
		System.out.println(sum);

		strCheck = sCode + ai[sum];
		// sCheck=sCode+Integer.toString(sum);
		return strCheck;
	}

	/**
	 * isIDCheckCode()方法 功能：检验身份证是否满足检验要求
	 * 
	 * @param aStrCode
	 *            String 18位机构代码
	 * @return boolean
	 */
	public static boolean isIDCheckCode(String aStrCode) {
		String strOrigin = "";
		strOrigin = aStrCode.substring(0, 17);
		strOrigin = getIDCheckCode(strOrigin);
		if (strOrigin.equals(aStrCode)) {
			return true;
		} else {
			return false;
		}
	}
	
	// 用于下载时程序自动拆码段自动加一
	public static String mdAddOne(String Qsmd, int distance) {
		String Result = "";
		String Qsmd_qz, Qsmd_hz, Qsmd_hz_int;
		int index = -1;
		for (int i = 0; i < Qsmd.length(); i++) {
			if (!((byte) Qsmd.charAt(i) >= 48 && (byte) Qsmd.charAt(i) <= 57)) {
				index = i;
			}
		}
		if (index > -1) {
			Qsmd_qz = Qsmd.substring(0, index + 1);
			Qsmd_hz = Qsmd.substring(index + 1, Qsmd.length());
		} else {
			Qsmd_qz = "";
			Qsmd_hz = Qsmd;
		}
		// System.out.println(Qsmd_qz+"/"+Qsmd_hz);
		Qsmd_hz_int = Integer.toString(Integer.parseInt(Qsmd_hz) + distance);
		Result = Qsmd_qz
				+ charReplicate('0', Qsmd_hz.length() - Qsmd_hz_int.length())
				+ Qsmd_hz_int;
		System.out.println("起始："+Qsmd+"：返回值："+Result);
		return Result;
	}
	
	// 复制字符
	public static String charReplicate(char char_in, int i) {
		String Result = "";
		for (int j = 1; j <= i; j++) {
			Result = Result + char_in;
		}
		return Result;
	}
	

}