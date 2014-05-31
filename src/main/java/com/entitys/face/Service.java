package com.entitys.face;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

   /**
    * service 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Service{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="type")
	private Type type;
	
	@OneToMany(mappedBy="service")
	private Set<Service_Orderlist> orderlists;
	
	private double money;
	private double discount;
	private String mark;
	
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
	public void setDiscount(double discount){
	this.discount=discount;
	}
	public double getDiscount(){
		return discount;
	}
	public void setMark(String mark){
	this.mark=mark;
	}
	public String getMark(){
		return mark;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Set<Service_Orderlist> getOrderlists() {
		return orderlists;
	}
	public void setOrderlists(Set<Service_Orderlist> orderlists) {
		this.orderlists = orderlists;
	}
}

