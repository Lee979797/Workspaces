/**
 * 用户自定义栏目
 */
package com.ninemax.nacao.to.portalet;

/**
 * @author yonghedawang
 *
 */
public class clsMyunitTO {

	private String user_id;
	private String unit_id;
	private String layout_row;
	private String layout_col;
	private String channel_id;//周鹏鹏添加
	private String webSite_id;//周鹏鹏添加
	
	public String getWebSite_id() {
		return webSite_id;
	}
	public void setWebSite_id(String webSite_id) {
		this.webSite_id = webSite_id;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	public String getLayout_col() {
		return layout_col;
	}
	public void setLayout_col(String layout_col) {
		this.layout_col = layout_col;
	}
	public String getLayout_row() {
		return layout_row;
	}
	public void setLayout_row(String layout_row) {
		this.layout_row = layout_row;
	}
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
}
