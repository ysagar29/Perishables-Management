package com.incture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.incture.dos.UserAuthDo;
import com.incture.repository.UserAuthRepository;

@Service
public class UserAuthService {

	@Autowired
	private UserAuthRepository repo;

	public List<UserAuthDo> listAll() 
	{
		return repo.findAll();
	}

	public void saveOrUpdate(UserAuthDo user) 
	{
		repo.saveAndFlush(user);
	}

	public  Optional<UserAuthDo> findById(String id) 
	{
		return repo.findById(id);
	}
	
	public String deleteById(String id) 
	{
	repo.deleteById(id);
	return "deleted";
	}


}
