package com.incture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.dos.Zartmas;
import com.incture.repository.ZartmasRepository;
import com.incture.repository.ZinventoryRepository;

@Service
public class ZartmasService 
{
	@Autowired
	private ZartmasRepository repo;

	public List<Zartmas> listAll() 
	{
		return repo.findAll();
	}
	
	
	public void saveOrUpdate(Zartmas zartmas) {
		// TODO Auto-generated method stub
		repo.saveAndFlush(zartmas);
	}
	
	public  Optional<Zartmas> findById(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	
	
	public String deleteById(String id) {
		
	repo.deleteById(id);
				return "deleted";
	}

	

}
