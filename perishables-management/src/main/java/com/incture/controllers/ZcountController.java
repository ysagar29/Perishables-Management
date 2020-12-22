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

import com.incture.dos.Zcount;
import com.incture.dos.Zinventory;
import com.incture.service.ZcountService;

@RestController
@RequestMapping("/Zcount")
public class ZcountController 
{
	@Autowired
	private ZcountService services;

	@PostMapping("/saveOrUpdate")
	public void saveOrUpdate(@RequestBody Zcount zcount) {
		services.saveOrUpdate(zcount);
	}

	@GetMapping("/findByplant/{id}")
	public List<Zcount> findById(@PathVariable String id) {
		return services.findByplant(id);
	}
	
	@GetMapping("/findByarticleNumber/{id}")
	public List<Zcount> findByarticleNumber(@PathVariable String id) {
		return services.findByarticleNumber(id);
	}

	@DeleteMapping("/deleteByplant/{id}")
	public String deleteByplant(@PathVariable String id) {
		return services.deleteByplant(id);
	}
	
	@DeleteMapping("/deleteByarticleNumber/{id}")
	public String deleteByarticleNumber(@PathVariable String id) {
		return services.deleteByarticleNumber(id);
	}

	@GetMapping("/list")
	public List<Zcount> listAll() {
		return services.listAll();
	}

}
