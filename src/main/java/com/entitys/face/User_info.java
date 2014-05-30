package com.entitys.face;

   /**
    * user_info 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class User_info{
	private long user;
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
	public void setUser(long user){
	this.user=user;
	}
	public long getUser(){
		return user;
	}
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
}

