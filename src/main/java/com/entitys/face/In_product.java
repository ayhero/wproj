package com.entitys.face;
import java.util.Date;

   /**
    * in_product 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class In_product{
	private long id;
	private String supplier;
	private Date datetime;
	private long product;
	private long employee;
	private int number;
	private double money;
	private long mark;
	public void setId(long id){
	this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setSupplier(String supplier){
	this.supplier=supplier;
	}
	public String getSupplier(){
		return supplier;
	}
	public void setDatetime(Date datetime){
	this.datetime=datetime;
	}
	public Date getDatetime(){
		return datetime;
	}
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
	public void setNumber(int number){
	this.number=number;
	}
	public int getNumber(){
		return number;
	}
	public void setMoney(double money){
	this.money=money;
	}
	public double getMoney(){
		return money;
	}
	public void setMark(long mark){
	this.mark=mark;
	}
	public long getMark(){
		return mark;
	}
}

