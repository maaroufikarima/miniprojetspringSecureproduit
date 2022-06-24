package com.doranco.security.service;

import com.doranco.security.model.AppRole;
import com.doranco.security.model.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser findUserByUsername(String username);
}
