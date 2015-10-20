package com.devapp.service.impl;

import java.util.List;
import java.util.Map;

import android.net.Uri;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.devapp.domain.Article;
import com.devapp.http.UrlConfig;
import com.devapp.service.ArticleService;

public class ArticleServiceImpl extends BaseServiceImpl implements ArticleService{
	
	public ArticleServiceImpl() {
		
	}
	
	public void getArticles(final Listener<List<Article>> listener,final ErrorListener errorListener){
		String url = UrlConfig.hostCurrent+"/articles";
		Uri.Builder builder = Uri.parse(url).buildUpon();
		
		requestByGet(builder.toString(), null, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				
			}
		});
	}
}
