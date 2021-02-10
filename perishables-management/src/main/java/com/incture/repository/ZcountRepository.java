package com.incture.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.incture.dos.Zcount;
import com.incture.dos.ZcountComposite;

public interface ZcountRepository extends JpaRepository<Zcount, ZcountComposite> 
{
public List<Zcount> findByplant(String plant);
public List<Zcount> findByarticleNumber(String articleNumber);
public List<Zcount> findByArticleNumberAndPeriod(String articleNumber,String period);

public List<Zcount> findByArticleNumberAndPlantAndDate(String articleNumber,String plant,Date date);

@Query("SELECT z FROM Zcount z WHERE z.articleNumber=?1 AND z.plant=?2 AND z.period=?3 AND z.date=?4 order by z.scannedDate desc")
public Zcount findByArticleNumberAndPlantAndSortedDate(String articleNumber,String plant,String period,Date date);
public String deleteByplant(String plant);
public String deleteByarticleNumber(String articleNumber);
}
