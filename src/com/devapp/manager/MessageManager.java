package com.devapp.manager;

import java.util.List;
import java.util.Map;

import com.devapp.domain.Post;
import com.devapp.http.ResponseHandler;

public interface MessageManager{

	/**
	 * 创建信息
	 */
	public void createMessage(Post post,final ResponseHandler<Integer , Exception> responseHandler);
	public void getPostMessages(Map<String,String> params,final ResponseHandler<List<Post> , Exception> responseHandler);

}
