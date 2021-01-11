package com.incture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.dos.Zinvencomposite;
import com.incture.dos.Zinventory;

public interface ZinventoryRepository extends JpaRepository<Zinventory, Zinvencomposite> {

	
	public List<Zinventory> findByarticleNumber(String artcielNumber);
	public List<Zinventory> findByplant(String plant);
	public List<Zinventory> findBystorageLoc(String storageLoc);
	public  List<Zinventory> findByArticleNumberAndPlantAndStorageLoc(String articleNumber,String plant,String storageLoc);
	
	//public List<Zinventory>();
	public String deleteByarticleNumber(String articleNumber);
	public String deleteByplant(String plant);
	public String deleteBystorageLoc(String storageLoc);



}
