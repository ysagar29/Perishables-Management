package com.incture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.incture.dos.Zartmas;

public interface ZartmasRepository  extends JpaRepository<Zartmas, String>{

}
