package com.ninemax.jpa.global;

import java.util.HashMap;

public class ConstantsMsg {
	public static HashMap<String,String> hash = new HashMap<String,String>();
	
	public HashMap<String,String> getMsgmap(){
		hash.put("ok", "�����ɹ�");
		hash.put("no", "����ʧ��");
		hash.put("fail","����ʧ��");
		hash.put("idexisting", "�ô����Ѵ���");
		hash.put("nameexisting", "�������Ѵ���");
		hash.put("checknull", "��ѡ����Ҫ��˵���Ŀ");
		return hash;
	}
	
	

}
