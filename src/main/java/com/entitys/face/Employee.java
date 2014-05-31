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

   /**
    * employee 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Employee{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	private String name;
	private long identification;
	private int sex;
	private String phone;
	private String address;
	
	@OneToMany(mappedBy="employee")
	private Set<Department_Employee> department;
	

	@OneToMany(mappedBy="employee")
	private Set<Product_Orderlist> product_Orderlist;
	
	@OneToMany(mappedBy="employee")
	private Set<Service_Orderlist> service_Orderlist;
	
	
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
	public void setIdentification(long identification){
	this.identification=identification;
	}
	public long getIdentification(){
		return identification;
	}
	public void setSex(int sex){
	this.sex=sex;
	}
	public int getSex(){
		return sex;
	}
	public void setPhone(String phone){
	this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setAddress(String address){
	this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public Set<Department_Employee> getDepartment() {
		return department;
	}
	public void setDepartment(Set<Department_Employee> department) {
		this.department = department;
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

