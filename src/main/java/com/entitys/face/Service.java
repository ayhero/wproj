package com.entitys.face;

   /**
    * service 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class Service{
	private long id;
	private int type;
	private double money;
	private double discount;
	private String mark;
	public void setId(long id){
	this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setType(int type){
	this.type=type;
	}
	public int getType(){
		return type;
	}
	public void setMoney(double money){
	this.money=money;
	}
	public double getMoney(){
		return money;
	}
	public void setDiscount(double discount){
	this.discount=discount;
	}
	public double getDiscount(){
		return discount;
	}
	public void setMark(String mark){
	this.mark=mark;
	}
	public String getMark(){
		return mark;
	}
}

