package com.devapp.manager;

import java.util.List;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.devapp.domain.Article;

public interface ArticleManager extends BaseManager{
	public void getArticles(final Listener<List<Article>> listener,final ErrorListener errorListener);
}
