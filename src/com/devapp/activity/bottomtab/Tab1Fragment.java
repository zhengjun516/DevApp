package com.devapp.activity.bottomtab;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;
import com.devapp.activity.base.BaseFragment;
import com.devapp.fragment.FragmentSampleActivity;
import com.devapp.utils.ActivityUtils;



/**
 * 侃侃
 * @author zhengjun1
 *
 */
	
public class Tab1Fragment extends BaseFragment {
	private ViewPager mViewPager;
	
	private TextView mFragmentDemo;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		View root = getView();
		mFragmentDemo = (TextView) root.findViewById(R.id.mFragmentDemo);
		
		mFragmentDemo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityUtils.startActivity(getActivity(),FragmentSampleActivity.class);
			}
		});
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
