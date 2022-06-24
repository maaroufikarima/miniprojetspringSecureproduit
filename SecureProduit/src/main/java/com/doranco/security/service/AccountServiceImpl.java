package com.doranco.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.doranco.security.dao.RoleRepository;
import com.doranco.security.dao.UserRepository;
import com.doranco.security.model.AppRole;
import com.doranco.security.model.AppUser;

@Service
@Transactional

public class AccountServiceImpl implements AccountService {
	private	BCryptPasswordEncoder	bCryptPasswordEncoder;

	@Autowired
	private RoleRepository roleRepository;
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public AppUser saveUser(AppUser user) {
		// TODO Auto-generated method stub
		this.bCryptPasswordEncoder=new BCryptPasswordEncoder();
		String hashPW=bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub
		AppRole role=roleRepository.findByRoleName(roleName);
		AppUser user=userRepository.findByUsername(username);
		user.getRoles().add(role);
		userRepository.save(user);
		

	}

	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}
