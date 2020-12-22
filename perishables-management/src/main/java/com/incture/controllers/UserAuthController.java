package com.incture.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incture.dos.UserAuthDo;
import com.incture.service.UserAuthService;

@RestController
@RequestMapping("/user")
public class UserAuthController 
{
	@Autowired
	private UserAuthService services;

	@PostMapping("/saveOrUpdate")
	public void saveOrUpdate(@RequestBody UserAuthDo user) {
		services.saveOrUpdate(user);
	}

	@GetMapping("/findById/{id}")
	public Optional<UserAuthDo> findById(@PathVariable String id) {
		return services.findById(id);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable String id) {
		return services.deleteById(id);
	}

	@GetMapping("/list")
	public List<UserAuthDo> listAll() {
		return services.listAll();
	}

	@GetMapping("/hi")
	public String hi() {
		return "Hi Laksh!!";
	}
	

}
