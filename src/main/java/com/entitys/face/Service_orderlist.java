package com.entitys.face;
import java.util.Date;

   /**
    * service_orderlist 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class Service_orderlist{
	private long consume;
	private long service;
	private long employee;
	private long card;
	private Date datetime;
	public void setConsume(long consume){
	this.consume=consume;
	}
	public long getConsume(){
		return consume;
	}
	public void setService(long service){
	this.service=service;
	}
	public long getService(){
		return service;
	}
	public void setEmployee(long employee){
	this.employee=employee;
	}
	public long getEmployee(){
		return employee;
	}
	public void setCard(long card){
	this.card=card;
	}
	public long getCard(){
		return card;
	}
	public void setDatetime(Date datetime){
	this.datetime=datetime;
	}
	public Date getDatetime(){
		return datetime;
	}
}

