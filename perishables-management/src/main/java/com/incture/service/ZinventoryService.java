package com.incture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.dos.UserAuthDo;
import com.incture.dos.Zinventory;
import com.incture.repository.ZinventoryRepository;

@Service
public class ZinventoryService  
{

	@Autowired
	private ZinventoryRepository repo;

	
	public List<Zinventory> listAll() 
	{
		return repo.findAll();
	}
	

	public void saveOrUpdate(Zinventory zinventory) {
		// TODO Auto-generated method stub
		 zinventory.setValTotValuatedStck(zinventory.getStndPrice().multiply(zinventory.getTotWeight()));
		repo.saveAndFlush(zinventory);
	}

	public List<Zinventory> findByplant(String id) {
		return repo.findByplant(id);
	}

	public List<Zinventory> findBystorageLoc(String id) {
		return repo.findBystorageLoc(id);
	}

	public List<Zinventory> findByarticleNumber(String id) {
		return repo.findByarticleNumber(id);
	}

	public String deleteByplant(String id) {
		// TODO Auto-generated method stub
		repo.deleteByplant(id);
		return "deleted";
	}

	public String deleteByStorage(String id) {
		// TODO Auto-generated method stub
		repo.deleteBystorageLoc(id);
		return "deleted";
	}

	public String deleteByarticleNumber(String id) {
		// TODO Auto-generated method stub
		repo.deleteByarticleNumber(id);
		return "deleted";
	}

	
}
