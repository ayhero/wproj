package com.entitys.face;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

   /**
    * user 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class User{	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long id;
	private String name;
	private String Identification;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL) 
	@PrimaryKeyJoinColumn
	private User_Info user_Info;
	
	@OneToMany
    @JoinTable(
            name="user_card_info",
            joinColumns = @JoinColumn( name="user"),
            inverseJoinColumns = @JoinColumn( name="card")
    )
	private Set<Card> cards;
	
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
	public void setIdentification(String Identification){
	this.Identification=Identification;
	}
	public String getIdentification(){
		return Identification;
	}
	public void setPhone1(String phone1){
	this.phone1=phone1;
	}
	public String getPhone1(){
		return phone1;
	}
	public void setPhone2(String phone2){
	this.phone2=phone2;
	}
	public String getPhone2(){
		return phone2;
	}
	public void setPhone3(String phone3){
	this.phone3=phone3;
	}
	public String getPhone3(){
		return phone3;
	}
	public void setEmail(String email){
	this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public User_Info getUser_Info() {
		return user_Info;
	}
	public void setUser_Info(User_Info user_Info) {
		this.user_Info = user_Info;
	}
	public Set<Card> getCards() {
		return cards;
	}
	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}
}

