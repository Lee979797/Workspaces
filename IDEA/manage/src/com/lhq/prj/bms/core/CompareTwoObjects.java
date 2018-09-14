package com.lhq.prj.bms.core;

import java.lang.reflect.Field; 
import java.lang.reflect.Method; 
import java.util.ArrayList; 
import java.util.List; 

/** 
* ClassName:CompareTwoObjects 
* Function: TODO ADD FUNCTION 
* Reason: TODO ADD REASON 
* 
* @author   田志超 
* @version  
* @since    Ver 1.1 
* @Date Mar 25, 2010 12:52:20 PM 
*/ 
public class CompareTwoObjects { 

	/** 
	* main:LIST文件比较
	* @param  @param args   
	* @return void    
	* @throws 
	* @since  Mar 25, 2013,22:52:22 PM 
	* written by yq
	*/ 
	
	public static void main(String[] args) {
		A a = new A(1,2);
		A b = new A(1,2);
		A c = new A(1,2);
		List<A> list1 = new ArrayList<A>();
		List<A> list2 = new ArrayList<A>();
		list1.add(a);
		list2.add(b);
		list2.add(c);
		boolean isEqual = true;
		for (A a1 : list1) {
			for (A b1 : list2) {
				if (!a1.equals(b1)) {
					isEqual= false;
				}
			}
		}
		System.out.println(isEqual);
	
	}
}

class A {
	int i;
	int j;
	public A(int i, int j){
		this.i=i;
		this.j=j;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		Class clazz = this.getClass();
		Field [] field = clazz.getDeclaredFields();
		try{
			for (Field field2 : field) {
			String methodName="get"+field2.getName().toUpperCase().charAt(0)+field2.getName().substring(1);
			Method method = clazz.getDeclaredMethod(methodName);
			Object obj1 = method.invoke(obj);
			Object obj2 = method.invoke(this);
			if (!obj1.equals(obj2)) return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
	return j;
	}
	public void setJ(int j) {
	this.j = j;
	}
} 

