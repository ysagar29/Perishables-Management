package com.incture.service;

import lombok.Data;

@Data
public class CaseFillUpDto {
	
	private String materialDescription ;
	
	private String standardPrice;
	
	private String boh; // totalValuatedStock
	
	private String articleNumber; 
	
	private String plant;
	
	private String storageLocation;
	

}
