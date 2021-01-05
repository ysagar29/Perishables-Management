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
public class ZcountComposite implements Serializable 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String articleNumber;
    
	private String plant;
	
	private String period;

}
