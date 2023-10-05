package com.CFM.crudex.entity;

public class SearchData {
	
	private String name;
	
	public SearchData() {
		
	}
	public SearchData(String name) {
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
