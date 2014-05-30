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
    * consume 实体类
    * Fri May 30 23:41:44 CST 2014 memego
    */ 

@Entity
public class Consume{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
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
}

