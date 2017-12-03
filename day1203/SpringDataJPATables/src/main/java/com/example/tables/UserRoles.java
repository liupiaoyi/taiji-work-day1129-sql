package com.example.tables;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRoles {
	
	@Id
	private String code;
	
	private String name;
	private boolean enabled;
	
	@OneToMany(cascade = { CascadeType.ALL},mappedBy="userRoles")
	private List<UserAccount> userAccount;
	
	public List<UserAccount> getUserAccount() {
		return userAccount;
	}

	public void setUserRoles(List<UserAccount> userAccount) {
		this.userAccount = userAccount;
	}

	
	
	public UserRoles() {
		super();
	}
	
	public UserRoles(String code, String name, boolean enabled) {
		super();
		this.code = code;
		this.name = name;
		this.enabled = enabled;
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "UserRoles [code=" + code + ", name=" + name + ", enabled=" + enabled + "]";
	}

}
