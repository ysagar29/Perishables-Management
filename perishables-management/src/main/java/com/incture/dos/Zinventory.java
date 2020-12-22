package com.incture.dos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@Table(name = "ZINVENTORY")
@EqualsAndHashCode(callSuper = false)
@IdClass(Zinventory.class)
public class Zinventory extends Zinvencomposite
{
	@Id
	@Column(name = "ARTICLE_NUMBER")
	private String articleNumber;
	
	@Id
	@Column(name = "PLANT")
	private String plant;
	
	@Id
	@Column(name = "STORAGE_LOCATION")
	private String storageLoc;

	@Column(name = "STANDARD_PRICE")
	private BigDecimal stndPrice;
	
	@Column(name = "PRICE_UNIT")
	private BigDecimal priceUnit;
	
	@Column(name = "CURRENT_PERIOD")
	private int currPeriod;
	
	@Column(name = "MIN_SAFETY_STOCK")
	private BigDecimal minSafetyStck;
	
	@Column(name = "TOTAL_VALUATED_STOCK")
	private BigDecimal totValuatedStck;
	
	@Column(name = "UNIT_OF_QTY")
	private int unitQty;
	
	@Column(name = "TOTAL_WEIGHT")
	private BigDecimal totWeight;
	
	@Column(name = "UNIT_OF_WEIGHT")
	private int unitWeight;
	
	@Column(name = "VALUE_TOT_VALUATED_STCK")
	private BigDecimal valTotValuatedStck;
	
	@Column(name = "UNIT_OF_CURRENCY")
	private int unitCurrency;
	
	
}
