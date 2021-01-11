package com.incture.payload;

import java.util.Date;

import lombok.Data;


@Data
public class CountPayload {

	private String articleNumber;  
	private String plant ;
	private String storageLocation;
	private String totalWeight;
	
     private  String period;
   private   Date date;
  private    String soldQuantityInLastPeriod;
     
	
	
	

	

}
