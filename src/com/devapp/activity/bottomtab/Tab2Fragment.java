package com.devapp.activity.bottomtab;

import com.devapp.R;
import com.devapp.activity.base.BaseFragment;

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



/**
 * 一起
 * @author zhengjun1
 *
 */
public class Tab2Fragment extends BaseFragment {
	
	private ListView mItems;
	
	/*@InjectView(R.id.mEventViewPager)
	public ViewPager mEventViewPager;*/
	//UserNetService userNetService;

	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
		}
	};
	
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
		//mParentActivity = getActivity();
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
	
	
	
	
	
	class OnMyClickListener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch(v.getId()){
			  case R.id.mRightBtn:
				break;
			}
		}
	}

}
