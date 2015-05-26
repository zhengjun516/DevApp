package com.devapp.activity.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;
import com.devapp.activity.base.BaseFragment;
import com.devapp.service.IMessageService;
import com.devapp.utils.ServiceFactory;

public class BBSFragment extends BaseFragment {

	public ListView mItems;
	
	private BaseActivity baseActivity;
	private IMessageService messageService;
	
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
		baseActivity = (BaseActivity) getActivity();
		
		//获取服务
		//messageService = (IMessageService) ServiceFactory.getService(ServiceFactory.MESSAGE_SERVICE, baseActivity);
		messageService = ServiceFactory.getMessageService(baseActivity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_bbs, null);
	}

	@Override
	public void onResume() {
		super.onResume();
	}
}
