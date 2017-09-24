package com.bridgeit.HemanthJava.Utility;

import java.util.Comparator;

import org.json.simple.JSONObject;

public class LastNameComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		JSONObject json1=(JSONObject)o1;  
		JSONObject json2=(JSONObject)o2;  
		  
		return (json1.get("LastName").toString()).compareTo(json2.get("LastName").toString());
	}

}
