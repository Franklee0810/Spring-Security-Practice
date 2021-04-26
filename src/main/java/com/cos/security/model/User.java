package com.cos.security.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

// ORM - Object Relation Mapping


@Entity
public class User {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String role; //ROLE_USER, ROLE_ADMIN
	
	@CreationTimestamp
	private Timestamp createDate;
	
	private String provider; //구글 
	
	private String providerId; //getAttributes()로 받은 정보 중 sub의 값 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + ", createDate=" + createDate + ", provider=" + provider + ", providerId=" + providerId + "]";
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String password, String email, String role, Timestamp createDate,
			String provider, String providerId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.createDate = createDate;
		this.provider = provider;
		this.providerId = providerId;
	}
	
	
	
}