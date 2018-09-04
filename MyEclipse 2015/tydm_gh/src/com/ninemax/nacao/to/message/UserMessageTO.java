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
	private String sys_id;   //系统公告表ID
	private String receive_time;   //接收时间
	private int view_status;   //消息状态  0 未读；1 已读；2 删除
	private String c_userid;  //用户编号，只有当用户点击查看信息时才插入记录
	private String type;   //消息类型 0 系统公告；1 消息
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
