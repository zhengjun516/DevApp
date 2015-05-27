package com.devapp.activity.bottomtab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;
import com.devapp.activity.base.BaseFragment;
import com.devapp.domain.Post;
import com.devapp.utils.ActivityUtils;
import com.devapp.utils.MyObjectUtils;
import com.devapp.widget.AbstractAdapterOnClickListenerAdapterView;



/**
 * 侃侃
 * @author zhengjun1
 *
 */
	
public class Tab1Fragment extends BaseFragment {
	
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
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_talk, null);
	}

	@Override
	public void onResume() {
		super.onResume();
		
	}
	
	
	
	class OnMyClickListener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch(v.getId()){
			  case R.id.mRightBtn:
				break;
			}
		}
	}
	
	
	class OnMyItemClickListenr implements OnItemClickListener{
		private BaseActivity activity;
		
		public OnMyItemClickListenr(BaseActivity activity) {
			this.activity = activity;
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		}
	}
	
}
