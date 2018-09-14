package com.lhq.prj.bms.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LeafHelp implements Serializable  {

	private String leafId;
	private String keyWs;
	private String title;
	private String content;
	
	public String getLeafId() {
		return leafId;
	}
	public void setLeafId(String leafId) {
		this.leafId = leafId;
	}
	public String getKeyWs() {
		return keyWs;
	}
	public void setKeyWs(String keyWs) {
		this.keyWs = keyWs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
