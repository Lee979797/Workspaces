/**
 * 布局定制
 */
package com.ninemax.nacao.to.portalet;

/**
 * @author yonghedawang
 * 这个类设置用户的布局和主题
 */
public class clsCustomMadeTO {

	private String user_id;
	private String layout_id;
	private String theme_id;
	private String lang_id;
	private String channel_id; //周鹏鹏添加
	private String webSite_id; //周鹏鹏添加
	
	
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
	public String getLang_id() {
		return lang_id;
	}
	public void setLang_id(String lang_id) {
		this.lang_id = lang_id;
	}
	public String getLayout_id() {
		return layout_id;
	}
	public void setLayout_id(String layout_id) {
		this.layout_id = layout_id;
	}
	public String getTheme_id() {
		return theme_id;
	}
	public void setTheme_id(String theme_id) {
		this.theme_id = theme_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
}
