package com.entitys.face;

   /**
    * user 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class User{
	private long id;
	private String name;
	private String Identification;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email;
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
	public void setIdentification(String Identification){
	this.Identification=Identification;
	}
	public String getIdentification(){
		return Identification;
	}
	public void setPhone1(String phone1){
	this.phone1=phone1;
	}
	public String getPhone1(){
		return phone1;
	}
	public void setPhone2(String phone2){
	this.phone2=phone2;
	}
	public String getPhone2(){
		return phone2;
	}
	public void setPhone3(String phone3){
	this.phone3=phone3;
	}
	public String getPhone3(){
		return phone3;
	}
	public void setEmail(String email){
	this.email=email;
	}
	public String getEmail(){
		return email;
	}
}

