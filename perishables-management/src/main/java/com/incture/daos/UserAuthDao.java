package com.incture.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incture.dos.UserAuthDo;

@Repository
public interface UserAuthDao extends JpaRepository<UserAuthDo, String> {

}
