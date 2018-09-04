package com.ninemax.nacao.to.message;

import java.io.Serializable;

/**
 * 
 * @author yangxf
 *
 */
public class SystemMessageTO implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6279158597626731317L;
	private String sys_id;
	private String oper_date;   //��������
	private String from_person;   //������
	private String send_time;   //����ʱ��
	private String object_type;  //��������  0:ȫ��;1:�����û�;2:�û���;3:����
	private String send_object;   //���Ͷ��� 
	private String send_content;   //��������
	private String send_title;   //���ݱ���
	private String memo;    //��ע��Ϣ
	private String top_status;    //�ö���ʶ  1�ö����ö�����Ψһ��
	private String type;   //��Ϣ����   0 ϵͳ���� 1 ��Ϣ��2 �������� 3���񹫸�
	private String send_status;  //0��д��(�ݸ���);1�ѷ���;2 ��ɾ��
	public String getSys_id() {
		return sys_id;
	}
	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}
	public String getOper_date() {
		return oper_date;
	}
	public void setOper_date(String oper_date) {
		this.oper_date = oper_date;
	}
	public String getFrom_person() {
		return from_person;
	}
	public void setFrom_person(String from_person) {
		this.from_person = from_person;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getSend_object() {
		return send_object;
	}
	public void setSend_object(String send_object) {
		this.send_object = send_object;
	}
	public String getSend_content() {
		return send_content;
	}
	public void setSend_content(String send_content) {
		this.send_content = send_content;
	}
	public String getSend_title() {
		return send_title;
	}
	public void setSend_title(String send_title) {
		this.send_title = send_title;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getTop_status() {
		return top_status;
	}
	public void setTop_status(String top_status) {
		this.top_status = top_status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSend_status() {
		return send_status;
	}
	public void setSend_status(String send_status) {
		this.send_status = send_status;
	}
	public String getObject_type() {
		return object_type;
	}
	public void setObject_type(String object_type) {
		this.object_type = object_type;
	}


}
