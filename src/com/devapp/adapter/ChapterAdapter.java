package com.devapp.adapter;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devapp.R;
import com.devapp.adapter.base.MBaseAdapter;
import com.devapp.domain.Chapter;

public class ChapterAdapter extends MBaseAdapter {

	public ChapterAdapter(Activity context, List<Chapter> datas) {
		super(context, datas);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.discovery_adapter_item, null);
		}
		Chapter category = (Chapter) getItem(position);
		
		TextView itemName = (TextView) convertView.findViewById(R.id.mItemName);
		itemName.setText(category.name);
		
		return convertView;
	}
}
