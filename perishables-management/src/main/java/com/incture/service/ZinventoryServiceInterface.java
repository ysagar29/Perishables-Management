package com.incture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.incture.dos.UserAuthDo;
import com.incture.dos.Zinventory;

public interface ZinventoryServiceInterface {

	 Optional<Zinventory> findById(String id);

	void  saveOrUpdate(Zinventory zineventory);
	
    String deleteById(String id);

	List<Zinventory>  listAll();

}
