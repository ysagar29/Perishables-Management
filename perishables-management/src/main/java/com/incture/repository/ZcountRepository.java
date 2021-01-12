package com.incture.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.dos.Zcount;
import com.incture.dos.ZcountComposite;

public interface ZcountRepository extends JpaRepository<Zcount, ZcountComposite> 
{
public List<Zcount> findByplant(String plant);
public List<Zcount> findByarticleNumber(String articleNumber);
public List<Zcount> findByArticleNumberAndPeriod(String articleNumber,String period);
//@Query("SELECT z FROM Zcount z WHERE z.articleNumber=?1 AND z.plant=?2 AND z.date LIKE ?3%")
public List<Zcount> findByArticleNumberAndPlantAndDate(String articleNumber,String plant,Date date);
public String deleteByplant(String plant);
public String deleteByarticleNumber(String articleNumber);
}
