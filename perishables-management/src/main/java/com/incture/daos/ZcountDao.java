package com.incture.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.dos.Zcount;

public interface ZcountDao extends JpaRepository<Zcount, String> {
}
