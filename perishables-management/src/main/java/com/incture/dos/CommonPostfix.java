package com.incture.dos;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class CommonPostfix {

	@Column(name = "CREATED_BY")
	private String  createdBy;

	@Column(name = "CREATED_AT")
	private Long createdAt;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_AT")
	private Long updatedAt;
}
