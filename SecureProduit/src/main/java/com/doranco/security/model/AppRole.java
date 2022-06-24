package com.doranco.security.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class AppRole  implements Serializable {

	@Id

	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public AppRole(String roleName) {
		super();
		this.roleName = roleName;
	}

	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AppRole [roleName=" + roleName + "]";
	}
	
	
	
}
