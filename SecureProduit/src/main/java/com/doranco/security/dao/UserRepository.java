package com.doranco.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.security.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, String> {
	public AppUser findByUsername(String username);
}
