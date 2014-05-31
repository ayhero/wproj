package com.entitys.face;

import java.util.Set;

import javax.persistence.*;

   /**
    * product 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Product{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="type")
	private Type type;
	
	private String name;
	private int number;
	private double in_price;
	private String mark;
	
	@OneToMany(mappedBy="product")
	private Set<Product_Orderlist> orderlist;
	
	@OneToMany(mappedBy="product")
	private Set<Damage_Product> damage_Products;
	
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
	public Set<Damage_Product> getDamage_Products() {
		return damage_Products;
	}
	public void setDamage_Products(Set<Damage_Product> damage_Products) {
		this.damage_Products = damage_Products;
	}
	public Set<Product_Orderlist> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(Set<Product_Orderlist> orderlist) {
		this.orderlist = orderlist;
	}
}

