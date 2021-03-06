package com.entitys.face;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

   /**
    * customer_card 实体类
    * Fri May 30 23:41:44 CST 2014 memego
    */ 

@Entity
public class Card{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="type")
	private Type type;
	
	private Date activedate;
	private double money;
	
	@OneToOne
    @JoinColumn(name="employee")
	private Employee employee;
	
	@ManyToOne
	@JoinTable(name = "user_card_info",
        joinColumns = @JoinColumn(name="card"),
        inverseJoinColumns = @JoinColumn(name="user")
    )
	private User user;
	
	public void setId(long id){
	this.id=id;
	}
	public long getId(){
		return id;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
}

