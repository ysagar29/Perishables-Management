package com.incture.response;

import java.math.BigDecimal;

public class ZartmasResponse {
	
	    private String articleNumber;
		
		private String materialType;
		
		private String materialGroup;
		
		private String baseUnitofMeasure;
	
		private String materialDesc;
		
		private BigDecimal minRemainShelfLife;
		
		private BigDecimal totalShelfLife ;
		
		private char periodIndicatorShelfLifeExpDate;
		
		private String materialGroupDesc;
		
		private byte[] productImage;
		
		public String getArticleNumber() {
			return articleNumber;
		}

		public void setArticleNumber(String articleNumber) {
			this.articleNumber = articleNumber;
		}

		public String getMaterialType() {
			return materialType;
		}

		public void setMaterialType(String materialType) {
			this.materialType = materialType;
		}

		public String getMaterialGroup() {
			return materialGroup;
		}

		public void setMaterialGroup(String materialGroup) {
			this.materialGroup = materialGroup;
		}

		public String getBaseUnitofMeasure() {
			return baseUnitofMeasure;
		}

		public void setBaseUnitofMeasure(String baseUnitofMeasure) {
			this.baseUnitofMeasure = baseUnitofMeasure;
		}

		public String getMaterialDesc() {
			return materialDesc;
		}

		public void setMaterialDesc(String materialDesc) {
			this.materialDesc = materialDesc;
		}

		public BigDecimal getMinRemainShelfLife() {
			return minRemainShelfLife;
		}

		public void setMinRemainShelfLife(BigDecimal minRemainShelfLife) {
			this.minRemainShelfLife = minRemainShelfLife;
		}

		public BigDecimal getTotalShelfLife() {
			return totalShelfLife;
		}

		public void setTotalShelfLife(BigDecimal totalShelfLife) {
			this.totalShelfLife = totalShelfLife;
		}

		public char getPeriodIndicatorShelfLifeExpDate() {
			return periodIndicatorShelfLifeExpDate;
		}

		public void setPeriodIndicatorShelfLifeExpDate(char periodIndicatorShelfLifeExpDate) {
			this.periodIndicatorShelfLifeExpDate = periodIndicatorShelfLifeExpDate;
		}

		public String getMaterialGroupDesc() {
			return materialGroupDesc;
		}

		public void setMaterialGroupDesc(String materialGroupDesc) {
			this.materialGroupDesc = materialGroupDesc;
		}

		public byte[] getProductImage() {
			return productImage;
		}

		public void setProductImage(byte[] productImage) {
			this.productImage = productImage;
		}

		
	}

