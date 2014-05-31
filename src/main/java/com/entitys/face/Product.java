package com.entitys.face;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

   /**
    * product 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Product{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="type")
	private Type type;
	
	private String name;
	private int number;
	private double in_price;
	private String mark;
	public void setId(long id){
	this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setName(String name){
	this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setNumber(int number){
	this.number=number;
	}
	public int getNumber(){
		return number;
	}
	public void setIn_price(double in_price){
	this.in_price=in_price;
	}
	public double getIn_price(){
		return in_price;
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
}

