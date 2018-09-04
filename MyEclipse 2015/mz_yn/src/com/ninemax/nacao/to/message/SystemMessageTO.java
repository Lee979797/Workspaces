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
	private String oper_date;   //操作日期
	private String from_person;   //发起人
	private String send_time;   //发送时间
	private String object_type;  //对象类型  0:全部;1:单独用户;2:用户组;3:地区
	private String send_object;   //发送对象 
	private String send_content;   //发送内容
	private String send_title;   //内容标题
	private String memo;    //备注信息
	private String top_status;    //置顶标识  1置顶（置顶数据唯一）
	private String type;   //消息类型   0 系统公告 1 消息；2 待办事宜 3政务公告
	private String send_status;  //0编写中(草稿箱);1已发送;2 已删除
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
