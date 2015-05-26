package com.devapp.domain;

import java.io.Serializable;
import java.util.HashMap;

public class BaseData implements Serializable{
	
	public int currentCategoryId = -1;
	
	/**
	 * 包含所有的name - values
	 */
	protected HashMap<String, String> nameValues = new HashMap<String, String>();
	
	public String getValue(String key){
		if(nameValues!=null&&nameValues.size()>0){
			return	nameValues.get(key);
		}
		return null;
	}
	
}
