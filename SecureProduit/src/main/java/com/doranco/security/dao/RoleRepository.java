package com.doranco.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.security.model.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, String> {
	public AppRole findByRoleName(String roleName);
}
