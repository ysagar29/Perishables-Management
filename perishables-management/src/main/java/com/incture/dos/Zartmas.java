package com.incture.dos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "ZARTMAS")
//@IdClass(Zartmas.class)
public class Zartmas 
{
	@Id
	@Column(name = "ARTICLE_NUMBER")
	private String articleNumber;
	
	@Column(name = "MATERIAL_TYPE")
	private String materialType;
	
	@Column(name = "MATERIAL_GROUP")
	private String materialGroup;
	
	@Column(name = "BASE_UNIT_OF_MEASURE")
	private String baseUnitofMeasure;
	
	@Column(name = "MATERIAL_DESC")
	private String materialDesc;
	
	@Column(name = "MIN_REMAIN_SHELFLIFE")
	private BigDecimal minRemainShelfLife;
	
	@Column(name = "TOTAL_SHELFLIFE")
	private BigDecimal totalShelfLife ;
	
	@Column(name = "PERIOD_INDIC_SHELFLIFE_DATE")
	private char periodIndicatorShelfLifeExpDate;
	
	@Column(name="MATERIALGROUPDESC")
	private String materialGroupDesc;
	
	@Lob
	@Column(name = "PRODUCT_IMAGE")
	private byte[] productImage;
	
}


