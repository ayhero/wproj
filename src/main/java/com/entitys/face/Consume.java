package com.entitys.face;
import java.util.Date;
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
    * consume 实体类
    * Fri May 30 23:41:44 CST 2014 memego
    */ 

@Entity
public class Consume{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	private double payables;
	private Date datetime;
	private int ispay;
	private double paymoney;
	private String mark;
	private int status;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="card")
	private Card card;

	@OneToMany(mappedBy="consume")
	private Set<Product_Orderlist> product_Orderlist;
	
	@OneToMany(mappedBy="service")
	private Set<Service_Orderlist> service_Orderlist;
	
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public void setId(long id){
	this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setPayables(double payables){
	this.payables=payables;
	}
	public double getPayables(){
		return payables;
	}
	public void setDatetime(Date datetime){
	this.datetime=datetime;
	}
	public Date getDatetime(){
		return datetime;
	}
	public void setIspay(int ispay){
	this.ispay=ispay;
	}
	public int getIspay(){
		return ispay;
	}
	public void setPaymoney(double paymoney){
	this.paymoney=paymoney;
	}
	public double getPaymoney(){
		return paymoney;
	}
	public void setMark(String mark){
	this.mark=mark;
	}
	public String getMark(){
		return mark;
	}
	public void setStatus(int status){
	this.status=status;
	}
	public int getStatus(){
		return status;
	}
	public Set<Product_Orderlist> getProduct_Orderlist() {
		return product_Orderlist;
	}
	public void setProduct_Orderlist(Set<Product_Orderlist> product_Orderlist) {
		this.product_Orderlist = product_Orderlist;
	}
	public Set<Service_Orderlist> getService_Orderlist() {
		return service_Orderlist;
	}
	public void setService_Orderlist(Set<Service_Orderlist> service_Orderlist) {
		this.service_Orderlist = service_Orderlist;
	}
}

