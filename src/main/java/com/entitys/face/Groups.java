package com.entitys.face;

   /**
    * groups 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class Groups{
	private long id;
	private String name;
	private int status;
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
	public void setStatus(int status){
	this.status=status;
	}
	public int getStatus(){
		return status;
	}
}

