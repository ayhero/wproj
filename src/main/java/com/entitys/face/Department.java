package com.entitys.face;

   /**
    * department 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class Department{
	private long id;
	private String name;
	public void setId(long id){
	this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setName(String name){
	this.name=name;
	}
	public String getName(){
		return name;
	}
}

