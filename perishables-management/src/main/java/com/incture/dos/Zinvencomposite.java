package com.incture.dos;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Zinvencomposite implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3687280181364334439L;

	private String articleNumber;
	
	private String plant;
	
	private String storageLoc;

	
}
