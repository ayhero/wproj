package com.entitys;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Resc {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="res_type")
	private String res_type;
	

	@Column(name="res_string")
	private String res_string;
	

	@Column(name="priority")
	private int priority;
	
	@Column(name="descn")
	private String descn;
	
	
	@OneToMany(targetEntity=Role.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)  
	@Fetch(FetchMode.SELECT)
	@JoinTable(joinColumns=@JoinColumn(name="resc_id",nullable=false),
				name="Resc_Role",inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles=new HashSet<Role>();
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRes_type() {
		return res_type;
	}
	public void setRes_type(String res_type) {
		this.res_type = res_type;
	}
	public String getRes_string() {
		return res_string;
	}
	public void setRes_string(String res_string) {
		this.res_string = res_string;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
}
