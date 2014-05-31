package com.entitys.face;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

   /**
    * financial_income 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Financial_Income{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="type")
	private Type type;
	
	private double money;
	
	@OneToMany
    @JoinTable(
            name="financial_income_bill",
            joinColumns = @JoinColumn( name="financial_income"),
            inverseJoinColumns = @JoinColumn( name="financial_bill")
    )
	private Set<Financial_Bill> financial_bills;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="consume")
	private Consume consume;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employee")
	private Employee employee;

	private int status;
	private String remark;
	private String charges;
	
	
	public void setId(long id){
	this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setMoney(double money){
	this.money=money;
	}
	public double getMoney(){
		return money;
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Consume getConsume() {
		return consume;
	}
	public void setConsume(Consume consume) {
		this.consume = consume;
	}
}

