package com.assignment.userservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.userservice.entity.UserInfo;
import com.assignment.userservice.model.LoginRequest;
import com.assignment.userservice.model.UserRequest;
import com.assignment.userservice.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserServiceController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/registerUser")
	public ResponseEntity<Integer> registerUser(@Valid @RequestBody UserRequest userInfo) throws Exception {
		return new ResponseEntity<>(userService.registerUser(userInfo), HttpStatus.OK);
	}
	
	@PostMapping("/validateUser")
	public UserInfo validateUser(@Valid @RequestBody LoginRequest userInfo) {
		return userService.validateUser(userInfo);
	}
	
	
}
