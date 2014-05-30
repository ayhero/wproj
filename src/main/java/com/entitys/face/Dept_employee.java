package com.entitys.face;

   /**
    * dept_employee 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class Dept_employee{
	private long department;
	private long employee;
	private long post;
	private String mark;
	public void setDepartment(long department){
	this.department=department;
	}
	public long getDepartment(){
		return department;
	}
	public void setEmployee(long employee){
	this.employee=employee;
	}
	public long getEmployee(){
		return employee;
	}
	public void setPost(long post){
	this.post=post;
	}
	public long getPost(){
		return post;
	}
	public void setMark(String mark){
	this.mark=mark;
	}
	public String getMark(){
		return mark;
	}
}

