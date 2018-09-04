package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsSceneTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1637140928699546916L;
	private String id ;
	private String scene_name;
	private String scene_islast;
	private String scene_depth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
	     this.id=id;
	}
	public String getSceneName(){
		return scene_name;
	}
	public void setSceneName(String scenename){
		this.scene_name=scenename;
	}
	public String getSceneIsLast(){
		return scene_islast;
	}
	public void setSceneIsLast(String sceneislast ){
		this.scene_islast=sceneislast;
	}
	public String getSceneDepth(){
		return scene_depth;
	}
	public void setSceneDepth(String scenedepth) {
		this.scene_depth=scenedepth;
	}

}
