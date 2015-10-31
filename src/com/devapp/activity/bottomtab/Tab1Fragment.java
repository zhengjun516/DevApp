package com.devapp.activity.bottomtab;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.Response.Listener;
import com.devapp.R;
import com.devapp.activity.base.BaseFragment;
import com.devapp.domain.Article;
import com.devapp.manager.ArticleManager;
import com.devapp.utils.ManagerFactory;


/**
 * 
 * @author zhengjun1
 */
	
public class Tab1Fragment extends BaseFragment implements OnItemClickListener {


	private ArticleManager mArticleManager;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();
		initData();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_together, null);
	}

	@Override
	public void onResume() {
		super.onResume();
	}
	
	
	 private void initView() {
		
	 }
	
	private void initData() {
		mArticleManager = (ArticleManager) ManagerFactory.getManager(ManagerFactory.ARTICLE_MANAGER);

		mArticleManager.getArticles(new Listener<List<Article>>() {

			@Override
			public void onResponse(List<Article> response) {
				
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		   
	}

}
