package com.devapp.activity.bottomtab;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.devapp.R;
import com.devapp.activity.base.BaseFragment;
import com.devapp.plugin.PluginAdapter;
import com.devapp.plugin.PluginItem;
import com.devapp.plugin.PluginManager;
import com.devapp.utils.Utils;
import com.ryg.dynamicload.internal.DLIntent;
import com.ryg.dynamicload.internal.DLPluginManager;
import com.ryg.utils.DLUtils;



/**
 * 一起
 * @author zhengjun1
 *
 */
public class Tab2Fragment extends BaseFragment implements OnItemClickListener {
	
	private ArrayList<PluginItem> mPluginItems = new ArrayList<PluginItem>();
	private PluginAdapter mPluginAdapter;

	private ListView mListView;
	private TextView mNoPluginTextView;
	
	private PluginManager pluginManager;
	
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
		initView();
		initData();
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
	
	
	 private void initView() {
		 mPluginAdapter = new PluginAdapter(mParentActivity,mPluginItems);
		 mListView = (ListView) getView().findViewById(R.id.plugin_list);
		 mNoPluginTextView = (TextView)getView().findViewById(R.id.no_plugin);
	 }
	
	private void initData() {
		pluginManager = PluginManager.getInstance();
		List<PluginItem> pluginItems = pluginManager.getPlugins();
		
		mPluginItems.addAll(pluginItems);
		
		mListView.setAdapter(mPluginAdapter);
		mListView.setOnItemClickListener(this);
		mPluginAdapter.notifyDataSetChanged();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		    PluginItem item = mPluginItems.get(position);
	        DLPluginManager pluginManager = DLPluginManager.getInstance(mParentActivity);
	        pluginManager.startPluginActivity(mParentActivity, new DLIntent(item.packageInfo.packageName, item.launcherActivityName));
	        
	        //如果存在Service则调用起Service
	        if (item.launcherServiceName != null) { 
		        DLIntent intent = new DLIntent(item.packageInfo.packageName, item.launcherServiceName);
	        }
	}

}
