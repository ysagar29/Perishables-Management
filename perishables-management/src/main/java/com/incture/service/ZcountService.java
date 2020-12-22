package com.incture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.dos.Zcount;
import com.incture.repository.ZcountRepository;

@Service
public class ZcountService 
{

	@Autowired
	private ZcountRepository repo;

	public List<Zcount> listAll() 
	{
		return repo.findAll();
	}

	public void saveOrUpdate(Zcount zcount) {
		// TODO Auto-generated method stub
		repo.saveAndFlush(zcount);
	}

	public  List<Zcount> findByarticleNumber(String id) {
		// TODO Auto-generated method stub
		return repo.findByarticleNumber(id);
	}
	
	public  List<Zcount> findByplant(String id) {
		// TODO Auto-generated method stub
		return repo.findByplant(id);
	}
	
	public String deleteByplant(String id) {
	repo.deleteByplant(id);
				return "deleted";
	}
	
	public String deleteByarticleNumber(String id) {	
		repo.deleteByarticleNumber(id);
					return "deleted";
		}
}
