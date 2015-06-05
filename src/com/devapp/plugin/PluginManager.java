package com.devapp.plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.Toast;

import com.devapp.activity.bottomtab.MainTabActivity;
import com.devapp.download.DownloadTask;
import com.devapp.download.DownloadTaskListener;
import com.devapp.download.DownloadTaskListenerAdapter;
import com.devapp.utils.Utils;
import com.ryg.dynamicload.internal.DLPluginManager;
import com.ryg.utils.DLUtils;

public class PluginManager {
	
	private static final String TAG = "PluginManager";

	private static Context mContext;
	private static PluginManager mPluginManager;
	
	private List<DownloadTask> downloadTasks = new ArrayList<DownloadTask>();
	
	private DownloadTaskListener mDownloadTaskListener = new DownloadTaskListenerAdapter() {
		@Override
		public void finishDownload(DownloadTask downloadTask) {
			Toast.makeText(mContext, "插件下载成功", Toast.LENGTH_LONG).show();
		}
		
		@Override
		public void errorDownload(int error) {
			
		}
	};
	
	private PluginManager() {
		downloadTasks = new ArrayList<DownloadTask>();
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
	
	/**
	 * 安装
	 */
	public void install(){
		
	}
	
	/**
	 * 更新
	 */
	public void update(){
		
	}
	
	/**
	 * 启动
	 */
	public void start(){
		
	}
	
	/**
	 * 停止
	 */
	public void stop(){
		
	}
	
	/**
	 * 卸载
	 */
	public void uninstall(){
		
	}
	
	public List<Plugin> getPlugins() {
		List<Plugin> plugins = null;
		String pluginFolder = Utils.APK_ROOT;
		File file = new File(pluginFolder);
		File[] pluginFiles = file.listFiles();
		if (pluginFiles == null || pluginFiles.length == 0) {
			return null;
		}
		
		plugins = new ArrayList<Plugin>();
		
		for (File plugin : pluginFiles) {
            Plugin item = new Plugin();
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

	public synchronized void startDownload(int viewPos,DownloadTaskListener downloadTaskListener) {
		   String pluginFolder = Utils.APK_ROOT;
	        File pluginFile = new File(pluginFolder);
	        if(!pluginFile.exists()){
	        	pluginFile.mkdirs();
	        }
			
			if (!Utils.isSDCardPresent()) {
				Toast.makeText(mContext, "未发现SD卡", Toast.LENGTH_LONG).show();
				return;
			}

			if (!Utils.isSdCardWrittenable()) {
				Toast.makeText(mContext, "SD卡不能读写", Toast.LENGTH_LONG).show();
				return;
			}

			File file = new File(Utils.APK_ROOT + Utils.getFileNameFromUrl(Utils.url[viewPos]));
			if (file.exists())
				file.delete();
			try {
				downloadTasks.add(viewPos, new DownloadTask(mContext,Utils.url[viewPos], Utils.APK_ROOT, downloadTaskListener));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			downloadTasks.get(viewPos).execute();
		}
}
