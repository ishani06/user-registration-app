package com.assignment.userservice.service;

import javax.validation.Valid;

import com.assignment.userservice.entity.UserInfo;
import com.assignment.userservice.model.LoginRequest;
import com.assignment.userservice.model.UserRequest;

public interface UserService {

	public Integer registerUser(UserRequest userInfo) throws Exception;

	public UserInfo validateUser(@Valid LoginRequest userInfo);
}
