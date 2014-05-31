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
    * product_orderlist 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Product_Orderlist{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="consume")
	private Consume consume;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product")
	private Product product;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employee")
	private Employee employee;
	
	
	private Date datetime;
	private int status;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="type")
	private Type type;
	
	public void setDatetime(Date datetime){
	this.datetime=datetime;
	}
	public Date getDatetime(){
		return datetime;
	}
	public void setStatus(int status){
	this.status=status;
	}
	public int getStatus(){
		return status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Consume getConsume() {
		return consume;
	}
	public void setConsume(Consume consume) {
		this.consume = consume;
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
}

