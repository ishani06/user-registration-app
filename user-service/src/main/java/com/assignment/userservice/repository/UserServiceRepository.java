package com.assignment.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.userservice.entity.UserInfo;

public interface UserServiceRepository extends JpaRepository<UserInfo, Integer>{

	@Query("select u from UserInfo u where u.username = :username")
	UserInfo findByUsername(String username);
}
