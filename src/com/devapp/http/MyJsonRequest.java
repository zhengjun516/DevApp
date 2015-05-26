package com.devapp.http;

import org.json.JSONObject;

import com.android.volley.Request.Priority;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;

public class MyJsonRequest extends JsonObjectRequest{

	private Priority priority = Priority.NORMAL;
	
	public MyJsonRequest(int method, String url, JSONObject jsonRequest,
			Listener<JSONObject> listener, ErrorListener errorListener) {
		super(method, url, jsonRequest, listener, errorListener);
	}

	
	
	@Override
	public Priority getPriority() {
		return priority;
	}
	
	public void setPriority(Priority priority){
		this.priority = priority;
	}
	
}
