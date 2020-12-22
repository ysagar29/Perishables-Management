package com.incture.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incture.dos.UserAuthDo;
import com.incture.dos.Zinventory;
import com.incture.service.UserAuthService;
import com.incture.service.ZinventoryService;

@RestController
@RequestMapping("/Zinventory")
public class ZinventoryController 
{

	@Autowired
	private ZinventoryService services;

	@PostMapping("/saveOrUpdate")
	public void saveOrUpdate(@RequestBody Zinventory zinventory) {
		services.saveOrUpdate(zinventory);
	}

	@GetMapping("/findByplant/{id}")
	public List<Zinventory> findByplant(@PathVariable String id) {
		return services.findByplant(id);
	}
	
	@GetMapping("/findBystorageLocation/{id}")
	public List<Zinventory> findBystorageLoc(@PathVariable String id) {
		return services.findBystorageLoc(id);
	}
	
	@GetMapping("/findByarticleNumber/{id}")
	public List<Zinventory> findByarticleNumber(@PathVariable String id) {
		return services.findByarticleNumber(id);
	}

	@DeleteMapping("/deleteByplant/{id}")
	public String deleteByplant(@PathVariable String id) {
		return services.deleteByplant(id);
	}
	
	@DeleteMapping("/deleteByStrorageLocation/{id}")
	public String deleteByStorageLocation(@PathVariable String id) {
		return services.deleteByStorage(id);
	}
	
	@DeleteMapping("/deleteByarticleNumber/{id}")
	public String deleteByarticleNumber(@PathVariable String id) {
		return services.deleteByarticleNumber(id);
	}
	

	@GetMapping("/list")
	public List<Zinventory> listAll() {
		return services.listAll();
	}
}
