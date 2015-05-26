package com.devapp.utils;

import java.io.Serializable;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;

import com.devapp.activity.base.BaseActivity;

public class ActivityUtils {
	
	public static void startActivity(BaseActivity activity,Class clazz){
		Intent intent = new Intent(activity,clazz);
		activity.startActivity(intent);
	}
	
	public static void startActivity(BaseActivity activity,Class clazz,Map<String,Object> params){
		Intent intent = new Intent(activity,clazz);
		if(!MyObjectUtils.isEmptyObject(params)){
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Integer){
					intent.putExtra(key, (Integer)params.get(key));
				}else if(params.get(key) instanceof String){
					intent.putExtra(key, (String)params.get(key));
				}else if(params.get(key) instanceof Boolean){
					intent.putExtra(key, (Boolean)params.get(key));
				}else if(params.get(key) instanceof Serializable){
					intent.putExtra(key, (Serializable)params.get(key));
				}

	        }
		}
		activity.startActivity(intent);
	}
	
	public static void startActivityForResult(BaseActivity activity,Class clazz,int requestCode){
		Intent intent = new Intent(activity,clazz);
		activity.startActivityForResult(intent, requestCode);
	}
	
	public static void startActivityForResult(BaseActivity activity,Class clazz,int requestCode,Bundle bundle){
		Intent intent = new Intent(activity,clazz);
		activity.startActivityForResult(intent, requestCode, bundle);
	}


}
