package com.devapp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import com.devapp.domain.Post;
import com.devapp.http.ResponseHandler;
import com.devapp.service.MessageService;

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
