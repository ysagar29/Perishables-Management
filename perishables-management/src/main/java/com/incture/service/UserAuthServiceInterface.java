package com.incture.service;

import org.springframework.http.ResponseEntity;

import com.incture.dos.UserAuthDo;

public interface UserAuthServiceInterface {
	ResponseEntity<?> findById(String id);

	ResponseEntity<?> saveOrUpdate(UserAuthDo user);

	ResponseEntity<?> deleteById(String id);

	ResponseEntity<?> listAll();

	
}
