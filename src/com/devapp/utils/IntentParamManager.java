package com.devapp.utils;

import java.util.HashMap;
import java.util.Map;

import com.devapp.domain.IntentParam;

public class IntentParamManager {
   private static Map<String,IntentParam> data =  new HashMap<String, IntentParam>();	
   
   public static void put(String key,IntentParam value){
	   data.put(key, value);
   }
   
   public static IntentParam get(String key){
	  return data.get(key);
   }
}
