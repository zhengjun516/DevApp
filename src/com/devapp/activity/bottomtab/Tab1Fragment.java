package com.devapp.activity.bottomtab;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.devapp.R;
import com.devapp.activity.base.BaseFragment;
import com.devapp.plugin.Plugin;
import com.devapp.plugin.PluginAdapter;
import com.devapp.plugin.PluginManager;
/*import com.ryg.dynamicload.internal.DLIntent;
import com.ryg.dynamicload.internal.DLPluginManager;
*/


/**
 * 
 * @author zhengjun1
 */
	
public class Tab1Fragment extends BaseFragment implements OnItemClickListener {

	/*private ArrayList<Plugin> mPluginItems = new ArrayList<Plugin>();
	private PluginAdapter mPluginAdapter;*/

	//private ListView mListView;
	private GridView mPluginList;
	private TextView mNoPluginTextView;
	
	/*private PluginManager pluginManager;*/
	
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
		/* mPluginAdapter = new PluginAdapter(mParentActivity,mPluginItems);
		 mPluginList = (GridView) getView().findViewById(R.id.mPluginList);*/
		 mNoPluginTextView = (TextView)getView().findViewById(R.id.no_plugin);
	 }
	
	private void initData() {
		/*pluginManager = PluginManager.getInstance();
		List<Plugin> pluginItems = pluginManager.getPlugins();
		
		mPluginItems.addAll(pluginItems);
		
		mPluginList.setAdapter(mPluginAdapter);
		mPluginList.setOnItemClickListener(this);
		mPluginAdapter.notifyDataSetChanged();*/
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		   /* Plugin item = mPluginItems.get(position);*/
	        /*DLPluginManager pluginManager = DLPluginManager.getInstance(mParentActivity);
	        pluginManager.startPluginActivity(mParentActivity, new DLIntent(item.packageInfo.packageName, item.launcherActivityName));
	        
	        //如果存在Service则调用起Service
	        if (item.launcherServiceName != null) { 
		        DLIntent intent = new DLIntent(item.packageInfo.packageName, item.launcherServiceName);
	        }*/
	}

}
