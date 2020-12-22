package com.incture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.dos.UserAuthDo;

public interface UserAuthRepository extends JpaRepository<UserAuthDo, String>
{

	

}
