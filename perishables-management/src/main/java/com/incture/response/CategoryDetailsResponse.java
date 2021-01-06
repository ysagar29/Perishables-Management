package com.incture.response;

public class CategoryDetailsResponse 
{
    private String materialGroupDesc;
	
	public String getMaterialGroupDesc() {
		return materialGroupDesc;
	}

	public void setMaterialGroupDesc(String materialGroupDesc) {
		this.materialGroupDesc = materialGroupDesc;
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

	public String getTotValuatedStck() {
		return totValuatedStck;
	}

	public void setTotValuatedStck(String totValuatedStck) {
		this.totValuatedStck = totValuatedStck;
	}

	public String getMinSafetyStck() {
		return minSafetyStck;
	}

	public void setMinSafetyStck(String minSafetyStck) {
		this.minSafetyStck = minSafetyStck;
	}

	public boolean isCriticalStckQtyCheck() {
		return criticalStckQtyCheck;
	}

	public void setCriticalStckQtyCheck(boolean criticalStckQtyCheck) {
		this.criticalStckQtyCheck = criticalStckQtyCheck;
	}

	public boolean isAvailableStckQtyCheck() {
		return true;
	}

	public void setAvailableStckQtyCheck(boolean availableStckQtyCheck) {
		this.availableStckQtyCheck = availableStckQtyCheck;
	}

	private String materialDesc;
	
	private String articleNumber;
	
	private String totValuatedStck;
	
	private String minSafetyStck;
	
	private boolean criticalStckQtyCheck ;
	
	private boolean availableStckQtyCheck;
	
	

}
