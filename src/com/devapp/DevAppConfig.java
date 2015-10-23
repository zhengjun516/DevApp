package com.devapp;


import java.io.IOException;
import java.util.List;

import com.devapp.http.UrlConfig;
import com.devapp.utils.StreamUtil;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.DisplayMetrics;

/**
 * 
 * @author zhengjun1
 */
public class DevAppConfig {
	
	public static Application appContext;
	
	 /**
    * 当前的 UI 线程
    */
   public static Thread uiThread;
	
	public static final String APP_ONLINE = "online";
	public static final String APP_TEST = "test";
	public static final String APP_WEB6 = "web6";
	
	public static final String APP_CONFIG_FILE = "devapp.txt";

	public static String packageName = "com.ganji.jianzhi";

	public static String  appState = APP_ONLINE;	
	public static boolean logEnable = false;
	
	public static String agencyid = "";
	public static String versionName = "";
	public static String versionCode = "";
	
	/**
    * 产品线 id，例如 Android 平台赶集生活客户端的产品线 id 为 801
    */
   public static String customerId = "879";
	
	/**
    * 应用程序在系统中的用户id
    */
   public static int uid;
   
   /**
    * 系统的 User-Agent
    */
   public static String systemUserAgent;
	
	 /**
    * 当前设备的屏幕宽度（短边）所占有的像素数
    */
   public static int screenWidth;
   /**
    * 当前设备的屏幕高度（长边）所占有的像素数
    */
   public static int screenHeight;
   /**
    * 屏幕的密度参数，如：0.75, 1.0, 1.5, 2.0, 3.0 等
    */
   public static float density;

   public static void init(Application app){
		appContext = app;
		uiThread = Thread.currentThread();
		
		try {
			PackageInfo packageInfo = app.getPackageManager().getPackageInfo(app.getPackageName(), 0);
			DevAppConfig.versionCode = packageInfo.versionCode+"";
			DevAppConfig.versionName = packageInfo.versionName;
			DevAppConfig.uid = app.getPackageManager().getApplicationInfo(app.getPackageName(), 0).uid;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		DisplayMetrics displayMetrics = app.getResources().getDisplayMetrics();
		DevAppConfig.screenWidth = displayMetrics.widthPixels;
		DevAppConfig.screenHeight = displayMetrics.heightPixels;
		DevAppConfig.density = displayMetrics.density;
		 
		DevAppConfig.systemUserAgent = System.getProperty("http.agent");
		
		
		try {
			String[] kv = null;
			List<String> lines;
			lines = StreamUtil.loadStringLinesFromStream(app.getAssets().open(DevAppConfig.APP_CONFIG_FILE));
			for(String str:lines){
				kv =str.split("=");
				if(kv == null || kv.length != 2 || str.startsWith("#")){
					continue;
				}
				
				//服务器host环境
				if(kv[0].equalsIgnoreCase("appstate")){
					if(kv[1].equalsIgnoreCase(DevAppConfig.APP_TEST)){
						DevAppConfig.appState = DevAppConfig.APP_TEST;
						UrlConfig.host = UrlConfig.HOST_TEST;
						/*JZUrlConfig.httpUrl =JZUrlConfig.HTTP+JZUrlConfig.HOST_TEST;*/
					}else if(kv[1].equalsIgnoreCase(DevAppConfig.APP_WEB6)){
						DevAppConfig.appState = DevAppConfig.APP_WEB6;
						UrlConfig.host = UrlConfig.HOST_ONLINE;
						/*UrlConfig.baseApi = UrlConfig.BASE_API_WEB6;
						JZUrlConfig.httpUrl = JZUrlConfig.HTTP+JZUrlConfig.HOST_WEB6;*/
					}else{
						DevAppConfig.appState = DevAppConfig.APP_ONLINE;
						UrlConfig.host = UrlConfig.HOST_ONLINE;
						/*UrlConfig.baseApi = UrlConfig.BASE_API_ONLINE;
						JZUrlConfig.httpUrl = JZUrlConfig.HTTP+JZUrlConfig.HOST_ONLINE;*/
					}
				}
				//日志控制
				if(kv[0].equalsIgnoreCase("log")){
					DevAppConfig.logEnable = kv[1].equalsIgnoreCase("true");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
