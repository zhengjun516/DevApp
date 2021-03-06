package com.devapp.manager.impl;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.devapp.domain.User;
import com.devapp.http.ErrorInfo;
import com.devapp.http.UrlConfig;
import com.devapp.http.ResponseHandler;
import com.devapp.manager.UserManager;

public class UserManagerImpl extends BaseManagerImpl implements UserManager {
	
	public UserManagerImpl(Context context) {
		super(context);
	}

	public void login(User user,final ResponseHandler<User, Exception> responseHandler) {
		String userInfo = JSON.toJSONString(user);
		if (TextUtils.isEmpty(userInfo)) {
			return;
		}

		String url = UrlConfig.baseUrl+"v1/user/login.do";
		Uri.Builder builder = Uri.parse(url).buildUpon();

		Map<String, String> params = new HashMap<String, String>();
		params.put("userInfo", userInfo);

		request(Request.Method.POST, url, params, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				/*
				 操作成功:状态码是200，且处理逻辑正确
				 * */
				User user = new User();
				responseHandler.onSuccess(ErrorInfo.SUCCESS, user,null);
				
				/*
				    操作失败：请求状态码是200，但是处理逻辑错误
				 * */
				ErrorInfo error = new ErrorInfo();
				responseHandler.onSuccess(error.code, null,error);
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				/*
				 * 异常：400系列错误、500系列错误、请求超时错误等
				 */
				responseHandler.onError(error);
			}
		});
	}
	
	@Override
	public void login(Map<String, String> params,ResponseHandler<User, Exception> responseHandler) {
		
	}

	public void register(User user,final ResponseHandler<User, Exception> responseHandler) {
		
	}
	

	@Override
	public void register(Map<String, String> params,ResponseHandler<User, Exception> responseHandler) {
		
	}

	@Override
	public void getUserInfo(String uid,ResponseHandler<User, Exception> responseHandler) {
		
	}

}
