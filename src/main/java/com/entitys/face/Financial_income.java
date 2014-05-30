package com.entitys.face;

   /**
    * financial_income 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class Financial_income{
	private long id;
	private int type;
	private double money;
	private long consume;
	private long employee;
	private int status;
	private String remark;
	private String charges;
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
	public void setConsume(long consume){
	this.consume=consume;
	}
	public long getConsume(){
		return consume;
	}
	public void setEmployee(long employee){
	this.employee=employee;
	}
	public long getEmployee(){
		return employee;
	}
	public void setStatus(int status){
	this.status=status;
	}
	public int getStatus(){
		return status;
	}
	public void setRemark(String remark){
	this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setCharges(String charges){
	this.charges=charges;
	}
	public String getCharges(){
		return charges;
	}
}

