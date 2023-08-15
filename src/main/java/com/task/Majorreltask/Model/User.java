package com.task.Majorreltask.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	String username;
	String password;
	String email;
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
	
	
	
	
	public User(String username,String password,String email) {
		super();
		this.username=username;
		this.password=password;
		this.email=email;

	}
	
	public User(String password,String email) {
		super();
		
		this.password=password;
		this.email=email;

	}
	
	
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
	
	
	
	
	
	

}
