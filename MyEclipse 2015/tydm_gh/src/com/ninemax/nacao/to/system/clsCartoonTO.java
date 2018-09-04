package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsCartoonTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4890927483423267464L;
	private String id ;
	private String cartoon_name;
	private String cartoon_islast;
	private String cartoon_depth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
	     this.id=id;
	}
	public String getCartoonName(){
		return cartoon_name;
	}
	public void setCartoonName(String cartoonname){
		this.cartoon_name=cartoonname;
	}
	public String getCartoonIsLast(){
		return cartoon_islast;
	}
	public void setCartoonIsLast(String cartoonislast ){
		this.cartoon_islast=cartoonislast;
	}
	public String getCartoonDepth(){
		return cartoon_depth;
	}
	public void setCartoonDepth(String cartoondepth) {
		this.cartoon_depth=cartoondepth;
	}
}
