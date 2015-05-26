package com.devapp.activity.base;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.devapp.R;

public class BaseActivity extends FragmentActivity{
	public static final String EXTRA_OPEN_ANIM_IN = "extra_open_anim_in";
	public static final String EXTRA_OPEN_ANIM_OUT = "extra_open_anim_out";
	public static final String EXTRA_CLOSE_ANIM_IN = "extra_close_anim_in";
	public static final String EXTRA_CLOSE_ANIM_OUT = "extra_close_anim_out";
	
	/**
	 * 默认Activity进出动画
	 */
	protected int mDefaultOpenAnimationIn = R.anim.activity_slide_in_right;
	
	
	/*标题栏中的控件*/
	protected TextView mLeftBtn;
	protected TextView mRightBtn;
	protected TextView mTitleText;
	
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 
		int openAnimInRes = getIntent().getIntExtra(EXTRA_OPEN_ANIM_IN, mDefaultOpenAnimationIn);
		if (openAnimInRes != -1) {
			int openAnimOutRes = getIntent().getIntExtra(EXTRA_OPEN_ANIM_OUT, R.anim.activity_no_anim);
			overridePendingTransition(openAnimInRes, openAnimOutRes);
		}
	}


	@Override
	protected void onResume() {
		super.onResume();
		if(findViewById(R.id.mTitleBar) != null){
			mLeftBtn = (TextView) findViewById(R.id.mLeftBtn);
			mRightBtn = (TextView) findViewById(R.id.mRightBtn);
			mTitleText = (TextView) findViewById(R.id.mTitleText);
			
			
			mLeftBtn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					onBackPressed();
				}
			});
		}
	}


	@Override
	public void onBackPressed() {
		super.onBackPressed();
		configCloseAnimation();
	}
	
	private void configCloseAnimation() {
		int closeAnimOutRes = getIntent().getIntExtra(EXTRA_CLOSE_ANIM_OUT, -1);
		if (closeAnimOutRes == -1) {
			// 如果未指定退出动画，则检查是否设置进入动画，如何设置了，则使用相对应的退出动画
			int openAnimInRes = getIntent().getIntExtra(EXTRA_OPEN_ANIM_IN, mDefaultOpenAnimationIn);
			if (openAnimInRes != -1) {
				if (openAnimInRes == R.anim.activity_push_up_in) {
					closeAnimOutRes = R.anim.activity_push_down_out;
				} else if (openAnimInRes == R.anim.activity_scale_in) {
					closeAnimOutRes = R.anim.activity_scale_out;
				} else if (openAnimInRes == R.anim.activity_slide_in_right) {
					closeAnimOutRes = R.anim.activity_slide_out_right;
				}
			}
		}
		
		if (closeAnimOutRes != -1) {
			int closeAnimInRes = getIntent().getIntExtra(EXTRA_CLOSE_ANIM_IN, R.anim.activity_no_anim);
			overridePendingTransition(closeAnimInRes, closeAnimOutRes);
		}
	}
	
	public void toast(String text){
		toast(text,0);
	}
	
	public void toast(String text,int duration){
		if(!TextUtils.isEmpty(text)){
			if(duration<0){
				duration = 0;
			}
			if(duration > 1){
				duration = 1;
			}
			Toast.makeText(this, text, duration).show();
		}
		
	}
	

}
