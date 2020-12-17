package com.incture.dos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "USER_AUTH")
@EqualsAndHashCode(callSuper = false)
public class UserAuthDo extends CommonPostfix {

	@Id
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "AUTHORIZATION_GRANTED")
	private String authorizationGranted;

}
