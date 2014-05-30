package com.entitys.face;
import java.util.Date;

   /**
    * damage_product 实体类
    * Fri May 30 23:41:44 CST 2014 memego
    */ 


public class Damage_product{
	private long product;
	private long employee;
	private Date datetime;
	private int number;
	private String mark;
	private int type;
	public void setProduct(long product){
	this.product=product;
	}
	public long getProduct(){
		return product;
	}
	public void setEmployee(long employee){
	this.employee=employee;
	}
	public long getEmployee(){
		return employee;
	}
	public void setDatetime(Date datetime){
	this.datetime=datetime;
	}
	public Date getDatetime(){
		return datetime;
	}
	public void setNumber(int number){
	this.number=number;
	}
	public int getNumber(){
		return number;
	}
	public void setMark(String mark){
	this.mark=mark;
	}
	public String getMark(){
		return mark;
	}
	public void setType(int type){
	this.type=type;
	}
	public int getType(){
		return type;
	}
}

