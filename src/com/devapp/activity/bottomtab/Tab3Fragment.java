package com.devapp.activity.bottomtab;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;
import com.devapp.activity.base.BaseFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


/**
 * 探索
 * @author zhengjun1
 *
 */
public class Tab3Fragment extends BaseFragment {
	
	public ListView mItems;
	
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
		return inflater.inflate(R.layout.fragment_discovery, null);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mTitleText.setText(R.string.titlebar_discovery);
	}



	class OnMyItemClickListener implements OnItemClickListener{

		private BaseActivity activity;
		public OnMyItemClickListener(BaseActivity activity) {
			this.activity = activity;
		}
		@Override 
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			
		}
	}
	
	
}
