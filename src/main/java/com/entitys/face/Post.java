package com.entitys.face;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

   /**
    * 职位表实体
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class Post{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy="post")
	private Set<Department_Employee> department_employee;
	
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
	public Set<Department_Employee> getDepartment_employee() {
		return department_employee;
	}
	public void setDepartment_employee(Set<Department_Employee> department_employee) {
		this.department_employee = department_employee;
	}
}

