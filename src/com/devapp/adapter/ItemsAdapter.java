package com.devapp.adapter;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.devapp.R;
import com.devapp.adapter.base.MBaseAdapter;

public class ItemsAdapter extends MBaseAdapter {

	public ItemsAdapter(Activity context, List<Object> datas) {
		super(context, datas);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = inflater.inflate(R.layout.discovery_adapter_item, null);
		}
		return convertView;
	}
}
