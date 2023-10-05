package com.CFM.crudex.entity;
/**
 * Used as an object when user wants to search for the address of a name. 
 * @author jesseturner
 *
 */
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
