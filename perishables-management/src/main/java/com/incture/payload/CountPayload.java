package com.incture.payload;

import java.util.Date;

public class CountPayload {

	private String articleNumber;  
	private String plant ;
	private String storageLocation;
	private String totalWeight;
	
     private  String period;
   private   Date date;
  private    String soldQuantityInLastPeriod;
     
	
	
	
	public String getPeriod() {
	return period;
}
public void setPeriod(String period) {
	this.period = period;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getSoldQuantityInLastPeriod() {
	return soldQuantityInLastPeriod;
}
public void setSoldQuantityInLastPeriod(String soldQuantityInLastPeriod) {
	this.soldQuantityInLastPeriod = soldQuantityInLastPeriod;
}
	public String getArticleNumber() {
		return articleNumber;
	}
	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getStorageLocation() {
		return storageLocation;
	}
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	public String getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}
	
	

}
