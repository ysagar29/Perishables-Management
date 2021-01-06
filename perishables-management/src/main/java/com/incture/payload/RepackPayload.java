package com.incture.payload;

import java.math.BigDecimal;

public class RepackPayload 
{
	
	private String articleNumber;
	
	private BigDecimal totWeight;
	
	private String plant;
	
	private String storageLoc;
	
	public  String getArticleNumber() {
		return articleNumber;
	}
	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}
	public  BigDecimal getTotWeight() {
		return totWeight;
	}
	public void setTotWeight(BigDecimal totWeight) {
		this.totWeight = totWeight;
	}
	public  String getPlant() {
		return plant;
	}
	public  void setPlant(String plant) {
		this.plant = plant;
	}
	public  String getStorageLoc() {
		return storageLoc;
	}
	public  void setStorageLoc(String storageLoc) {
		this.storageLoc = storageLoc;
	}

}
