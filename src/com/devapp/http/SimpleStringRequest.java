package com.devapp.http;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.devapp.utils.MyObjectUtils;


public class SimpleStringRequest extends StringRequest{
	private Priority priority = Priority.NORMAL;
	
	private Map<String, String> mParams = new HashMap<String, String>();
	private Map<String,String>  mHeaders = new HashMap<String, String>();
	
	//private static  ResponseHandler<String, VolleyError> responseHandler;
	/*private static Listener<String> listener = new Listener<String>() {
		@Override
		public void onResponse(String response) {
			responseHandler.onSuccess(200,response);
		}
	};*/
	
	/*private static ErrorListener errorListener = new ErrorListener() {

		@Override
		public void onErrorResponse(VolleyError error) {
			responseHandler.onError(error);
		}
	};
	*/
	/*public SimpleStringRequest(int method, String url,Map<String, String> params,ResponseHandler<String,VolleyError> responseHandler) {
		super(method, url, listener, errorListener);
		this.responseHandler = responseHandler;
		this.mParams = params;
		mHeaders.put("User-Agent", "android");
	}*/
	
	public SimpleStringRequest(int method, String url,Map<String, String> params,
			Listener<String> listener, ErrorListener errorListener) {
		super(method, url, listener, errorListener);
		this.mParams = params;
		mHeaders.put("User-Agent", "android");
	}

	public SimpleStringRequest(String url, Listener<String> listener,
			ErrorListener errorListener) {
		super(url, listener, errorListener);
	}

	@Override
	protected Map<String, String> getParams() throws AuthFailureError {
		return mParams;
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return mHeaders;
	}

	public void addHeaders(String key,String value){
		if(!MyObjectUtils.isEmptyObject(mHeaders)){
			mHeaders.put(key, value);
		}
	}
	
	public void addHeaders(Map<String, String> header){
		if(!MyObjectUtils.isEmptyObject(mHeaders) && !MyObjectUtils.isEmptyObject(header)){
			mHeaders.putAll(header);
		}
	}
	
	@Override
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
}
