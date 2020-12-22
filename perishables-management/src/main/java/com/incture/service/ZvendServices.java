package com.incture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.dos.UserAuthDo;
import com.incture.dos.Zvend;
import com.incture.dos.ZvendComposite;
import com.incture.repository.UserAuthRepository;
import com.incture.repository.ZvendRepository;

@Service
public class ZvendServices
{

	@Autowired
	private ZvendRepository repo;

	public List<Zvend> listAll() 
	{
		return repo.findAll();
	}

	public String saveOrUpdate(Zvend zvend) {
		repo.saveAndFlush(zvend);
		return "Saved";
	}

	public  List<Zvend> findByIdplant(String plant) {
		return repo.findByplant(plant);
	}
	
	public List<Zvend> findByIdarticle(String articlenumber) {
		return repo.findByarticleNumber(articlenumber);
	}

	public String deleteByarticleNumber(String id) {
		 deleteByarticleNumber(id);
		 return "deleted!!";
	}

	public String deleteByplant(String plant) {
		deleteByplant(plant);
		return "deleted!!";
	}


}
