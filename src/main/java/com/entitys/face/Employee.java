package com.entitys.face;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

   /**
    * employee 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Employee{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long id;
	private String name;
	private long identification;
	private int sex;
	private String phone;
	private String address;
	
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
	public void setIdentification(long identification){
	this.identification=identification;
	}
	public long getIdentification(){
		return identification;
	}
	public void setSex(int sex){
	this.sex=sex;
	}
	public int getSex(){
		return sex;
	}
	public void setPhone(String phone){
	this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setAddress(String address){
	this.address=address;
	}
	public String getAddress(){
		return address;
	}
}

