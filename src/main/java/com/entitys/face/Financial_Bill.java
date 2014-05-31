package com.entitys.face;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

   /**
    * financial_bill 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Financial_Bill{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "financial_income_bill",
        joinColumns = @JoinColumn(name="financial_bill"),
        inverseJoinColumns = @JoinColumn(name="financial_income")
    )
	private Financial_Income financial_Income;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="type")
	private Type type;
	
	private String description;
	private String mrak;
	private double money;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name="financial_income_bill",
        joinColumns = @JoinColumn(name="financial_bill"),
        inverseJoinColumns = @JoinColumn(name="financial_income")
    )
	private Financial_Income financial_income;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employee")
	private Employee employee;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pm")
	private Employee pm;
	
	public void setId(long id){
	this.id=id;
	}
	public long getId(){
		return id;
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
	public Employee getPm() {
		return pm;
	}
	public void setPm(Employee pm) {
		this.pm = pm;
	}
	public Financial_Income getFinancial_Income() {
		return financial_Income;
	}
	public void setFinancial_Income(Financial_Income financial_Income) {
		this.financial_Income = financial_Income;
	}
	public Financial_Income getFinancial_income() {
		return financial_income;
	}
	public void setFinancial_income(Financial_Income financial_income) {
		this.financial_income = financial_income;
	}
}

