package com.entitys.face;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

   /**
    * type 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Type{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;
	
	private String name;
	private String status;
	private String mark;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="group")
	private Groups group;
	
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
	public Groups getGroup() {
		return group;
	}
	public void setGroup(Groups group) {
		this.group = group;
	}
	
}

