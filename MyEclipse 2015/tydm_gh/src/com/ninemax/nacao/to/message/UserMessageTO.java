package com.ninemax.nacao.to.message;

import java.io.Serializable;

/**
 * 
 * @author yangxf
 *
 */
public class UserMessageTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4205439386757886927L;
	private String th_id;
	private String sys_id;   //ϵͳ�����ID
	private String receive_time;   //����ʱ��
	private int view_status;   //��Ϣ״̬  0 δ����1 �Ѷ���2 ɾ��
	private String c_userid;  //�û���ţ�ֻ�е��û�����鿴��Ϣʱ�Ų����¼
	private String type;   //��Ϣ���� 0 ϵͳ���棻1 ��Ϣ
	public String getTh_id() {
		return th_id;
	}
	public void setTh_id(String th_id) {
		this.th_id = th_id;
	}
	public String getSys_id() {
		return sys_id;
	}
	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}
	public String getReceive_time() {
		return receive_time;
	}
	public void setReceive_time(String receive_time) {
		this.receive_time = receive_time;
	}
	public String getC_userid() {
		return c_userid;
	}
	public void setC_userid(String c_userid) {
		this.c_userid = c_userid;
	}
	public int getView_status() {
		return view_status;
	}
	public void setView_status(int view_status) {
		this.view_status = view_status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
