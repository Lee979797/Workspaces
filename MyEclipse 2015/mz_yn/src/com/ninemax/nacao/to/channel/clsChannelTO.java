package com.ninemax.nacao.to.channel;

/**
 * վ��Ƶ��
 * @author ZhouPeng
 *
 */
public class clsChannelTO implements java.io.Serializable {

	
	private static final long serialVersionUID = -1432088786239518119L;
	private String channel_id;
	private String channel_name;
	private String user_id;
	private String isvisible;
	private String isshare;
	private String webSite_id;
	private String isRightkey; //�Ƿ��Ȩ
	
	private String channelTemplate;//Ƶ��ģ�壬�Ļ����û�
	private String orderbyKey;//�����ֶ�
	
	public String getOrderbyKey() {
		return orderbyKey;
	}
	public void setOrderbyKey(String orderbyKey) {
		this.orderbyKey = orderbyKey;
	}
	public String getChannelTemplate() {
		return channelTemplate;
	}
	public void setChannelTemplate(String channelTemplate) {
		this.channelTemplate = channelTemplate;
	}
	public String getIsRightkey() {
		return isRightkey;
	}
	public void setIsRightkey(String isRightkey) {
		this.isRightkey = isRightkey;
	}
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
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getIsvisible() {
		return isvisible;
	}
	public void setIsvisible(String isvisible) {
		this.isvisible = isvisible;
	}
	public String getIsshare() {
		return isshare;
	}
	public void setIsshare(String isshare) {
		this.isshare = isshare;
	}
	
}
