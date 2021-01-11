package com.incture.payload;

import org.springframework.web.bind.annotation.PathVariable;

public class CasefillUpPayload 
{
	private String articleNumber;  
	private String plant ;
	private String storageLocation;
	private String totalWeight;
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
