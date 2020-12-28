package com.incture.utils;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh.mm.ss.S aa");
		String formattedDate = dateFormat.format(new Date()).toString();
		System.err.println(formattedDate);
		System.err.println("scannedDate "+new Date());
	
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		System.err.println(localTime.format(dateTimeFormatter).substring(6));
		
		    String hours   = localTime.format(dateTimeFormatter).substring(0,2);
		System.err.println("hours "+hours);
		
		int i = Integer.parseInt(hours);
		
		int j = 6;
		
		int k = 06;
		
		int result = i-j;
		
		
		System.err.println("result "+ result);
		
	if(6 == k ){
		
		int count = 1;
		
		
	}else {
		
	
	}
		
		int period =1;
		Date scannedDate = new Date(); 
		

	}

}
