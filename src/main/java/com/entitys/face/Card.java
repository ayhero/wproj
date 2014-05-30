package com.entitys.face;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

   /**
    * customer_card 实体类
    * Fri May 30 23:41:44 CST 2014 memego
    */ 

@Entity
public class Card{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private long id;
	private int type;
	private Date activedate;
	private double money;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employee")
	private Employee employee;
	
	
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
	public void setActivedate(Date activedate){
	this.activedate=activedate;
	}
	public Date getActivedate(){
		return activedate;
	}
	public void setMoney(double money){
	this.money=money;
	}
	public double getMoney(){
		return money;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}

