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

	private String materialDesc;
	
	private String articleNumber;

}
