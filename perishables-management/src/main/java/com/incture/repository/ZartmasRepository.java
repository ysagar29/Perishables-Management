package com.incture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.dos.Zartmas;

public interface ZartmasRepository  extends JpaRepository<Zartmas, String>{

	
	List<Zartmas> findByMaterialGroupDesc(String materialGroupDesc);
	
}
