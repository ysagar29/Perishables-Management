package com.incture.dos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ZINVENTORY")
@IdClass(Zinvencomposite.class)
public class Zinventory implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private String  priceUnit;
	
	@Column(name = "CURRENT_PERIOD")
	private int currPeriod;
	
	@Column(name = "MIN_SAFETY_STOCK")
	private BigDecimal minSafetyStck;
	
	@Column(name = "TOTAL_VALUATED_STOCK")
	private BigDecimal totValuatedStck;
	
	@Column(name = "UNIT_OF_QTY")
	private String unitQty;
	
	@Column(name = "TOTAL_WEIGHT")
	private BigDecimal totWeight;
	
	@Column(name = "WEIGHT_PER_UNIT")
	private BigDecimal weightPerUnit;

	@Column(name = "UNIT_OF_WEIGHT")
	private String unitWeight;
	
	@Column(name = "VALUE_TOT_VALUATED_STCK")
	private BigDecimal valTotValuatedStck;
	
	@Column(name = "UNIT_OF_CURRENCY")
	private String unitCurrency;
	
	
}
