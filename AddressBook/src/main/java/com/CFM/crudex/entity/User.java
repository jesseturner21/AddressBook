package com.CFM.crudex.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	@NotEmpty(message="Input Username")
	private String username;
	@Column
	@NotEmpty(message="Input Password")
	private String password;
	@Column
	private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	List<Contact> contacts;
	

	public List<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return this.id;
	}


	public User() {
		this.contacts = new ArrayList<Contact>();
	}
	
	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.setEmail(email);
	}


	
}
