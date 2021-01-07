package com.incture.response;

import java.math.BigDecimal;

import javax.persistence.Column;

public class ItemDetailsResponse {

	private String materialGroupDesc;
	
	private BigDecimal totWeight;
	
	private String unitofWeight;//MEINS2

	private String materialDesc;
	
	private String articleNumber;

	private String vendorAccNumber;
	
	private BigDecimal minSafetyStck;

	private String minSafetyStckUnit;//MEINS1
	
	private BigDecimal totValuatedStck;
	
    private BigDecimal valTotValuatedStck;
	
	private String valTotValuatedStckUnit;

	public String getMaterialGroupDesc() {
		return materialGroupDesc;
	}

	public void setMaterialGroupDesc(String materialGroupDesc) {
		this.materialGroupDesc = materialGroupDesc;
	}

	public BigDecimal getTotWeight() {
		return totWeight;
	}

	public void setTotWeight(BigDecimal totWeight) {
		this.totWeight = totWeight;
	}

	public String getUnitofWeight() {
		return unitofWeight;
	}

	public void setUnitofWeight(String unitofWeight) {
		this.unitofWeight = unitofWeight;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
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

	public String getMinSafetyStckUnit() {
		return minSafetyStckUnit;
	}

	public void setMinSafetyStckUnit(String minSafetyStckUnit) {
		this.minSafetyStckUnit = minSafetyStckUnit;
	}

	public BigDecimal getTotValuatedStck() {
		return totValuatedStck;
	}

	public void setTotValuatedStck(BigDecimal totValuatedStck) {
		this.totValuatedStck = totValuatedStck;
	}

	public BigDecimal getValTotValuatedStck() {
		return valTotValuatedStck;
	}

	public void setValTotValuatedStck(BigDecimal valTotValuatedStck) {
		this.valTotValuatedStck = valTotValuatedStck;
	}

	public String getValTotValuatedStckUnit() {
		return valTotValuatedStckUnit;
	}

	public void setValTotValuatedStckUnit(String valTotValuatedStckUnit) {
		this.valTotValuatedStckUnit = valTotValuatedStckUnit;
	}
	
	

}
/*import java.math.BigDecimal;

import javax.persistence.Column;

public class ItemDetailsResponse {

	private String materialGroupDesc;
	
	private BigDecimal totWeight;
	
	private String unitofWeight;//MEINS2

	private String materialDesc;
	
	private String articleNumber;

	private String vendorAccNumber;
	
	private BigDecimal minSafetyStck;

	private String minSafetyStckUnit;//MEINS1
	
	private BigDecimal totValuatedStck;
	
	public String getMaterialGroupDesc() {
		return materialGroupDesc;
	}

	public void setMaterialGroupDesc(String materialGroupDesc) {
		this.materialGroupDesc = materialGroupDesc;
	}

	public BigDecimal getTotWeight() {
		return totWeight;
	}

	public void setTotWeight(BigDecimal totWeight) {
		this.totWeight = totWeight;
	}

	public String getUnitofWeight() {
		return unitofWeight;
	}

	public void setUnitofWeight(String unitofWeight) {
		this.unitofWeight = unitofWeight;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
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

	public String getMinSafetyStckUnit() {
		return minSafetyStckUnit;
	}

	public void setMinSafetyStckUnit(String minSafetyStckUnit) {
		this.minSafetyStckUnit = minSafetyStckUnit;
	}

	public BigDecimal getTotValuatedStck() {
		return totValuatedStck;
	}

	public void setTotValuatedStck(BigDecimal totValuatedStck) {
		this.totValuatedStck = totValuatedStck;
	}

	public BigDecimal getValoftotalvaluatedstck() {
		return valoftotalvaluatedstck;
	}

	public void setValoftotalvaluatedstck(BigDecimal valoftotalvaluatedstck) {
		this.valoftotalvaluatedstck = valoftotalvaluatedstck;
	}

	public String getValoftotalvaluatedstckunit() {
		return valoftotalvaluatedstckunit;
	}

	public void setValoftotalvaluatedstckunit(String valoftotalvaluatedstckunit) {
		this.valoftotalvaluatedstckunit = valoftotalvaluatedstckunit;
	}

	private BigDecimal valoftotalvaluatedstck;
	
	private String  valoftotalvaluatedstckunit;//MEINS UNIT OF CURRENCY
	
	
}*/