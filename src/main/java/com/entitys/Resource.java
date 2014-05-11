package com.entitys;

public class Resource {

	private String url;
	private String role;
	
	
	public Resource(){
		
	}
	public Resource(String url,String role){
		this.url=url;
		this.role=role;
	}
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
