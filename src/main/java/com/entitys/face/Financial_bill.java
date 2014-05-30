package com.entitys.face;

   /**
    * financial_bill 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class Financial_bill{
	private long id;
	private long financial;
	private int type;
	private String description;
	private String mrak;
	private double money;
	private long employee;
	private long pm;
	public void setId(long id){
	this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setFinancial(long financial){
	this.financial=financial;
	}
	public long getFinancial(){
		return financial;
	}
	public void setType(int type){
	this.type=type;
	}
	public int getType(){
		return type;
	}
	public void setDescription(String description){
	this.description=description;
	}
	public String getDescription(){
		return description;
	}
	public void setMrak(String mrak){
	this.mrak=mrak;
	}
	public String getMrak(){
		return mrak;
	}
	public void setMoney(double money){
	this.money=money;
	}
	public double getMoney(){
		return money;
	}
	public void setEmployee(long employee){
	this.employee=employee;
	}
	public long getEmployee(){
		return employee;
	}
	public void setPm(long pm){
	this.pm=pm;
	}
	public long getPm(){
		return pm;
	}
}

