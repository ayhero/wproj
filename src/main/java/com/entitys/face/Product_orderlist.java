package com.entitys.face;
import java.util.Date;

   /**
    * product_orderlist 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class Product_orderlist{
	private long consume;
	private long product;
	private long employee;
	private Date datetime;
	private int status;
	private int type;
	public void setConsume(long consume){
	this.consume=consume;
	}
	public long getConsume(){
		return consume;
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
	public void setDatetime(Date datetime){
	this.datetime=datetime;
	}
	public Date getDatetime(){
		return datetime;
	}
	public void setStatus(int status){
	this.status=status;
	}
	public int getStatus(){
		return status;
	}
	public void setType(int type){
	this.type=type;
	}
	public int getType(){
		return type;
	}
}

