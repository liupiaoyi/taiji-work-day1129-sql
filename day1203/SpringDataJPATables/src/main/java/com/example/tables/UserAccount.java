package com.example.tables;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_account")
public class UserAccount  implements Serializable {
	//用户表，多对一（角色-------每个角色有多个用户）
	private static final long serialVersionUID = -6064570101677336748L;

	@Id
	private String code;
	
	private String name;
	private String password;
	private boolean enabled;
	private String email;
	
	@ManyToOne(cascade = {CascadeType.ALL }, optional = true)   
	@JoinColumn(name="userRoles_code")
	private UserRoles userRoles;
	

	public UserRoles getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserAccount(String code, String name, String password, boolean enabled, String email, UserRoles userRoles) {
		super();
		this.code = code;
		this.name = name;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
		this.userRoles = userRoles;
	}

	public UserAccount() {
		super();
	}

	@Override
	public String toString() {
		return "UserAccount [code=" + code + ", name=" + name + ", password=" + password + ", enabled=" + enabled
				+ ", email=" + email + ", userRoles=" + "userRoles" + "]";
	}
	
}
