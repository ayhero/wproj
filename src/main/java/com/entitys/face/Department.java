package com.entitys.face;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

   /**
    * department 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Department{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	private String name;
	
	@OneToMany(mappedBy="department")
	private Set<Department_Employee> employees;
	
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
	public Set<Department_Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Department_Employee> employees) {
		this.employees = employees;
	}
}

