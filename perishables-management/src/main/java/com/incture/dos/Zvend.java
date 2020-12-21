package com.incture.dos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "ZVEND")
public class Zvend extends ZvendComposite
{
	@Id
	@Column(name = "ARTICLE_NUMBER")
	private String articleNumber;
	
	@Id
	@Column(name = "PLANT")
	private String plant;
	
	@Column(name = "SOURCELIST_RECORD_VALID_FROM")
	private Date sourceListRecordValidFrom;
	
	@Column(name = "SOURCELIST_RECORD_VALID_TO")
	private Date sourceListRecordValidTo;
	
	@Column(name = "VENDOR_ACC_NUMBER")
	private String vendorAccNumber;
	
}

