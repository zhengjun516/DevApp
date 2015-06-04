package com.devapp.adapter;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devapp.R;
import com.devapp.adapter.base.MBaseAdapter;
import com.devapp.domain.Chapter;
import com.devapp.domain.Section;

public class SectionAdapter extends MBaseAdapter {

	public SectionAdapter(Activity context, List<Section> datas) {
		super(context, datas);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.discovery_adapter_item, null);
		}
		Section section = (Section) getItem(position);
		
		TextView itemName = (TextView) convertView.findViewById(R.id.mItemName);
		itemName.setText(section.name);
		return convertView;
	}
}
