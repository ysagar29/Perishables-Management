package com.incture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.incture.dos.Zartmas;

public interface ZartmasServiceInterface {
	
	public List<Zartmas> listAll();
	
	public ResponseEntity<?> saveOrUpdate(Zartmas zartmas);
	
	public  Optional<Zartmas> findById(String id);
	
	public String deleteById(String id);

}
