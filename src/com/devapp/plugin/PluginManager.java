package com.devapp.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.devapp.utils.Utils;
import com.ryg.dynamicload.internal.DLPluginManager;
import com.ryg.utils.DLUtils;

public class PluginManager {
	
	private static final String TAG = "PluginManager";

	private static Context mContext;
	private static PluginManager mPluginManager;
	
	private PluginManager() {
	}
	
	/**
	 * 在使用这个类时必须先调用这个方法
	 * @param context
	 */
	public static void init(Context context){
		mContext = context;
	}
	
	public synchronized static PluginManager getInstance(){
		if(mContext == null){
			throw new RuntimeException(TAG+"未初始化!");
		}
		
		if(mPluginManager == null){
			mPluginManager = new PluginManager();
		}
		return mPluginManager;
	}
	
	public void start(){
		
	}
	
	public List<PluginItem> getPlugins() {
		List<PluginItem> plugins = null;
		String pluginFolder = Utils.APK_ROOT;
		File file = new File(pluginFolder);
		File[] pluginFiles = file.listFiles();
		if (pluginFiles == null || pluginFiles.length == 0) {
			return null;
		}
		
		plugins = new ArrayList<PluginItem>();
		
		for (File plugin : pluginFiles) {
            PluginItem item = new PluginItem();
            item.pluginPath = plugin.getAbsolutePath();
            item.packageInfo = DLUtils.getPackageInfo(mContext, item.pluginPath);
            if (item.packageInfo.activities != null && item.packageInfo.activities.length > 0) {
                item.launcherActivityName = item.packageInfo.activities[0].name;
            }
            if (item.packageInfo.services != null && item.packageInfo.services.length > 0) {
                item.launcherServiceName = item.packageInfo.services[0].name;
            }
            plugins.add(item);
            DLPluginManager.getInstance(mContext).loadApk(item.pluginPath);
        }
		return plugins;
	}

}
