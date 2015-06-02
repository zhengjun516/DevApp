package com.devapp.service;

import java.util.Map;

import com.devapp.domain.User;
import com.devapp.http.ResponseHandler;

public interface UserService extends BaseService {
	
	public void login(User user,final ResponseHandler<User, Exception> responseHandler);
	public void login(Map<String, String> params,ResponseHandler<User, Exception> responseHandler);
	public void getUserInfo(String uid,final ResponseHandler<User, Exception> responseHandler);
	public void register(User user,final ResponseHandler<User, Exception> responseHandler);
	public void register(Map<String, String> params,ResponseHandler<User, Exception> responseHandler);
}
