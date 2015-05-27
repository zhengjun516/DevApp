package com.devapp.activity.bottomtab;

import com.devapp.R;
import com.devapp.activity.base.BaseFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;


/**
 * 探索
 * 
 * @author zhengjun1
 * 
 */
public class Tab4Fragment extends BaseFragment {
	
	private ListView mListView;

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
		return inflater.inflate(R.layout.activity_personcenter, null);
	}

	@Override
	public void onResume() {
		super.onResume();
		mTitleText.setText(R.string.titlebar_individual_center);
	}

	private int measureHeight() {
		// get ListView adapter
		ListAdapter adapter = mListView.getAdapter();
		if (null == adapter) {
			return 0;
		}

		int totalHeight = 0;

		for (int i = 0, len = adapter.getCount(); i < len; i++) {
			View item = adapter.getView(i, null, mListView);
			if (null == item)
				continue;
			// measure each item width and height
			item.measure(0, 0);
			// calculate all height
			totalHeight += item.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = mListView.getLayoutParams();

		if (null == params) {
			params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
		}

		// calculate ListView height
		params.height = totalHeight + (mListView.getDividerHeight() * (adapter.getCount() - 1));

		mListView.setLayoutParams(params);
		return params.height;
	}
}
