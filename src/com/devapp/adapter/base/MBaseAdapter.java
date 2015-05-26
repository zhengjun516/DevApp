package com.devapp.adapter.base;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.devapp.utils.MyObjectUtils;
import com.devapp.widget.OnClickListenerAdapterView;


public abstract class MBaseAdapter<T> extends BaseAdapter{
	
	protected Activity context;
	protected List<T> datas = new ArrayList<T>();
	protected LayoutInflater inflater;
	
	/**
	 * 通用点击事件回调类
	 */
	protected OnClickListenerAdapterView<T> mOnClickListenerAdapterView;
	
	public MBaseAdapter(Activity context, List<T> datas) {
		super();
		this.context = context;
		if(!MyObjectUtils.isEmptyObject(datas)){
			this.datas = datas;
		}
		
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		if(datas!=null){
			return datas.size();
		}else{
			return 0;
		}
	}

	public List<T> getDatas(){
		return datas;
	}
	
	
	/**
	 * 在原有数据基础上增加数据
	 * @param datas
	 */
	public void addDatas(List<T> datas){
		if(!MyObjectUtils.isEmptyObject(datas)){
			getDatas().addAll(datas);
		}
		notifyDataSetChanged();
	}
	
	/**
	 * 重新填充数据
	 * @param datas
	 */
	public void setDatas(List<T> datas){
		if(!MyObjectUtils.isEmptyObject(datas)){
			getDatas().clear();
			getDatas().addAll(datas);
		}
		notifyDataSetChanged();
	}
	
	@Override
	public Object getItem(int position) {
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public abstract View getView(int position, View convertView, ViewGroup parent);

	public void setOnClickListenerAdapterView(OnClickListenerAdapterView onClickListenerAdapterView) {
		this.mOnClickListenerAdapterView = onClickListenerAdapterView;
	}
}
