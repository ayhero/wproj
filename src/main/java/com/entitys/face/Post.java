package com.entitys.face;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

   /**
    * 职位表实体
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Post{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
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

