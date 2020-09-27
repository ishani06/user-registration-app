package com.assignment.userservice.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.userservice.entity.UserInfo;
import com.assignment.userservice.model.LoginRequest;
import com.assignment.userservice.model.UserRequest;
import com.assignment.userservice.repository.UserServiceRepository;
import com.assignment.userservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserServiceRepository userServiceRepository;

	@Override
	public Integer registerUser(UserRequest registerUserRequest) throws Exception {
		String encodedPassword=null;
		try { 
			  UserInfo userInfo = new UserInfo();
			  userInfo.setFirstname(registerUserRequest.getFirstName());
			  userInfo.setLastname(registerUserRequest.getLastName());
			  userInfo.setUsername(registerUserRequest.getUsername());
			  encodedPassword = BCrypt.hashpw(registerUserRequest.getPassword(), BCrypt.gensalt(10));
			  userInfo.setPassword(encodedPassword);
			  userInfo = userServiceRepository.save(userInfo);
			  return userInfo.getId();
		  } catch (Exception e) {
			 log.error(e.getMessage());
			 throw new Exception("Username already exists");
		  }
	}

	@Override
	public UserInfo validateUser(LoginRequest userInfo) {
		UserInfo user = userServiceRepository.findByUsername(userInfo.getUsername());
		if(user != null && BCrypt.checkpw(userInfo.getPassword(),user.getPassword()))
			return user;
		return null;
	}
	
}
