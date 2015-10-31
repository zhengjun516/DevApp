package com.devapp.manager.impl;

import java.util.Map;

import org.json.JSONObject;

import android.content.Context;
import android.os.Handler;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.Volley;
import com.devapp.DevAppConfig;
import com.devapp.http.MyJsonRequest;
import com.devapp.http.SimpleStringRequest;
import com.devapp.manager.BaseManager;

public class BaseManagerImpl implements BaseManager{
	
	protected static RequestQueue mVolleyQueue;
	
	public BaseManagerImpl() {
		if(mVolleyQueue == null){
			mVolleyQueue = Volley.newRequestQueue(DevAppConfig.appContext);
		}
	}

	public BaseManagerImpl(Context context) {
		
	}
	
	protected void requestByGet(String url, Map<String, String> params, Listener<String> listener, ErrorListener errorListener){
		request(Request.Method.GET, url, params, listener, errorListener);
	}
	
	protected void request(int method, String url, JSONObject jsonRequest, Listener<JSONObject> listener, ErrorListener errorListener){
		MyJsonRequest jsonObjectRequest = new MyJsonRequest(method,url,jsonRequest,listener,errorListener);
		jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		jsonObjectRequest.setTag(this.getClass().getSimpleName());	
		jsonObjectRequest.setPriority(Priority.NORMAL);
		mVolleyQueue.add(jsonObjectRequest);
	}
	
	protected void request(int method, String url, Map<String, String> params, Listener<String> listener, ErrorListener errorListener){
		SimpleStringRequest simpleStringRequest = new SimpleStringRequest(method,url,params,listener,errorListener);
		simpleStringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		simpleStringRequest.setTag(this.getClass().getSimpleName());	
		simpleStringRequest.setPriority(Priority.NORMAL);
		mVolleyQueue.add(simpleStringRequest);
	}
}
