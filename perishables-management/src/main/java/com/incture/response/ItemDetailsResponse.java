package com.incture.response;

import java.math.BigDecimal;

import javax.persistence.Column;

public class ItemDetailsResponse {

	private String materialGroupDesc;
	
	private String articleNumber;
	
	private String vendorAccNumber;
	
	private BigDecimal minSafetyStck;
	
	private BigDecimal totValuatedStck;

	public String getMaterialGroupDesc() {
		return materialGroupDesc;
	}

	public void setMaterialGroupDesc(String materialGroupDesc) {
		this.materialGroupDesc = materialGroupDesc;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getVendorAccNumber() {
		return vendorAccNumber;
	}

	public void setVendorAccNumber(String vendorAccNumber) {
		this.vendorAccNumber = vendorAccNumber;
	}

	public BigDecimal getMinSafetyStck() {
		return minSafetyStck;
	}

	public void setMinSafetyStck(BigDecimal minSafetyStck) {
		this.minSafetyStck = minSafetyStck;
	}

	public BigDecimal getTotValuatedStck() {
		return totValuatedStck;
	}

	public void setTotValuatedStck(BigDecimal totValuatedStck) {
		this.totValuatedStck = totValuatedStck;
	}

	
}
