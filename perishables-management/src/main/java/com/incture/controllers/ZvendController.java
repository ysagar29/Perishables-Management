package com.incture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incture.dos.Zvend;
import com.incture.service.ZvendServices;

@RestController
@RequestMapping("/zvend")
public class ZvendController 
{

	@Autowired
	private ZvendServices services;

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(@RequestBody Zvend zvend) {
		return services.saveOrUpdate(zvend);
		
	}

	@GetMapping("/findById/{id}")
	public List<Zvend> findById(@PathVariable String id) {
		return services.findByIdarticle(id);
	}

	@DeleteMapping("/deleteByarticleNumber/{id}")
	public String deleteByarticleNumber(@PathVariable String id) {
	return services.deleteByarticleNumber(id);
	}
	
	@DeleteMapping("/deleteByplant/{plant}")
	public String deleteByplant(@PathVariable String plant) {
	return services.deleteByplant(plant);
	}

	@GetMapping("/list")
	public List<Zvend> listAll() {
		return services.listAll();
	}
	
	@GetMapping("/findByIdPlant/{plant}")
	public List<Zvend> findByIdPlant(@PathVariable String plant){
		return services.findByIdplant(plant);
	}

	

}
