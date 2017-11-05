package com.politechnika.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String login;
	private String password;
	
	private String name;
	
	@Column(unique=true)
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	@Override
	@Transient
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
