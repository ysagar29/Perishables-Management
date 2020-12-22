package com.incture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.dos.Zcount;
import com.incture.dos.ZcountComposite;

public interface ZcountRepository extends JpaRepository<Zcount, ZcountComposite> 
{
public List<Zcount> findByplant(String plant);
public List<Zcount> findByarticleNumber(String articleNumber);


public String deleteByplant(String plant);
public String deleteByarticleNumber(String articleNumber);
}
