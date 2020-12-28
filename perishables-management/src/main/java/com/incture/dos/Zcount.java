package com.incture.dos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ZCOUNT")
@IdClass(Zcount.class)
public class Zcount  extends ZcountComposite
{
	
	@Id
	@Column(name = "ARTICLENUMBER")
	private String articleNumber;
	
	@Id
	@Column(name = "PLANT")
	private String plant;
	
	@Column(name = "DATE")
	private Date Date;
	
	@Column(name = "PERIOD")
	private String period;
	
	@Column(name = "Time")
	private String time;
	
	@Column(name = "UNITTIME")
	private int unitTime;
	
	@Column(name = "PEAK")
	private String peak;
	
	@Column(name = "OPTIMUM_QTY")
	private BigDecimal optimumQty;
	
	@Column(name = "SOLD_QTY")
	private BigDecimal soldQty;
	
	@Column(name = "BEGINNIG_BOH_QTY")
	private BigDecimal beginningBOHQty;
	
	@Column(name = "SCANNED_QTY")
	private BigDecimal scannedQty;
	
	@Column(name = "FORECAST_QTY")
	private BigDecimal forecastQty;
	
	@Column(name = "PROJECTED_BOH_QTY")
	private BigDecimal projectedBOHQty;
	
	@Column(name = "PROJECTED_REQ_QTY")
	private BigDecimal projectedReqQty;
	
	@Column(name = "REORDER_Pt")
	private BigDecimal reorderPt;
	
	@Column(name = "UNIT_QTY")
	private int unitQty;
	
	@Column(name = "REPLEN_INDICATOR")
	private String replenIndicator;
	
	@Column(name = "STORAGE_LOCATION")
	private String storageLocation;
	
	@Column(name =  "REPLEN_REQ_QTY")
	private int replenRequiredQuantity;
}
