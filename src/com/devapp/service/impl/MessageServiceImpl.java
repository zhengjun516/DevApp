package com.devapp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.net.Uri;
import android.os.Message;

import com.alibaba.fastjson.JSON;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.devapp.domain.Post;
import com.devapp.domain.User;
import com.devapp.http.API;
import com.devapp.http.ResponseHandler;
import com.devapp.http.SimpleStringRequest;
import com.devapp.service.MessageService;
import com.devapp.utils.CacheUtils;
import com.devapp.utils.MyObjectUtils;

public class MessageServiceImpl extends BaseServiceImpl implements MessageService{

	public MessageServiceImpl(Context context) {
		super(context);
	}
	
	/**
	 * 创建信息
	 */
	public void createMessage(Post post,final ResponseHandler<Integer , Exception> responseHandler){
		
	}
	
	public void getPostMessages(Map<String,String> params,final ResponseHandler<List<Post> , Exception> responseHandler){
	
	}

}
