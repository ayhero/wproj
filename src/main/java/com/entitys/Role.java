package com.entitys;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="descn")
	private String descn;
	

	@OneToMany(targetEntity=Resc.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)  
	@Fetch(FetchMode.SELECT)
	@JoinTable(joinColumns=@JoinColumn(name="role_id",nullable=false),
				name="Resc_Role",inverseJoinColumns=@JoinColumn(name="resc_id"))
	private Set<Resc> rescs=new HashSet<Resc>();
	
	public Set<Resc> getRescs() {
		return rescs;
	}
	public void setRescs(Set<Resc> rescs) {
		this.rescs = rescs;
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
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	
}
