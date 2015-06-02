package com.devapp.service.impl;

import java.util.Map;

import org.json.JSONObject;

import android.content.Context;
import android.os.Handler;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request.Priority;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.Volley;
import com.devapp.http.MyJsonRequest;
import com.devapp.http.SimpleStringRequest;
import com.devapp.service.BaseService;

public class BaseServiceImpl implements BaseService{
	
	protected String testHost = "";
	protected static RequestQueue mVolleyQueue;
	protected static Context mContext;
	
	public static void init(Context context){
		mContext = context;
		if(mVolleyQueue == null){
			mVolleyQueue = Volley.newRequestQueue(mContext);
		}
	}
	
	public BaseServiceImpl() {
	}

	public BaseServiceImpl(Context context) {
		
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
