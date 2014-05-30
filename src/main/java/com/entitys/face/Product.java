package com.entitys.face;

   /**
    * product 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class Product{
	private long id;
	private int type;
	private String name;
	private int number;
	private double in_price;
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
	public void setName(String name){
	this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setNumber(int number){
	this.number=number;
	}
	public int getNumber(){
		return number;
	}
	public void setIn_price(double in_price){
	this.in_price=in_price;
	}
	public double getIn_price(){
		return in_price;
	}
	public void setMark(String mark){
	this.mark=mark;
	}
	public String getMark(){
		return mark;
	}
}

