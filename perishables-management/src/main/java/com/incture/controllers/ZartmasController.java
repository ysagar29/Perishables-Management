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

import com.incture.dos.Zartmas;
import com.incture.dos.Zinventory;
import com.incture.service.ZartmasService;

@RestController
@RequestMapping("/Zartmas")
public class ZartmasController 
{
	@Autowired
	private ZartmasService services;

	@PostMapping("/saveOrUpdate")
	public void saveOrUpdate(@RequestBody Zartmas zartmas) {
		services.saveOrUpdate(zartmas);
	}

	@GetMapping("/findById/{id}")
	public Optional<Zartmas> findById(@PathVariable String id) {
		return services.findById(id);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable String id) {
		return services.deleteById(id);
	}

	@GetMapping("/list")
	public List<Zartmas> listAll() {
		return services.listAll();
	}

}
