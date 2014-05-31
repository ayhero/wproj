package com.entitys.face;

import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;


   /**
    * user_info 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 

@Entity
public class User_Info{
	@Id
    @GeneratedValue(generator="pkUser_Info")
    @GenericGenerator(name="pkUser_Info", strategy="foreign",parameters=@Parameter(name="property",value="user"))
	private long id;
	
	@OneToOne(mappedBy = "user_Info")
	private User user;
	
	
	private int skin;
	private double height;
	private double weight;
	private String address;
	private int health;
	private int sport;
	private int smook;
	private int emotion;
	private int sleep;
	private int eatting;
	private int nature;
	private String postCode;
	
	public void setSkin(int skin){
	this.skin=skin;
	}
	public int getSkin(){
		return skin;
	}
	public void setHeight(double height){
	this.height=height;
	}
	public double getHeight(){
		return height;
	}
	public void setWeight(double weight){
	this.weight=weight;
	}
	public double getWeight(){
		return weight;
	}
	public void setAddress(String address){
	this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setHealth(int health){
	this.health=health;
	}
	public int getHealth(){
		return health;
	}
	public void setSport(int sport){
	this.sport=sport;
	}
	public int getSport(){
		return sport;
	}
	public void setSmook(int smook){
	this.smook=smook;
	}
	public int getSmook(){
		return smook;
	}
	public void setEmotion(int emotion){
	this.emotion=emotion;
	}
	public int getEmotion(){
		return emotion;
	}
	public void setSleep(int sleep){
	this.sleep=sleep;
	}
	public int getSleep(){
		return sleep;
	}
	public void setEatting(int eatting){
	this.eatting=eatting;
	}
	public int getEatting(){
		return eatting;
	}
	public void setNature(int nature){
	this.nature=nature;
	}
	public int getNature(){
		return nature;
	}
	public void setPostCode(String postCode){
	this.postCode=postCode;
	}
	public String getPostCode(){
		return postCode;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
}

