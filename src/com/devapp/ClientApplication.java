package com.devapp;

import java.lang.Thread.UncaughtExceptionHandler;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.devapp.plugin.PluginManager;

public class ClientApplication extends Application implements UncaughtExceptionHandler {

	
	
	public static ClientApplication application;
	
	private UncaughtExceptionHandler mDefaultUncaughtExceptionHandler;
	
	/** 是否启用StrictMode，在 release 情况下严禁打开 */
	public static boolean ENABLE_STRICTMODE = false;
	/** 是否开启性能分析 */
	public static boolean ENABLE_PROFILING = false;
	/** 性能分析是否支持图片请求 */
	public static boolean ENABLE_PROFILING_IMAGE_REQUEST = false;
	
	@Override
	public void onCreate() {
		super.onCreate();
		application = this;
		
		mDefaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
		
		//初始化ActiveAndroid数据库框架
		ActiveAndroid.initialize(this);
		PluginManager.init(this);
		//初始化app配置项
		DevAppConfig.init(this);
		
	}
	
	
	/**
	 * 配置开发环境参数、是否打印日志参数 等等
	 */
	private void configAppParameters(){
		
	}
	
	@Override
	public synchronized void uncaughtException(Thread thread, Throwable ex) {
		// synchronized 以后，每次启动不会崩溃多次
		// 每次 crash 记录一次启动次数，下次启动时不再记录
	/*	getUserTracer().syncAddLog("1," + TimeUtil.getTimeStamp(), UserTraceDatabaseHelper.TABLE_NAME, UserTracer.HTTP_URL);
		getSharedPreferences(Pref.FILE_GENERIC, MODE_PRIVATE).edit().putBoolean(Pref.LAUNCH_COUNT_INCREASED_WHEN_CRASH, true).commit();
		
		// 记录崩溃日志
		StringBuilder log = new StringBuilder();
		log.append("999997,").append(TimeUtil.getTimeStamp()).append(",");
		// 异常栈
		log.append(VERSION_NAME).append(",").append(Build.VERSION.RELEASE).append(",").append(Build.MODEL).append(",")
				.append(Log.getStackTraceString(ex).replace("\n", "\\n").replace(",", " ").replace("|", " "));
		// 访问路径
		log.append(mcrashRecord.toString().replace(",", " ->"));
		// meminfo: free/allocated/total/max
		if (ex instanceof OutOfMemoryError) {
			Runtime runtime = Runtime.getRuntime();
			long free = runtime.freeMemory();
			long total = runtime.totalMemory();
			long max = runtime.maxMemory();
			long allocated = total - free;
			log.append("[meminfo: ").append(free / 1024).append("kB/").append(allocated / 1024).append("kB/").append(total / 1024).append("kB/")
					.append(max / 1024).append("kB]");
			log.append("[threadcount=").append(Thread.activeCount()).append("]");
		}
		
		getUserTracer().syncAddLog(log.toString(), UserTraceDatabaseHelper.TABLE_NAME, UserTracer.HTTP_URL);
		
		if (mDefaultUncaughtExceptionHandler != null) {
			mDefaultUncaughtExceptionHandler.uncaughtException(thread, ex);
		}*/
	}
	
	/**
	 * 使用一个静态的Toast主要是解决一个页面会多次闪现新的Toast的问题
	 */
	/*public static Toast toast = null;
	private static View toastView = null;
	private static TextView textView = null;*/
	
	/*public static void toast(final Context context, final String notice, final int duration) {
		if (context == null || TextUtils.isEmpty(notice)) {
			return;
		}
		
		if (toastView == null) {
			toastView = LayoutInflater.from(application).inflate(R.layout.toast, null);
			textView = (TextView) toastView.findViewById(R.id.toast_text);
		}
		
		if (toast == null) {
			toast = Toast.makeText(application, notice, duration);
			if (toastView != null && textView != null) {
				textView.setText(notice);
				toast.setView(toastView);
			}
			toast.show();
		} else {
			if (toastView != null && textView != null) {
				textView.setText(notice);
			} else {
				toast.setText(notice);
			}
			toast.setDuration(duration);
			toast.show();
		}
	}*/

	@Override
	public void onLowMemory() {
		super.onLowMemory();
//		当整个系统处于低内存的时候调用这个函数，就像进程试着勒劲裤带。如果临界点没有定义，通常是所有后台进程都被kill，在到临界点之前，主服务和前台UI将不被kill。
//		应用程序可以自己实现这个函数来释放任何缓存或其它不需要的资源。系统将在和谁返回后进行垃圾回收。
		System.gc();
	}
	
}
