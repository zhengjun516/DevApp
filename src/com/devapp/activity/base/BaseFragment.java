package com.devapp.activity.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.devapp.R;

/**
 * 
 * @author zhengjun1
 *
 */
public class BaseFragment extends Fragment{
	
	/*标题栏中的控件*/
	protected TextView mLeftBtn;
	protected TextView mRightBtn;
	protected TextView mTitleText;
	
	protected BaseActivity mParentActivity;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(this.isRemoving()){
			return;
		}
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mParentActivity = (BaseActivity) getActivity();
	}

	@Override
	public void onResume() {
		super.onResume();
		if(getView().findViewById(R.id.mTitleBar) != null){
			mLeftBtn = (TextView)getView().findViewById(R.id.mLeftBtn);
			mRightBtn = (TextView)getView().findViewById(R.id.mRightBtn);
			mTitleText = (TextView)getView().findViewById(R.id.mTitleText);
			
			mLeftBtn.setVisibility(View.GONE);
		}
	}
	
	
	

}
