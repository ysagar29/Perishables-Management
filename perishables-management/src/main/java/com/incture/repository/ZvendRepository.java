package com.incture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.dos.Zvend;
import com.incture.dos.ZvendComposite;

public interface ZvendRepository extends JpaRepository<Zvend,ZvendComposite> {

     public List<Zvend> findByplant(String plant);
     public List<Zvend> findByarticleNumber(String articleNumber);
     public String deleteByplant(String plant);
     public String deleteByarticleNumber(String articleNumber);
     
     //<Entity_Class_Column_Name>_<Embaded_Class_Column_Name>(...)

}
