package com.devapp.activity.common;

import android.os.Bundle;
import android.os.Handler;

import com.devapp.activity.base.BaseActivity;
import com.devapp.activity.bottomtab.MainTabActivity;
import com.devapp.utils.ActivityUtils;

public class LaunchActivity extends BaseActivity {
	
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				ActivityUtils.startActivity(LaunchActivity.this, MainTabActivity.class);
				finish();
			}
		}, 1000);
	}
}
