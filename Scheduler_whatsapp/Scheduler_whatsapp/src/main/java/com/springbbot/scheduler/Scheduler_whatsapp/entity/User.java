package com.springbbot.scheduler.Scheduler_whatsapp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {
	
	

	private String username;
	@Id
	private String password;
	public User( String username, String password) {
		super();
		
		this.setUsername(username);
		this.setPassword(password);
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "User [ username=" + username + ", password=" + password + "]";
	}

	
}
