package com.ninemax.nacao.to.govInfo;

import java.io.Serializable;

public class JSONTreeNode implements Serializable{ 

    private static final long serialVersionUID = 1L; 
    private String id;            //ID 
    private String text;          //节点显示 
    private String cls;           //图标 
    private boolean leaf;         //是否叶子 
    private String href;          //链接 
    private String hrefTarget;    //链接指向 
    private boolean expandable;   //是否展开 
    private String description;   //描述信息 
	private String type;//节点类型 1 为有孩子节点的 2 为最后的叶子节点
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getHrefTarget() {
		return hrefTarget;
	}
	public void setHrefTarget(String hrefTarget) {
		this.hrefTarget = hrefTarget;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    
    

}
