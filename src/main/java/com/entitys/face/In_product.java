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
    * in_product 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class In_product{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	private String supplier;
	private Date datetime;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product")
	private Product product;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employee")
	private Employee employee;
	
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}

