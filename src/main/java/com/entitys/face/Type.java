package com.entitys.face;

   /**
    * type 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class Type{
	private int id;
	private String name;
	private String status;
	private String mark;
	private int groups;
	public void setId(int id){
	this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
	this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setStatus(String status){
	this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public void setMark(String mark){
	this.mark=mark;
	}
	public String getMark(){
		return mark;
	}
	public void setGroups(int groups){
	this.groups=groups;
	}
	public int getGroups(){
		return groups;
	}
}

