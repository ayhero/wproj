package com.entitys.face;

   /**
    * user_card_info 实体类
    * Fri May 30 23:41:45 CST 2014 memego
    */ 


public class User_card_info{
	private long card;
	private long user;
	private int isactive;
	public void setCard(long card){
	this.card=card;
	}
	public long getCard(){
		return card;
	}
	public void setUser(long user){
	this.user=user;
	}
	public long getUser(){
		return user;
	}
	public void setIsactive(int isactive){
	this.isactive=isactive;
	}
	public int getIsactive(){
		return isactive;
	}
}

