package com.devapp.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class IntentParam implements Serializable{
	public static final String KEY = "IntentParam";
	
	private Map<String,Object> data = new HashMap<String, Object>();
	
	public IntentParam put(String key,Object value){
		data.put(key, value);
		return this;
	}
	
	public Object get(String key){
		return data.get(key);
	}

}
