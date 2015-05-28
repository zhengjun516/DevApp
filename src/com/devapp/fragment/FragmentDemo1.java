package com.devapp.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devapp.R;
import com.devapp.activity.base.BaseFragment;
import com.devapp.utils.AppLog;

public class FragmentDemo1 extends BaseFragment {
	private static final String TAG = "CustomFragment1";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppLog.i(TAG, "onCreate");
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		AppLog.i(TAG, "onViewCreated");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		AppLog.i(TAG, "onActivityCreated");
	}

	@Override
	public void onResume() {
		super.onResume();
		AppLog.i(TAG, "onResume");
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		AppLog.i(TAG, "onAttach");
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		AppLog.i(TAG, "onConfigurationChanged");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		AppLog.i(TAG, "onCreateView");
		return inflater.inflate(R.layout.fragment_demo1,container,false);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		AppLog.i(TAG, "onDestroy");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		AppLog.i(TAG, "onDestroyView");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		AppLog.i(TAG, "onDetach");
	}

	@Override
	public void onPause() {
		super.onPause();
		AppLog.i(TAG, "onPause");
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		AppLog.i(TAG, "onSaveInstanceState");
	}

	@Override
	public void onStart() {
		super.onStart();
		AppLog.i(TAG, "onStart");
	}

	@Override
	public void onStop() {
		super.onStop();
		AppLog.i(TAG, "onStop");
	}

	@Override
	public void onViewStateRestored(Bundle savedInstanceState) {
		super.onViewStateRestored(savedInstanceState);
		AppLog.i(TAG, "onViewStateRestored");
	}
	
	

}
