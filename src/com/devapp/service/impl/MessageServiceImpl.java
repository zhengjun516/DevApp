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
import com.devapp.http.ResponseHandler;
import com.devapp.http.SimpleStringRequest;
import com.devapp.service.IMessageService;
import com.devapp.utils.CacheUtils;
import com.devapp.utils.MyObjectUtils;

public class MessageServiceImpl extends BaseServiceImpl implements IMessageService{

	public MessageServiceImpl(Context context) {
		super(context);
	}
	
	/**
	 * 创建信息
	 */
	public void createMessage(Post post,final ResponseHandler<Integer , Exception> responseHandler){
		if(MyObjectUtils.isEmptyObject(post)){
			return;
		}
		
		User user = CacheUtils.user;
		if(MyObjectUtils.isEmptyObject(user)){
              return;
		}
		
		post.setUserId(user.id);
		post.setSchoolNumber(user.schoolId);
		
		String url = host+"v1/message/create.do";
		Uri.Builder builder = Uri.parse(url).buildUpon();
		String messageStr = JSON.toJSONString(post);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("message", messageStr);
		
	    SimpleStringRequest simpleStringRequest = new SimpleStringRequest(Request.Method.POST, builder.toString(), params, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				Message msg = handler.obtainMessage();
				msg.what = 1;
				handler.sendMessage(msg);
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				
			}
		});
		simpleStringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		simpleStringRequest.setTag(this.getClass().getSimpleName());	
		simpleStringRequest.setPriority(Priority.NORMAL);
		mVolleyQueue.add(simpleStringRequest);
	}
	
	public void getPostMessages(Map<String,String> params,final ResponseHandler<List<Post> , Exception> responseHandler){
	
	}

}
